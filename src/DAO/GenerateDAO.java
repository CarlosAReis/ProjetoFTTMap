/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Enums.Entities;
import Enums.Repositories;

/**
 *
 * @author jojok
 */
public class GenerateDAO {
     public static DAO Fabrica(Entities entity, Repositories repository) {
        switch (repository)
        {
            case EXCEL:
                return ExcelDAO(entity);
            case MYSQL:
                return MYSqlDAO(entity);
            default:
                return null;
        }
       
    }

    private static DAO ExcelDAO(Entities enumEntidade) {
        DAO retorno;
        switch (enumEntidade)
        {
            //case USUARIO:
            //    retorno = new UsuarioExcelDAO();
            //    break;            
            default:
                retorno = null;
                break;
        }
        return retorno;    
    }
    
    private static DAO MYSqlDAO(Entities enumEntidade) {
        DAO retorno;
        switch (enumEntidade)
        {
            case USUARIO:
                retorno = new UserMySQLDAO();
                break;
            case AULA:
                retorno = new UserMySQLDAO();
                break; 
            default:
                retorno = null;
                break;
        }
        return retorno;    
    }
}
