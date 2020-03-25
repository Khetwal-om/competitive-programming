

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