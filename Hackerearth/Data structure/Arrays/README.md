


1.  


1 X 

Flip A[X] 
if(0) set to 1 else set to 0

Now 0 L R
consider the array from L to R
check if this last digit 1 or not , if it's a yes. print odd


```c  

#include <bits/stdc++.h>
using namespace std;

int main(){

    int flip,zero;
    int one,left,right;
    int N,Q;

    cin>>N>>Q;

    int A[N];


    for(int i=1;i<=N;i++){
        cin>>A[i];
    }


    cin>>zero>>flip;

    cin>>one>>left>>right;



    if(A[flip]==0){
        A[flip]=1;
    }
    else{
        A[flip]=0;
    }

    if(A[right]==1){
        cout<<"ODD";
    }
    else{
        cout<<"EVEN";
    }
    return 0;


}

```



2. Monk and welcome problem

```c  

#include <bits/stdc++.h>
using namespace std;

int main(){


    int n;
    cin>>n;

    int *A=(int*)malloc(n*sizeof(int));
    int *B=(int*)malloc(n*sizeof(int));
    int *C=(int*)malloc(n*sizeof(int));


    for(int i=0;i<n;i++){
        cin>>A[i];
    }
    for(int i=0;i<n;i++){
        cin>>B[i];
    }

    for(int i=0;i<n;i++){
        C[i]=A[i]+B[i];
    }


    for(int k=0;k<n;k++){
        cout<<C[k]<<" ";
    }

    return 0;


}

```




3. Micro and Array Update


```c++

#include <bits/stdc++.h>
using namespace std;

int main() {

    int n, t, k,small;
    cin >> t;
//    cin >> n >> k;
    vector<int> v;




    for (int i = 0; i < t; i++) {

        cin >> n >> k;
        int A[n];


        for (int p = 0; p < n; p++) {
            cin >> A[p];
        }




        small=*min_element(A,A+n);



        v.push_back(k-small);
    }


    for(auto x:v){
        if(x<0)
        {
            x=0;
            cout<<x<<" "<<endl;
        }
        else{
            cout<<x<<" "<<endl;
        }

    }


    return 0;


}

```


### Pairs having similar elements

1. 

```c++  
#include<bits/stdc++.h>
using namespace std;

long long SimilarElementsPairs (vector<int> A,int N) {
    // Write your code here
    vector< pair<int,int> > points;
    int count=0;

    for(int i=0;i<N;i++){
        for(int j=i+1;j<=N;j++){
            if((A[i]==A[j]+1 || A[j]==A[i]+1))
            {

                points.emplace_back(i+1,j+1);
                count+=1;
            }
        }
    }


    cout<<"*********"<<endl;
    int flag=0;

    for(int k=0;k<count;k++){
        cout<<points[k].first<<"   "<<points[k].second<<endl;
        for(int m=k+1;m<count;m++){
                if(points[k].second==points[m].second || points[k].second==points[m].first){
                   flag+=1;
                }
        }
    }
    return flag;

}

int main() {

    ios::sync_with_stdio(0);
    cin.tie(0);
    int N;
    cin >> N;
    vector<int> A(N);
    for(int i_A=0; i_A<N; i_A++)
    {
        cin >> A[i_A];
    }

    long long out_;
    out_ = SimilarElementsPairs(A,N);
    cout << out_;
}

```



2. The function ain't returning proper value

```c++

#include<bits/stdc++.h>
using namespace std;

long long SimilarElementsPairs (vector<int> A,int N) {
    // Write your code here
    vector< pair<long long,long long> > points;
    long long count=0;

    for(int i=0;i<N;i++){
        for(int j=i+1;j<=N;j++){
            if((A[i]==A[j]+1 || A[j]==A[i]+1))
            {
                points.emplace_back(i+1,j+1);
                count+=1;
            }
        }
    }


    int flag=0;
    for(int k=0;k<count;k++){
        for(int m=k+1;m<count;m++){
                if(points[k].second==points[m].second ) {
//                   cout<<points[k].second<<"  "<<points[m].second<<endl;
flag+=1;
                }
                 if( points[k].second==points[m].first)
            {
//                cout<<points[k].second<<"  "<<points[m].first<<endl;
flag+=1;
            }
             if(points[k].first==points[m].first){
//                cout<<points[k].first<<"  "<<points[m].first<<endl;
flag+=1;
            }
            else{

            }

        }
    }
    return flag+count;

}

int main() {

    ios::sync_with_stdio(0);
    cin.tie(0);
    int N;
    cin >> N;
    vector<int> A(N);
    for(int i_A=0; i_A<N; i_A++)
    {
        cin >> A[i_A];
    }

    long long out_;
    out_ = SimilarElementsPairs(A,N);
    cout << out_;
}

```




