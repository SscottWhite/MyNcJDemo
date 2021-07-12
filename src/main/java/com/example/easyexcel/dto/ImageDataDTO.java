package com.example.easyexcel.dto;

import java.io.File;
import java.io.InputStream;
import java.net.URL;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import com.alibaba.excel.annotation.write.style.ContentRowHeight;
import com.example.easyexcel.handlers.StringImageConverter;


import lombok.Data;

@Data
@ContentRowHeight(100)
@ColumnWidth(100 / 3)
public class ImageDataDTO {
	
    private File file;
    
    private InputStream inputStream;
    
    @ExcelProperty(converter = StringImageConverter.class)
    private String string;
    
    private byte[] byteArray;
    
    private URL url;
}