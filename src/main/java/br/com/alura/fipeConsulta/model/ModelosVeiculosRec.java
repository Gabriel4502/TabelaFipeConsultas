package br.com.alura.fipeConsulta.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;
@JsonIgnoreProperties(ignoreUnknown = true)
public record ModelosVeiculosRec(List<DadosRec> modelos, List <DadosRec> anos) {
}
