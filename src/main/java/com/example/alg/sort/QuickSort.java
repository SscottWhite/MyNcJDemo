package com.example.alg.sort;

/**
 * s 快速排序 ,   从两头向中间比较, 去一个平衡值, 以值区分, 分别在进行
 * @author KJS_352
 *
 */
public class QuickSort {
	public static void main(String[] args) {
		int[] a = new int[] {1,6,3,2,8,5,7,4};
		int[] b = sort(a,0,a.length-1);
	//	int[] b = sort2(a,0,a.length-1);
		for(int x = 0; x < b.length; x++) {
			System.out.println(b[x]);			
		}
	}
	
	public static int[] sort(int[] array, int start, int end) {
		int a = 0;
		if(start < end) {
			//间接排序后再分开排序, 直至分到最小分区
			a = partition(array, start, end);
			sort(array,start,a);
			sort(array,a+1,end);
		}
		return array;
	}
	
	public static int partition(int[] array, int low, int high) {
		int position = array[low];

		while(low < high) {
			while( low < high && array[high] > position) {
				high--;//从后往前
			}
			array[low] = array[high];//把小的换到前面
			while( low < high && array[low] < position) {
				low++;//从前往后
			}
			array[high] = array[low];//把大得换到后面
		}
		array[low] = position;//给空的赋值
		return low;//取得中间值位置
	}
	
	
	
	
	
	public static int[] sort2(int[] numbers, int start, int end) { 
	    if (start < end) {
	         int base = numbers[start]; // 选定的基准值（第一个数值作为基准值）
	         int temp; // 记录临时中间值 
	         int i = start, j = end;
	         do { 
	             while ((numbers[i] < base) && (i < end)) i++;
	             while ((numbers[j] > base) && (j > start)) j--;
	             if (i <= j) { 
	                 temp = numbers[i];
	                 numbers[i] = numbers[j]; 
	                 numbers[j] = temp; 
	                 i++; 
	                 j--;
	             }
	        } while (i <= j); 
	        if (start < j) sort2(numbers, start, j); 
	        if (end > i) sort2(numbers, i, end); 
	    }
	    return numbers;
	}
}
