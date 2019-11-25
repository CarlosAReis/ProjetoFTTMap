/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import VO.Entity;
import VO.Usuario;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
        setUpdateField("Senha");
    }

    @Override
    public String propertyInsertCommand(String sqlCommand,Entity user){
        Usuario u = (Usuario)user;
        setObjectField(u.getUserArray());
        sqlCommand =("insert into `Usuario`(`Username`,`Nome`,`Sobrenome`,`Senha`,`Categoria`,`Curso`,`Semestre`,`IsEnabled`) values (?, ?, ?, ?, ?, ?, ?, ?)");
        return sqlCommand;
    }
    
    @Override
    protected E preencheEntidade(ResultSet rs) {
        Usuario entidade = new Usuario();
        try {
            //ra, nome, senha , categoria, curso, semestre
            entidade.setRA(rs.getString("RA"));
            entidade.setNome(rs.getString("Nome"));
            entidade.setSenha(rs.getString("Senha"));
            entidade.setCategoria(rs.getString("Categoria"));
            entidade.setCurso(rs.getString("Curso"));
            entidade.setSemestre(rs.getInt("Semestre"));
        } catch (SQLException ex) {
            Logger.getLogger(UserMySQLDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return (E)entidade;
    }
    @Override
    public boolean insert(Object user) throws SQLException {
        Usuario usuario = (Usuario)user;
         try (Connection connection = DriverManager.getConnection(STRING_CONEXAO, USUARIO, SENHA )) {
            try (PreparedStatement stmt = connection.prepareStatement("insert into `Usuario`(`RA`,`Nome`,`Senha`,`Categoria`,`Curso`,`Semestre`) values (?, ?, ?, ?, ?, ?)")){
                for (int i = 0; i < usuario.getUserArray().size(); i++) {
                    stmt.setObject(i+1, usuario.getUserArray().get(i));
                }
                stmt.execute();
                return true;
                }
            }
        catch(SQLException e){
            System.out.println(e);
            return false;
        }
    }
    
}
    
    

