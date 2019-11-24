/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

/**
 *
 * @author Caue
 */
public class Excel {
    
    private static String EXCEL_FILE_LOCATION = "C:\\test\\MyFirstExcel.xls";
    
    private static final Integer diaSemana = 0;
    private static final Integer disciplina = 1;
    private static final Integer horaInicio = 2;
    private static final Integer horaTermino = 3;
    private static final Integer professor = 4;
    private static final Integer sala = 5;
    
    private static List<String> diaSemanaList;
    private static List<String> disciplinaList;
    private static List<String> horaInicioList;
    private static List<String> horaTerminoList;
    private static List<String> professorList;
    private static List<String> salaList;
    
    private static Boolean hasSaturday;
    
    private static String path;
    
    static {
        diaSemanaList = new ArrayList<>();
        disciplinaList = new ArrayList<>();
        horaInicioList = new ArrayList<>();
        horaTerminoList = new ArrayList<>();
        professorList = new ArrayList<>();
        salaList = new ArrayList<>();
        hasSaturday = true;
        try {
            path = new File(".").getCanonicalPath();
            EXCEL_FILE_LOCATION = String.valueOf(path) + "\\csv\\newCsv.xls";
        } catch (IOException ex) {
            Logger.getLogger(Excel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void read(String semester) {

        Workbook workbook = null;
        try {
            
            workbook = Workbook.getWorkbook(new File(path + "\\csv\\" + semester + ".xls"));
            Sheet sheet = workbook.getSheet(0);
            // column, line
            Integer rowLimit = 23;
            try {
                sheet.getCell(diaSemana, rowLimit - 1);
            } catch (Exception e) {
                hasSaturday = false;
                rowLimit = 21;
            }
            for (Integer i = 1; i < rowLimit; i++) {
                diaSemanaList.add(sheet.getCell(diaSemana, i).getContents());
                System.out.println(sheet.getCell(diaSemana, i).getContents());
            }
            for (Integer i = 1; i < rowLimit; i++) {
                disciplinaList.add(sheet.getCell(disciplina, i).getContents());
                System.out.println(sheet.getCell(disciplina, i).getContents());
            }
            for (Integer i = 1; i < rowLimit; i++) {
                horaInicioList.add(sheet.getCell(horaInicio, i).getContents());
                System.out.println(sheet.getCell(horaInicio, i).getContents());
            }
            for (Integer i = 1; i < rowLimit; i++) {
                horaTerminoList.add(sheet.getCell(horaTermino, i).getContents());
                System.out.println(sheet.getCell(horaTermino, i).getContents());
            }
            for (Integer i = 1; i < rowLimit; i++) {
                professorList.add(sheet.getCell(professor, i).getContents());
                System.out.println(sheet.getCell(professor, i).getContents());
            }
            for (Integer i = 1; i < rowLimit; i++) {
                salaList.add(sheet.getCell(sala, i).getContents());
                System.out.println(sheet.getCell(sala, i).getContents());
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (BiffException e) {
            e.printStackTrace();
        } finally {
            if (workbook != null) {
                workbook.close();
            }
        }
    }
    
    public enum Day {
        MONDAY,
        TUESDAY,
        WEDNESDAY,
        THURSDAY,
        FRIDAY,
        SATURDAY;
    }
    
    public static String[][] get(Day day) {
        switch (day) {
            case MONDAY:
                return fillMatrix(1, 5);
            case TUESDAY:
                return fillMatrix(5, 9);
            case WEDNESDAY:
                return fillMatrix(9, 13);
            case THURSDAY:
                return fillMatrix(13, 17);
            case FRIDAY:
                return fillMatrix(17, 21);
            case SATURDAY:
                if (!hasSaturday) {
                    return null;
                }
                return fillMatrix(21, 25);
        }
        return null;
    }
    
    private static String[][] fillMatrix (Integer begin, Integer end) {
        String m[][] = new String[4][6];
        for (Integer i = begin; i < end; i++) {
            m[i][diaSemana] = diaSemanaList.get(i);
        }
        for (Integer i = begin; i < end; i++) {
            m[i][disciplina] = disciplinaList.get(i);
        }
        for (Integer i = begin; i < end; i++) {
            m[i][horaInicio] = horaInicioList.get(i);
        }
        for (Integer i = begin; i < end; i++) {
            m[i][horaTermino] = horaTerminoList.get(i);
        }
        for (Integer i = begin; i < end; i++) {
            m[i][professor] = professorList.get(i);
        }
        for (Integer i = begin; i < end; i++) {
            m[i][sala] = salaList.get(i);
        }
        return m;
    }
    
    // USED TO CREATE NEW EXCEL SHEETS TO USE DUE TO VERSION
    public static void write() {

        //1. Create an Excel file
        WritableWorkbook myFirstWbook = null;
        try {

            myFirstWbook = Workbook.createWorkbook(new File(EXCEL_FILE_LOCATION));

            // create an Excel sheet
            WritableSheet excelSheet = myFirstWbook.createSheet("Sheet 1", 0);

            // add something into the Excel sheet
            Label label = new Label(0, 0, "Test Count");
            excelSheet.addCell(label);

            jxl.write.Number number = new jxl.write.Number(0, 1, 1);
            excelSheet.addCell(number);

            label = new Label(1, 0, "Result");
            excelSheet.addCell(label);

            label = new Label(1, 1, "Passed");
            excelSheet.addCell(label);

            number = new jxl.write.Number(0, 2, 2);
            excelSheet.addCell(number);

            label = new Label(1, 2, "Passed 2");
            excelSheet.addCell(label);

            myFirstWbook.write();


        } catch (IOException e) {
            e.printStackTrace();
        } catch (WriteException e) {
            e.printStackTrace();
        } finally {

            if (myFirstWbook != null) {
                try {
                    myFirstWbook.close();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (WriteException e) {
                    e.printStackTrace();
                }
            }


        }

    }
    
}
