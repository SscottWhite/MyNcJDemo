package com.example.ThreadHard.service;

import java.util.ArrayList;

public class OneMoreList {
	private ArrayList<String> list = new ArrayList<String>();
	synchronized public void setList(String str) {
		list.add(str);
	}
	synchronized public int getList() {
		return list.size();
	}
}
