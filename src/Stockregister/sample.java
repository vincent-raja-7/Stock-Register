/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Stockregister;
import java.util.*;
/**
 *
 * @author DELL
 */
public class sample {
    public static String convert(int n)
    {
        if (n == 0)  
                return "zero";  
            String words = "";  
            if ((n / 1000) > 0)  
            {
                if(n%1000 == 0)
                {
                  words = words+ convert(n / 1000) + " Thousand ";  
                  n=n % 1000;
                  
                }
                 else
                {
                    words = words+ convert(n / 1000) + " Thousand and ";  
                  n=n % 1000;
                }
                    
                  
            }  
            if ((n / 100) > 0)  
            {  
                if(n%100 == 0)
                {
                   words = words+ convert(n / 100) + " Hundred ";  
                   n = n % 100;  
                  
                }
                 else
                {
                     words = words+ convert(n / 100) + " Hundred and  ";  
                     n = n % 100;  
                }
               
            }  
            if (n > 0)  
            {  
                String [] units = { "Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen" };  
                String [] tens =  { "Zero", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety" };  
                if (n < 20)  
                    words = words+ units[n];  
                else  
                {  
                    words = words+ tens[n / 10];  
                    if ((n % 10) > 0)  
                        words = words+ " " + units[n % 10];  
                }  
            }  
            return words;  
    }
	public static void main(String[] args) {
	    Scanner s=new Scanner(System.in);
		System.out.println("Enter a Number : ");
		int n= s.nextInt();
		System.out.println("The Word Format is : "+ convert(n));
	}
}
