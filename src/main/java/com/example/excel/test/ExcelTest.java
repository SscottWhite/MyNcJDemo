package com.example.excel.test;

import com.spire.xls.FileFormat;
import com.spire.xls.Workbook;

public class ExcelTest {
	public static void main(String[] args) {
        //加载Excel文档
        Workbook wb = new Workbook();
        wb.loadFromFile("20201212.xlsx");

        //调用方法保存为PDF格式
        wb.saveToFile("ToPDF3.pdf",FileFormat.PDF);
        
        System.out.print("OK");
    }
}
