
# First question.

1. 


```c++
#include <bits/stdc++.h>
using namespace std;




int find_larger(vector<int> A,int element,int j,int n){
    int flag=0;
    for (int k = j+1; k < n; ++k) {
        if(element<A[k]){
            flag=1;
            return A[k];
        }
    }
    if(flag==0){
        return -1;
    }
}

int find_smaller(vector<int> A,int element,int j,int n){
    int flag=0;
    for (int k = j+1; k < n; ++k) {
        if(element>A[k]){
            flag=1;
            return A[k];
        }
    }
    if(flag==0){
        return -1;
    }
}





int main(){
    int n;
    cin>>n;
    vector<int> A;
    int next_larger,next_smaller;
    vector<int> next_larger_A;
    vector<int> next_smaller_A;

    int element;
    for (int i = 0; i < n; ++i) {
         cin>>element;
         A.push_back(element);
    }

    for (int j = 0; j < n-1; ++j) {
        element=A[j];
        next_larger=find_larger(A,element,j,n);
        next_larger_A.push_back(next_larger);
    }
    next_larger_A.push_back(-1);


    for (int j = 0; j < n-1; ++j) {
        element=next_larger_A[j];
        next_smaller=find_smaller(A,element,j,n);
        next_smaller_A.push_back(next_smaller);
    }
    next_smaller_A.push_back(-1);




//    for(auto x:A){
//        cout<<x<<"  ";
//    }
//
//
//    for(auto y:next_larger_A){
//        cout<<y<<"  ";
//    }
//    cout<<"            "<<endl;
    for(auto y:next_smaller_A){
        cout<<y<<"  ";
    }



    return 0;
}




``` 