### Dynamic programming

---

```c++
ios::sync_with_stdio(false);cin.tie(0);     // decrease the time for cin, cout
```

---


1. Simple solution . Perform further optimizations

```c++
#include <bits/stdc++.h>
using namespace std;





int main(){

    string value;
    cin>>value;
    int count=0;
    vector<int> yeah;

    for (int i = 0; i < value.size(); ++i) {
        if(value[i]%2==0){
            count+=1;
        }

       yeah.push_back(count);

    }
    cout<<endl;
    for(auto y:yeah){
        cout<<y<<" ";
    }

    return 0;
}
```



### Misc


1. memset() :
*onverts the value ch to unsigned char and copies it into each of the first n characters of the object pointed to by str[]*.


--- 


```c
void* memset( void* str, int ch, size_t n);
Parameters
str[] : Pointer to the object to copy the character.
ch : The character to copy.
n : Number of bytes to copy.
Return value :
The memset() function returns str, the pointer to the destination string.
```

---

```c++
#include <bits/stdc++.h>
using namespace std;



int main(){
    char value[]={'h','e','l','l','o'};
    memset(value,'x',sizeof(value));
    cout<<value;
    return 0;
}
xxxxx a
```



2. We can use memset() to set all values as 0 or -1 for integral data types also. It will not work if we use it to set as other values. The reason is simple, memset works *byte by byte*.



```c++
#include <bits/stdc++.h>
using namespace std;



int main(){

    int value[5];

    memset(value,-1,sizeof(value));

    for (int i = 0; i < 5; ++i) {
        cout<<value[i]<<"   ";
    }
 
    return 0;
}

-1   -1   -1   -1   -1
```


---


**Initialize all values with 0**


```c++

#include <bits/stdc++.h>
using namespace std;



int main(){

    int value[5];

    memset(value,0,sizeof(value));

    for (int i = 0; i < 5; ++i) {
        cout<<value[i]<<"   ";
    }

    return 0;
}
0   0   0   0   0 

```

**These won't work**

---

```c++
    memset(value,1,sizeof(value));
    memset(value,2,sizeof(value));
    memset(value,3,sizeof(value));
```

---




**The optimized version**


:black_heart:

---

```c
    for(int i=n-2;i>=0;i--)
        v[i]+=v[i+1];
```

---


:earth_asia:

```c++
#include<bits/stdc++.h>
using namespace std;
int main(){
    string S;
    cin>>S;
    int n=S.length();
    assert(n>=1&&n<=10000);
    int v[n];
    memset(v,0,sizeof(v));
    //if charcter is even then set its frequency 1 else 0
    for(int i=0;i<n;i++){
        if(int(S[i])%2==0)
        v[i]=1;
        else
        v[i]=0;
    }
    //cumulative array


    for(int i=n-2;i>=0;i--)
        v[i]+=v[i+1];

    for(int i=0;i<n;i++)
        cout<<v[i]<<" ";
    return 0;
}
```

---

*another one*


```c++
#include <bits/stdc++.h>

using namespace std;

int arr [10000 + 10];


int main()
{
    ios::sync_with_stdio(false);cin.tie(0);     // decrease the time for cin, cout
    string s;
    cin >>    s         ;

    for(int i = s.size() - 1; i >= 0; i--){                                     // traverse in reversed order

        arr[i] = arr[i + 1];                                                    // add the stored value in store[i + 1]
        if(s[i] == '2' || s[i] == '4' || s[i] == '6' || s[i] == '8') arr[i]++;   // store[i]++ if this index has an eve number
    }

    for(int i = 0; i < s.size(); i++) cout << arr[i] << " ";


    return 0;
}
```