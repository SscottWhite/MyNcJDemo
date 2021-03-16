package com.example.toolutils;

import java.io.IOException;

import org.apache.commons.httpclient.DefaultHttpMethodRetryHandler;
import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;

import com.alibaba.fastjson.JSONObject;

public class HttpClientUtils {
	
	/**
	 * GET
	 * @param url
	 * @param content  这是格式
	 */
		public static void doGet(String url, String content) {
			
			HttpClient  httpClient = new HttpClient();
			httpClient.getHttpConnectionManager().getParams().setConnectionTimeout(5000);
			
			GetMethod getMethod = new GetMethod(url);
			getMethod.getParams().setParameter(HttpMethodParams.SO_TIMEOUT, 5000);
			getMethod.getParams().setParameter(HttpMethodParams.RETRY_HANDLER, new DefaultHttpMethodRetryHandler());
			
			String response = "";
			
			try {
				int statusCode = httpClient.executeMethod(getMethod);
				if(statusCode != HttpStatus.SC_OK) {
					System.out.println("请求出错: " + getMethod.getStatusLine());
				}
				
				Header[] headers = getMethod.getRequestHeaders();
				for(Header h : headers) {
					System.out.println(h.getName() + "-------------" + h.getValue());
				}
				byte[] responseBody = getMethod.getResponseBody();
				response = new String(responseBody, content);
				System.out.println("--response--:"+response);
				
			} catch (HttpException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				getMethod.releaseConnection();
			}
			
		}
		
		/**
		 * POST
		 * @param url
		 * @param json
		 */
		public static void doPost(String url, JSONObject json) {
				HttpClient httpClient = new HttpClient();
				PostMethod postMethod = new PostMethod(url);
				
				postMethod.addRequestHeader("accept", "*/*");
				postMethod.addRequestHeader("connection", "Keep-Alive");
		        //设置json格式传送
		        postMethod.addRequestHeader("Content-Type", "application/json;charset=GBK");
		        //必须设置下面这个Header
		        postMethod.addRequestHeader("User-Agent","Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1; SV1)");
		        //添加请求参数 , 不添加参数就去掉
		      //  postMethod.addParameter();

		        String res= "";
		        int code;
				try {
					code = httpClient.executeMethod(postMethod);
					if(code == HttpStatus.SC_OK) {
			        	 res = postMethod.getResponseBodyAsString();
			        	 System.out.println(res);
			        }
				} catch (HttpException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
		        
		}
}
