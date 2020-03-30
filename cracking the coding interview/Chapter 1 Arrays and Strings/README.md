

1. A Unique occurences of characters. Form a boolean array of 128 characters. Write 128 as *1<<7*.


> Time complexity O(n). n is *length* of string given as input. or you can say O(1) because\
the for loop will never iterate beyond 128 as this is a constant which we have already learnt.

```java

public class Unique  {
	public static void main(String[] args) {
		// This is the intuitive way of  writing 128 :)
		System.out.println(1<<7);  
		System.out.println(isUnique("hity"));
	}

	static private boolean isUnique(String str){
		if(str.length()>128) return false;
		boolean unique[]=new boolean[1<<7];
		for (int i=0; i<str.length(); i++) {
			if(unique[str.charAt(i)]){
				return false;
			}
			unique[str.charAt(i)]=true;
		}

		return true;
	}
}
```



2. Out of the box.


*Boolean can't be assigned to integer.*

```java
public class Unique  {
	public static void main(String[] args) {
		

		int a=5,b=4;
		System.out.println(a*=b);

		System.out.println(a=(a==b));
		System.out.println(a==b);

	}
	
	
}
```







1. B We can reduce our space usage by a factor of eight by using a bit vector

*Ask this concept*

:-1:

```java

boolean isUniqueChars(String stn) {

 int checker = 0;
 for (int i = 0; i < Str.lengthQ ; i++) {
 int val « str.charAt(i) - raJ;
 if ((checker & (1 << val)) > 0) {
 return false ;
 }
 checker |= (1 << val) ;
 >
 return true ;
 
``` 




---

2. Check if a string is permutation of another


*O(n^2) Solution*



```java
public class Unique  {
	public static void main(String[] args) {
		
 		System.out.println(isPermute("abc","bca"));

	}
		
	private static boolean isPermute(String a,String b){

		if(a.length()!=b.length()) return false;
		int flag;

		for (int i=0; i<a.length();i++ ) {
			flag=0;
			for (int j=0;j<b.length() ; j++ ) {
				if(a.charAt(i)==b.charAt(j)){
					flag=1;
					break;
				}
			}
			if(flag==0){
				return false;
			}
		}

		return true;
	}
	
}

```

*O(nlogn) The much better approach is to sort both of the strings and check they are equal or not*


```java
import java.util.*;
public class Unique  {
	public static void main(String[] args) {
		
 		System.out.println(permute("abcc","bcac"));

	}
	
	private static String sort(String s){
		char array[]=s.toCharArray();
		Arrays.sort(array);
		return new String(array);
	}
	

	private static boolean permute(String first,String second){
		if(first.length()!=second.length()) return false;
		return sort(first).equals(sort(second));
	}
}
```



*Another intuitive approach to solve*

```java
import java.util.*;
public class Unique  {
	public static void main(String[] args) {
		
 		System.out.println(permute("hello","hello"));

	}
	


	private static boolean permute(String first,String second){
		if(first.length()!=second.length()) return false;


		int counts[]=new int[1<<7];
		char one[]=first.toCharArray();
		for(char c:one) counts[(int)c]++;

		char two[]=second.toCharArray();
		// for(char c:two) counts[(int)c]--; now to avoid use of a extra loop simple use 
	// regular for loop and after each iteration compare the value
		// for(int x:counts){
		// 	if(x!=0) return false;
		// }


		for(int i=0;i<two.length;i++){
			int c=(int)two.charAt(i);
			counts[c]--;
			if(counts[c]<0) return false; //can't make out of this line
		}


		return true;


	}
}

```


---



:earth:



## 3 URLify

1. This is the most basic solution that I came out with.

---


```java
import java.util.*;
public class Unique  {
	public static void main(String[] args) {
		
 		System.out.println(URLify("Mr John Smith"));

	}

	private static String URLify(String first){
			StringBuilder answer=new StringBuilder("");
			char array[]=first.toCharArray();
			for(char c:array){
				if(c!=32) answer.append(c);
				else answer.append("%20"); 
			}


		return answer.toString();

	}
}

Output 
Mr%20John%20Smith


```


*Can't make out of this solution*


