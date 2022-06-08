// Name:- Shivam Sharma
// Student Id:- A00253431
// Program Description:- Program for Encryption and Decryption with Ceaser's Cipher Technique, Calculate Average of Array Elements, Search an Element from Array and Reverse Array.

package com.example.ArrayToolsLab;

import java.util.Scanner; 
import java.util.Arrays;

public class MyCeaserShift
{    
    //------ The Main Method which collects inputs and testing every above defined methods 
    public static void main(String[] args)
	{
        // --- Calling method of Ceaser's Cipher for encryption 
        Scanner initVal = new Scanner(System.in);  
        System.out.print("Enter the String you want to encrypt : ");
        String Str = initVal.next();
        System.out.print("Enter the value to encrypt with : ");
        int shiftKey = initVal.nextInt();
        
        String CipherTxt = Encrypt(Str, shiftKey);
        System.out.println("The encrypted string is : " + CipherTxt);   
        
        // --- Calling method of Ceaser's Cipher for decryption 
        String decryptTxt = Decrypt(CipherTxt, shiftKey);
        System.out.println("The decrypted string is : " + decryptTxt);        	

        //--- Asking for Array size and elements from Users
        int n;
        System.out.print("Enter the number of elements or Array Size : "); 
        //--- Reading the number of elements from the that user want to enter
        n = initVal.nextInt();  
        
        int[] myArray = new int[n]; //--- Creating an array in the memory
        System.out.println("Enter the elements of the array : ");  
        for(int i=0; i<n; i++)  
        {  
        	//--- Reading array elements from the user 
        	myArray[i] = initVal.nextInt();  
        }  
        System.out.println("Array elements are: ");  
        
        // --- Printing array elements 
        for (int i=0; i<n; i++)   
        {  
        	System.out.println(myArray[i]);  
        }  

        // --- Calling method for calculate average of array elements 
        ArrAvg(myArray);
        
        // --- Calling method for search an entered element from array 
        System.out.print("Enter the element you want to search : ");
        int searchKey = initVal.nextInt();
        initVal.close();
        SearchArr(myArray, searchKey);

        // --- Calling method for reverse array elements 
        ReverseArr(myArray, myArray.length);
	}

    //--- Method to Encryption of String using Ceaser's Cipher technique
    public static String Encrypt(String plainStr, int shiftTo)
    {
    	if(shiftTo > 26)
    	{
    		shiftTo = shiftTo % 26;
    	}
    	else if(shiftTo < 0)
    	{
    		shiftTo = (shiftTo % 26) + 26;
    	}
    	
    	String encryptStr = "";
    	int lngth = plainStr.length();
    	for(int i = 0; i < lngth; i++)
    	{
    		char ch = plainStr.charAt(i);
    		if(Character.isLetter(ch))
    		{
    			if(Character.isLowerCase(ch))
    			{
    				char newChar = (char)(ch + shiftTo);
    				if(newChar > 'z')
    				{
    					encryptStr = encryptStr + (char)(ch - (26 - shiftTo));
    				}
    				else
    				{
    					encryptStr = encryptStr + newChar;
    				}
    			}
    			else if(Character.isUpperCase(ch))
    			{
    				char newChar = (char)(ch + shiftTo);
    				if(newChar > 'Z')
    				{
    					encryptStr = encryptStr + (char)(ch - (26 - shiftTo));
    				}
    				else
    				{
    					encryptStr = encryptStr + newChar;
    				}
    			}
    		}
    		else
    		{
    			encryptStr = encryptStr + ch;
    		}
    	}
    	return encryptStr;
    }

    //--- Method to Encryption of String using Ceaser's Cipher technique
    public static String Decrypt(String plainStr, int shiftTo)
    {
    	if(shiftTo > 26)
    	{
    		shiftTo = shiftTo % 26;
    	}
    	else if(shiftTo < 0)
    	{
    		shiftTo = (shiftTo % 26) + 26;
    	}
    	
    	String decryptStr = "";
    	int lngth = plainStr.length();
    	for(int i = 0; i < lngth; i++)
    	{
    		char ch = plainStr.charAt(i);
    		if(Character.isLetter(ch))
    		{
    			if(Character.isLowerCase(ch))
    			{
    				char newChar = (char)(ch - shiftTo);
    				if(newChar < 'a')
    				{
    					decryptStr = decryptStr + (char)(ch + (26 + shiftTo));
    				}
    				else
    				{
    					decryptStr = decryptStr + newChar;
    				}
    			}
    			else if(Character.isUpperCase(ch))
    			{
    				char newChar = (char)(ch - shiftTo);
    				if(newChar < 'A')
    				{
    					decryptStr = decryptStr + (char)(ch + (26 + shiftTo));
    				}
    				else
    				{
    					decryptStr = decryptStr + newChar;
    				}
    			}
    		}
    		else
    		{
    			decryptStr = decryptStr + ch;
    		}
    	}
    	return decryptStr;
    }

    //--- Method to calculate average of all values of an Array 
    public static void ArrAvg(int Arr[])
    {
    	int sumOfArr = 0;
    	int avgOfArr = 0;
    	for(int i = 0; i < Arr.length; i++)
    	{
    		sumOfArr = sumOfArr + Arr[i];
    	}
    	avgOfArr = sumOfArr/Arr.length;
    	System.out.println("Average of Entered Array values : " + avgOfArr);
    }
    
    //--- Method to search a value into an array list
	public static void SearchArr(int Arr[], int searchVal)
    {        
        int Result = 0;

    	// -- Checking if the specified element is present in the array or not using contains() method
		for(int i = 0; i < Arr.length; i++)
        {
            if(Arr[i] == searchVal)
            {
            	Result = 1;
                break;
            }
            else
            {
            	Result = 0;
            }
        } 
		
        // --- Print the result
        if(Result == 1)
        {
            System.out.println("The array contains : " + searchVal);
        }
        else
        {
            System.out.println("The array does not contain : " + searchVal);        	
        }
    }

    //--- Method to Reverse an array values and add them into new array
    public static void ReverseArr(int firstArr[], int n)
    {
        int[] newArr = new int[n];
        int j = n;
        for (int i = 0; i < n; i++)
        {
        	newArr[j - 1] = firstArr[i];
            j = j - 1;
        }
        System.out.println("Reversed array values : " + Arrays.toString(newArr));
    }
}
