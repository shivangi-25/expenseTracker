package MT;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution3 {
	
	public static List<Integer> getFactors(int number) {
		int factorNumber = 1;
		List<Integer> factors = new ArrayList<>();
		while(factorNumber <= number){
		    if(number % factorNumber == 0){
		        factors.add(factorNumber);
		    }
		    factorNumber++;
		}
	 return factors;
	}
	
	public static String PS_logic(int n){
//		for (int i=1;i<=n;i++) {
//	        if (n%i==0) 
		List<Integer> list_factors;
		list_factors=getFactors(n);
		System.out.println("the factors of "+n+ " are : " +list_factors);
		
		if(list_factors.contains(3))
		{
			if(list_factors.contains(5))
				return "mytheresa";
			
			if(list_factors.contains(7))
				return "myclothes";
			
				return "my";
		}	
		
		else if(list_factors.contains(5))
			return "theresa";
		
		else if(list_factors.contains(7))
			return "clothes";
		
		else
			
			return ""+n;
					}
	

	public static void main(String[] args) {
	
		
		Scanner scan = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int num = scan.nextInt();
        System.out.println("number is: "+num);

		String result=PS_logic(num);
        System.out.println("result is: "+result);
scan.close();
	}

}
