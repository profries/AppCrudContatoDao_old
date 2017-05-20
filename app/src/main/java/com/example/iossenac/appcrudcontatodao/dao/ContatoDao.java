package com.example.iossenac.appcrudcontatodao.dao;

import com.example.iossenac.appcrudcontatodao.model.Contato;

import java.util.List;

public interface ContatoDao {
    public void inserir(Contato contato);
    public void excluir(Contato contato);
    public void atualizar(Contato contato);
    public List<Contato> listar();
    public Contato procurarPorId(int id);

}
