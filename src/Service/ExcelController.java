/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import DAO.Excel;
import DAO.Excel.Day;

/**
 *
 * @author Caue
 */
public class ExcelController {
    
    public static void loadExcelData(String semester) {
        Excel.read(semester);
    }
    
    public static String[][] getDayMatrix(Day day) {
        return Excel.get(day);
    }
}
