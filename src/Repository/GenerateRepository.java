/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repository;

import Config.Config;
import Enums.Repositories;

/**
 *
 * @author jojok
 */
public class GenerateRepository {
    
    public static Repository generateRepository() {
        if (Config.getInstance().getTipoRepositorio() == Repositories.MYSQL)
            return new MySQLRepository();
        else
            return new ExcelRepository();
    }
}
