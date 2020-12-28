/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
import factory.ConnectionFactory;
import modelo.Dono;
import java.sql.*;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author iano
 */
public class CadastrarDonoDAO {
    //Conexão com o banco
    private Connection connection;
    
    // da classe pessoa
    long id_pesso;
    String nome;
    String cpf;
    //da classe dono
    long id_dono;
    long id_pessoa_dono;

    public CadastrarDonoDAO()
    {
        this.connection = new ConnectionFactory().getConnection();
    } 
    
    //realizando a inserção do cliente dono
    public void adiciona(Dono dono)
    {
        String sql1 = " INSERT INTO pessoa(nome, cpf) VALUES(?, ?) ";
        try {
            
            PreparedStatement stmt = connection.prepareStatement(sql1);
            stmt.setString(1, dono.getNome());
            stmt.setString(2, dono.getCpf());
            stmt.execute();
        } catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
    }
    
    /**
     *
     * @return
     * @throws java.sql.SQLException
     */
    public List<Dono> Exibir() throws SQLException 
    {
        String sql = " select * from dono JOIN pessoa ON(id_pessoa = id_pessoa_dono) ";
        PreparedStatement stmt = null;
        ResultSet result = null;
        
        List<Dono> cliente = new ArrayList();
        try {
            stmt = connection.prepareStatement(sql);
            result = stmt.executeQuery();
            
            while(result.next())
            {
                Dono dono = new Dono();
                
                dono.setIdPessoaDono(result.getInt("id_dono"));
                dono.setNome(result.getString("nome"));
                dono.setCpf(result.getString("cpf"));
                
                cliente.add(dono);
            }
            
        } catch(SQLException e) {
            throw new RuntimeException(e);
        } finally {
            connection.close();
        }
        return cliente;
    }
    
    /* 
    public void IdPessoa(Dono dono)
    {
       String sql = " SELECT * FROM pessoa "; 
       ResultSet result;
       try {
           PreparedStatement stmt = connection.prepareStatement(sql);
           result = stmt.executeQuery();
           
           while(result.next())
           {
               int id = result.getInt("id_pessoa");
               String nome = result.getString("nome");
               String cpf = result.getString("cpf");
               System.out.println("ID: " + id + " Nome: " + nome + " CPF: " + cpf);
               
           }
       } catch(SQLException e) {
           throw new RuntimeException(e);
       }
    } 
    */
}
