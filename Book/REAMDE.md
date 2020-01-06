
# Modular Arithmetic


1. To find mod we can use


---
>(a+b) mod m = (a mod m+b mod m) mod m \
(a−b) mod m = (a mod m−b mod m) mod m (a·b)\
 mod m = (a mod m·b mod m) mod m
---


```c++


# Floating point numbers


4.

```c++
```c++
#include<bits/stdc++.h>

using namespace std;

int  main(){
    int n=10;
    int m=5;
    long long x = 1;
     for (int i = 2; i <= n; i++)
        {
             x = (x*i)%m;
             cout<<x<<endl;
        }
     cout << x%m << "\n";

}

```


5. Check whether two floating point numbers using if else

```c++
#include<bits/stdc++.h>

using namespace std;

int  main(){
    float a=23.3221234143;
    float b=23.322123213;




    if (abs(a-b) < 1e-9) { // a and b are equal
            cout<<"Yes both are equal";
    }
    else{
        cout<<"No, unequivocal bovine canine feline ";
    }

}


Both are equal

```




# Shortening code





1. **Type Names**




```c++
#include<bits/stdc++.h>

using namespace std;

typedef long long ll;

int  main(){
    ll a=123456789;
    ll b=987654321;
    ll answer=a*b;
    cout<<answer;

}

```





# Macro


1. Short the loop

```c++
#include<bits/stdc++.h>


using namespace std;


#define REP(i,a,b) for(int i=a;i<=b;i++)

int  main(){
    REP(i,1,10)
    cout<<i<<endl;
}


```


2. Sometimes macro causes problems

```c++
#include<bits/stdc++.h>


using namespace std;

#define SQ(a) a*a


int  main(){

    cout<<SQ(3+2)<<endl;
}


```

---

This is the bug

```c++
#include<bits/stdc++.h>


using namespace std;

#define SQ(a) a*a   //a+a*b+b


int  main(){

    cout<<SQ(3+1)<<endl;   //  3+3*1+1
}


```

---

3. Instead use

```c++

#include<bits/stdc++.h>


using namespace std;

#define SQ(a) (a)*(a)


int  main(){

    cout<<SQ(3+1)<<endl;
}



```








# 2 Chapter

1. Maximum subarray problem

> Approach One  : O(log(n**^**3))

```c++
#include<bits/stdc++.h>

using namespace std;
int main(){
    int best=0;
    int elements[]={-1,2,4,-3,5,2,-5,2};
    int n=sizeof(elements)/sizeof(elements[0]);
    for(int a=0;a<n;a++){
        for(int b=0;b<n;b++){
            int sum=0;
            for(int k=a;k<=b;k++){
                cout<<elements[k];
                sum+=elements[k];
            }
            cout<<endl;
            best=max(best,sum);
        }
    }
    cout<<endl<<best;

    return 0;

}


```  

2. Approach two 

```c++
#include<bits/stdc++.h>

using namespace std;
int main(){
    int best=0;
    int elements[]={-1,2,4,-3,5,2,-5,2};
    int n=sizeof(elements)/sizeof(elements[0]);
    for(int a=0;a<n;a++){
        int sum=0;
        for(int b=a;b<n;b++){
            cout<<a<<"  "<<b<<endl;
            sum+=elements[b];
            best=max(best,sum);
        }
    }
    cout<<endl<<best;

    return 0;

}

```



3. 








# Chapter 3 Sorting




1. **inbuilt** methods to sort vector elements

```c++

#include<bits/stdc++.h>

using namespace std;
int main(){

    vector<int> v;
    v.push_back(1);
    v.push_back(43);
    v.push_back(23);
    v.push_back(11);
    v.push_back(81);
    sort(v.begin(),v.end());


    vector<int>:: iterator it;

    for(it=v.begin();it!=v.end();it++){
        cout<<*it<<endl;
    }

}

```


2. Sorting in reverse order


```c++
#include<bits/stdc++.h>

using namespace std;
int main(){

    vector<int> v;
    v.push_back(1);
    v.push_back(43);
    v.push_back(23);
    v.push_back(11);
    v.push_back(81);
    sort(v.rbegin(),v.rend());


    vector<int>:: iterator it;

    for(it=v.begin();it!=v.end();it++){
        cout<<*it<<endl;
    }

}

```


3. Sort an array

