# AtCoder ... Beginner contest 042


1. A Iroha and Haiku


```c++
#include<bits/stdc++.h>

using namespace std;

int main(){

    int a,b,c;

    cin>>a>>b>>c;

    if(a==7){
        if(b==5 && c==5){
            cout<<"YES";
        }
        else{
            cout<<"NO";
        }
    }
    else if(b==7){
        if(a==5 && c==5){
            cout<<"YES";
        }
        else{
            cout<<"NO";
        }

    }


    else if(c==7){
        if(b==5 && a==5){
            cout<<"YES";
        }
        else{
            cout<<"NO";
        }
    }

    else{

    }

}
```

**Better one**

```c++
int main()
{
    ll a,b,c;
    cin>>a>>b>>c;
    bool f=false;
    if((a==5&&b==5&&c==7)||(a==5&&b==7&&c==5)||(a==7&&b==5&&c==5))
        cout<<"YES";
    else
        cout<<"NO";
 
    return 0;
}
```


2. Iroha loves string

```c++
#include<bits/stdc++.h>

using namespace std;



int main(){


    int n,l;
    string s;
    cin>>n>>l;
    vector<string> v;
    while(cin>>s){
        v.push_back(s);
        if(n==1){
            break;
        }
        n--;

    }

    sort(v.begin(),v.end());

    for(auto x:v){
        cout<<x;
    }




}
```



**2 Iroha loves string , but now compare the length of the string**

```c++
#include<bits/stdc++.h>

using namespace std;

bool compare(string x,string y){
    return x.size()<y.size();
}

int main(){


    int n,l;
    string s;
    cin>>n>>l;
    vector<string> v;
    while(cin>>s){
        v.push_back(s);
        if(n==1){
            break;
        }
        n--;

    }

    sort(v.begin(),v.end(),compare);

    for(auto x:v){
        cout<<x;
    }


}

```

3. **Iroha's obsession with string**

```c++
#include<bits/stdc++.h>

using namespace std;


bool isNotPresent(int d,vector<int> v){
    for(auto x:v){
        if (x==d){
                return false;
        }
    }
    return true;
}

int main(){

    int N,K;
    cin>>N>>K;

    vector<int> hatred;
    int data;
    for(int i=0;i<K;i++){
        cin>>data;
        hatred.push_back(data);
    }
    int flag=1;
    for(int n=N;n<100000;n++){
        int a=n;
        flag=1;
        while(a>0){
            int d=a%10;
            a=a/10;
            if(isNotPresent(d,hatred)==false){

                    flag=0;
                    break;
            }
        }
        if(flag==1){
                cout<<n<<endl;
                break;
        }
        }


    return 0;

}

```


**C Iroha's obsession**

```c++
// spnauT
//
#include <bits/stdc++.h>
using namespace std;
#define FOR(i,a,b) for(int _b=(b),i=(a);i<_b;++i)
#define ROF(i,b,a) for(int _a=(a),i=(b);i>_a;--i)
#define REP(n) for(int _n=(n);_n--;)
#define _1 first
#define _2 second
#define PB(x) push_back(x)
#define SZ(x) int((x).size())
#define ALL(x) (x).begin(),(x).end()
#define MSET(m,v) memset(m,v,sizeof(m))
#define MAX_PQ(T) priority_queue<T>
#define MIN_PQ(T) priority_queue<T,vector<T>,greater<T>>
#define IO(){ios_base::sync_with_stdio(0);cin.tie(0);}
#define nl '\n'
#define cint1(a) int a;cin>>a
#define cint2(a,b) int a,b;cin>>a>>b
#define cint3(a,b,c) int a,b,c;cin>>a>>b>>c
typedef long long LL;typedef pair<int,int> PII;
typedef vector<int>VI;typedef vector<LL>VL;typedef vector<PII>VP;
template<class A,class B>inline bool mina(A &x,const B &y){return(y<x)?(x=y,1):0;}
template<class A,class B>inline bool maxa(A &x,const B &y){return(x<y)?(x=y,1):0;}
 
#define MAXN ()
 
int D[10];
 
int main()
{
    IO();
    cint2(N,K);
    REP(K)
    {
        cint1(a);
        D[a] = 1;
    }
 
    for(int n = N; 1; ++n)
    {
        int a = n;
        int v = 1;
        while(a > 0)
        {
            int d = a % 10;
            a /= 10;
            if(D[d])
            {
                v = 0;
                break;
            }
        }
        if(v)
        {
            cout << n << nl;
            return 0;
        }
    }
 
    return 0;
}

```



---


# Problem 4



---









---



# Atcoder beginner contest 043


---


1. Children and Candies

```c++
#include<bits/stdc++.h>

using namespace std;

int main(){

   int n;

   cin>>n;

   cout<<(n*(n+1)/2);

   return 0;

}

```


2. **Unhappy Hacking**

```c++
#include<bits/stdc++.h>

using namespace std;

int main(){


  // take string as input

  string s;
  cin>>s;

  // initialize another string so that we can append required characters only

  string n;

  int i=0;
  for(auto x:s){


  // if B is encountered pop the last element inserted in new string named n


  if(x=='B'){


    if(n.size()>=1){
        n.pop_back();
    }

  }
  // append 0 and 1 , coz they are friends :)
  else{

    n=n+x;
  }

  }
  cout<<n;

  return 0;
}


```



3. Be  *Together* 2 test cases need to be passed

```c++
#include<bits/stdc++.h>


using namespace std;

int main(){
    vector<int> dollars;
    int n;

    cin>>n;
    int data;

    for(int i=0;i<n;i++){
        cin>>data;
        dollars.push_back(data);
    }

    int sum=accumulate(dollars.begin(),dollars.end(),0);

    if(sum%2==1){
        sum+=1;
    }
    int bottomline=ceil(sum/n);

    //cout<<bottomline;

    int total=0;


    for(auto x:dollars){
        if (x==bottomline){

        }
        else{
            total+=pow(bottomline-x,2);
        }
    }

    cout<<total;

    return 0;
}


```



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