package br.com.alura.fipeConsulta.model;

public class DadosModel {
    String codigo;
    String nome;

    public DadosModel(DadosRec dadosRec) {
        this.codigo = dadosRec.codigo();
        this.nome = dadosRec.nome();
    }

    @Override
    public String toString() {
        return
                "Codigo: " + codigo + '\n' +
                "Modelo: " + nome + '\n';
    }
}
