package com.first;

import java.util.Scanner;

public class MultipleThings {

	public static void main(String[] args) {
	   Scanner sc=new Scanner(System.in);
	   System.out.println("Enter the first Number ");
	   int a=sc.nextInt();
	   System.out.println("Enter the Second Number ");
	   int b=sc.nextInt();
	   System.out.println("what option do you want ");
	   int option=sc.nextInt();
	   
	   switch(option) {
	   case 1:
		   System.out.println("Addition of two number "+(a+b));
		   break;
		   
	   case 2:
		   System.out.println("Substraction of two Number "+(a-b));
		   break;
		   
	   case 3:
		   System.out.println("Multiplication of two Number "+(a*b));
		   break;
		   
	   case 4:
		   System.out.println("Division of two Number "+(a/b));
		   break;
		   
		   default:
			   System.out.println("invalid choice");
	   
	   }
	

	}

}
