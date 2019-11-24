/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import VO.Aula;
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
public class AulaMySQLDAO <E extends Entity> extends MySQLDAO  {

    public AulaMySQLDAO() {
        super(Aula.class);
        setTabela("Aula");
    }

    @Override
    protected E preencheEntidade(ResultSet rs) {
        Usuario user = new Usuario();
        try {
            user.setUsername(rs.getString("Login"));
            user.setSenha(rs.getString("Senha"));
        } catch (SQLException ex) {
            Logger.getLogger(UserMySQLDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return (E)user;
    }
    
    
}
