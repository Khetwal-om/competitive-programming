



1. Rotate(Circular)

FAVFABEX

00FAVFAB
EX000000

*This ain't working at all.*




```c++


int shiftThemUp(int N,int digit){
	return number>>N|number<<(32-N);
}




```



2. Addition without arithmetic operator.


```c++

int summation(int a,int b){
	if(b==0) return a;
	int partialSum=a^b;
	int carry=(a&b)<<1;
	return summation(partialSum,carry);
}

```



3. Swap two integers without using arithmetic operators.


```c++

int swap(int x,int y){
	x=x^y;
	y=x^y;
	x=x^y;
}

```



4. Find missing numbers from an array


*find one missing element*

```c++


int oneMissing(int[] arr){
	int totalXor=0;
	int arrXor=0;
	for (int i = 1; i <= arr.size()+1; ++i)
	{
		/* code */totalXor^=i;
	}

	for(auto x:arr){
		arrXor=arrXor^x;
	}
	return totalXor^arrXor;
}


```


*Two missing numbers*


```c++

[1,2,3,4,5,6]
[1,2,4,6]

sum=3+4
sum=sum/2
sum=3
now
xor all elements smaller than= 3 with array 
xor all elements greater than 3 with array ,
this way we will have both of them


```

---


```c++


int[] two missing(int[] arr){
	int size=arr.size()+2;
	int totalSum=size*(size-1)/2;
	long arrSum=0;
	for(int i:arr) arrSum+=i;

	int pivot=(int)(totalSum-arrSum)/2;
	int totalLeftXor=0;
	int totalRightXor=0;
	int arrLeftXor=0;
	int arrRightXor=0;

	for (int i = 0; i <=pivot; ++i)totalLeftXor^=i;
	
	for (int i = pivot+1;i<=size ++i)totalRightXor^=i;
				                                	
}





```

---










5. Number of ones in binary

```c++

int count(int x){
	int total=0;
	while(x>0){
		sum+=x^1;
		x>>=1;
	}
}



```