```java
import java.util.*;
public class Unique  {
	public static void main(String[] args) {
		
 		System.out.println(URLify("Mr John Smith"));

	}
	


	private static String URLify(char[] str,int trueLength){
		int spaceCount=0,index,i=0;
		for(i=0;i<trueLength;i++){
			if(str[i]==' ') spaceCount++;
		}

		index=trueLength+spaceCount*2;

		if(trueLength<str.length) str[trueLength]='\0'; //end array can't make out this



		for(i=trueLength-1;i>=0;i--){
			if(str[i]==' '){
				str[index-1]='0';
				str[index-2]='2';
				str[index-3]='%';
				index=index-3
			}else{
				str[index-1]=str[i];
				index--;
			}
		}

	}
}


```



---






# Palindrome permutation


1. O(n) solution. Only *one* odd occurence is allowed while the even occurences prevail.

```java
import java.util.*;
public class Unique  {
	public static void main(String[] args) {
		System.out.println(isPermutationOfPalindrome("aammi"));
 		 
	}
	
	private static boolean isPermutationOfPalindrome(String phrase){
		int[] table=buildCharFrequencyTable(phrase);
		return checkMaxOneOdd(table);
	}


	// foundOdd is set to true if any odd occuerence is found once , for the second time it turns out that false value is returned from this function

	private static boolean checkMaxOneOdd(int[] table){
		boolean foundOdd=false;
		for(int count:table){
			if(count%2==1){
				if(foundOdd){
					return false;
				}
				foundOdd=true;
			}
		}
		return true;
	}

	private static int getCharNumber(Character c){
		int a=Character.getNumericValue('a');
		int z=Character.getNumericValue('z');
		int val=Character.getNumericValue(c);

		if(a<=val&&val<=z){
			return val-a;
		}
		return -1;
	}

	private static int[] buildCharFrequencyTable(String phrase){
		System.out.println(Character.getNumericValue('z'));
		System.out.println(Character.getNumericValue('a'));

		System.out.println(Character.getNumericValue('z')-Character.getNumericValue('a')+1);
		int[] table=new int[Character.getNumericValue('z')-Character.getNumericValue('a')+1];
		for(char c:phrase.toCharArray()){
			int x=getCharNumber(c);
			if(x!=-1){
				table[x]++;
			}
		}
		for(int x:table){
			System.out.print(" "+x);
		}
		return table;
	}
}
```



2. Another approach

*We can't optimize the big 0 time here since any algorithm will always have to look through the entire
string. However, we can make some smaller incremental improvements. Because this is a relatively simple
problem, it can be worthwhile to discuss some small optimizations or at least some tweaks.
Instead of checking the number of odd counts at the end, we can check as we go along. Then, as soon as
we get to the end .*


```java
import java.util.*;
public class Unique  {
	public static void main(String[] args) {
		System.out.println(isPermutationOfPalindrome("malayalam"));
 		 
	}
	
	private static boolean isPermutationOfPalindrome(String phrase){
		int countOdd=0;
		int[] table=new int[Character.getNumericValue('z')-Character.getNumericValue('a')+1];
		for(char c:phrase.toCharArray()){
			int x=getCharNumber(c);
			table[x]++;
			if(table[x]%2==1){
				countOdd++;
			}
			else{
				countOdd--;
			}
		}
		return countOdd<=1;

	}





	private static int getCharNumber(Character c){
		int a=Character.getNumericValue('a');
		int z=Character.getNumericValue('z');
		int val=Character.getNumericValue(c);

		if(a<=val&&val<=z){
			return val-a;
		}
		return -1;
	}
}
 
```




---

#### Solution third using bitmask :(

---





## 5 One away

---

*Apprach 1*

