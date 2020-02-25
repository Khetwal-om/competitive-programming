
1. How we can shift anything.

```c++
#include <bits/stdc++.h>
using namespace std;

int main(){


     string s="mark";
     string h="mark";
     int k=2,N=s.size();

     for(int i=0;i<N;i++){
         int index=(i+k)%N;
         h[index]=s[i];
     }
     cout<<h;

    return 0;
}


```