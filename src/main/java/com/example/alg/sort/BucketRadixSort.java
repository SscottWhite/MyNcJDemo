package com.example.alg.sort;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * s 基数排序
 * @author KJS_352
 *
 */
public class BucketRadixSort {
	public static void main(String[] args) {
		int[] a = new int[] {1,6,3,21,2,8,5,7,4,22};
	//	int[] b = sort(a);
		int[] b = sort2(a);
		for(int x = 0; x < b.length; x++) {
			System.out.println(b[x]);			
		}
	}
	
	public static int[] sort(int[] list) {  
        radixSort(list, 0, list.length - 1, 3);  
        return list;  
    }  
	public static void radixSort(int[] list, int begin, int end, int digit) {  
        final int radix = 10; // 基数，定义为常量  
        int i = 0, j = 0;  
        int[] count = new int[radix]; // 存放各个桶的数据统计个数，10个桶  
        int[] bucket = new int[end - begin + 1];//list中的数量  
   
        // 按照从低位到高位的顺序执行排序过程  
        for (int d = 1; d <= digit; d++) {  
   
            // 置空各个桶的数据统计  
            for (i = 0; i < radix; i++) {  
                count[i] = 0;  
            }  
   
            // 统计各个桶将要装入的数据个数  
            for (i = begin; i <= end; i++) {  
                j = getDigit(list[i], d);  
                count[j]++;  
            }//对应的桶计数++，这里只是得到了每个桶会放的个数  
   
            // count[i]表示第i个桶的右边界索引  
            for (i = 1; i < radix; i++) {  
                count[i] = count[i] + count[i - 1];  
            }  
   
            // 将数据依次装入桶中  
            // 这里要从右向左扫描，保证排序稳定性  
            for (i = end; i >= begin; i--) {  
                j = getDigit(list[i], d); // 求出关键码的第k位的数字， 例如：576的第3位是5  
                bucket[count[j] - 1] = list[i]; // 放入对应的桶中，count[j]-1是第j个桶的右边界索引  
                count[j]--; // 对应桶的装入数据索引减一  
            }  
   
            // 将已分配好的桶中数据再倒出来，此时已是对应当前位数有序的表  
            for (i = begin, j = 0; i <= end; i++, j++) {  
                list[i] = bucket[j];  
            }  
        }  
    }
	 public static int getDigit(int x, int d) {  
	        int a[] = { 1, 1, 10, 100 }; 
	        //第一个没有用到，给多少都可以，保险给1， 本实例中的最大数是百位数，所以只要到100就可以了  
	        return ((x / a[d]) % 10);  
	        //187/10取得的值是18，所以再对10取余就可以获得其十位上的值  
	 }  	 	 
	 
	 
	 
	 
	public static int[] sort2(int[] arr) { 
	 //1.找出最大值
     int n = arr.length;
     int max = arr[0];
     for (int i = 1; i < n; i++) {
         if (max < arr[i]){
             max = arr[i];
         }
     }

     //2.求出对大值的位数
     int num = 1;
     while (max / 10 > 0){
         num++;
         max /= 10;
     }

     //3.创建桶
     List<LinkedList<Integer>> bucketList = new ArrayList<>(10);

     //4.初始化桶
     for (int i = 0; i < 10; i++) {
         bucketList.add(new LinkedList<>());
     }

     //5.把每个数放到对应的桶当中
     for (int i = 1; i <= num; i++){
         for (int j = 0; j < n; j++) {
             int index = (int) ((arr[j]/Math.pow(10, i-1)) % 10);
             bucketList.get(index).add(arr[j]);
         }

         //6.把桶中的数输出到原数组
         int k = 0;
         for (int j = 0; j < 10; j++){
             for (Integer integer : bucketList.get(j)) {
                 arr[k] = integer;
                 k++;
             }
             //清除桶中的元素
             bucketList.get(j).clear();
         }
     }
     return arr;
   }
}
