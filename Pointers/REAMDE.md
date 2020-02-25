
# Introduction to pointers

1. Pointers -> variables that store address of other variables

```c
int a;
int *p;  //pointer to integer
char c;
char *d;  //pointer to character
```




> *value at* and *value of*

```c

#include <bits/stdc++.h>
using namespace std;

int main(){
    int a=24;
    int *p;

    p=&a;
    printf("%d\n",p);
    printf("*****\n");
    printf("%d",*p);
    printf("This will be address of a  &a%d\n",p);
    printf("This is be address of p &p   %d\n",&p);
    printf("Eventually value at p%d\n",*p); //deferencing
    return 0;
}


6422300
*****
24This will be address of a  &a6422300
This is be address of p &p   6422296
Eventually value at p24

```


```c

#include <bits/stdc++.h>
using namespace std;

int main(){
    int a;
    int *p;
    p=&a;       //&a
    
    printf("Address of a stored in p");
    printf("%d \n",p);
    printf("Value stored at p, p's address");
    printf("%d \n",*p);
}
```


2. Pointer Arithmetic

```c


#include <bits/stdc++.h>
using namespace std;
int main(){
    int a=10;
    int *p;
    p=&a;

    printf("p    %d\n ",p);
    printf("p+1  %d\n ",p+1);
    printf("p+2  %d\n ",p+2);

    return 0;
}
p    6422296
p+1  6422300
p+2  6422304
```


---


```c



#include <bits/stdc++.h>
using namespace std;
int main(){
    int a=10;
    int *p;
    p=&a;

    printf("p    %d\n ",p);
    printf("p    %d\n ",*(p+1));

    printf("p+1  %d\n ",p+1);
    printf("p+1  %d\n ",*(p+1));

    printf("p+2  %d\n ",p+2);
    printf("p+2  %d\n ",*(p+2));

    return 0;
}
p    6422296
p    6422296
p+1  6422300
p+1  6422296
p+2  6422304
p+2  6422284
```




#Pointer types,pointer arithmetic, void pointers

1. Pointer variables are strongly typed .

> Why not generic type? Pointer variable doesn't store only
addresses but to dereference these references to access/change value.



```c

#include <bits/stdc++.h>
using namespace std;
int main(){

    int a=1027;
    int *p;
    p=&a;

    printf("size of integer is %d bytes \n ",sizeof(int));
    printf("address = %d , value =%d \n",p,*p);

    char *p0;
    p0=(char*)p;  //typecasting

    printf("size of char is %d bytes \n ",sizeof(char));
    printf("address = %d , value =%d \n",p0,*p0);

    // 1027= 00000000 00000000 00000100 00000111
    // 00000111 eventually single byte is dereferenced 
    return 0;
}

size of integer is 4 bytes
        address = 6422292 , value =1027
size of char is 1 bytes
        address = 6422292 , value =3
```



---



```c


#include <bits/stdc++.h>
using namespace std;
int main(){

    int a=1025;
    int *p;
    p=&a;

    printf("size of integer is %d bytes \n ",sizeof(int));
    printf("address = %d , value =%d \n",p,*p);

    char *p0;
    p0=(char*)p;  //typecasting

    printf("size of char is %d bytes \n ",sizeof(char));
    printf("address = %d , value =%d \n",p0,*p0);

    // 1027= 00000000 00000000 00000100 00000001
    // 00000111 eventually single byte is dereferenced
    return 0;
}


size of integer is 4 bytes
        address = 6422292 , value =1025
size of char is 1 bytes
        address = 6422292 , value =1
```


---


```c


#include <bits/stdc++.h>
using namespace std;
int main(){

    int a=1025;
    int *p;
    p=&a;

    printf("size of integer is %d bytes \n ",sizeof(int));
    printf("address = %d , value =%d \n",p,*p);

    char *p0;
    p0=(char*)p;  //typecasting

    printf("size of char is %d bytes \n ",sizeof(char));
    printf("address = %d , value =%d \n",p0,*p0);
    printf("address = %d , value =%d \n",p0+1,*(p0+1));
    printf("address = %d , value =%d \n",p0+2,*(p0+2));

    // 1027= 00000000 00000000 00000100 00000001
    // 00000111 eventually single byte is dereferenced
    return 0;
}


size of integer is 4 bytes
        address = 6422292 , value =1025
size of char is 1 bytes
        address = 6422292 , value =1
address = 6422293 , value =4
address = 6422294 , value =0

```



---


*void pointer*

