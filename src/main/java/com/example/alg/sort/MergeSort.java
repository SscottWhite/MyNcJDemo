package com.example.alg.sort;

/**
 * s 归并排序
 * ss 很有趣的递归算法, 先分两头逐布拆分, 在分布逐步聚合, 最后两个相溶, 
 * @author KJS_352
 *
 */
public class MergeSort {
	public static void main(String[] args) {
		int[] a = new int[] {1,6,3,2,8,5,7,4};
		int[] b = new int[a.length];
		sort(a,b,0,a.length-1);
		//int[] b = sort2(a,0,a.length-1);
		for(int x = 0; x < b.length; x++) {
			System.out.println(b[x]);			
		}
	}
	
	public static int[] sort(int[] array,int[] tmp ,int start, int end) {
		
		if(start < end) {
			 int mid = (end + start) / 2;
			 sort(array,tmp,start,mid);
			 sort(array,tmp,mid+1,end);
			 marge(array, tmp, start, mid, mid+1,end);//这个参数分两组, [  start - mid ]   ,[ mid+1 - end ]
		}
		return array;
	}
	
	public static void marge(int[] array,int[] temp, int head,int headmid,int footmid, int foot) {
		int len = foot - head + 1;//数组总长度
		int count = head;//计数器从头开始
		while(head <= headmid && footmid <= foot) {//两组分别开始
			if(array[head] < array[footmid]) {
				temp[count++] = array[head++];
			}else {
				temp[count++] = array[footmid++];
			}
		}
		//剩下的都直接接到后面
		while(head <= headmid) {
			temp[count++] = array[head++];
		}
		
		while(footmid <= foot) {
			temp[count++] = array[footmid++];
		}
		//把排好序的还给它
		for(int i = 0; i < len; i++, foot--) {
			array[foot] = temp[foot];
		}
		
	}
}