```java
import java.util.*;
public class Unique  {
	public static void main(String[] args) {
	 
     	String a = "pie";
		String b = "pale";
		boolean isOneEdit = oneEditAway(a, b);
		System.out.println(a + ", " + b + ": " + isOneEdit);
	}
	
	 

	private static boolean oneEditAway(String first,String second){
		if(first.length()==second.length()){
			return oneEditReplace(first,second);
		}
		else if(first.length()+1==second.length()){
			return oneEditInsert(first,second);
		}
		else if(first.length()-1==second.length()){
			return oneEditInsert(second,first);
		}
		else{
			return false;
		}
	}



	private static boolean oneEditReplace(String first,String second){
		boolean foundDifference=false;
		for (int i=0; i<first.length(); i++) {
			if(first.charAt(i)!=second.charAt(i)){
				if(foundDifference){
					return false;
				}
				foundDifference=true;
			}

		}
		return true;
	}

	private static boolean oneEditInsert(String first,String second){
		int index1=0;
		int index2=0;
		while(index2<second.length()&&index1<first.length()){
			if(first.charAt(index1)!=second.charAt(index2)){
				if(index1!=index2){
					return false;
				}
				index2++;
			}
			else{
				++index1;
				++index2;
			}
		}
		return true;
	}
}
 
```


*2 Approach two, this is better but I can't make out of this*


```java
import java.util.*;
public class Unique  {
	public static void main(String[] args) {
	 
     	String first = "pales";
		String second = "pale";

		 


		boolean isOneEdit = oneEditAway(first,second);
		System.out.println(first + ", " + second+ ": " + isOneEdit);
	}
	
	 

	private static boolean oneEditAway(String first,String second){
 		if(Math.abs(first.length()-second.length())>1) return false;


 		String one=first.length()<second.length()?first:second;
 		String two=first.length()<second.length()?second:first;

 		int index1=0;
 		int index2=0;
 		boolean foundDifference=false;
 		while(index2<two.length()&&index1<one.length()){
 			if(one.charAt(index1)!=two.charAt(index2)){
 				if(foundDifference) return false;

 				foundDifference=true;

 				if(one.length()==two.length()){
 					index1++; // on replace move shorter pointer
 				}


 			}
 			else{
 				++index1;	    //if matching move shorter pointer
 			}
 			++index2;
 		}
 		return true;
	}

}
 

```

---





### 5. String compression


1. My solution **O(n^2)** Naive approach
 


```java
import java.util.*;
public class Unique  {
	public static void main(String[] args) {
	 
        String s="aabcccccaaaaax";
        System.out.println(stringCompression(s));

	}


	private static String stringCompression(String s){
		int count;
		StringBuilder answer=new StringBuilder("");
		for (int i=0; i<s.length(); i++) {
			count=1;
			char c=s.charAt(i);
			while((i<s.length()-1)&&c==s.charAt(i+1)){
				count++;
				i++;
			}
			answer.append(c);
			answer.append(count);
		}
		return answer.toString();
	}

 
}	
 




```


2. Solution from byte by byte 


```java

import java.util.*;
public class Unique  {
	public static void main(String[] args) {
	 
        String s="aabcccccaaaaax";
        System.out.println(stringCompression(s));

	}


	private static String stringCompression(String s){
		int count=1;
		StringBuilder answer=new StringBuilder("");
		for (int i=0; i<s.length(); i++) {
			if((i<s.length()-1)&&s.charAt(i)==s.charAt(i+1)){
				count++;
			}			
			else{
				answer.append(s.charAt(i));
				answer.append(count);
				count=1;
			} 
		} 

		if(s.length()<answer.length()) return s;

		return answer.toString();
	}

 
}	
 



```



3. Need to go through the solution of the author once more.
















### 8 Zero matrix


1. My solution just a simple way to do it.  

```java
 

public class Unique {

 	public static void main(String[] args) {
		 
 		int m=3;
 		int n=3; 
 		int[][] a={{1,0,1},{1,1,1},{1,1,1}};
 		int[][] b={{1,0,1},{1,1,1},{1,1,1}};


		 for(int i=0;i<n;i++){
			  for(int j=0;j<m;j++){
      			if(a[i][j]==0){
					for(int x=0;x<n;x++){
		   			 b[i][x]=0;
					}
					for(int y=0;y<m;y++){
					    b[y][j]=0;
					}		
		   }
	}
		

}


	for(int[] x:b){
		for(int element:x){
			System.out.print(element+"       ");
		}
		System.out.println();
	}




	}
}

```








2. Solution of the author.



