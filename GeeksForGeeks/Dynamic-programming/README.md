

1. Memoization

```c++
#include<bits/stdc++.h>
#define NIL -1
#define MAX 100

using namespace std;

int lookup[MAX];

void _initialize(){
    for(int i=0;i<MAX;i++){
        lookup[i]=NIL;
    }
}

int fibonacci(int n){
    if(lookup[n]==NIL)
    {
    if(n<=1)
        lookup[n]=n;
    else
        lookup[n]=fibonacci(n-1)+fibonacci(n-2);
    }

    return lookup[n];

}

int main(){
    int n=20;
    _initialize();
    cout<<fibonacci(n);
}

```


2. Tabulation

```c++


#include<bits/stdc++.h>

#define NIL -1
#define MAX 100

using namespace std;

int lookup[MAX];
void _initialize(){
    for(int i=0;i<MAX;i++){
        lookup[i]=NIL;
    }
}

int fibonacci(int n){
int f[n+1];
f[0]=0;
f[1]=1;

for(int i=2;i<=n;i++){
    f[i]=f[i-1]+f[i-2];
}
return f[n];

}
int main(){

_initialize();
cout<<fibonacci(50);
}


```


3. **Longest Increasing subsequence**

Find the length of longest subsequence of a given sequence such that elements of the subsequence are sorted in increasing order.

```c++
#include<bits/stdc++.h>

using namespace std;

int lis(int arr[],int n){

    int *lis,maximum=0;
    lis=(int*)malloc(sizeof(int)*n);

    for(int i=0;i<n;i++){
        lis[i]=1;
    }

    for(int i=1;i<n;i++){
        for(int j=0;j<i;j++){
            if(arr[i]>arr[j] &&lis[i]<lis[j]+1){
                lis[i]=lis[j]+1;
            }
        }
    }

    for(int i=0;i<n;i++){
        if(maximum<lis[i]){
            maximum=lis[i];
        }
    }

    // simply max(lis)
    free(lis);
    return maximum;

}

int main(){
  int arr[]={10,22,9,33,21,50,41,60};
  int n=sizeof(arr)/sizeof(arr[0]);
  cout<<lis(arr,n);

  return 0;
}


```

4. **Longest Common subsequence**


```c++
#include<bits/stdc++.h>

using namespace std;


int lcs(char *X,char *Y,int m,int n){
    int L[m+1][n+1];


    for(int i=0;i<=m;i++){
        for(int j=0;j<=n;j++){
            if(i==0 || j==0){
                L[i][j]=0;
            }
            else if(X[i-1]==Y[j-1]){
                L[i][j]=L[i-1][j-1]+1;
            }
            else{
                L[i][j]=max(L[i][j-1],L[i-1][j]);
                }
            }
    }


    return L[m][n];
}



int main(){


    char X[]="AGGTAB";
    char Y[]="GXTXAYB";


    int m=sizeof(X)/sizeof(X[0])-1;  // character array place /0 at last
    int n=sizeof(Y)/sizeof(Y[0])-1;



    cout<<lcs(X,Y,m,n);

    return 0;
}
```

5. Edit distance

**Given two Strings string1,string2 and below operations
that can be performed on string1. Find minimum number of operations or edits required to convert string1 to string2.**

 1. insert
 2. delete
 3. modify

 *Assume all operations are of equal cost*


example cat ,cut only one operation is required
convert a to u.


####Approach

1. If last characters match ,don't change a thing recur for length m-1 and n-1.

2. Else compute minimum cost of all three operations(insert,delete and modify). Take **minimum** one.
 
 1. Insert: recur for m and n-1
 2. Delete: recur for m-1 and n
 3. Modify: recur for m-1 and n-1

















### Binomial coefficient.

1. C(n,n) returns 1
2. C(n,k) returns C(n-1,k-1)+C(n-1,k)


**The recursive solution**


```c++

  int binomialCoefficient(int n,int k){
    if(n==0 || n==k){
        return 1;
    }
    else{
        return binomialCoefficient(n-1,k-1)+binomialCoefficient(n-1,k);
    }
  }

```


---

1. This approach somewhere follows *overlapping* subproblem property. So what do we do.
**Dynamic programming** .               :+1:

---


:heart:


```c++

#include <bits/stdc++.h>
using namespace std;
int binomialCoeffcient(int n,int k){
    int C[n+1][k+1];


    for(int i=0;i<=n;i++){
        
//        this min(i,k) should not bother you say we have C(6,3) we don't wanna calculate C(6,5) or C(6,4) i.e second argument must be less than k
        
        for (int j = 0; j <=min(i,k) ; ++j) {
            if(j==0||j==i){
                C[i][j]=1;
            }
            else{
                C[i][j]=binomialCoeffcient(i-1,j-1)+binomialCoeffcient(i-1,j);
            }
        }
    }
    return C[n][k];
}

int main(){
 


}

``` 



**The optimized version**

```c++
#include <bits/stdc++.h>
using namespace std;
int binomialCoeffcient(int n,int k){
    int C[k+1];
    memset(C,0,sizeof(C));
    C[0]=1;   // C(n,0) is always 1
    for(int i=1;i<=n;i++){
        for(int j=min(i,k);j>0;j--){
            C[j]=C[j]+C[j-1];
        }
    }
    return C[k];
}

int main(){



}


``` 


---

### Kadane's algo.

---


**Largest sum contiguous subarray**



```c++

#include <bits/stdc++.h>
using namespace std;

int largestSumContiguousSubarray(int array[],int size){
    int max_end_here=0;
    int max_so_far=0;

    for(int i=0;i<size;i++){
        max_end_here=max_end_here+array[i];
        if(max_end_here<0){
            max_end_here=0;
        }
        if(max_end_here>max_so_far){
            max_so_far=max_end_here;
        }
    }
    return max_so_far;
}

int main(){

    int array[]={-2,-3,4,-1,-2,1,5,-3};
    cout<<largestSumContiguousSubarray(array,8);

    return 0;
}




```




*Minor optimization*

```c++

    for(int i=0;i<size;i++){
        max_end_here=max_end_here+array[i];
        if(max_end_here<0){
            max_end_here=0;
        }
        else if(max_so_far<max_end_here){
            max_so_far=max_end_here;
        }
    }


```



**The above algorithm won't work for negative numbers,it returns 0 if all numbers are negative**

```c++
#include <bits/stdc++.h>
using namespace std;

int largestSumContiguousSubarray(int array[],int size){
    int curr_max=array[0];
    int max_so_far=array[0];

    for(int i=0;i<size;i++){
        curr_max=max(array[i],curr_max+array[i]);
        max_so_far=max(max_so_far,curr_max);
    }
    return max_so_far;
}

int main(){

    int array[]={-2,-3,4,-1,-2,1,5,-3};
    cout<<largestSumContiguousSubarray(array,8);

    return 0;
}
```