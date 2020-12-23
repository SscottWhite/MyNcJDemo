package com.example.alg;

public class SortTest {
	/*public static void main(String[] args) {
		int[] a = new int[1000];
		int j = 0;
		for(int i = 999; i > 0; i--) {
			if(i/100 == 7) {
				j++;
			}
			if((i/10)%10 == 7) {
				j++;
			}
			if(i%10 == 7) {
				j++;
			}
			
			a[i] = i;
		}
		System.out.print(j+","+a.length);
	}*/
	
	/*public static void main(String[] args) {
		int i = 1;
        i = i++;//这一步没自增
        int j = i++;
        int k = i + ++i * i++;
        System.out.println("i="+i);
        System.out.println("j="+j);
        System.out.println("k="+k);
	}*/
	
	public static void main(String[] args) {	
		int[] a = new int[] {1,6,3,2,8,5,7,4,9,20,33,32,23,12,11};
		int[] b = new int[a.length];
		
		long startTime = System.currentTimeMillis();
	BubbleSort.sort(a);
		long endTime = System.currentTimeMillis();
		System.out.println("冒泡:"+(endTime-startTime));
		long startTime1 = System.currentTimeMillis();
	DirectInsertSort.sort(a);
		long endTime1 = System.currentTimeMillis();
		System.out.println("插入:"+(endTime1-startTime1));
		long startTime2 = System.currentTimeMillis();
	MergeSort.sort(a,b,0,a.length-1);
		long endTime2 = System.currentTimeMillis();
		System.out.println("归并:"+(endTime2-startTime2));
		long startTime3 = System.currentTimeMillis();
	SelectSort.sort(a);
		long endTime3 = System.currentTimeMillis();
		System.out.println("选择:"+(endTime3-startTime3));
		long startTime4 = System.currentTimeMillis();
	ShellSort.sort(a);
		long endTime4 = System.currentTimeMillis();
		System.out.println("希尔:"+(endTime4-startTime4));
		long startTime5 = System.currentTimeMillis();
	QuickSort.sort(a,0,a.length-1);
		long endTime5 = System.currentTimeMillis();
		System.out.println("快速:"+(endTime5-startTime5));
	}
}
