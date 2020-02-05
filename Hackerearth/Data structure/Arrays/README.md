


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