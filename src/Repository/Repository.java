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
  
  public abstract Entity Select(int id, Entities entityType);
  public abstract Entity Find(String code, Entities entityType);
  public abstract boolean Update(String code, Entities entityType);
  public abstract boolean Delete(String code, Entities entityType);
}
