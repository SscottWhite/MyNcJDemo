package com.example.easyexcel.handlers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;


public class ModelExcelListener extends AnalysisEventListener{

	private List<Object> datas = new ArrayList<>();
	
	@Override
	public void doAfterAllAnalysed(AnalysisContext arg0) {
		//Log.info("解析完成");
	}

	@Override
	public void invoke(Object data, AnalysisContext arg1) {
		// Log.info((String) data); //坑爹啊, 不要乱转
         datas.add(data);
         System.out.println("表行:"+data);
         
         //根据业务自行处理，可以写入数据库等等
	}

	@Override
	public void invokeHeadMap(Map headMap, AnalysisContext context) {
		// TODO Auto-generated method stub
		super.invokeHeadMap(headMap, context);
		
		System.out.println("表头:"+headMap);
	}
	
}