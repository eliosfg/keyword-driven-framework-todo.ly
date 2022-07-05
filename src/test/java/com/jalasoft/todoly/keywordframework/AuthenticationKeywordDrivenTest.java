package com.jalasoft.todoly.keywordframework;

import org.testng.annotations.Test;
import utils.ExcelReader;

import java.util.ArrayList;

public class AuthenticationKeywordDrivenTest {
    private static final ExcelReader excelReader = new ExcelReader();
    @Test
    public void isAuthenticated() {
        System.out.println("Authentication Keyword Driven Test");
        ArrayList<String> arrayList = excelReader.readExcelData(4);
        System.out.println(arrayList);
    }
}