### Hamilton and lagrangian



1. **Try to improve time complexity**

```c++ 

#include <bits/stdc++.h>
using namespace std;


int main(){
    vector<int> v;
    int N,flag=0,element;
    int* A=(int *)malloc(sizeof(int)*N);
    cin>>N;
    for(int i=0;i<N;i++){
        cin>>A[i];
    }

//    iterate over array  add it in vector if it is smaller than rest of elements   in its right
//  i

    for(int i=0;i<N;i++){
        element=A[i];
        // for each A[i]  check whether all a[j] are smaller
        //  j=i+1
        for(int k=i+1;k<N;k++){
            if(A[k]>element){
                flag=1;
                break;
            }
        }
        if(flag==0){
            v.push_back(element);
        }
        flag=0;
    }


    for(auto x:v){
        cout<<x<<" ";
    }

}

```




### Charged Up Array


1. We need to generate subsets


```c++ 

#include <bits/stdc++.h>
using namespace std;



void printPowerSet(char *set,int set_size){
    unsigned int pow_set_size=pow(2,set_size);
    int counter,j;

    for(counter=0;counter<pow_set_size;counter++){
        for(j=0;j<set_size;j++){
            if(counter&(1<<j)){
                cout<<set[j];
            }
        }
        cout<<endl;
    }

}

int main(){
    char set[]={'a','b','c'};
    printPowerSet(set,3);

}



```



### Pending solution


1. Need to store one D vector in 2 D vector.

```c++
#include <bits/stdc++.h>
using namespace std;



void printPowerSet(int *set,int set_size){
    unsigned int pow_set_size=pow(2,set_size);
    vector <int> v;
    vector<vector<int>> wow;
    int counter,j;

    for(counter=0;counter<pow_set_size;counter++){
        for(j=0;j<set_size;j++){
            if(counter&(1<<j)){
                cout<<set[j];
                v.push_back(set[j]);
            }
        }
        wow.push_back(v);

        cout<<endl;
    }

    for(auto x:wow){
        for(auto y:x){
            cout<<y;
        }
        cout<<endl;
    }
}

int main(){
    int set[]={1,2,3};
    printPowerSet(set,3);

}


```









4. Polygon possibility

:heart:


**Property of a polygon is that sum of largest side is always smaller than sum of the
rest of the sides**


```c++


#include<bits/stdc++.h>
using namespace std;


int main() {

    int T, N;
    vector<int> values;
    vector<string> answers;
    int sum = 0, rest = 0;
    int element;
    int maximum;

    cin >> T;


    for (int i = 0; i < T; i++) {
        cin >> N;

        for (int j = 0; j < N; j++) {
            cin >> element;
            values.push_back(element);
        }
        sum = accumulate(values.begin(), values.end(), 0);
        maximum = *max_element(values.begin(), values.end());
        rest = sum - maximum;

        if (maximum < rest) {
            answers.emplace_back("Yes");
        } else {
            answers.emplace_back("No");
        }

        rest=0;
        sum=0;
        maximum=0;
        values.clear();
        N=0;
    }

    for(auto x:answers){
        cout<<x<<endl;
    }


//   find max(elements)
//   check if max<sum of all elements other than max
//   sum of rest elements  sum(elements)-max;
//   if   yes,  print Yes else No


}



"A:\Competitive programming\Cplusplusworkbench\cmake-build-debug\Cplusplusworkbench.exe"
2
3
4 3 2
4
1 2 1 42
3
4 3 2
4
1 2 1 4

Yes
        No



Process finished with exit code 0



```