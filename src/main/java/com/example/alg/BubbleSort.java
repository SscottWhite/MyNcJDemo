package com.example.alg;

/**
 * s 冒泡排序
 * @author KJS_352
 *
 */
public class BubbleSort {
	
	public static void main(String[] args) {
		int[] a = new int[] {1,6,3,2,8,5,7,4};
		int[] b = sort(a);
	//	int[] b = sort2(a);
		for(int x = 0; x < b.length; x++) {
			System.out.println(b[x]);			
		}
	}
	
	public static int[] sort(int[] array) {
		int a = array.length;
		int tmp;
		for(int i = 0; i < a; i++) {
			for(int j = 0; j < a-i-1; j++) {
				if(array[j] > array[j+1]) {
					tmp = array[j];
					array[j] = array[j+1];
					array[j+1] = tmp;
				}
			}
		}
		return array;
	}
}
