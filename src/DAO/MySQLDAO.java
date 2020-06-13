/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Comuns.CampoNoBanco;
import VO.Entity;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author jojok
 * @param <E>
 */
public class MySQLDAO <E extends Entity> extends DAO {

    final String STRING_CONEXAO_CRIA_BANCO ="jdbc:mysql://localhost/sys";
    final String STRING_CONEXAO = "jdbc:mysql://localhost/fttmap";  
    final String USUARIO = "fttmap";  
    final String SENHA = "";
    private String tabela;
    private String updateField;
    private ArrayList<Object> ObjectField;
    
    public MySQLDAO(Class entityClass) {
        super(entityClass);
    }
    
    protected void setTabela(String value){
        tabela = value;
    }
    protected void setUpdateField(String value){
        updateField = value;
    }
    protected void setObjectField(ArrayList<Object> value){
        ObjectField = value;
    }
    
    @Override
    public E select(int id) {
        // Não há retorno por id
        return null;
    }

    /**
     *
     * @param codigo
     * @return
     * @throws SQLException
     */
    @Override
    public E find (String codigo) throws SQLException {
        E entidade = null;
        try (Connection conexao = DriverManager.getConnection(STRING_CONEXAO, USUARIO, SENHA )) {
            String SQL = getLocalizaCommand();
            try (PreparedStatement stmt = conexao.prepareStatement(SQL)) {
                stmt.setString(1, codigo);
                try (ResultSet rs = stmt.executeQuery()) {
                    if (rs.first()){
                        entidade = preencheEntidade(rs);
                    }
                }
            }
        }        
        return entidade;
    }
    
    @Override
    public void update(String value,String key) throws SQLException{
      
        try (Connection connection = DriverManager.getConnection(STRING_CONEXAO, USUARIO, SENHA )) {
            String SQL = getUpdateCommand();
            try (PreparedStatement stmt = connection.prepareStatement(SQL)){
                stmt.setString(1, value);
                stmt.setString(2,key);
                stmt.executeUpdate();
                }
            }
    } 

    protected String getLocalizaCommand() {
        String campos = "";
        String chave = "";
        for (Field campo : entityClass.getDeclaredFields()) {            
            if (campo.isAnnotationPresent(CampoNoBanco.class)) {
                CampoNoBanco anotacao = campo.getAnnotation(CampoNoBanco.class);
                if (anotacao.chave())
                    chave = anotacao.nome();
                campos += anotacao.nome() +",";
            }
        }
        if (campos.length() >0)
            campos = campos.substring(0, campos.length()-1);
        return "select "+ campos+ " from "+ tabela +" where "+chave +" = ?";
    }
    
    protected String getUpdateCommand(){
        String chave = "";
        for (Field campo : entityClass.getDeclaredFields()) {            
            if (campo.isAnnotationPresent(CampoNoBanco.class)) {
                CampoNoBanco anotacao = campo.getAnnotation(CampoNoBanco.class);
                if (anotacao.chave())
                    chave = anotacao.nome();
            }
        }
        return "update "+ tabela + " set "+ updateField +" = ? where "+chave +" = ?";
    }
    
    protected String getListaCommand() {
        return "select * from " + tabela;
    }
    
    protected E preencheEntidade(ResultSet rs) {
        throw new UnsupportedOperationException("Implementar na classe filha."); //To change body of generated methods, choose Tools | Templates.
    }
    protected String propertyInsertCommand(String command, Entity e){
        return command;
    }
    protected String setUpdateCommand(String Command){
        return Command;
    }
    
    @Override
    public ArrayList<E> getList() throws SQLException {
        ArrayList<E> entidades = new ArrayList();
        try (Connection conexao = DriverManager.getConnection(STRING_CONEXAO, USUARIO, SENHA)) {
            System.out.println("Banco conectado!");
            // ? => binding
            String SQL = getListaCommand();
            try (PreparedStatement stmt = conexao.prepareStatement(SQL)) {
                try (ResultSet rs = stmt.executeQuery()) {
                    while (rs.next()){
                        E entidade = preencheEntidade(rs);
                        entidades.add(entidade);
                    }
                }
            }
        }
        
        return entidades;
      }

    @Override
    public boolean insert(String code) throws SQLException {
         try (Connection connection = DriverManager.getConnection(STRING_CONEXAO, USUARIO, SENHA )) {
            try (PreparedStatement stmt = connection.prepareStatement(propertyInsertCommand(code, null))){
                for (int i = 0; i < ObjectField.size(); i++) {
                    stmt.setObject(i+1, ObjectField.get(i));
                }
                ResultSet rs = stmt.executeQuery();
                System.out.println(rs);
                return true;
                }
            }
        catch(SQLException e){
            System.out.println(e);
            return false;
        }
    }

    @Override
    public ArrayList updateList() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean insert(Object object) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void verifyDatabase() throws SQLException {
        try (Connection connection = DriverManager.getConnection(STRING_CONEXAO_CRIA_BANCO, USUARIO, SENHA )) {
            String SQL =" create database if not exists fttmap;";
            Statement stmt = connection.createStatement();  
            stmt.executeUpdate(SQL);
            }
        try(Connection connection = DriverManager.getConnection(STRING_CONEXAO,USUARIO,SENHA)){
            String SQL = "CREATE TABLE `Usuario` (\n" +
                        "  `Id` int  PRIMARY KEY auto_increment,\n" +
                        "  `RA` varchar(20) unique,\n" +
                        "  `Nome` varchar(20),  \n" +
                        "  `Senha` varchar(50),\n" +
                        "  `Categoria` varchar(20),\n" +
                        "  `Curso` varchar(20),\n" +
                        "  `Semestre` int\n" +
                        ");";
            Statement stmt = connection.createStatement();  
            stmt.executeUpdate(SQL);
        }
         try(Connection connection = DriverManager.getConnection(STRING_CONEXAO,USUARIO,SENHA)){
            String SQL = "insert into `Usuario`(`RA`,`Nome`,`Senha`,`Categoria`,`Curso`,`Semestre`) values ('admin','Administrador','104-107-116-112-117','Administrador','ALL','0') ;";
            Statement stmt = connection.createStatement();  
            stmt.executeUpdate(SQL);
        }
    }



}

