package com.example.IO.Impl;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.junit.jupiter.api.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class XmlBuiler {
	
	@Test
	public void test() {
		Long start = System.currentTimeMillis();
		factoryXML();
		System.out.println(System.currentTimeMillis() - start);
	}
	
	
	//DOM 写入
	public static void factoryXML() {
		
		try {
			//文件制造工厂
			DocumentBuilderFactory factoy = DocumentBuilderFactory.newDefaultInstance();
			DocumentBuilder builder = factoy.newDocumentBuilder();
			Document document = builder.newDocument();
			
			//xml属性
			document.setXmlStandalone(false);
			
			//类似标签
			Element table = document.createElement("table");
			Element person =  document.createElement("person");
			Element name =  document.createElement("name");
			Element age =  document.createElement("age");
			
			age.setAttribute("id", "1");
			age.setTextContent("20");
			name.setAttribute("class", "name");
			name.setTextContent("Jack");
		
			person.appendChild(name);//person包住name,age
			person.appendChild(age);		
			table.appendChild(person);		
			document.appendChild(table);//最终包在最大的里
			
			//转换工厂
			TransformerFactory tff = TransformerFactory.newDefaultInstance();
			Transformer transformer = tff.newTransformer();
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");//是否换行
			//写入文件
			transformer.transform(new DOMSource(document), new StreamResult(new File("factoryXml.xml")));			
			
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (TransformerConfigurationException e) {
			e.printStackTrace();
		} catch (TransformerException e) {
			e.printStackTrace();
		}	
	}
}
