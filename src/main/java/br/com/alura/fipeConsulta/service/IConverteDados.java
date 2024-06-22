package br.com.alura.fipeConsulta.service;

public interface IConverteDados {
    <T> T converteDados(String json, Class <T> Classes);
}
