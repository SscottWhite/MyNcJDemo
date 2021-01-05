package com.example.alg;

/**
 * s 选择排序, 从前往后, 就是不停的对比, 选一个最小的放前面, 然后再同样比下去
 * @author KJS_352
 *
 */
public class SelectSort {
	
	public static void main(String[] args) {
		int[] a = new int[] {1,6,3,2,8,5,7,4};
		int[] b = sort(a);
	//	int[] b = sort2(a);
		for(int x = 0; x < b.length; x++) {
			System.out.println(b[x]);			
		}
	}
	
	public static int[] sort(int[] array) {
		int key,position;
		for(int i = 0; i < array.length; i++) {
			key = i;
			position = array[i];
			for(int j = i+1; j < array.length; j++) {
				if(position > array[j]) {
					position = array[j];//把最小值和位置记录下来, 换到i的起始位去
					key = j;
				}
			}
			//最小直位置和值 与 其起始的对调
			array[key] = array[i];
			array[i] = position;
		}
		return array;
	}
	
	public static int[] sort2(int[] array){ 
	    for(int i = 0;i<array.length-1;i++){ 
	        int min = array[i]; 
	        int minindex = i; 
	        for(int j = i;j<array.length;j++){ 
	            if(array[j]<min){ 
	            //选择当前最小的数 
	                min = array[j];
	                minindex = j; 
	             } 
	        } 
	        if(i != minindex){ 
	       //若i不是当前元素最小的，则和找到的那个元素交换 
	           array[minindex] = array[i]; 
	           array[i] = min; 
	        }
	    }
	    return array;
	}
}
