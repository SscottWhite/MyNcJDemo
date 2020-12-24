package com.example.alg;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class BucketSort {
	
	public static void main(String[] args) {
	    double[] arr = new double[]{4.12, 6.421, 0.0023, 3.0, 2.123, 8.122, 4.12, 10.09};
	    System.out.println(Arrays.toString(arr));
	    arr = sort(arr);
	    System.out.println(Arrays.toString(arr));
	}
	
	public static double[] sort(double[] arr){
        //1.计算出最大值和最小值，求出两者的差值
        double min = arr[0];
        double max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (max < arr[i]){
                max = arr[i];
            }
            if (arr[i] < min){
                min = arr[i];
            }
        }
        double d = max - min;

        //2.初始化桶
        int bucketNum = arr.length;
        List<LinkedList<Double>> bucketList = new ArrayList<>(bucketNum);
        for (int i = 0; i < bucketNum; i++) {
            bucketList.add(new LinkedList<>());
        }

        //3.遍历数组中的元素，把所有元素都放入对应的桶当中
        for (int i = 0; i < arr.length; i++) {
            //计算当前元素应该放在哪个桶里面
            int num = (int)((arr[i] - min) / (d / (bucketNum - 1)));
            bucketList.get(num).add(arr[i]);
        }

        //4.对每个桶里面的元素进行排序
        for (int i = 0; i < bucketNum; i++) {
            Collections.sort(bucketList.get(i));
        }

        //5.输出全部元素
        int k = 0;
        for(LinkedList<Double> doubles : bucketList){
            for (Double aDouble : doubles) {
                arr[k] = aDouble;
                k++;
            }
        }
        return arr;
    }
	
	public static void sort2(int[] arr){
	    //分桶，这里采用映射函数f(x)=x/10。
	    //输入数据为0~99之间的数字
	    int bucketCount =10;
	    Integer[][] bucket = new Integer[bucketCount][arr.length];  //Integer初始为null,以与数字0区别。
	    for (int i=0; i<arr.length; i++){
	        int quotient = arr[i]/10;   //这里即是使用f(x)
	        for (int j=0; j<arr.length; j++){
	            if (bucket[quotient][j]==null){
	                bucket[quotient][j]=arr[i];
	                break;
	            }
	        }
	    }
	    //小桶排序
	    for (int i=0; i<bucket.length; i++){
	            //insertion sort
	            for (int j=1; j<bucket[i].length; ++j){
	                if(bucket[i][j]==null){
	                    break;
	                }
	                int value = bucket[i][j];
	                int position=j;
	                while (position>0 && bucket[i][position-1]>value){
	                    bucket[i][position] = bucket[i][position-1];
	                    position--;
	                }
	                bucket[i][position] = value;
	            }
	                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            
	    }
	    //输出
	    for (int i=0, index=0; i<bucket.length; i++){
	        for (int j=0; j<bucket[i].length; j++){
	            if (bucket[i][j]!=null){
	                arr[index] = bucket[i][j];
	                index++;
	            }
	            else{
	                break;
	            }
	        }
	    }
	}
}	
