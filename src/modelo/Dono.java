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
public class Dono extends Pessoa{
    
    int id_pessoa_dono;
  
    public void setIdPessoaDono(int id_pessoa_dono)
    {
        this.id_pessoa_dono = id_pessoa_dono;
    }
    
    public int getIdPessoaDono()
    {
        return id_pessoa_dono;
    }
   
}