```c++
#include<bits/stdc++.h>

#define REP(i,a,b) for(int i=a;i<b;i++)
using namespace std;
int main(){

    int arr[]={4,5,23,1,55,12,7,11};
    int n=sizeof(arr)/sizeof(arr[0]);

    sort(arr,arr+n);
    REP(i,0,n){
        cout<<arr[i]<<"  ";
    }



}

```

4. Sort string


```c++
#include<bits/stdc++.h>

#define REP(i,a,b) for(int i=a;i<b;i++)
using namespace std;
int main(){


    string s="hithere";
    sort(s.begin(),s.end());

    cout<<s;


}

```



5. This is to retrieve size of array

```c++


    int arr[]={12,5,67,7};
    int n=sizeof(arr)/sizeof(arr[0]);
    cout<<" this is the memory allocated to array"<<sizeof(arr)<<endl;
    cout<<" this is the first location's memory"<<sizeof(arr[0])<<endl;
    cout<<n;

```

6. Sort the vector pair

```c++
#include<bits/stdc++.h>

#define REP(i,a,b) for(int i=a;i<b;i++)
using namespace std;


bool sortbysec(const pair<int,int> &a,const pair<int,int> &b)
{
    return (a.second < b.second);
}

int main(){




    vector <pair<int,int> > v;
    v.push_back({1,111});
    v.push_back({2,12});
    v.push_back({30,1322});
    v.push_back({4,141});


    for(int i=0;i<4;i++){
        cout<<v[i].first<<"  "<<v[i].second<<endl;
    }

    sort(v.begin(),v.end());

    cout<<endl<<"*****!!!@@@@@*****"<<endl;

    for(int i=0;i<4;i++){
        cout<<v[i].first<<"  "<<v[i].second<<endl;
    }

    sort(v.begin(),v.end(),sortbysec);

    for(int i=0;i<4;i++){
        cout<<v[i].first<<"  "<<v[i].second<<endl;
    }




    return 0;

}

```


7. Tuple

```c++
// C++ code to demonstrate tuple, get() and make_pair()
#include<iostream>
#include<tuple> // for tuple
using namespace std;
int main()
{
    // Declaring tuple
    tuple <char, int, float> geek;

    // Assigning values to tuple using make_tuple()
    geek = make_tuple('a', 10, 15.5);

    // Printing initial tuple values using get()
    cout << "The initial values of tuple are : ";
    cout << get<0>(geek) << " " << get<1>(geek);
    cout << " " << get<2>(geek) << endl;

    // Use of get() to change values of tuple
    get<0>(geek) = 'b';
    get<2>(geek) = 20.5;

    // Printing modified tuple values
    cout << "The modified values of tuple are : ";
    cout << get<0>(geek) << " " << get<1>(geek);
    cout << " " << get<2>(geek) << endl;

    return 0;
}


```


8. Tuple

```c++
#include<bits/stdc++.h>

using namespace std;
int main()
{
    vector <tuple<int,int,int>> v;
    v.push_back(make_tuple(1,2,3));
    v.push_back(make_tuple(2,3,4));
    v.push_back(make_tuple(3,4,5));


    vector <tuple<int,int,int>> :: iterator itr;


    sort(v.begin(),v.end());

    return 0;
}


```


9. 








# Sort


1. sort according to the length of string 

```c++
#include<bits/stdc++.h>
using namespace std;


bool sort_method(string a, string b){
    if(a.size()!=b.size()){
        return a.size()<b.size();
    }
    else{
        return a<b;
    }
}


int main(){
    vector <string> v;
    v.push_back("hello");
    v.push_back("aladin");
    v.push_back("abu");

    sort(v.begin(),v.end(),sort_method);


    for(int i=0;i<v.size();i++){
        cout<<v[i]<<endl;
    }

    return 0;
}

```


1. Binary search method 1

```c++
#include<bits/stdc++.h>

using namespace std;

int main(){

    int values[]={1,5,7,8,12,45,67,89};
    int a=0;
    int b=(sizeof(values)/sizeof(values[0]))-1;
    cout<<endl<<b;
    int data=7;

    while(a<=b){
        int k=(a+b)/2;
        if(values[k]==data){
           cout<<endl<<" found at index... "<<k;
        }
        if (values[k]>data) {
             b=k-1;
            }
        else{
            a=k+1;
        }
    }

    return 0;

}

```


2. Binary search method **jump and then slow speed**

