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


@HeadRowHeight(20)
@ContentRowHeight(20)
public class UserModel extends BaseRowModel implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@ColumnWidth(15)
	@ExcelProperty(value = {"一层","姓名"}, converter = CustomStringStringConverter.class)
	private String name;
	
	@ExcelProperty(value = {"年龄",""},index = 1)
	private Integer age;

	@ExcelProperty(value = "手机号",index = 2)
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
	
	public UserModel(String name, Integer age, String mobile, String sex, Date date,String ignore) {
		super();
		this.name = name;
		this.age = age;
		this.mobile = mobile;
		this.sex = sex;
		this.date = date;
		this.ignore = ignore;
	}
	public UserModel(String name, Integer age, String mobile, String sex, Date date) {
		super();
		this.name = name;
		this.age = age;
		this.mobile = mobile;
		this.sex = sex;
		this.date = date;
	}

	public UserModel() {
		super();
	}

	public String getName() {
		return name;
	}

	public Integer getAge() {
		return age;
	}

	public String getMobile() {
		return mobile;
	}

	public String getSex() {
		return sex;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	public String getIgnore() {
		return ignore;
	}
	
	public void setIgnore(String ignore) {
		this.ignore = ignore;
	}
	
	
}
