/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repository;

import Enums.Entities;
import VO.Entity;

/**
 *
 * @author jojok
 */
public abstract class Repository {
  
  public abstract Entity select(int id, Entities entityType);
  public abstract Entity find(String code, Entities entityType);
  public abstract boolean update(String value,String Key, Entities entityType);
  public abstract boolean delete(String code, Entities entityType);
  public abstract boolean insert(String code, Entities entityType);
  public abstract boolean insert(Object obj, Entities entityType);
  public abstract void verifyDatabase( Entities entityType);
}