```c++
#include<bits/stdc++.h>

using namespace std;

int main(){

    int values[]={1,5,7,8,12,45,67,89,111,112,223,444,567,577,888};
    int a=0;
    int n=(sizeof(values)/sizeof(values[0]))-1;
    int x=112;


    int k=0;
    for(int b=n/2;b>=1;b=b/2){
        cout<<"first time "<<b<<"  "<<k<<endl;
        while(k+b<n && values[k+b]<=x){
            k+=b;
            cout<<"value of k within while"<<k<<endl;
        }
        if(values[k]==x){
            cout<<endl<<"found at "<<k;
        }
    }

    return 0;

}


```







3. use of lower_bound()

```c++
#include<bits/stdc++.h>

using namespace std;

int main(){

    int values[]={1,5,7,8,12,12,14,15,22,23,45,67,89};
    int a=0;
    int n=sizeof(values)/sizeof(values[0]);
    int data=12;
    auto k = lower_bound(values,values+n,data)-values;
    if(k<n && values[k]==data){
        cout<<endl<<"found at"<<k;
    }




    return 0;

}


```


5. **lower_bound**


```c++
#include<bits/stdc++.h>

using namespace std;

int main(){

    int values[]={1,5,7,8,12,12,14,15,22,23,45,67,89};
    int a=0;
    int n=sizeof(values)/sizeof(values[0]);
    int data=12;
    auto k = lower_bound(values,values+n,data)-values;
    if(k<n && values[k]==data){
        cout<<endl<<"found at"<<k;
    }

    cout<<endl<<"          "<<endl;
    auto x=lower_bound(values,values+n,data);
    auto y=upper_bound(values,values+n,data);
    cout<<y-x<<"times "<<data<<" is there";


    return 0;

}


```



6. Shorten the code.


```c++
#include<bits/stdc++.h>

using namespace std;

int main(){

    int values[]={1,5,7,8,12,12,14,15,22,23,45,67,89};
    int a=0;
    int n=sizeof(values)/sizeof(values[0]);

    int data=12;
    auto r=equal_range(values,values+n,data);
    cout<<r.second-r.first;


    return 0;

}



```



#   Data Structures

1. *Vector* basics.

```c++
#include<bits/stdc++.h>

using namespace std;

int main(){

    vector<int> v;
    v.push_back(13);
    v.push_back(123);
    v.push_back(355);

    cout<<v[0]<<endl;
    cout<<v[1]<<endl;
    cout<<v[2]<<endl;

    return 0;

}


```


2. The function size returns the number of elements in the vector


```c++
#include<bits/stdc++.h>

using namespace std;

int main(){

    vector<int> v;
    v.push_back(13);
    v.push_back(123);
    v.push_back(355);



    for(int i=0;i<v.size();i++){
        cout<<v[i]<<"    ";
    }

    return 0;

}


``` 


3. We can iterate in the following manner too.

```c++
#include<bits/stdc++.h>

using namespace std;

int main(){

    vector<int> v;
    v.push_back(13);
    v.push_back(123);
    v.push_back(355);



    for(auto data:v){
        cout<<data<<"   ";
    }

    return 0;

}


```

4. Use of *pop_back()* and *back()*

```c++
#include<bits/stdc++.h>

using namespace std;

int main(){

    vector<int> v;
    v.push_back(13);
    v.push_back(123);
    v.push_back(355);


    cout<<"The function back returns the last element"<<v.back()<<endl;


    for(auto data:v){
        cout<<data<<"   ";
    }

    cout<<endl<<"The function pop_back() removes last element from the stack,but we can't just print it's value"<<endl;
    v.pop_back();

    for(auto data:v){
        cout<<data<<"   ";
    }


    return 0;

}

```


5. We can  create vector with 5 elements in the following manner too.

```c++
#include<bits/stdc++.h>

using namespace std;

int main(){

    vector<int> v={1,5,6,7};

    for(auto x:v){
        cout<<x<<"  ";
    }


    return 0;

}


```


6. Another way is to give the size() ,  *default* value is 0

```c++
#include<bits/stdc++.h>

using namespace std;

int main(){

    vector<int> v(10);

    for(auto x:v){
        cout<<x<<"  ";
    }


    return 0;

}


```


7. The value for each element can be given as

