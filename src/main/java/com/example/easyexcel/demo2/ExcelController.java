package com.example.easyexcel.demo2;

import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.example.easyexcel.dto.ImageDataDTO;
import com.example.easyexcel.dto.UserModel;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.util.FileUtils;
import com.gaoice.easyexcel.SheetInfo;
import com.gaoice.easyexcel.spring.boot.autoconfigure.ExcelFile;
import com.gaoice.easyexcel.spring.boot.autoconfigure.annotation.ResponseExcel;


/**
 * 注解式导出
 * @author KJS_352
 *
 */
@Controller  //注意不要设置返回值
@RequestMapping("/excel")
public class ExcelController {

	static final String FINAL_NAME =  "D:\\Users\\kjs_352\\Desktop\\easyexcel (1).xlsx";
	
	//条件要对, 字段要对应
	//生效条件： enable-sheet-info=true等
	
	static List<UserModel> getList() {
		List<UserModel> list = new ArrayList();
		list.add(new UserModel("张三",12,"13867098765","男",new Date(),""));
		list.add(new UserModel("张三1",12,"13867098765","男",new Date(),""));
		list.add(new UserModel("张三2",12,"13867098765","男",new Date(),""));
		list.add(new UserModel("张三3",12,"13867098765","男",new Date(),""));
		return list;
	}
	
	
	@ResponseExcel(fileName="Java知识日历20201101测试",
				   sheetName = "同一班的同学名册",
				   columnNames= {"学生姓名","学号","年龄","","",""},
				   classFieldNames = { "name","age","mobile","sex","date","ignore" })
	@RequestMapping("/re")
	public List<UserModel> export() {
		
		return getList();
	}
	

    @RequestMapping("/sheetInfo")
    public SheetInfo sheetInfo() {
        String sheetName = "灵活组合测试";
        String[] columnNames = {"学生姓名", "学号", "年龄"};
        String[] classFieldNames = {"name", "mobile", "age"};
        List<UserModel> data = getList();
        return new SheetInfo(sheetName, columnNames, classFieldNames, data);
    }
 
  
    @RequestMapping("/excelFile")
    public ExcelFile excelFile() {
        /* SheetInfo */
        String sheetName = "灵活组合测试Sheet1";
        String[] columnNames = {"学生姓名", "学号", "年龄"};
        String[] classFieldNames = {"name", "mobile", "age"};
        List<UserModel> data = getList();
        SheetInfo sheetInfo1 = new SheetInfo(sheetName, columnNames, classFieldNames, data);
 
        String sheetName2 = "灵活组合测试Sheet2";
        String[] columnNames2 = {"学生姓名", "学号", "年龄","班主任姓名"};
        String[] classFieldNames2 = {"name", "mobile", "age","date"};
        SheetInfo sheetInfo2 = new SheetInfo(sheetName2, columnNames2, classFieldNames2, data);
 
        /* 通过 ExcelFile 自定义下载的文件名，放入多个 sheet */
        ExcelFile excelFile = new ExcelFile();
        excelFile.setFileName("ExcelFile可以自定义文件名和放入多个sheet");
        excelFile.addSheet(sheetInfo1);
        excelFile.addSheet(sheetInfo2);
 
        return excelFile;
    }

    //放入图片的几种方式
    @GetMapping("/image")
    public void imageWrite() throws Exception {
    	//String fileName = "D:\\Users\\kjs_352\\Desktop\\easyexcel (1).xlsx";
    	 // 如果使用流 记得关闭
    	InputStream inputStream = null;
    	try {
    		List<ImageDataDTO> list = new ArrayList<ImageDataDTO>();
    		ImageDataDTO imageData = new ImageDataDTO();
    		list.add(imageData);
    		String imagePath = "D:\\Users\\kjs_352\\Desktop\\微信图片_20210712095308.jpg";
    		// 放入四种类型的图片 实际使用只要选一种即可
    		imageData.setByteArray(FileUtils.readFileToByteArray(new File(imagePath)));  //1
    		imageData.setFile(new File(imagePath));//2
    		imageData.setString(imagePath);  		//3
    		inputStream = FileUtils.openInputStream(new File(imagePath));
    		imageData.setInputStream(inputStream); //4
    		imageData.setUrl(new URL("https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fscimg.jianbihuadq.com%2F202012%2F20201204222811179.jpg&refer=http%3A%2F%2Fscimg.jianbihuadq.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1628663467&t=7bf34442ad0c841086678f74e358e1ee"));
    		
    		EasyExcel.write(FINAL_NAME, ImageDataDTO.class).sheet().doWrite(list);
    	} finally {
    		if (inputStream != null) {
    			inputStream.close();
    	}
      }  		
   }
}
