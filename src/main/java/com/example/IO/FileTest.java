package com.example.IO;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;
import java.util.Properties;
import java.util.zip.GZIPInputStream;
import java.util.zip.ZipInputStream;


public class FileTest {
	public static void main(String[] args) throws Exception {
		File file = new File("D:\\git\\Exlip\\workSpace\\MyNcJDemo\\src\\main\\resources\\application.properties");
		
		System.out.println(file.getPath()+"\n"+file.getAbsolutePath()+"\n"+file.getCanonicalPath());
		
//		File[] files = file.listFiles(new FilenameFilter() {
//			@Override
//			public boolean accept(File dir, String name) {
//				return name.endsWith(".exe");
//			}
//		});
		
//		FileInputStream fs = new FileInputStream(file);
//		
//		InputStream stream = new GZIPInputStream(new BufferedInputStream(new FileInputStream("")));
//		InputStream zip = new ZipInputStream(new FileInputStream(""));
//		
//		Properties prop = new Properties();
//		InputStream getcalss = FileTest.class.getResourceAsStream("/application.properties");
//		prop.load(getcalss);
//		
//		
//		InputStream obj = new ObjectInputStream(new ByteArrayInputStream(new byte[100]));
		
		//序列化
		ByteArrayOutputStream byt = new ByteArrayOutputStream();
		try(ObjectOutputStream out = new ObjectOutputStream(byt)){
			out.writeInt(123);
			out.writeUTF("途虎");
			out.writeObject(Double.valueOf(123.66));
		}
		System.out.println(Arrays.toString(byt.toByteArray()));
		
		//反序列化
		ByteArrayInputStream input = new ByteArrayInputStream(byt.toByteArray()) ;
		try (ObjectInputStream in = new ObjectInputStream(input)) {
			int n = in.readInt();
			String str = in.readUTF();
			Double double1 = (Double)in.readObject();
			System.out.println(n+";"+str+";"+double1);
		}
		
	}
}
