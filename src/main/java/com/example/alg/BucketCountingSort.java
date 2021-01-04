package com.example.alg;
/**
 * s 桶排序的一种 计数排序
 * @author KJS_352
 *
 */
public class BucketCountingSort {
	public static void main(String[] args) {
		int[] a = new int[] {1,6,3,21,2,7,4,22,8,8};
	//	int[] a = new int[] {2,1,3,5,3};
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
	        data[--buckets[tmp[k] - min]] = tmp[k]; //如果是一样的数值, 确实只要取同一位置的数, 但是数值已经--了
	        //如果你不明白上面的同值 .  说明还不是很熟悉 --bucket 的意思
	    }
	    return data;
	}
	
	
	public static int[] sort2(int[] arr) {
		int n = arr.length;
	    //先定义两个变量用来存放数组中的最大值和最小值
	    int min = arr[0];
	    int max = arr[0];
	    for (int i = 1; i < n; i++){
	        if (max < arr[i]){
	            max = arr[i];
	        }
	        if (arr[i] < min){
	            min = arr[i];
	        }
	    }
	    //定义一个长度为len的数组，这样做是为了防止数组中的最小值为1000，最大值为1010
	    //这样创建一个大小为10的数组就行了，不用创建大小为1010的数组，浪费空间
	    int len = max - min + 1;
	    //哪个数字出现了一次，就把它的数字作为下标存起来，假如1006出现了一次，就把temp[1006-1000]加一
	    int[] temp = new int[len];
	    for (int i = 0; i < n; i++) {
	        temp[arr[i] - min]++;
	    }
	    int k = 0;
	    //对temp进行遍历，temp[i]的值就是i出现的次数，加入temp[5]=3，说明(5+1000)出现了3次
	    for (int i = 0; i < len; i++) {
	        for (int j = temp[i]; j > 0; j--){
	            arr[k] = i + min;
	            k++;
	        }
	    }

	    return arr;
	}
}