```c

#include <bits/stdc++.h>
using namespace std;
int main(){

    int a=1025;
    int *p;
    p=&a;

    printf("size of integer is %d bytes \n ",sizeof(int));
    printf("address = %d , value =%d \n",p,*p);

    void *p0;
    p0=p;

    printf("address = %d  \n",p0);




    return 0;
}


size of integer is 4 bytes
        address = 6422292 , value =1025
address = 6422292

```



---


# Pointer to pointer



---



1. 


```c

#include <bits/stdc++.h>
using namespace std;
int main(){

    int x=24;        //225    24
    int *p=&x;       //215    225
    int **q=&p;      //205    215
    int ***r=&q;     //230    205


    printf("%d\n",*p);  //24
    printf("%d\n",*q);  //215
    printf("%d\n",*(*q)); //24
    printf("%d\n",*(*r)); //  225
    printf("%d\n",*(*(*r))); // 24

    return 0;
}

24
6422296
24
6422296
24


```


2.


```c

#include <bits/stdc++.h>
using namespace std;

void increment(int *p){
    *p=(*p)+1;
}

int main(){

    int a=24;
    increment(&a);
    printf("a %d",a);
    return 0;
}

a 25



```



# Pointers and Arrays

```c

#include <bits/stdc++.h>
using namespace std;

int main(){
    int K[]={1,2,3,4};
    printf("%d   %d\n",K,*K);
    printf("%d   %d\n",K+1,*(K+1));
    printf("%d   %d\n",K+2,*(K+2));
    printf("%d   %d\n",K+3,*(K+3));


    return 0;
}



6422288   1
6422292   2
6422296   3
6422300   4

```



*Try to fix this*

```c

#include <bits/stdc++.h>
using namespace std;

void sumOfArray(int K[]){
    printf("The size of K within sumOfArray is %d",sizeof(K));

}
int main(){
    int K[]={1,2,3,4};
    printf("The size of K within main is %d\n",sizeof(K));
    sumOfArray(K);
    return 0;
}

The size of K within main is 16
The size of K within sumOfArray is 4


```


**int *K = int K[]**


```c

#include <bits/stdc++.h>
using namespace std;

void sumOfArray(int *K){
    printf("The size of K within sumOfArray is %d",sizeof(K));

}
int main(){
    int K[]={1,2,3,4};
    printf("The size of K within main is %d\n",sizeof(K));
    sumOfArray(K);
    return 0;
}




```


# Arrays as function argument

```c

#include <bits/stdc++.h>
using namespace std;

void sumOfArray(int K[],int size){
     int i=0;

     for(i=0;i<size;i++){
         K[i]=2*i;
     }


}
int main(){
    int K[]={1,2,3,4};
    int size=sizeof(K)/sizeof(K[0]);
    sumOfArray(K,size);

    int i=0;
    for(i=0;i<size;i++){
        printf("%d ",K[i]);
    }
    return 0;
}



```



---

# Character arrays and pointers 


```c

#include <bits/stdc++.h>
using namespace std;

void print(char *value){
    while(*value!='\0'){
        printf("%c",*value);
        value+=1;
    }
}
int main(){

    char value[10]="Hello";
    print(value);
    return 0;
}


```

---







### Structure Basics

```c






1. Structure in c

```c

#include <stdio.h>


struct book{
    char title[20];
    char author[20];
    int pages;
};

int main() {

    struct book oxford={"yeah","john",200};
    printf("%s",oxford.title);
    printf("%s",oxford.author);
    printf("%d",oxford.pages);
    return 0;
}
```




2. Taking input from the user.



```c 
#include <stdio.h>
struct book{
    char title[20];
    char author[20];
    int pages;
};

int main() {

    struct book oxford;
    scanf("%s",oxford.title);
    scanf("%s",oxford.author);
    scanf("%d",&oxford.pages);


    printf("%s",oxford.title);
    printf("%s",oxford.author);
    printf("%d",oxford.pages);
    return 0;
}
```

3. Array of structure.

```c

#include <stdio.h>


struct marks{
    int os;
    int dbms;
    int c;
};

int main() {

    struct marks student[3];

    student[0].c=100;
    student[0].dbms=100;
    student[0].os=99;

    student[1].c=81;
    student[1].dbms=81;
    student[1].os=91;

    student[2].c=80;
    student[2].dbms=80;
    student[2].os=90;

    for(int i=0;i<=2;i++){
        printf("student %d c=%d dbms=%d os=%d\n",i,student[i].dbms,student[i].c,student[i].os);
    }
    return 0;
}

student 0 c=100 dbms=100 os=99
student 1 c=81 dbms=81 os=91
student 2 c=80 dbms=80 os=90


```



3. Return type as of structure


```c

#include <stdio.h>
#include <malloc.h>
#include <string.h>
struct student{
    char name[20];
    int roll;
};
void display(struct student *);
struct student *function();
int main() {
    struct student *a;
    a=function();
    display(a);
    return 0;
}

