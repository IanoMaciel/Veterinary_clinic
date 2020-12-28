/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
import factory.ConnectionFactory;
import modelo.Pet;
import java.sql.*;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;


/**
 *
 * @author iano
 */
public class CadastrarPetDAO {
    
    private Connection connection;
    
    Long id_pet;
    String nome;
    String porte;
    String descricao;
    double peso;
    Long id_dono_pet;
    
    public CadastrarPetDAO()
    {
         this.connection = new ConnectionFactory().getConnection();
    }
    
    //create 
    public void Adicionar(Pet pet)
    {
        String sql = " insert into pet(nome, porte, descricao, peso, id_dono_pet) values(?,?,?,?,?) ";
        PreparedStatement stmt = null;
        try {
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, pet.getNome());
            stmt.setString(2, pet.getPorte());
            stmt.setString(3, pet.getDescricao());
            stmt.setDouble(4, pet.getPeso());
            stmt.setLong(5, pet.getIdPessoaDono());
            stmt.execute();
            stmt.close();
        } catch(SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    // selection
    public List<Pet> ExibirPet() throws SQLException
    {
        String sql = " select * from pet join dono on(id_dono_pet = id_pessoa_dono) ";
        PreparedStatement stmt = null;
        ResultSet result = null;
        
         List<Pet> listPet = new ArrayList();
        try {
            stmt = connection.prepareStatement(sql);
            result = stmt.executeQuery();
            
            while(result.next())
            {
                Pet pet = new Pet();
                pet.setIdPet(result.getLong("id_pet"));
                pet.setNome(result.getString("nome"));
                pet.setPorte(result.getString("porte"));
                pet.setPeso(result.getDouble("peso"));
                pet.setDescricao(result.getString("descricao"));
                pet.setIdPessoaDono(result.getInt("id_pessoa_dono"));
                
                
                listPet.add(pet);
            }
        } catch(SQLException e) {
            throw new RuntimeException(e);
        } finally {
            connection.close();
        }
        return listPet;
    }
    
    //update 
    public void Atualizar(Pet pet)
    {
        String sql  = " UPDATE pet SET ";
               sql += " nome = ?, porte = ?, descricao = ?, peso = ?, id_dono_pet = ? ";
               sql += " WHERE id_pet = ? ";
               
        PreparedStatement stmt = null;
        try {           
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, pet.getNome());
            stmt.setString(2, pet.getPorte());
            stmt.setString(3, pet.getDescricao());
            stmt.setDouble(4, pet.getPeso());
            stmt.setLong(5, pet.getIdPessoaDono());
            stmt.setLong(6, pet.getIdPet());
            
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
            stmt.close();
        } catch(SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar " + e);
            //throw new RuntimeException(e);
        } 
    }
    
    //Delete
    public void Deletar(Pet pet)
    {
        String sql = " delete from pet where id_pet = ? ";
        PreparedStatement stmt = null;
        
        try {
            stmt = connection.prepareStatement(sql);
            stmt.setLong(1, pet.getIdPet());
            
            stmt.execute();
            JOptionPane.showMessageDialog(null, "Registro excluido com sucesso!");
            stmt.close();
        } catch(SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao deleter registro do banco" + e);
        }
    }
}
