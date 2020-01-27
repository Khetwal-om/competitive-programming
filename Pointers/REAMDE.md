
#Introduction to pointers

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


```cmake

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

```cmake



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


```cmake



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



```cmake

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



```cmake


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


```cmake


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

```cmake

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


```cmake

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


```cmake

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



3. 