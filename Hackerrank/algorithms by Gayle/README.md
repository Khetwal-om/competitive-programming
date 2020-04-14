##### 13 Bit manipulation

---

**Masks**

## Getting the ith bit

1. To get the *ith* bit :smile:  :earth:

 00101100
&00100000   ```c++ (x&(1<<i))!=0```
**--------**
 00100000

## Setting the ith bit

2. 

```c++
(x|(1<<i))
``` 


## Clear the ith bit


3. Here we and with a mask where it has 1 everywhere else but that *one spot*


```c++
x(&(~(1<<i)))
```

10001100

  1<<3  =   00001000
!(1<<3) =   11110111
10001100
11110111
10000100


---



#### 15 Lonely integer


```java

int lonelyInteger(int[] array){
	int answer=0;
	for(int x:array){
		answer^=x;
	}
}

```


