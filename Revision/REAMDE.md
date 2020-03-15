
---

# Revision


1. selection 

```c++

#include <bits/stdc++.h>
using namespace std;

// swap method
//
//void swap(int *first,int *second){
//    int temp;
//    temp=*first;
//    *first=*second;
//    *second=*temp;
//}

void selectionSort(int *array,int n){
    int minindex;
    for(int i=0;i<n-1;i++){
        minindex=i;
        for (int j = i+1; j < n; ++j) {
            if(*(array+j)<*(array+minindex))
                minindex=j;
        }
        if(i!=minindex){
            swap(*(array+minindex),*(array+i));
        }
    }
}

void printElements(int *array,int n){
    for (int i = 0; i < n; ++i) {
        cout<<array[i]<<"   ";
    }
}


int main(){
    int elements[]={1,34,4,9,341,99,7};
    selectionSort(elements,sizeof(elements)/sizeof(elements[0]));
    printElements(elements,sizeof(elements)/sizeof(elements[0]));
    return 0;
}

```

---