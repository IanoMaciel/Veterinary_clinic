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
public class Medico extends Pessoa {
    String crm;
    int id_pessoa_medico;

    public void setCrm(String crm)
    {
        this.crm = crm;
    }
    
    public String getCrm()
    {
        return crm;
    }
    
    public void setIdPessoaMedico(int id_pessoa_medico)
    {
        this.id_pessoa_medico = id_pessoa_medico;
    }
    
    public int getIdPessoaMedico()
    {
        return id_pessoa_medico;
    }
}
