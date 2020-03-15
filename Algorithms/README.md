


1. Selection sort

```c++

#include<bits/stdc++.h>
using namespace std;


void swapme(int *a,int *b)
{
    int temp;
    temp=*a;
    *a=*b;
    *b=temp;
}
void selectionSort(int arr[],int n){
    int minindex;
    for(int i=0;i<n-1;i++){
        minindex=i;
        for(int j=i+1;j<n;j++){
            if(arr[j]<arr[minindex]){
                    minindex=j;
            }
        }
        if(i!=minindex)
        swapme(&arr[i],&arr[minindex]);
    }

}


void display(int arr[],int n){

    for(int i=0;i<n;i++){
        cout<<arr[i]<<"   ";
    }


}

int main(){
    int arr[]={45,13,67,23,11,1,23,10,19};
    int n=sizeof(arr)/sizeof(arr[0]);
    display(arr,n);
    cout<<endl;
    selectionSort(arr,n);
    display(arr,n);
}



```



2. Bubble Sort

```c++

#include <bits/stdc++.h>
using namespace std;


void swapme(int *first,int *second){
    int temp;
    temp=*first;
    *first=*second;
    *second=temp;
}

void bubbleSort(int *array,int n){
    for(int i=0;i<n-1;i++){
        for (int j = 0; j < n-i-1; ++j) {
            if(array[j]>array[j+1])
                swapme(&array[j],&array[j+1]);
        }
    }
}

void printElements(int *array,int n){
    for (int i = 0; i < n; ++i) {
        cout<<array[i]<<"   ";
    }
}


int main(){
    int elements[]={1,34,4,9,341,99,7,11,-1,0,-2};
    bubbleSort(elements,sizeof(elements)/sizeof(elements[0]));
    printElements(elements,sizeof(elements)/sizeof(elements[0]));
    return 0;
}


```


3. Insertion sort

```c++

#include<bits/stdc++.h>
using namespace std;



void insertionSort(int arr[],int n){
    int temp;
    int j;
    for(int i=1;i<n;i++){
        temp=arr[i];
        j=i-1;
        while(j>=0 && arr[j]>temp){
            arr[j+1]=arr[j];
            j=j-1;
        }
        arr[j+1]=temp;
    }

}


void display(int arr[],int n){

    for(int i=0;i<n;i++){
        cout<<arr[i]<<"   ";
    }


}

int main(){
    int arr[]={45,13,67,23,11,1,23,10,19};
    int n=sizeof(arr)/sizeof(arr[0]);
    display(arr,n);
    cout<<endl;
    insertionSort(arr,n);
    display(arr,n);
}

``` 


**using for loop**

---

```c++

#include <bits/stdc++.h>
using namespace std;


void insertionSort(int *array,int n){
    int temp,i,j;
    for(i=1;i<n;i++){
        temp=array[i];
        for(j=i-1;j>=0&&array[j]>temp;j--)
        {
                array[j+1]=array[j];
        }
        array[j+1]=temp;
    }
}

void printElements(int *array,int n){
    for (int i = 0; i < n; ++i) {
        cout<<array[i]<<"   ";
    }
}


int main(){
    int elements[]={1,34,4,9,341,99,7,11,-1,0,-2};
    insertionSort(elements,sizeof(elements)/sizeof(elements[0]));
    printElements(elements,sizeof(elements)/sizeof(elements[0]));
    return 0;
}

```


---


4. *Quicksort*

> In the first swap pivot is at its proper position, all the elements to its left are smaller while elements on right
are greater but not necessarily in sorted order.\
Some elements are swapped in this process


```c++
#include<bits/stdc++.h>

using namespace std;



int partitions(int a[],int low,int up){
    int pivot=a[low];
    int i=low+1;
    int j=up;

    while(i<=j){
        while(a[i]<pivot && i<j){
            i=i+1;
        }
        while(a[j]>pivot){
            j=j-1;
        }
        if(i<j){
            swap(a[i],a[j]);
            i+=1;
            j-=1;
        }
        else{
            break;
        }
    }
    a[low]=a[j];
    a[j]=pivot;

    return j;

}
void quickSort(int a[],int low,int up){
    int p;
    if (low>=up)
        return;
    else{

        p=partitions(a,low,up);
        quickSort(a,low,p-1);
        quickSort(a,p+1,up);
    }
}


void display(int a[],int n){

    for(int i=0;i<n;i++){
        cout<<a[i]<<"   ";
    }
}


int main(){

    int a[]={12,4,11,24,5,1,43};
    quickSort(a,0,(sizeof(a)/sizeof(a[0])));
    display(a,(sizeof(a)/sizeof(a[0])));

    return 0;
}


```