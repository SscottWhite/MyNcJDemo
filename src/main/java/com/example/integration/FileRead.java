package com.example.integration;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;

public class FileRead {
	
	// 设置一个全局动态数组，来存放文件路径 
	  // 主要遍历文件夹，包含所有子文件夹、文件的情况时，用到递归，所以要这样设置 
	  public static ArrayList<String> dirAllStrArr = new ArrayList<String>(); 
	  
	  // 这里是仅仅查询当前路径下的所有文件夹、文件并且存放其路径到文件数组 
	  // 由于遇到文件夹不查询其包含所有子文件夹、文件，因此没必要用到递归 
	  public static ArrayList<String> Dir(File dirFile) throws Exception { 
	    ArrayList<String> dirStrArr = new ArrayList<String>(); 
	  
	    if (dirFile.exists()) { 
	      // 直接取出利用listFiles()把当前路径下的所有文件夹、文件存放到一个文件数组 
	      File files[] = dirFile.listFiles(); 
	      for (File file : files) { 
	        // 如果传递过来的参数dirFile是以文件分隔符，也就是/或者\结尾，则如此构造 
	        if (dirFile.getPath().endsWith(File.separator)) { 
	          dirStrArr.add(dirFile.getPath() + file.getName()); 
	        } else { 
	          // 否则，如果没有文件分隔符，则补上一个文件分隔符，再加上文件名，才是路径 
	          dirStrArr.add(dirFile.getPath() + File.separator 
	              + file.getName()); 
	        } 
	      } 
	    } 
	    return dirStrArr; 
	  } 
	  
	  public static void DirAll(File dirFile) throws Exception { 
	  
	    if (dirFile.exists()) { 
	      File files[] = dirFile.listFiles(); 
	      for (File file : files) { 
	        // 如果遇到文件夹则递归调用。 
	        if (file.isDirectory()) { 
	          // 递归调用 
	          DirAll(file); 
	        } else { 
	          // 如果遇到文件夹则放入数组 
	          if (dirFile.getPath().endsWith(File.separator)) { 
	            dirAllStrArr.add(dirFile.getPath() + file.getName()); 
	          } else { 
	            dirAllStrArr.add(dirFile.getPath() + File.separator 
	                + file.getName()); 
	          } 
	        } 
	      } 
	    } 
	  } 
	  
	  public static void main(String[] args) throws Exception { 
	    File dirFile = new File("f:/aa"); 
	    System.out.println(Dir(dirFile)); 
	    DirAll(dirFile); 
	    System.out.println(dirAllStrArr); 
	    
	    new FileTest().copyFolder("f:/a", "f:/b"); 
	  } 	  
}

class FileTest { 
	  public void copyFolder(String oldPath, String newPath) { 
	   try { 
	    // 如果文件夹不存在，则建立新文件夹 
	    (new File(newPath)).mkdirs(); 
	    //读取整个文件夹的内容到file字符串数组，下面设置一个游标i，不停地向下移开始读这个数组 
	    File filelist = new File(oldPath); 
	    String[] file = filelist.list(); 
	    //要注意，这个temp仅仅是一个临时文件指针 
	    //整个程序并没有创建临时文件 
	    File temp = null; 
	    for (int i = 0; i < file.length; i++) { 
	     //如果oldPath以路径分隔符/或者\结尾，那么则oldPath/文件名就可以了 
	     //否则要自己oldPath后面补个路径分隔符再加文件名 
	     //谁知道你传递过来的参数是f:/a还是f:/a/啊？ 
	     if (oldPath.endsWith(File.separator)) { 
	      temp = new File(oldPath + file[i]); 
	     } else { 
	      temp = new File(oldPath + File.separator + file[i]); 
	     } 
	       
	     //如果游标遇到文件 
	     if (temp.isFile()) { 
	      FileInputStream input = new FileInputStream(temp); 
	      FileOutputStream output = new FileOutputStream(newPath 
	        + "/" + "rename_" + (temp.getName()).toString()); 
	      byte[] bufferarray = new byte[1024 * 64]; 
	      int prereadlength; 
	      while ((prereadlength = input.read(bufferarray)) != -1) { 
	       output.write(bufferarray, 0, prereadlength); 
	      } 
	      output.flush(); 
	      output.close(); 
	      input.close(); 
	     } 
	     //如果游标遇到文件夹 
	     if (temp.isDirectory()) { 
	      copyFolder(oldPath + "/" + file[i], newPath + "/" + file[i]); 
	     } 
	    } 
	   } catch (Exception e) { 
	    System.out.println("复制整个文件夹内容操作出错"); 
	   } 
	  } 
	 } 
