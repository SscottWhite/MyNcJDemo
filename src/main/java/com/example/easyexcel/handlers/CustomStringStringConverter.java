package com.example.easyexcel.handlers;

import com.alibaba.excel.converters.Converter;
import com.alibaba.excel.enums.CellDataTypeEnum;
import com.alibaba.excel.metadata.CellData;
import com.alibaba.excel.metadata.GlobalConfiguration;
import com.alibaba.excel.metadata.property.ExcelContentProperty;

/**
 * 个人理解
 * 参考这个https://www.freesion.com/article/11701207531/
 * @author KJS_352
 *
 */
public class CustomStringStringConverter implements Converter<String>{

	@Override
	public Class supportJavaTypeKey() {
		return String.class;//程序内格式
	}

	@Override
	public CellDataTypeEnum supportExcelTypeKey() {
		return CellDataTypeEnum.STRING;//单元格格式
	}

	/**
	* 这个返回java数据
	*/
	@Override
	public String convertToJavaData(CellData cellData, ExcelContentProperty contentProperty,
			GlobalConfiguration globalConfiguration) throws Exception {
		return cellData.getStringValue();
	}
	/**
	 * 这个具体展示单元格内容, value就是java数据
	 */
	@Override
	public CellData convertToExcelData(String value, ExcelContentProperty contentProperty,
			GlobalConfiguration globalConfiguration) throws Exception {
		return new CellData("加前缀::" + value);
	}

}
