package servico;

import java.util.ArrayList;

public abstract class BaseServico<TDominio> {

    public abstract ArrayList<TDominio> Navegar(); //Browse
    public abstract TDominio Ler(int chave); // Read
    public abstract TDominio Editar(TDominio obj); //Edit
    public abstract TDominio Adicionar(TDominio obj); //Add
    public abstract TDominio Deletar(int chave); //Delete
}