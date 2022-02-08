package chegg;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class fFibonacci {
	public static List<Integer> findNdigidFibonacciseries(int n)
	{
		List<Integer> result=new ArrayList<>();
		List<Integer> fibo=new ArrayList<>();
		fibo.add(1);
		fibo.add(1);
		int i=2;
		if(n==1)
		{
			return fibo;
		}
		while(true)
		{
			fibo.add(fibo.get(i-2)+fibo.get(i-1));
			if(fibo.get(i).toString().length()==n) {
				result.add(fibo.get(i));

			}
			 if(fibo.get(i).toString().length()>n) {
				break;
			}
			 i++;
			
		}
		return result;
	}
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the value of n : ");
		int n=sc.nextInt();
		List<Integer> list=new ArrayList<>();
		list=findNdigidFibonacciseries(n);
		System.out.println("The Fibonacci terms with "+n+" digigts are:");
		for(int i:list)
		{
			System.out.println(i);
		}
	}

}
