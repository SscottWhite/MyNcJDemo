package com.example.control;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.poi.hpsf.DocumentSummaryInformation;
import org.apache.poi.hpsf.SummaryInformation;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
//import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@Controller
@RequestMapping("/control")
public class ExcelControl {
	
	//    /control/add/123
	@RequestMapping("/add/{id}")
	public @ResponseBody  Integer getStr(@PathVariable("id") Integer id) {
		return 123 + id;
	}
	
	//    /control/export/file
	//   单文件上传
	@RequestMapping("/export/file")
	public String analExcel(@RequestParam("file") MultipartFile file) {
		
		if(!file.isEmpty()) {
			try {
				BufferedOutputStream buff = new BufferedOutputStream(
						new FileOutputStream(new File(file.getOriginalFilename())));
				
				System.out.println(file.getName());
				
				buff.flush();
				buff.close();
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return "";
	}
	
	/*
	 * <body>    
       <form method="POST" enctype="multipart/form-data" action="/export/fileList">     
           <p>文件1：<input type="text" name="id" /></p>    
           <p>文件2：<input type="text" name="name" /></p>    
           <p>文件3：<input type="file" name="file" /></p>    
           <p><input type="submit" value="上传" /></p>    
       </form>    
    </body>
	 * */
	@RequestMapping(value = "/export/fileList", method = RequestMethod.POST)    
    public  @ResponseBody String handleFileUpload(HttpServletRequest request) {    
      MultipartHttpServletRequest params=((MultipartHttpServletRequest) request);  
        List<MultipartFile> files = ((MultipartHttpServletRequest) request).getFiles("file");  
        String name=params.getParameter("name");  
     //   System.out.println("name:"+name);  
        String id=params.getParameter("id");  
     //   System.out.println("id:"+id);  
        MultipartFile file = null;    
        BufferedOutputStream stream = null;    
        for (int i = 0; i < files.size(); ++i) {    
            file = files.get(i);    
            if (!file.isEmpty()) {    
                try {    
                    byte[] bytes = file.getBytes();    
                    stream = new BufferedOutputStream(new FileOutputStream(    
                            new File(file.getOriginalFilename())));    
                    stream.write(bytes);    
                    stream.close();    
                } catch (Exception e) {    
                    stream = null;    
                    return "You failed to upload " + i + " => "    
                            + e.getMessage();  
                }    
            } else {    
                return "You failed to upload " + i    
                        + " because the file was empty.";    
            }  
        }    
        return "upload successful";  
    } 
	
	
	
//	@Test
	public void export() {
		HSSFWorkbook  wb = new HSSFWorkbook();
		DocumentSummaryInformation dsi = wb.getDocumentSummaryInformation();
		//文档类别
		dsi.setCategory("员工信息");
		//设置文档管理员
		dsi.setManager("江南一点雨");
		//设置组织机构
		dsi.setCompany("XXX集团");
		
		SummaryInformation si = wb.getSummaryInformation();
		//设置文档主题
		si.setSubject("员工信息表");
		//设置文档标题
		si.setTitle("员工信息");
		//设置文档作者
		si.setAuthor("XXX集团");
		//设置文档备注
		si.setComments("备注信息暂无");
		
		HSSFSheet  sheet = wb.createSheet("xx集团");
		
		HSSFRow headerRow = sheet.createRow(0);
		
		HSSFCell cell0 = headerRow.createCell(0);
		cell0.setCellValue("编号");
	}
	
}
