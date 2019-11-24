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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jojok
 */
public class MySQLRepository extends Repository {

    @Override
    public Entity Select(int id, Entities entityType) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Entity Find(String code, Entities entityType) {
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
    public boolean Update(String code, Entities entityType) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean Delete(String code, Entities entityType) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
