package com.example.IO.Impl;

import com.spire.xls.FileFormat;
import com.spire.xls.Workbook;


/**
 *  用了第三方的jdk,直接转换
 * @author KJS_352
 *
 */
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
