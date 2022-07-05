package com.jalasoft.todoly.keywordframework;

import Keywords.Keywords;
import org.testng.Reporter;
import org.testng.annotations.Test;
import utils.ExcelReader;

import java.util.ArrayList;

public class KeywordDrivenScript {
    private static final ExcelReader excelReader = new ExcelReader();
    private static Keywords keywords = new Keywords();
    private static Assertions assertions = new Assertions();
    @Test
    public void executeKeywordDrivenTests() {
        Reporter.log("Executing Keyword Driven Tests", true);
        ArrayList<String> arrayList = excelReader.readExcelData(4);

        for (String keywordType : arrayList) {
            switch (keywordType) {
                case "basicAuthentication" -> assertions.AssertResponse("basicAuthentication", keywords.sendBasicAuthenticationRequest());
            }
        }
    }
}
