/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author iano
 */
public class Pessoa {
    String nome;
    String cpf;
    
    //metodos setters
    public void setNome(String nome)
    {
        this.nome = nome;
    }
    
    public void setCpf(String cpf)
    {
        this.cpf = cpf;
    }
    
    //metodos getters
    public String getNome()
    {
        return nome;
    }
    
    public String getCpf()
    {
        return cpf;
    }
}
