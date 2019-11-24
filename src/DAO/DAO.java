/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import VO.Entity;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author jojok
 * @param <E>
 */
public abstract class DAO <E extends Entity> {
    
    protected Class<E> entityClass;

    public DAO(Class<E> entityClass){
        this.entityClass = entityClass;
    }
    
    public abstract E select(int id);
    public abstract E find(String code) throws SQLException;
    public abstract ArrayList<E> getList() throws SQLException;
    
    protected E getInstanceOfE()
    {
        try
        {
            return entityClass.newInstance();
        }
        catch (IllegalAccessException | InstantiationException e)
        {
            // No constructor
            throw new RuntimeException(e);
        }
    }
}
