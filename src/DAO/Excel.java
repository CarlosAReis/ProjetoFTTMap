/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import java.io.File;
import java.io.IOException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

/**
 *
 * @author Caue
 */
public class Excel {
    
    private static final String EXCEL_FILE_LOCATION = "C:\\test\\MyFirstExcel.xls";

    public static void read(String semester) {

        Workbook workbook = null;
        try {
            
            String path = new File(".").getCanonicalPath();

            workbook = Workbook.getWorkbook(new File(path + "\\csv\\" + semester + ".xls"));

            Sheet sheet = workbook.getSheet(0);
            Cell cell1 = sheet.getCell(0, 0);
            System.out.print(cell1.getContents() + ":");    // Test Count + :
            Cell cell2 = sheet.getCell(0, 1);
            System.out.println(cell2.getContents());        // 1

            Cell cell3 = sheet.getCell(1, 0);
            System.out.print(cell3.getContents() + ":");    // Result + :
            Cell cell4 = sheet.getCell(1, 1);
            System.out.println(cell4.getContents());        // Passed

            System.out.print(cell1.getContents() + ":");    // Test Count + :
            cell2 = sheet.getCell(0, 2);
            System.out.println(cell2.getContents());        // 2

            System.out.print(cell3.getContents() + ":");    // Result + :
            cell4 = sheet.getCell(1, 2);
            System.out.println(cell4.getContents());        // Passed 2

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
