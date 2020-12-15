package com.example.IO.Impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public class JsonTest {
	
	public static void main(String[] args) {
		String jonStr = "{\"name\":\"vivin\",\"age\":20, \"hoppy\":[\"read\",\"write\"]}";
		JSONObject jsonobject = new JSONObject();
		JSONArray  jsonArray = new JSONArray();

		jsonobject = JSON.parseObject(jonStr);
		System.out.print(jsonobject.getJSONArray("hoppy"));
	}
}
