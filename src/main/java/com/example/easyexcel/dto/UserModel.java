package com.example.easyexcel.dto;

import java.io.Serializable;
import java.util.Date;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.format.DateTimeFormat;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import com.alibaba.excel.annotation.write.style.ContentRowHeight;
import com.alibaba.excel.annotation.write.style.HeadRowHeight;
import com.alibaba.excel.metadata.BaseRowModel;
import com.example.easyexcel.handlers.CustomStringStringConverter;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@HeadRowHeight(20)
@ContentRowHeight(20)
public class UserModel extends BaseRowModel implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@ColumnWidth(15)
	@ExcelProperty(value = {"一层","姓名"}, converter = CustomStringStringConverter.class)
	private String name;
	
	@ExcelProperty(value = {"一层","年龄",""},index = 1)
	private Integer age;

	@ExcelProperty(value = {"一层","手机号"},index = 2)
	private String mobile;

	@ExcelProperty(value = "性别",index = 3)
	private String sex;
	
	@ColumnWidth(28)
	@DateTimeFormat("yyyy年MM月dd日HH时mm分ss秒")
	@ExcelProperty(value = "日期",index = 4)
	private Date date;

	@ExcelIgnore   //用来忽略的
	@ExcelProperty(value = {"第二层","忽略子端"} ,index = 6)  //这个是初始位置, 如果有类似exclude, 位置会自己调整,
	private String ignore;
}
