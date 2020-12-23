package com.example.alg;
/**
 * s 桶排序
 * @author KJS_352
 *
 */
public class BucketSort {
	public static void main(String[] args) {
		int[] a = new int[] {1,6,3,21,2,8,5,7,4,22};
		int[] b = sort(a,1,23);
	//	int[] b = sort2(a);
		for(int x = 0; x < b.length; x++) {
			System.out.println(b[x]);			
		}
	}
	
	//min的值为0，max的值为待排序数组中最大值+1 
	public static int[] sort(int[] data, int min, int max) { 
	    // 缓存数组 
	    int[] tmp = new int[data.length]; 
	    // buckets 用于记录待排序元素的信息 
	    // buckets数组定义了max-min个桶 
	    int[] buckets = new int[max - min];//给的是数组最最最大的长度,因为是有最大和最小值
	    // 计算每个元素在序列出现的次数 , 本身数值为0 , ++只能计数
	    for (int i = 0; i < data.length; i++) {
	         buckets[data[i] - min]++;
	    } 
	    // 计算 落入 各桶内的元素在有序序列中的位置 ,就是把上面的计数值变成像排序一样的计数值
	    for (int i = 1; i < max - min; i++) { 
	        buckets[i] = buckets[i] + buckets[i - 1];
	    } 
	    // 将data中的元素完全复制到tmp数组中 
	    System.arraycopy(data, 0, tmp, 0, data.length); 
	    // 根据buckets 数组中的信息将待排序列的各元素放入相应位置 
	    for (int k = data.length - 1; k >= 0; k--) { 
	        data[--buckets[tmp[k] - min]] = tmp[k]; 
	    }
	    return data;
	}
}
