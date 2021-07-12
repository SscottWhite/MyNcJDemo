package com.example.easyexcel.bootDemo;

import java.awt.image.IndexColorModel;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.example.easyexcel.dto.UserModel;
import com.example.easyexcel.handlers.CustomCellWriteHandler;
import com.example.easyexcel.handlers.CustomSheetWriteHandler;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.write.merge.LoopMergeStrategy;
import com.alibaba.excel.write.metadata.WriteSheet;
import com.alibaba.excel.write.metadata.style.WriteCellStyle;
import com.alibaba.excel.write.style.HorizontalCellStyleStrategy;
import com.alibaba.excel.write.style.column.LongestMatchColumnWidthStyleStrategy;

public class App 
{
	static final String FINAL_NAME =  "D:\\Users\\kjs_352\\Desktop\\easyexcel (1).xlsx";
	
	public static void main(String[] args) {
		System.out.println("123");
		int i = 9;
		i = i++;
	    System.out.println(i);
	    System.out.println(432 % (int) Math.pow(10, 2) / (int) Math.pow(10, 1));
	    
	    
	    //这个是排除
	    Set<String> excludeColumnFiledNames = new HashSet<String>();
	    excludeColumnFiledNames.add("date"); //用的是字符名
	    
	    //但这个是只显示这个添加的内容, 所以不能有属性是ignore的列, 会不显示
	    Set<String> includeColumnFiledNames = new HashSet<String>();
	    includeColumnFiledNames.add("date"); //用的是字符名
	    includeColumnFiledNames.add("name");
	    
	  //  ExcelWriter ew = EasyExcel.write(fileName, UserModel.class).build(); 
//	    ExcelWriter ew = EasyExcel.write(fileName).build();
//	    for (int x = 5; x > 0; x--) {
//	          // 每次都要创建writeSheet 这里注意必须指定sheetNo
//	    	   WriteSheet writeSheet = EasyExcel.writerSheet(x, "模板").head(UserModel.class).build();
	    	  //WriteSheet writeSheet = EasyExcel.writerSheet(x, "模板").build();
//	          ew.write(getList(), writeSheet);
//	      }
//	    ew.finish();
	    
	    
	    // 合并策略 //从第(0+1)列开始, 内容每2个合并(上下)
	    LoopMergeStrategy loopMergeStrategy = new LoopMergeStrategy(2, 0);
	    //1是纵向合并数, 那1就是不合并,    3是合并数,  2是说明从(2+1)列的位置开始,--> 所以是第三列开始每行合并三个
	    LoopMergeStrategy loopMergeStrategy2 = new LoopMergeStrategy(1,3,2);
	    
	    
	    WriteCellStyle headWrite = new WriteCellStyle();
	    WriteCellStyle contentWrite = new WriteCellStyle();
	    			   contentWrite.setFillPatternType(FillPatternType.SOLID_FOREGROUND);
	    			   contentWrite.setFillForegroundColor(IndexedColors.GREEN.index);
	    //格式设置(头格式+内容格式)
	    HorizontalCellStyleStrategy horizontalCellStyleStrategy =
	            new HorizontalCellStyleStrategy(headWrite, contentWrite);
	  
//这是整个抹除数据重写的方法
	    EasyExcel
		    .write(FINAL_NAME, UserModel.class)  
		    //两个方法放在一起就是取不重复部分
		    .excludeColumnFiledNames(excludeColumnFiledNames)   //导出忽略字段
		  //  .includeColumnFiledNames(includeColumnFiledNames)   //导出需要的字段
		    .registerWriteHandler(loopMergeStrategy2)
		    //.registerWriteHandler(new LongestMatchColumnWidthStyleStrategy())//自动列宽
		    .registerWriteHandler(new CustomSheetWriteHandler())
		    .registerWriteHandler(new CustomCellWriteHandler())
		    .registerWriteHandler(horizontalCellStyleStrategy)
		    .sheet(1,"teat")
		    .doWrite(getList());
		
	}
	
	 static List<UserModel> getList(){
		List<UserModel> list = new ArrayList<UserModel>();
		list.add(new UserModel("张三",12,"13867098765","男",new Date(),"ignore"));
		list.add(new UserModel("张三1",12,"13867098765","男",new Date(),"ignore1"));
		list.add(new UserModel("张三2",12,"13867098765","男",new Date(),"ignore2"));
		list.add(new UserModel("张三3",12,"13867098765","男",new Date(),"ignore3"));
		list.add(new UserModel("张三3",12,"13867098765","男",new Date(),"ignore4"));
		return list;
	}
}