package com.example.toolutils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class NetHttpUtils {
	
	/**
	 * post请求
	 * @param urlPath
	 * @param json
	 */
	 public static void doPost(String urlPath, String json) {
		
		 	try {
				URL url = new URL(urlPath);
				HttpURLConnection  conn = (HttpURLConnection) url.openConnection();
				conn.setRequestMethod("POST");
				conn.setDoOutput(true); //数据放在请求正文里 -- setDoOutput() 方法是为了下面 getOutputStream()；
				conn.setDoInput(true); //                    -- setDoInput() 方法是为了下面 getInputStream()。
				conn.setConnectTimeout(20000);//连接超时
				conn.setReadTimeout(20000);//读取超时
				conn.setUseCaches(false);
				// 设定传送的内容类型是可序列化的java对象 (如果不设此项,在传送序列化对象时,当WEB服务默认的不是这种类型时可能抛java.io.EOFException) 
				//conn.setRequestProperty("Content-type", "application/x-java-serialized-object"); 
				//conn.setRequestProperty("Content-Type", "application/json;charset=utf-8"); //这个内容是json格式
				//conn.setRequestProperty("Connection", "Keep-Alive");
				//conn.setRequestProperty("Charset", "UTF-8");
				conn.connect();
				
				if(json != null) {
					/*OutputStream outPut = conn.getOutputStream();
					outPut.write(json.getBytes("UTF-8")); //写入数据
					outPut.flush();
					outPut.close();*/
					BufferedWriter BW = new BufferedWriter(new OutputStreamWriter(conn.getOutputStream(),"UTF-8"));
					BW.write(json);
					BW.flush();
					BW.close();
				}
				
				int code = conn.getResponseCode();//响应参数
				if( code == HttpURLConnection.HTTP_OK) {
					InputStream input = conn.getInputStream();
					InputStreamReader inputReader = new InputStreamReader(input,"utf-8");
					BufferedReader bufferReader = new BufferedReader(inputReader);
					//BufferedReader bufferReader = new BufferedReader(new InputStreamReader(conn.getInputStream(),"utf-8"));
					
					String str = null;
					StringBuffer buffer = new StringBuffer();
					while((str = bufferReader.readLine()) != null) {
						buffer.append(str);
					}
					bufferReader.close();
					inputReader.close();
					input.close();
					conn.disconnect();
				}
				
			} catch (MalformedURLException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
	 }
}