```c++

#include<bits/stdc++.h>

using namespace std;

int main(){

    vector<int> v(10,11);

    for(auto x:v){
        cout<<x<<"  ";
    }


    return 0;

}

```


8. **String** 


```c++
#include<bits/stdc++.h>

using namespace std;

int main(){


    string first="hello";
    string second=first+first;
    cout<<"second "<<second<<endl;

    second[5]='v';
    cout<<"second "<<second<<endl;


    string third=second.substr(2,5);
    cout<<"third  "<<third<<endl;


    return 0;

}


```



8. auto in for loop can be used for this too.

```c++
#include<bits/stdc++.h>

using namespace std;

int main(){


    string first="hello";
    string second=first+first;
    cout<<"second "<<second<<endl;

    second[5]='v';
    cout<<"second "<<second<<endl;


    string third=second.substr(2,5);
    cout<<"third  "<<third<<endl;

    for(auto x:third){
        cout<<x<<endl;
    }

    return 0;

}


```


---


# Set 


1. set            : maintains order  O(log(n))


2. unordered_set  : out of order      O(log(1)) , but set have various methods .

---


1. Basic method available

```c++
#include<bits/stdc++.h>

using namespace std;

int main(){

    set<int> s;
    s.insert(4);
    s.insert(5);
    s.insert(6);

    cout<<s.count(4)<<" number of 4 ";;
    cout<<s.count(7)<<" number of 7 ";;


    s.erase(4);

    for(auto x:s){
        cout<<x<<"  ";
    }

    cout<<endl<<" Number of elements present in the set"<<s.size();

    return 0;

}





```



2. No duplicates are allowed in *set*.



3. **multiset** can be used inorder to place duplicate elements .**unordered_multiset** used
instead of *unordered_set*.

```c++

#include<bits/stdc++.h>

using namespace std;

int main(){


    multiset<int> s;

    s.insert(1);
    s.insert(2);
    s.insert(3);

    s.insert(4);
    s.insert(4);

    for(auto x:s){
        cout<<x<<"      ";
    }

    cout<<endl<<" No. of 4's "<<s.count(4);

    return 0;

}



```


5. **erase()** removes all instances of an element from given multiset .


```c++

#include<bits/stdc++.h>

using namespace std;

int main(){


    multiset<int> s;

    s.insert(1);
    s.insert(2);
    s.insert(3);

    s.insert(4);
    s.insert(4);

    for(auto x:s){
        cout<<x<<"      ";
    }

    cout<<endl<<" No. of 4's "<<s.count(4);

    s.erase(4);



    cout<<endl<<" No. of 4's "<<s.count(4);

    return 0;

}

1      2      3      4      4
 No. of 4's 2
 No. of 4's 0




```



6. To remove just single instance...

*s.erase(s.find())*


```c++

#include<bits/stdc++.h>

using namespace std;

int main(){


    multiset<int> s;

    s.insert(1);
    s.insert(2);
    s.insert(3);

    s.insert(4);
    s.insert(4);

    for(auto x:s){
        cout<<x<<"      ";
    }

    cout<<endl<<" No. of 4's "<<s.count(4);

    s.erase(s.find(4));



    cout<<endl<<" No. of 4's "<<s.count(4);

    return 0;

}

1      2      3      4      4
 No. of 4's 2
 No. of 4's 1

```



---

# Map 

1. key,pair values

```c++
#include<bits/stdc++.h>

using namespace std;

int main(){

    map<string,int> m;

    m["one"]=1;
    m["two"]=2;
    m["three"]=3;

    cout<<m["three"];


    return 0;

}



```

---


1. If the key value pari doesn't exist , default value is added

```c++
#include<bits/stdc++.h>

using namespace std;

int main(){

    map<string,int> m;

    m["one"]=1;
    m["two"]=2;
    m["three"]=3;

    cout<<m["three"];
    cout<<endl;
    cout<<m["four"];



    return 0;

}


3
0
```

3. Key value pair can be printed in the following manner


```c++
#include<bits/stdc++.h>

using namespace std;

int main(){

    map<string,int> m;

    m["one"]=1;
    m["two"]=2;
    m["three"]=3;

    cout<<m["three"];
    cout<<endl;
    cout<<m["four"];

    for(auto x:m){
        cout<<x.first<<"       **** "<<x.second<<endl;
    }

    return 0;

}





```



# Iterators

---

1. sort,reverse,random_shuffle