struct student *function(){
    struct student *harry;
    harry=(struct student *)malloc(sizeof(struct student));
    strcpy(harry->name,"yeah");
    harry->roll=101;
}

void display(struct student *a){
    printf("%d",a->roll);
    printf("%s",a->name);
}

```




### Basics of structure







1. Structure in c

```c

#include <stdio.h>


struct book{
    char title[20];
    char author[20];
    int pages;
};

int main() {

    struct book oxford={"yeah","john",200};
    printf("%s",oxford.title);
    printf("%s",oxford.author);
    printf("%d",oxford.pages);
    return 0;
}
```




2. Taking input from the user.



```c 
#include <stdio.h>
struct book{
    char title[20];
    char author[20];
    int pages;
};

int main() {

    struct book oxford;
    scanf("%s",oxford.title);
    scanf("%s",oxford.author);
    scanf("%d",&oxford.pages);


    printf("%s",oxford.title);
    printf("%s",oxford.author);
    printf("%d",oxford.pages);
    return 0;
}
```

3. Array of structure.

```c

#include <stdio.h>


struct marks{
    int os;
    int dbms;
    int c;
};

int main() {

    struct marks student[3];

    student[0].c=100;
    student[0].dbms=100;
    student[0].os=99;

    student[1].c=81;
    student[1].dbms=81;
    student[1].os=91;

    student[2].c=80;
    student[2].dbms=80;
    student[2].os=90;

    for(int i=0;i<=2;i++){
        printf("student %d c=%d dbms=%d os=%d\n",i,student[i].dbms,student[i].c,student[i].os);
    }
    return 0;
}

student 0 c=100 dbms=100 os=99
student 1 c=81 dbms=81 os=91
student 2 c=80 dbms=80 os=90


```



3. Return type as of structure


```c

#include <stdio.h>
#include <malloc.h>
#include <string.h>
struct student{
    char name[20];
    int roll;
};
void display(struct student *);
struct student *function();
int main() {
    struct student *a;
    a=function();
    display(a);
    return 0;
}

struct student *function(){
    struct student *harry;
    harry=(struct student *)malloc(sizeof(struct student));
    strcpy(harry->name,"yeah");
    harry->roll=101;
}

void display(struct student *a){
    printf("%d",a->roll);
    printf("%s",a->name);
}

```




### Basics of structure


```c

#include <stdio.h>
#include <malloc.h>
#include <string.h>


struct node {
    int info;
    struct node *link;
};

int main() {

    struct node *start=NULL;
    start=(struct node*)malloc(sizeof(struct node));

    struct node *node1,*node2,*node3,*node4,*p;
    node1=(struct node*)malloc(sizeof(struct node));
    node2=(struct node*)malloc(sizeof(struct node));
    node3=(struct node*)malloc(sizeof(struct node));
    node4=(struct node*)malloc(sizeof(struct node));

    p=(struct node*)malloc(sizeof(struct node));

    start=node1;
    node1->info=1;
    node1->link=node2;
    node2->info=2;
    node2->link=node3;
    node3->info=3;
    node3->link=node4;
    node4->info=4;
    node4->link=NULL;
    p=start;

    printf("%d\n",p->info);
    p=p->link;
    printf("%d\n",p->info);
    p=p->link;
    printf("%d\n",p->info);
    p=p->link;
    printf("%d\n",p->info);



//    while (p->link->link!=NULL){
//        printf("%d",p->info);
//        p=p->link;
//    }

    return 0;
}







```


```c
#include <stdio.h>
#include <malloc.h>
#include <string.h>


struct node {
    int info;
    struct node *link;
};

int main() {

    struct node *start=NULL;
    start=(struct node*)malloc(sizeof(struct node));

    struct node *node1,*node2,*node3,*node4,*p;
    node1=(struct node*)malloc(sizeof(struct node));
    node2=(struct node*)malloc(sizeof(struct node));
    node3=(struct node*)malloc(sizeof(struct node));
    node4=(struct node*)malloc(sizeof(struct node));

    p=(struct node*)malloc(sizeof(struct node));

    start=node1;
    node1->info=1;
    node1->link=node2;
    node2->info=2;
    node2->link=node3;
    node3->info=3;
    node3->link=node4;
    node4->info=4;
    node4->link=NULL;
    p=start;

    printf("%d\n",p->info);
    p=p->link;
    printf("%d\n",p->info);
    p=p->link;
    printf("%d\n",p->info);
    p=p->link;
    printf("%d\n",p->info);



//    while (p->link->link!=NULL){
//        printf("%d",p->info);
//        p=p->link;
//    }

    return 0;
}



```