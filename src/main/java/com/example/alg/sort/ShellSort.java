package com.example.alg.sort;
/**
 * s 希尔排序  ,有定长, 二分排序
 * s  给量大的数据先排好序, 再采用直接排序
 * @author KJS_352
 *
 */
public class ShellSort {
	public static void main(String[] args) {
		int[] a = new int[] {1,6,3,2,8,5,7,4};
	//	int[] b = sort(a);
		int[] b = sort2(a);
		for(int x = 0; x < b.length; x++) {
			System.out.println(b[x]);			
		}
	}
	
	public static int[] sort(int[] array) {
		int arrLen = array.length;
		while(arrLen != 0) {//其实是不停地区分组, 直到分不出组
			arrLen = arrLen / 2;//一半, 分成两组
			for(int x = 0; x < arrLen; x++) {//区分一下, 这是两组中的前一组
				//加的是间隔值, 所以比较的条件是总长度, 累加间隔值
				for(int y = x+arrLen; y < array.length; y += arrLen) { 
					int j = y - arrLen;//返回到前一组
					int tmp = array[y];//后一组的值
					for(; j >= 0 && tmp < array[j]; j -= arrLen) {//比大小, 采用正序
						array[j+arrLen] = array[j];//把前面的移到后面
					}
					array[j+arrLen] = tmp;
				}
			}
		}
		return array;
	}
	
	public static int[] sort2(int[] array){ 
	    int j; 
	    for(int gap = array.length/2; gap>0; gap /= 2){ 
	    //定义一个增长序列，即分割数组的增量,d1=N/2 dk=(d(k-1))/2 
	        for(int i = gap; i<array.length; i++){ 
	            int tmp = array[i]; 
	            for( j = i; j >= gap && tmp < array[j-gap]; j -= gap){
	             //将相距为Dk的元素进行排序 
	                 array[j] = array[j-gap];
	            } 
	            array[j] = tmp;
	        } 
	    } 
	    return array;
	}
}