```c++

#include<bits/stdc++.h>

using namespace std;

int main(){

    vector<int> v;
    v.push_back(12);
    v.push_back(10);
    v.push_back(4);
    v.push_back(2);
    v.push_back(11);

    for(auto x: v){
        cout<<x<<"        ";
    }

    cout<<endl;


    sort(v.begin(),v.end());
    for(auto x: v){
        cout<<x<<"        ";
    }


    reverse(v.begin(),v.end());

    cout<<endl;
    for(auto x: v){
        cout<<x<<"        ";
    }


    random_shuffle(v.begin(),v.end());

    cout<<endl;
    for(auto x: v){
        cout<<x<<"        ";
    }





}



12        10        4        2        11
2        4        10        11        12
12        11        10        4        2
2        11        4        10        12


```







---



2. The above functions are given pointers incase of array

```c++
#include<bits/stdc++.h>

using namespace std;

int main(){

    int a[]={23,12,1,34,56,22,10,11};
    int n=sizeof(a)/sizeof(a[0]);

    for(auto x: a){
        cout<<x<<"        ";
    }

    cout<<endl;


    sort(a,a+n);
    for(auto x: a){
        cout<<x<<"        ";
    }


    reverse(a,a+n);

    cout<<endl;
    for(auto x: a){
        cout<<x<<"        ";
    }


    random_shuffle(a,a+n);

    cout<<endl;
    for(auto x: a){
        cout<<x<<"        ";
    }





}

23        12        1        34        56        22        10        11
1        10        11        12        22        23        34        56
56        34        23        22        12        11        10        1
12        34        10        23        56        11        1        22

```



# Set iterators

---

1. Basic example

```c++
#include<bits/stdc++.h>

using namespace std;

int main(){

    set<int> s;

    s.insert(3);
    s.insert(6);
    s.insert(9);
    s.insert(12);

    set<int>::iterator it=s.begin();
    cout<<*it;

    return 0;
}

```



2. Shorter and better approach

```c++
#include<bits/stdc++.h>

using namespace std;

int main(){

    set<int> s;
    s.insert(19);
    s.insert(111);
    s.insert(12);
    s.insert(29);
    s.insert(31);

    auto it=s.begin();
    cout<<endl<<*it;

    return 0;
}

```


3. The output is weird in second case


```c++
#include<bits/stdc++.h>

using namespace std;

int main(){

    set<int> s;
    s.insert(19);
    s.insert(111);
    s.insert(12);
    s.insert(29);
    s.insert(31);
    s.insert(199);
    s.insert(9);

    for(auto it=s.begin();it!=s.end();it++){
        cout<<*it<<"       ";
    }
    cout<<"        "<<endl;

    for(auto i=s.end();i!=s.begin();--i){
        cout<<*i<<"       ";
    }
    return 0;
}

9       12       19       29       31       111       199
7       199       111       31       29       19       12



```



4. This finds element nearest to x, *something is wrong*


```c++
#include<bits/stdc++.h>

using namespace std;

int main(){

    set<int> s;
    s.insert(1);
    s.insert(11);
    s.insert(28);
    s.insert(30);
    s.insert(31);
    s.insert(34);
    s.insert(41);
    s.insert(55);

    int x=39;
    auto it=s.lower_bound(x);


    if(it==s.begin()){
        cout<<" found at starting "<<*it;
    }
    else if(it==s.end()){
        it--;
        cout<<" found at last "<<*it;
    }

    else{
        int a=*it;
        it--;
        int b=*it;

        if(x-b<a-x){
            cout<<b;
        }
        else{
            cout<<a;
        }
    }


    return 0;
}

```





# Bitset


---



1. A bitset is an array whose each value is either 0 or 1. 

**The beneﬁt of using bitsets is that they require less memory than ordinary arrays, because each element in a bitset only uses one bit of memory. For example, if n bits are stored in an int array, 32n bits of memory will be used, but a corresponding bitset only requires n bits of memory. In addition, the values of a bitset can be efﬁciently manipulated using bit operators, which makes it possible to optimize algorithms using bit sets**


```c++
#include<bits/stdc++.h>

using namespace std;

int main(){

    bitset<10> s;
    s[1]=1;
    s[3]=1;
    s[4]=0;
    cout<<s[0]<<"  "<<s[1]<<"  "<<s[2]<<"  "<<s[3]<<"  "<<s[4];

    return 0;

}
0  1  0  1  0
```


