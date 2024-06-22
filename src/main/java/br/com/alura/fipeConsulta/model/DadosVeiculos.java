package br.com.alura.fipeConsulta.model;

import java.util.List;

public class DadosVeiculos {

    Integer TipoVeiculo;
    String Valor;
    String Marca;
    String Modelo;
    String AnoModelo;
    String Combustivel;
    String CodigoFipe;
    String MesReferencia;
    String SiglaCombustivel;

    public DadosVeiculos(DadosVeiculoRec dadosVeiculoRec) {
        this.TipoVeiculo = dadosVeiculoRec.tipoVeiculo();
        Valor = dadosVeiculoRec.valor();
        Marca = dadosVeiculoRec.marca();
        Modelo = dadosVeiculoRec.modelo();
        AnoModelo = dadosVeiculoRec.anoModelo();
        Combustivel = dadosVeiculoRec.combustivel();
        CodigoFipe = dadosVeiculoRec.codigoFipe();
        MesReferencia = dadosVeiculoRec.mesReferencia();
        SiglaCombustivel = dadosVeiculoRec.siglaCombustivel();
    }

    @Override
    public String toString() {
        return "DadosVeiculos{" +
                "TipoVeiculo: " + TipoVeiculo + '\n' +
                " Valor: " + Valor + '\n' +
                " Marca: " + Marca + '\n' +
                " Modelo: " + Modelo + '\n' +
                " AnoModelo: " + AnoModelo + '\n' +
                " Combustivel: " + Combustivel + '\n' +
                " CodigoFipe: " + CodigoFipe + '\n' +
                " MesReferencia: " + MesReferencia + '\n' +
                " SiglaCombustivel: " + SiglaCombustivel + '\n' +
                '}';
    }
}
