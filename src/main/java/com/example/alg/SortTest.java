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
	
	public static void main(String[] args) {
		int i = 1;
        i = i++;//这一步没自增
        int j = i++;
        int k = i + ++i * i++;
        System.out.println("i="+i);
        System.out.println("j="+j);
        System.out.println("k="+k);
	}
}
