/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import VO.Entity;
import VO.Usuario;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jojok
 * @param <E>
 */
public class UserMySQLDAO <E extends Entity> extends MySQLDAO {
    public UserMySQLDAO() {
        super(Usuario.class);
        setTabela("Usuario");
    }

    @Override
    protected E preencheEntidade(ResultSet rs) {
        Usuario user = new Usuario();
        try {
            user.setUsername(rs.getString("Username"));
            user.setSenha(rs.getString("Senha"));
            user.setSobrenome(rs.getString("Sobrenome"));
        } catch (SQLException ex) {
            Logger.getLogger(UserMySQLDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return (E)user;
    }
    
    
    @Override
    public Entity select(int id) {
        // Não há retorno por id
        return null;
    }
    protected Usuario getUser(ResultSet rs){
        Usuario user = new Usuario();
        try{
            user.setUsername(rs.getString("Username"));
            user.setSenha(rs.getString("Senha"));
            user.setSobrenome(rs.getString("Sobrenome"));
        }
        catch(SQLException ex){
            Logger.getLogger(UserMySQLDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return user;
    }
    public static void InsertUser(){
        
    }
}

