



## What is and optimization problem.

**Enumeration** :

*You want to climb n steps. At any step either you can climb 1,2, or 3.*

2. Maximization/Minimization.

3. Yes/No . Form 10 dollars from 1,2,5,3 coins. etc





```c++

#include <bits/stdc++.h>
using namespace std;

int main(){

    int stairs;
    cin>>stairs;
    int *steps=(int *)malloc(sizeof(int)*stairs);
    int i;

    steps[1]=1;
    steps[2]=2;
    for (i = 3; i < stairs+1 ; ++i) {
        steps[i]=steps[i-1]+steps[i-2];
    }
    cout<<steps[i-1];

    return 0;
}


```













---

#### Maximum subarray problem

---

**N^3** solution.

```c++
#include <bits/stdc++.h>
using namespace std;

int main(){
    int n=5;
    for (int i = 0; i < n; ++i) {
        for (int j = i+1; j <=n; ++j) {
            for(int k=i;k<j;k++){
                cout<<"i= "<<i<<"j= "<<j<<"  "<<"k= "<<k;
            }
            cout<<endl;
        }
        cout<<endl;
    }


    return 0;
}



i= 0j= 1  k= 0
i= 0j= 2  k= 0i= 0j= 2  k= 1
i= 0j= 3  k= 0i= 0j= 3  k= 1i= 0j= 3  k= 2
i= 0j= 4  k= 0i= 0j= 4  k= 1i= 0j= 4  k= 2i= 0j= 4  k= 3
i= 0j= 5  k= 0i= 0j= 5  k= 1i= 0j= 5  k= 2i= 0j= 5  k= 3i= 0j= 5  k= 4

i= 1j= 2  k= 1
i= 1j= 3  k= 1i= 1j= 3  k= 2
i= 1j= 4  k= 1i= 1j= 4  k= 2i= 1j= 4  k= 3
i= 1j= 5  k= 1i= 1j= 5  k= 2i= 1j= 5  k= 3i= 1j= 5  k= 4

i= 2j= 3  k= 2
i= 2j= 4  k= 2i= 2j= 4  k= 3
i= 2j= 5  k= 2i= 2j= 5  k= 3i= 2j= 5  k= 4

i= 3j= 4  k= 3
i= 3j= 5  k= 3i= 3j= 5  k= 4

i= 4j= 5  k= 4
```