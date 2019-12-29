


# AtCoder Beginner contest 145


1. A **Circle**

```c++
#include<bits/stdc++.h>

using namespace std;

int main(){
    int r;
    cin>>r;
    cout<<pow(r,2);
    return 0;
}

```


2. 





3. Average Length


**Brush up the concepts**


> Permutation can be calculated using next_permutation

```c++
#include<bits/stdc++.h>

using namespace std;
int main()
{
    int A[] = { 1, 2, 3, 2};


    do{
        cout<<A[0]<<" "<<A[1]<<"  "<<A[2]<<" "<<A[3]<<endl;
      }
    while(
            next_permutation(A,A+4)
         );

    return 0;
}


```

```c++
#include<bits/stdc++.h>

using namespace std;


int n;
int x[10];
int y[10];

double area(int i,int j)
{
    cout<<x[i]<<"  "<<x[j]<<endl;
    cout<<y[i]<<"  "<<y[j]<<endl;
    double dx=x[i]-x[j];
    double dy=y[i]-y[j];
    return pow(dx*dx+dy*dy,0.5);

}


int main(){
    cin>>n;
    for(int i=0;i<n;i++){
        cin>>x[i]>>y[i];
    }
    double sum=0.0;
    vector<int> v(n);
    for(int i=0;i<n;i++){
        v[i]=i;
    }

    do{
        for(int i=0;i<n;i++){
            sum+=area(v[i],v[i+1]);
      }
    }
    while(
        next_permutation(v.begin(),v.end())
        );


    int factorial=1;
    for(int i=2;i<=n;i++){
        factorial*=i;
    }

    cout<<fixed<<setprecision(10)<<sum/factorial<<endl;
    return 0;
}
```

### Converting array to set ,set to array

---

```c++
#include<bits/stdc++.h>

using namespace std;
int main()
{
    int A[] = { 1, 2, 3, 2,4, 5,8,99,1,1,2,2 };

    set<int> s;
    for (int i: A) {
        s.insert(i);
    }


    set<int>:: iterator itr;
    int u=1;
    for(itr=s.begin();itr!=s.end();itr++){
        int ans=*itr;
        if(u==ans){
            cout<<ans<<"   "<<endl;
        }

        u++;
    }
    cout<<endl;

    for (int i: s) {
        cout << i << " ";
    }



    return 0;
}

```

---




# AtCoder Beginner contest  148




---

# AtCoder Beginner contest  148


1. Round one


```c++
#include<bits/stdc++.h>
using namespace std;
 
int main(){
    int a,b;
    cin>>a;
    cin>>b;
 
    if(a==1 && b==2){
        cout<<3;
    }
    else if(a==2 &&b==1){
        cout<<3;
    }
    else if(a==3 && b==1){
        cout<<2;
    }
    else if(a==1 && b==3){
        cout<<2;
    }
    else if(a==2 && b==3){
        cout<<1;
    }
    else if(a==3 && b==2){
        cout<<1;
    }
    else{
 
    }
 
 
 
 
}
```






2. Strings with same length

```c++
#include<bits/stdc++.h>

#define REP(i,a,b) for(int i=a;i<b;i++)

using namespace std;
int main(){

    int total;
    cin>>total;


    string first,second;
    cin>>first>>second;
//    getline(cin,first);


//    getline(cin,second);


    string answer;




    REP(i,0,total)
     {
          answer=answer+first.at(i);
          answer=answer+second.at(i);
     }
     cout<<answer;

}
```




---



1. Round one


```c++
#include<bits/stdc++.h>
using namespace std;
 
int main(){
    int a,b;
    cin>>a;
    cin>>b;
 
    if(a==1 && b==2){
        cout<<3;
    }
    else if(a==2 &&b==1){
        cout<<3;
    }
    else if(a==3 && b==1){
        cout<<2;
    }
    else if(a==1 && b==3){
        cout<<2;
    }
    else if(a==2 && b==3){
        cout<<1;
    }
    else if(a==3 && b==2){
        cout<<1;
    }
    else{
 
    }
 
 
 
 
}
```

**Editorial solution**

```c++
#include<bits/stdc++.h>
using namespace std;

int main(){
    int a,b;
    int answer;
    cin>>a>>b;

    answer=6-a-b;
    cout<<answer;

}

```


2. Strings with same length

```c++
#include<bits/stdc++.h>

#define REP(i,a,b) for(int i=a;i<b;i++)

using namespace std;
int main(){

    int total;
    cin>>total;

    string first,second;
    cin>>first>>second;
//    getline(cin,first);


//    getline(cin,second);


    string answer;

    REP(i,0,total)
     {
          answer=answer+first.at(i);
          answer=answer+second.at(i);
     }
     cout<<answer;

}
```
**Editorial**

```c++
#include<bits/stdc++.h>


using namespace std;

int main(){
    int n;
    cin>>n;

    string a;
    string b;
    cin>>a>>b;

    for(int i=0;i<n;i++){
        cout<<a.at(i)<<b.at(i);
    }
}



```

**Editorial sol**

```c++
#include<bits/stdc++.h>
#define REP(i,a,b) for(int i=a;i<b;i++)
using namespace std;
int main(){

    char one[101];
    char two[101];
    int n;
    cin>>n;
    cin>>one;

    cin>>two;
    REP(i,0,n)
    cout<<one[i]<<two[i];


    return 0;

}



```


3. Snacks


```c++


  int  gcd(int a,int b){
        int temp;
        if(a<b){
            temp=a;
            a=b;
            b=temp;
        }
        if(a%b==0){
            return b;
        }
        else{
            return gcd(b,a%b);
        }
    }

//    123 456

```



**Snacks distribution solution**

```c++
#include<bits/stdc++.h>
typedef long long ll;
using namespace std;

int main(){
    ll a,b;
    cin>>a>>b;
    ll minimum=min(a,b);
    ll maximum=max(a,b);
    ll i=1;
    while(true){
        if((minimum*i)%maximum==0){
            cout<<endl<<i*minimum;
            break;
        }
        i++;
    }
}

```






    map<int,int>::iterator itr;