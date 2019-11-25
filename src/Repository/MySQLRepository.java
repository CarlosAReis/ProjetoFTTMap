/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repository;

import DAO.DAO;
import DAO.GenerateDAO;
import Enums.Entities;
import Enums.Repositories;
import VO.Entity;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jojok
 */
public class MySQLRepository extends Repository {

    @Override
    public Entity select(int id, Entities entityType) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Entity find(String code, Entities entityType) {
        DAO dao = GenerateDAO.Fabrica(entityType, Repositories.MYSQL);
        Entity entidade = null;
        try {
            entidade = dao.find(code);
        } catch (SQLException ex) {
            Logger.getLogger(MySQLRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return entidade;
    }

    @Override
    public boolean update(String value,String key, Entities entityType) {
        DAO dao = GenerateDAO.Fabrica(entityType, Repositories.MYSQL);
        try {
            dao.update(value,key);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(MySQLRepository.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public boolean delete(String code, Entities entityType) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean insert(String code, Entities entityType) {
        DAO dao = GenerateDAO.Fabrica(entityType, Repositories.MYSQL);
        try {
            dao.insert(code);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(MySQLRepository.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public boolean insert(Object obj, Entities entityType) {
        DAO dao = GenerateDAO.Fabrica(entityType, Repositories.MYSQL);
        try {
            dao.insert(obj);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(MySQLRepository.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
}
