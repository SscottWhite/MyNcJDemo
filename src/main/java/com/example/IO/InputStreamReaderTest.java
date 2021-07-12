package com.example.IO;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Properties;
import java.util.zip.GZIPInputStream;
import java.util.zip.ZipInputStream;

//import jdk.internal.org.jline.utils.InputStreamReader;


public class InputStreamReaderTest {
	public static void main(String[] args) throws Exception {
		//File file = new File("D:\\git\\Exlip\\workSpace\\MyNcJDemo\\src\\main\\resources\\application.properties");		
		//System.out.println(file.getPath()+"\n"+file.getAbsolutePath()+"\n"+file.getCanonicalPath());
		
		InputStream in = new FileInputStream("D:\\Users\\kjs_352\\Desktop\\新建文本文档.txt");
		byte[] by  = new byte[100];
		
//		int n ;
//		while ( (n = in.read(by)) != -1 ) {
//			//其实已经存入byte了
//			System.out.println(n);
//		}
		for ( int i = 0; i < by.length ; i++ ) {}
		//System.out.println(by[i]);
		
		for(int i = 0; i <"测试区中".getBytes().length; i++) {}
		//System.out.println("测试区中".getBytes()[i]);
		
		for(int i = 0; i <"测试区中".toCharArray().length; i++) {
		//	System.out.println("测试区中".toCharArray()[i]);
		}
		int m;
		while( (m = in.read()) != -1) {
		//	System.out.println("::"+m);
		}
		in.close();
//=============================================================================================		
//		File[] files = file.listFiles(new FilenameFilter() {
//			@Override
//			public boolean accept(File dir, String name) {
//				return name.endsWith(".exe");
//			}
//		});
		
//		FileInputStream fs = new FileInputStream(file);
		
//		InputStream stream = new GZIPInputStream(new BufferedInputStream(new FileInputStream("")));
//		InputStream zip = new ZipInputStream(new FileInputStream(""));
//		
//		Properties prop = new Properties();
//		InputStream getcalss = FileTest.class.getResourceAsStream("/application.properties");
//		prop.load(getcalss);
//		
//		
//		InputStream obj = new ObjectInputStream(new ByteArrayInputStream(new byte[100]));
//=====================================================================================================		
		//序列化
/*		ByteArrayOutputStream byt = new ByteArrayOutputStream();
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
		}*/
		
//===================================================================================================		
	//	Reader reader =  new FileReader("", StandardCharsets.UTF_8);
		//Reader reader3 = new InputStreamReader(new FileInputStream(""),"UTF-8");
	//	char[] cha = new char[100];
	//	int x;
		//while((x = reader.read(cha)) != -1) {}
	//	reader.close();
		
		//Writer wr = new OutputStreamWriter(new FileOutputStream(""));
//===================================================================================================
		// 持有InputStream:
	//	InputStream input = new FileInputStream("src/readme.txt");
		// 变换为Reader:  同样ReaderInputStream再换回来
	//	Reader reader = new InputStreamReader(input, "UTF-8");
		
//===================================================================================================		
		StringWriter sw = new StringWriter();
	}
}
