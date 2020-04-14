



1. Day 1


---

*Naive solution O(n2)*


```c++
#include <bits/stdc++.h>

using namespace std;



void singleNumber(vector<int>& nums) {
           int element=0;
           int count=0;

           for(int i=0;i<nums.size();i++){
               element=nums[i];
               count=0;
               for(int j=0;j<nums.size();j++){
                   if(element==nums[j]){
                       count+=1;
                   }
                   if(count==2){
                       break;
                   }

               }
               if(count==1){
                   cout<<element;
                   break;
               }

           }
    }

int main(){
    vector<int>  elements;
    elements.push_back(1);
    elements.push_back(2);
    elements.push_back(1);
    elements.push_back(2);
    elements.push_back(4);

    singleNumber(elements);
    return 0;
}

```


*O(n) solution but this is with extra space*

```c++
#include<bits/stdc++.h>
using namespace std;
class Solution {
public:
    int singleNumber(vector<int>& nums) {
    map<int,int> frequencies;

    for(auto x:nums){
        frequencies[x]++;
    }
    for(auto z:frequencies){
         if(z.second==1){
             cout<<z.first;
             return z.first;
         }
    }
    return -1;
        
    }
};
```





*O(n) linear solution using XOR operation (Do you remember you had used this ?)*

```c++

int answer=0;
for(int i=0;i<nums.size();i++){
  answer=answer^nums[i];
}

```



**add-on This will make it terribly fast**



---












2. Day 2


**My Solution**

:smile:

```c++

class Solution {
public:
    bool isHappy(int number) {
        
     if(check(number)==1){
        return true;
    }
    else{
        return false;
    }        
    }
    
    int check(int number){
    if(number==1|| number==7){
        return 1;
    }
    
    else if(number<10 && number>1){
        return -1;
    }    
        

    else if(number<1){
        return -1;
    }


    else{
        int remainder=0;
        int digit=0;
        while(number!=0){
            remainder=number%10;
            digit=digit+pow(remainder,2);
            number/=10;
        }
        return  check(digit);
    }
}

    
    
};


```




**submitted solutions**


```c++
class Solution {
public:
    bool isHappy(int n) {
        vector<int> check;
        while(1)
        {
            int sum=0;
            while(n>0)
            {
                int temp=n%10;
                sum+=(temp*temp);
                n=n/10;
            }
            if(sum==1)
                return 1;
            auto it=find(check.begin(),check.end(),sum);
            if(it!=check.end())
                return 0;
            check.push_back(sum);
            n=sum;            
            
        }
    }
};
```




#### Day 4. Move Zeroes

1. My solution :) with extra space

[](https://leetcode.com/problems/move-zeroes/solution/)

```c++

class Solution {
public:
    void moveZeroes(vector<int>& nums) {
        
        vector<int> answer;
        int count=0;
        for(int i=0;i<nums.size();i++){
            if(nums[i]==0){
                count++;
            }
            else{
                answer.push_back(nums[i]);
            }
        }
        
        while(count--){
            answer.push_back(0);
        }
        
        for(int i=0;i<nums.size();i++){
            nums[i]=answer[i];
        }
        
        

    }
};

```

2. The two pointer method that *discussion* reveals

```c++
class Solution {
public:
    void moveZeroes(vector<int>& nums) {
        int i=0,j=0;
        while(j<nums.size()){
            if(nums[j]!=0){
                nums[i]=nums[j];
                i++;
            }
            j++;
        }
        while(i<nums.size()){
            nums[i++]=0;
        }
    }
};
```

2. vector.erase(vector.begin()+i) will remove the element 


```c++
class Solution {
public:
    void moveZeroes(vector<int>& nums) {
        /*if (nums.size() == 0 || nums.size() == 1)
            return;
        int count = 0;
        for (int i = 0; i < nums.size(); i++) {
            if (nums[i] == 0) {
                count++;
                nums.erase(nums.begin()+i);
                i--;
            }
        }
        for (int j = 0; j < count; j++) 
            nums.push_back(0);
    }*/
        if (nums.size() == 0 || nums.size() == 1)
            return;
        int i = 0, j = nums.size()-1;
        while (i <= j) {
            if (nums[i] == 0) {
                nums.erase(nums.begin()+i);
                nums.push_back(0);
                j--;
            }
            else
                i++;
        }
    }
};
```


4. Boom

```c++
class Solution {
public:
    void moveZeroes(vector<int>& nums) {
        ios::sync_with_stdio(false);cin.tie(NULL);cout.tie(NULL);
        int n1 = nums.size();
        vector <int>::iterator pos; 
        pos = remove (nums.begin(), nums.end() , 0); 
        for(auto i = pos; i != nums.end(); ++i)
            *i = 0;
    }
};
```



**Two pointer approach**


```c++
void moveZeroes(vector<int>& nums) {
    int lastNonZeroFoundAt = 0;
    // If the current element is not 0, then we need to
    // append it just in front of last non 0 element we found. 
    for (int i = 0; i < nums.size(); i++) {
        if (nums[i] != 0) {
            nums[lastNonZeroFoundAt++] = nums[i];
        }
    }
  // After we have finished processing new elements,
  // all the non-zero elements are already at beginning of array.
  // We just need to fill remaining array with 0's.
    for (int i = lastNonZeroFoundAt; i < nums.size(); i++) {
        nums[i] = 0;
    }
}
```



**Yeah**
  
```c++
void moveZeroes(vector<int>& nums) {
    for (int lastNonZeroFoundAt = 0, cur = 0; cur < nums.size(); cur++) {
        if (nums[cur] != 0) {
            swap(nums[lastNonZeroFoundAt++], nums[cur]);
        }
    }
}
```

---




5. *Counting elements*




```c++


class Solution {
public:
    int countElements(vector<int>& arr) {
        int occurence=0;
        multiset<int> frequencies;
        set<int> elements;

        for(auto element:arr){
            frequencies.insert(element);
            elements.insert(element);
        }


    sort(arr.begin(),arr.end());
    for(auto x:elements){
        if(elements.count(x+1)==1){
            if(frequencies.count(x+1)==frequencies.count(x)){
                occurence+=frequencies.count(x);
            }
            else if(frequencies.count(x)<frequencies.count(x+1)){
                occurence+=frequencies.count(x);
            }
            else{
                occurence+=frequencies.count(x);
            }
        }
    }

     return occurence;

    }
};
```


---


