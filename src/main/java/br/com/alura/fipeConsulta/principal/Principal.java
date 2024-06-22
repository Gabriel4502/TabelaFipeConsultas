package br.com.alura.fipeConsulta.principal;

import br.com.alura.fipeConsulta.model.*;
import br.com.alura.fipeConsulta.service.ConsumoApi;
import br.com.alura.fipeConsulta.service.ConverteDados;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Principal {
    private String json;
    private ConverteDados conversor;


    public void menu(){
        Scanner scan = new Scanner(System.in);
        final String URL_BASE = "https://parallelum.com.br/fipe/api/v1/";
        conversor = new ConverteDados();

        System.out.println("""
                ******************************************************************
                Informe o tipo de veículo para pesquisa
                1- Carros
                2- Motos
                3- Caminhões
                ******************************************************************
                """);

        String endereco = null;
        Integer option = scan.nextInt();



        switch (option){
            case 1:
                   endereco = URL_BASE + "carros/marcas/" ;
                    break;
            case 2:
                    endereco = URL_BASE + "motos/marcas/";
                    break;
            case 3:
                    endereco = URL_BASE + "caminhoes/marcas/";
                    break;
            default:
                throw new IllegalStateException("Unexpected value: " + option);
        }

        var consumo = new ConsumoApi();
        this.json = consumo.consulta(endereco);
         List <DadosRec> dadosRecLista = Arrays.stream(conversor.obterDados(this.json, DadosRec[].class)).collect(Collectors.toList()) ;
         List <DadosModel> dadosModel = dadosRecLista.stream()
                 .map(DadosModel::new)
                 .collect(Collectors.toList());


        System.out.println(dadosModel);

        System.out.println("""
                ******************************************************************
                Informe o código da marca:
                """);
        var marca = scan.nextInt();
        scan.nextLine();
        json = consumo.consulta(endereco + marca + "/modelos/");
        var modelosVeiculosRec = conversor.obterDados(json, ModelosVeiculosRec.class);
        List<DadosRec> modelos = modelosVeiculosRec.modelos().stream().collect(Collectors.toList());
        List<DadosRec> anos = modelosVeiculosRec.anos().stream().collect(Collectors.toList());
        modelos.forEach(System.out::println);


        System.out.println("""
                ******************************************************************
                Informe o nome do veículo:
                """);
        String nome = scan.nextLine();
        List <DadosRec> filtroModelos = new ArrayList<>();
        filtroModelos =  modelos.stream()
                .filter(fm -> fm.nome().toLowerCase().contains(nome.toLowerCase()))
                .collect(Collectors.toList());
        filtroModelos.forEach(System.out::println);

        System.out.println("""
                ******************************************************************
                Insira o código do veículo: 
                """);

        var codigo = scan.nextInt();
        json = consumo.consulta(endereco + marca + "/modelos/" + codigo + "/anos/");
        List <DadosRec> anosVeiculo = Arrays.stream(conversor.obterDados(this.json, DadosRec[].class)).collect(Collectors.toList()) ;

        anosVeiculo.forEach(System.out::println);


        json = consumo.consulta(endereco + marca + "/modelos/" + filtroModelos.get(0).codigo() + "/anos/" + anos.get(0).codigo());
        System.out.println(json);



        System.out.println("""
                ******************************************************************
                Todos os modelos com valores por ano:
                """);

        List <DadosVeiculoRec> ficha = new ArrayList<>();
        List <DadosVeiculos> listaFichas = new ArrayList<>();
        for (int i = 0; i < anosVeiculo.size(); i++) {
            json = consumo.consulta(endereco + marca + "/modelos/" + codigo + "/anos/" +anosVeiculo.get(i).codigo());
            ficha.add(conversor.obterDados(json, DadosVeiculoRec.class));
            listaFichas.add(new DadosVeiculos(ficha.get(i)));
        }
        listaFichas.forEach(System.out::println);






    }

}
