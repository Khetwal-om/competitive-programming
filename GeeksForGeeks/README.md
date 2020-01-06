

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


