package com.example.easyexcel.demo2;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.example.easyexcel.dto.UserModel;
import com.example.easyexcel.handlers.ModelExcelListener;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;



@RestController
@RequestMapping("hello2")
public class HelloController {
       
	@RequestMapping("/test")
    public @ResponseBody  String hello() {
              return "helloworld2";

     }
	
	@GetMapping("/download")
	public void downloadTemplate(HttpServletResponse response) throws IOException {
		ClassPathResource classPathResource = new ClassPathResource("template/easyexcel.xlsx");
		InputStream  input = classPathResource.getInputStream();
		Workbook wb = new XSSFWorkbook(input);
		
		response.setContentType("application/vnd.ms-excel");
		response.setHeader("content-Disposition", "attachment;filename="+URLEncoder.encode("easyexcel.xlsx","utf-8"));
		response.setHeader("Access-Control-Expose-Headers", "content-Disposition");
		OutputStream outputStream  = response.getOutputStream();
		
		wb.write(outputStream);
		outputStream.flush();
		outputStream.close();
	}
	
	@GetMapping("/export")
	public void exporTemplate(HttpServletResponse response) throws IOException {
		XSSFWorkbook xssf = new XSSFWorkbook();
		String[] columns = {"姓名","年龄","手机号","性别"};
		
		Sheet sheet = xssf.createSheet();
		//字体
		Font titleFont = xssf.createFont();
		titleFont.setFontName("simsun");  //宋体
		titleFont.setBold(true);
		titleFont.setColor(IndexedColors.BLACK.index);
		
		//格式
		XSSFCellStyle titleStyle = xssf.createCellStyle();
		titleStyle.setAlignment(HorizontalAlignment.CENTER);
		titleStyle.setVerticalAlignment(VerticalAlignment.CENTER);
		titleStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		titleStyle.setFillForegroundColor(IndexedColors.YELLOW.index);
		titleStyle.setFont(titleFont);
		
		Row titleRow = sheet.createRow(0);//创建 第一行
		
		for (int i=0; i < columns.length; i++) {
			Cell cell = titleRow.createCell(i);
			cell.setCellValue(columns[i]); //设置单元格的内容
			cell.setCellStyle(titleStyle); // 和格式
		}
		
		List<UserModel> list = new ArrayList();
		list.add(new UserModel("张三",12,"13867098765","男",new Date()));
		list.add(new UserModel("张三1",12,"13867098765","男",new Date()));
		list.add(new UserModel("张三2",12,"13867098765","男",new Date()));
		list.add(new UserModel("张三3",12,"13867098765","男",new Date()));
		
		for (UserModel user : list) {
			int rowNum = sheet.getLastRowNum();
			Row dataRow = sheet.createRow(rowNum + 1);//取下一行
			dataRow.createCell(0).setCellValue(user.getName());
			dataRow.createCell(1).setCellValue(user.getAge());
			dataRow.createCell(2).setCellValue(user.getMobile());
			dataRow.createCell(3).setCellValue(user.getSex());
		}
		response.setContentType("application/vnd.ms-excel");
		response.setHeader("content-Disposition", "attachment;filename="+URLEncoder.encode("easyexcel.xlsx", "utf-8"));
		response.setHeader("Access-Control-Expose-Headers", "content-Disposition");
		OutputStream outputStream = response.getOutputStream();
		xssf.write(outputStream);
		outputStream.flush();
		outputStream.close();	
	}
	
	@PostMapping("/read")
	public List<UserModel> readExcel(@RequestParam("file") MultipartFile file) {
		List<UserModel> list = new ArrayList();
		try {
			list = EasyExcel.read(file.getInputStream(), UserModel.class, new ModelExcelListener()).sheet().doReadSync();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return list;
	}


	@GetMapping("/byeasy")
	public void exportByEasy(HttpServletResponse response) {
	//	EasyExcel.w
	}
}

