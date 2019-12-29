


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
#include<bits/stdc++.h>
using namespace std;


void swapme(int *a,int *b)
{
    int temp;
    temp=*a;
    *a=*b;
    *b=temp;
}
void bubbleSort(int arr[],int n){
    for(int i=0;i<n-1;i++){
        for(int j=i+1;j<n;j++){
            if(arr[i]>arr[j]){
                swapme(&arr[i],&arr[j]);
            }
        }
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
    bubbleSort(arr,n);
    display(arr,n);
}



```


3. Insertion sort

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
void insertionSort(int arr[],int n){
    int temp;
    int j;
    for(int i=0;i<n;i++){
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


4. 