package com.example.alg;

import java.util.ArrayList;
import java.util.List;

//贪心算法- prim算法
public class Prim {
	static int MAX = Integer.MAX_VALUE;
	
	public static void main(String[] args) {
		//定义无向图矩阵
		int[][] map = new int[][] {
			{ 0, 1, 6, 2},
			{ 1, 0, 3, 2},
			{ 6, 3, 0, 1},
			{ 2, 2, 1, 0}
		};
		prim(map, map.length);
	}
	
	public static void prim(int[][] graph, int n){
		//定义节点名字
		char[] c = new char[]{'A','B','C','D'};
		int[] lowcost = new int[n]; //到新集合的最小权
		int[] mid= new int[n];//存取前驱结点
		List<Character> list=new ArrayList<Character>();//用来存储加入结点的顺序
		int i, j, min, minid , sum = 0;
		//初始化辅助数组
		for(i=1;i<n;i++)
		{
			lowcost[i]=graph[0][i];
			mid[i]=0;
		}
		list.add(c[0]);
		//一共需要加入n-1个点
		for(i=1;i<n;i++)
		{
			min=MAX;
			minid=0;
			//每次找到距离集合最近的点
			for(j=1; j<n; j++)
			{
				if(lowcost[j] != 0 && lowcost[j] < min)
				{
					min=lowcost[j];
					minid=j;
				}
			}
			if(minid == 0) return;
			list.add(c[minid]);
			lowcost[minid] = 0;
			sum += min;
			System.out.println(c[mid[minid]] + "到" + c[minid] + " 权值：" + min);
			//加入该点后，更新其它点到集合的距离
			for(j=1;j<n;j++)
			{
				if(lowcost[j] != 0 && lowcost[j] > graph[minid][j])
				{
					lowcost[j] = graph[minid][j];
					mid[j] = minid;
				}
			}
			System.out.print("\n");
		}
		System.out.println("sum:" + sum);
	}
}