2. Elements can be inserted in the following manner too.

```c++
#include<bits/stdc++.h>

using namespace std;

int main(){

    bitset<10> s(string("0101010101"));  //right to left assignment

    cout<<s[0]<<"  "<<s[1]<<"  "<<s[2]<<"  "<<s[3]<<"  "<<s[4]<<"  "<<s[5]<<"  "<<s[6]<<"  "<<s[7]<<"  "<<s[8]<<"  "<<s[9];

    return 0;

}

```



3. Some operations &,|,^


```c++

#include<bits/stdc++.h>

using namespace std;

int main(){

    bitset<10> a(string("0101010101"));
    bitset<10> b(string("1010101010"));

    cout<<" &  operation "<<(a&b)<<endl;
    cout<<" |  operation "<<(a|b)<<endl;
    cout<<" ^  operation "<<(a^b)<<endl;


    return 0;

}

 &  operation 0000000000
 |  operation 1111111111
 ^  operation 1111111111


```



# Deque 

1. push_front(),pop_front() functions are available as compared to vector

```c++
#include<bits/stdc++.h>

using namespace std;

int main(){


    deque<int> d;
    d.push_back(10);
    d.push_back(11);
    d.push_back(112);
    d.push_back(101);

    for(auto x:d){
        cout<<x<<"    ";
    }

    d.pop_back();
    d.pop_back();
    d.pop_back();

    cout<<endl;

    cout<<endl<<" after performing  pop"<<endl;

    for(auto x:d){
        cout<<x<<"    ";
    }
    cout<<endl;

    cout<<endl<<" inserting elements in front , this we can't do in vector"<<endl;


    d.push_front(7);
    d.push_front(9);
    d.push_front(11);



    for(auto x:d){
        cout<<x<<"    ";
    }


    d.pop_front();

    cout<<endl;
    cout<<endl<<"  pop front operation "<<endl;

    for(auto x:d){
        cout<<x<<"    ";
    }


    return 0;

}

10    11    112    101

 after performing  pop
10

 inserting elements in front , this we can't do in vector
11    9    7    10

  pop front operation
9    7    10

```




---



# Stack

1. A stack is a data structure that provides two O(1) time operations: adding an element to the top, and removing an element from the top. It is only possible to access the top element of a stack.


2. 

```c++
#include<bits/stdc++.h>

using namespace std;

int main(){

    stack<int> s;
    s.push(4);
    s.push(11);
    s.push(1);

    cout<<endl<<s.top();

    s.pop();

    cout<<endl<<s.top();


    s.pop();

    cout<<endl<<s.top();

    return 0;

}


```




# Queue

1. A queue also provides two O(1) time operations: adding an element to the end of the queue, and removing the ﬁrst element in the queue. It is only possible to access the ﬁrst and last element of a queue.


2. Need to perform further operations.

```c++
#include<bits/stdc++.h>

using namespace std;

int main(){

    queue<int> q;
    q.push(11);
    q.push(12);
    q.push(34);
    q.push(344);

    cout<<q.front();


    return 0;

}

```


---


# Priority Queue

1. A priority queue maintains a set of elements. The supported operations are insertion and, depending on the type of the queue, retrieval and removal of either the minimum or maximum element. Insertion and removal take O(logn) time, and retrieval takes O(1) time. While an ordered set efﬁciently supports all the operations of a priority queue, the beneﬁt of using a priority queue is that it has smaller constant factors.

2. A priority queue is usually implemented using a heap structure that is much simpler than a balanced binary tree used in an ordered set. By default, the elements in a C++ priority queue are sorted in decreasing order, and it is possible to ﬁnd and remove the largest element in the queue.


3. 34 is displayed on top not 1 as this maintains the order

```c++
#include<bits/stdc++.h>

using namespace std;

int main(){


    priority_queue<int> q;
    q.push(3);
    q.push(4);
    q.push(34);
    q.push(1);

    cout<<q.top();

    return 0;

}


```


4. If we want to create a priority queue that supports ﬁnding and removing the smallest element, we can do it as follows.

**Perform some more operations**

:yellow_heart:

```c++


#include<bits/stdc++.h>

using namespace std;

int main(){

    priority_queue<int,vector<int>,greater<int>> q;
    q.push(2);
    q.push(34);
    q.push(345);


    cout<<q.top();

    return 0;

}




```






---