package com.example.alg;

/**
 *s   插入排序
 *s   很直接的,   把后一个数与前面排好序的作比较,不停地对调, 直到排好序,插入位置中
 * @author KJS_352
 *
 */
public class DirectInsertSort {
	public static void main(String[] args) {
		int[] a = new int[] {1,6,3,2,5,4};
	//	int[] b = sort(a);
		int[] b = sort2(a);
		for(int x = 0; x < b.length; x++) {
			System.out.println(b[x]);			
		}
	}
	
	public static int[] sort(int[] array) {
		int arrLen = array.length;
		int count;
		for(int i = 1; i < arrLen; i++) {
			count = array[i];	
			int j = i-1;//这个起始的长度, 就是从第二个开始, 把前面的都排序好了
			while(j >= 0 && array[j] > count) {//就是不停判断,把数往后移,不停地减, 反正会占用一个位置
				array[j+1] = array[j];
				j--;
			}
			//把占用的位置填上
			array[j+1] = count;
		}
		return array;
	}
	
	public static int[] sort2(int[] array){
	     int tmp; 
	     for(int i=1;i<array.length;i++){ 
	         tmp = array[i]; //将当前位置的数给tmp 
	         int j = i; 
	             for( ; j>0 && array[j-1] > tmp; j--){
	               //往右移腾出左边的位置,array[j-1]>tmp大于号是升序排列，小于号是降序排列 */ 
	                array[j] = array[j-1]; 
	              } 
	         //将当前位置的数插入到合适的位置 
	         array[j] = tmp;
	     }
	     return array;
	 }
}
