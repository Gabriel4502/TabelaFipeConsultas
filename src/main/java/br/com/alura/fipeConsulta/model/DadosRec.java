package br.com.alura.fipeConsulta.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosRec(@JsonAlias("codigo") String codigo,
                       @JsonAlias("nome") String nome)
                    {
}