```java

public class Unique{
	public static void nullifyRow(int[][] matrix, int row) {
		for (int j = 0; j < matrix[0].length; j++) {
			matrix[row][j] = 0;
		}		
	}

	public static void nullifyColumn(int[][] matrix, int col) {
		for (int i = 0; i < matrix.length; i++) {
			matrix[i][col] = 0;
		}		
	}			
	
	public static void setZeros(int[][] matrix) {
		boolean[] row = new boolean[matrix.length];	
		boolean[] column = new boolean[matrix[0].length];

		// Store the row and column index with value 0
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length;j++) {
				if (matrix[i][j] == 0) {
					row[i] = true; 
					column[j] = true;
		 		}
			}
		}
		
		// Nullify rows
		for (int i = 0; i < row.length; i++) {
			if (row[i]) {
				nullifyRow(matrix, i);
			}
		}
		
		// Nullify columns
		for (int j = 0; j < column.length; j++) {
			if (column[j]) {
				nullifyColumn(matrix, j);
			}
		}
	}	
	
	// public static boolean matricesAreEqual(int[][] m1, int[][] m2) {
	// 	if (m1.length != m2.length || m1[0].length != m2[0].length) {
	// 		return false;
	// 	}
		
	// 	for (int k = 0; k < m1.length; k++) {
	// 		for (int j = 0; j < m1[0].length; j++) {
	// 			if (m1[k][j] != m2[k][j]) {
	// 				return false;
	// 			}
	// 		}
	// 	}	
	// 	return true;
	// }
	
	// public static int[][] cloneMatrix(int[][] matrix) {
	// 	int[][] c = new int[matrix.length][matrix[0].length];
	// 	for (int i = 0; i < matrix.length; i++) {
	// 		for (int j = 0; j < matrix[0].length; j++) {
	// 			c[i][j] = matrix[i][j];
	// 		}
	// 	}
	// 	return c;
	// }
	
	public static void main(String[] args) {
		int nrows = 10;
		int ncols = 15;
		int[][] matrix = AssortedMethods.randomMatrix(nrows, ncols, -10, 10);		

		AssortedMethods.printMatrix(matrix);
		
		setZeros(matrix);
		
		System.out.println();
		
		AssortedMethods.printMatrix(matrix);
	}
}

```







### 9. String rotation


1. My approach , The position is wrong . The value of K


```java

public class Unique{
	public static void main(String[] args) {
		
 		System.out.println(isSubstring("waterbottle","erbottlewat"));

	}

	public static boolean isSubstring(String s1,String s2){
		int k=0;
		for(int i=0;i<s2.length();i++){
			if(s1.charAt(0)==s2.charAt(i)){
				k=i;
				break;
			}
		}

		String reversedString=rotate(s2,k);
		return s1.equals(reversedString);

	}

	public static String rotate(String s,int k){

		int shift=k%s.length();


		StringBuilder answer=new StringBuilder("");
		for (int i=0;i<s.length();i++ ) {
			
			answer.append(s.charAt((i+shift)%s.length()));			
		}
		return answer.toString();
	}
}



```


2. **This solution is of Nick white : only the concept is plagiarized but this is same as above**

```java
public class Unique{
	public static void main(String[] args) {
		
 		System.out.println(isSubstring("waterbottle","erbottlewat"));

	}

	public static boolean isSubstring(String s1,String s2){
			for(int i=0;i<s2.length();i++){
				if(s1.charAt(0)==)
			}
			int k;
			k=k%s2.length();
			char[] charArray=s2.toCharArray();
			reverse(charArray,0,s2.length()-1);
			reverse(charArray,0,k-1);
			reverse(charArray,k,s2.length()-1);
			String rotated=valueOf(charArray);
			return s1.equals(rotated); 

	}

	public static String reverse(char[] charArray,int start,int end){
		while(start<end){
			int temp=charArray[start];
			charArray[start]=charArray[end];
			charArray[end]=temp;
			start++;
			end--;
		}
	}
}
```


3. *Solution of the author*

:smile:

---

# Fix isSubstring method


---


```java

public class Unique{
	public static void main(String[] args) {
		
		System.out.println(isRotation("waterbottle","erbottlewat"));
	}


	private static boolean isRotation(String s1,String s2){
		int size=s1.length();
		if(size==s2.length()&&size>2){
			String s1s1=s1+s1;
			return isSubString(s1s1,s2);
		}
		return false;
	}

}


```