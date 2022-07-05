package utils;

import framework.Environment;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class ExcelReader {
    private static final Environment environment = Environment.getInstance();

    public ArrayList<String> readExcelData(int colNo) {
        File file = new File(System.getProperty("user.dir") + environment.getKeywordsSheetPath());
        System.out.println(file.getAbsolutePath());
        ArrayList<String> arrayList = new ArrayList<>();

        try {
            FileInputStream fis = new FileInputStream(file);
            XSSFWorkbook wb = new XSSFWorkbook(fis);
            XSSFSheet sheet = wb.getSheet("Sheet1");
            Iterator rowIterator = sheet.rowIterator();
            rowIterator.next();

            while (rowIterator.hasNext()) {
                Row row = (Row) rowIterator.next();
                Cell cell = row.getCell(colNo);
                if (cell != null) {
                    String data = cell.getStringCellValue();
                    arrayList.add(data);
                }

                if (!arrayList.isEmpty()) {
                    System.out.println(arrayList.size());
                    System.out.println("Your data ----> " + arrayList.get(0));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return arrayList;
    }
}
