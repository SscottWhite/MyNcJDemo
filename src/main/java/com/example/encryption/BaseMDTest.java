package com.example.encryption;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;

import javax.mail.Message;

public class BaseMDTest {
	public static void main(String[] args) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		String enstr = URLEncoder.encode("中文", StandardCharsets.UTF_8);
		System.out.println(enstr);
		String str = URLDecoder.decode(enstr, StandardCharsets.UTF_8);
		System.out.println(str);
		
		byte[] input = new byte[] {(byte)0xe4,(byte)0xb8,(byte)0xad};
		String base = Base64.getEncoder().encodeToString(input);
		System.out.println(base);		
		System.out.println(Arrays.toString(Base64.getDecoder().decode(base)));
		
		byte[] input2 = new byte[] {(byte)0xe4,(byte)0xb8,(byte)0xad,0x21};
		String base2 = Base64.getEncoder().encodeToString(input2);//基本就不是三的倍数,那会补齐,用=表示,
		String base22 = Base64.getEncoder().withoutPadding().encodeToString(input2);// withoutPadding就是来去掉=的
		System.out.println(base2);	
		System.out.println(base22);	
		System.out.println(Arrays.toString(Base64.getDecoder().decode(base22)));
		
		
		MessageDigest md = MessageDigest.getInstance("MD5");
		md.update("Hello".getBytes("UTF-8"));
		md.update("World".getBytes("UTF-8"));
		System.out.println(new BigInteger(1,md.digest()).toString(16));
		
	}
}
