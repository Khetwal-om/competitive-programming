


1. Median of two arrays.


Can't make out of this [Solution](https://www.educative.io/edpresso/how-to-find-the-median-of-two-sorted-arrays-in-cpp).


```c++

class Solution {
    
    
private:
    double findK(vector<int> &nums1,vector<int> &nums2,int s1,int len1,int s2,int len2,int k){
        if(len1>len2) return findK(nums2,nums1,s2,len2,s1,len2,K);
        if(len1<=0) return nums2[s2+K-1];
        if(k==1) return min(nums[s1],nums[s2]);
        
        int mid1,mid2,hL1,hL2;
        hL1=min(K   /2,len1);
        mid1=s1+hL1-1;
        hL2=K-hL1;
        mid2=s2+hL2-1;
        
        if(nums1[mid1]==nums2[mid2]) return nums1[mid1];
        else if(nums1[mid1]<nums2[mid2]) return findK(nums1,nums2,mid1+1,len-hL1,s2,len2,K-hL1);
         else return findK(nums1, nums2, s1, len1, mid2+1, len2-hL2, K - hL2);
        
    }
    
    
public:
    double findMedianSortedArrays(vector<int>& nums1, vector<int>& nums2) {
        
        int len1=nums1.size(),len2=nums2.size();
        if(!len1 && !len2) return 0;
        if((len1+len2)%2) return findK(nums1,nums2,0,len1,0,len2,(len1+len2)/2+1);
        else return (findK(nums1,nums2,0,len1,0,len2,(len1+len2)/2)+findK(nums1,nums2,0,len1,0,len2,(len1+len2)/2+1))/2.0;
        
    }
};


```


```java


private static class Subarray {
    private int[] underlying;
    private int start;
    private int size;
        
    // Get a new subarray that is backed by the input array
    private static Subarray fromArray(int[] arr) {
        Subarray s = new Subarray();
        s.underlying = arr;
        s.start = 0;
        s.size = arr.length;
        return s;
    }
        
    // Return the subarray from i to j, including i and excluding j
    private Subarray subarray(int i, int j) {
        if (i > j) throw new IllegalArgumentException();
        if (j > this.size) throw new IndexOutOfBoundsException();
        Subarray s = new Subarray();
        s.underlying = this.underlying;
        s.start = start + i;
        s.size = j - i;
        return s;
    }
        
    // Get the size of the subarray
    private int getSize() {
        return size;
    }
        
    // Get the first element of the subarray
    private int getFirst() {
        return underlying[start];
    }
        
    // Get the last element of the subarray
    private int getLast() {
        return underlying[start + size - 1];
    }
        
    // Get the median of the subarray
    private double getMedian() {
        // If it is even length, average the middle elements
        if (size % 2 == 0) 
            return (underlying[start + size / 2 - 1] + 
                    underlying[start + size / 2]) / 2.;
        return underlying[start + size / 2];
    }
}
    
// Recursively find the median. We remove ~half the items from above and
// below the median on each turn, resulting in O(n log n) runtime
public static double median(int[] arr1, int[] arr2) {
    if (arr1.length == 0 || arr1.length != arr2.length) throw new IllegalArgumentException();
    return median(Subarray.fromArray(arr1), Subarray.fromArray(arr2));
}
    
// Recursive function
private static double median(Subarray arr1, Subarray arr2) {
    // If each array is length 1, just average the two values
    if (arr1.getSize() == 1) {
        return (arr1.getFirst() + arr2.getFirst()) / 2.;
    }
    // If each array is length 2, take the larger first value and the 
    // smaller second value and average them to get the median
    if (arr1.getSize() == 2) {
        return (Math.max(arr1.getFirst(), arr2.getFirst()) +
                Math.min(arr1.getLast(), arr2.getLast())) / 2.;
    }
        
    double median1 = arr1.getMedian();
    double median2 = arr2.getMedian();
        
    // If both arrays have the same median we've found the overall median
    if (median1 == median2) return median1;
    // For the array with the greater median, we take the bottom half of 
    // that array and the top half of the other array
    if (median1 > median2) {
        // If the arrays are even length, we want to include the upper/lower
        // half of the array plus one additional element
        return median(arr1.subarray(0, arr1.getSize() / 2 + 1), 
                      arr2.subarray((arr2.getSize() - 1) / 2, arr2.getSize()));
    }
    // Do the opposite of median1 > median2
    return median(arr1.subarray((arr1.getSize() - 1) / 2, arr1.getSize()),
                  arr2.subarray(0, arr2.getSize() / 2 + 1));
}

```




---

2. ANagram

**O(m+n)**

:raised_hands:





```c++

#include <bits/stdc++.h>
using namespace std;

bool isAnagram(string s1,string s2){
    if(s1.size()!=s2.size()) return false;


    vector<int> check(1<<8);

        for(auto x:s1){
            check[x]++;
        }

        for(auto x:s2){
            check[x]--;
        }

        for(auto x:check){
            if(x!=0)
                return false;
        }

      return true;

}

int main(){

    cout<<isAnagram("bbbb","bbbb");

    return 0;
}

```



*java*


:clap:

```java
public boolean isAnagram(String s1, String s2) {
    if (s1.length() != s2.length()) return false;
 
    s1 = s1.toLowerCase();
    s2 = s2.toLowerCase();
 
    int[] letters = new int[1<<8];
 
    for (char c : s1.toCharArray()) {
        letters[c]++;
    }
 
    for (char c: s2.toCharArray()) {
        letters[c]--;
    }
 
    for (int i : letters) {
        if (i != 0) return false;
    }
 
    return true;
}

```






---



2. N stacks


**Can't make anything out of this :)**

```c++

#include <bits/stdc++.h>
using namespace std;


vector<int> topOfStack;
vector<int> stackData;
vector<int> nextIndex;
int nextAvailable=0;

void Stacks(int numStacks,int capacity){
    for(int i=0;i<capacity;i++){
        topOfStack[i]=-1;
    }
    for (int j = 0; j < capacity; ++j) {
        stackData[j]=0;
    }
    for (int k = 0; k < capacity; ++k) {
        nextIndex[k]=k+1;
    }
    nextIndex[nextIndex.size()-1]=-1;

}
void push(int stack,int value){
    if(stack<0 || stack>=topOfStack.size()){
        return;
    }
    if(nextAvailable<0) return ;
    int currentIndex=nextAvailable;
    nextAvailable=nextIndex[currentIndex];
    stackData[currentIndex]=value;
    nextIndex[currentIndex]=topOfStack[stack];
    topOfStack[stack]=currentIndex;


}

int pop(int stack){
    if(stack<0 ||stack>=topOfStack.size() ||topOfStack[stack]<0)
        return -1;
    int currentIndex=topOfStack[stack];
    int value=stackData[currentIndex];
    topOfStack[stack]=nextIndex[currentIndex];
    nextIndex[currentIndex]=nextAvailable;
    nextAvailable=currentIndex;
    return value;
}

int main(){



    return 0;
}


```




3. Permutations


```c++
#include <bits/stdc++.h>
using namespace std;



void swap(vector<int> a,int i,int j){
    int temp=a[i];
    a[i]=a[j];
    a[j]=temp;
}





void permutations(vector<int> a,int start,vector<int[]> results){
    if(start>=a.size()){
        results.emplace_back(a.begin(),a.end());
//        results.add(a);
    }
    else{
        for(int i=start;i<a.size();i++){
            swap(a,start,i);
            permutations(a,start+1,results);
            swap(a,start,i);
        }
    }
}

vector<int[]> permutations(vector<int> a){
    vector<int[]> results;
    permutations(a,0,results);
    return results;
}

int main(){


    return 0;
}
```


4. Merge Arrays


```c++

void mergeArrays(int[] a,int[] b,int aLength,int bLength){
    int aIndex=aLength-1;
    int bIndex=bLength-1;
    int mergeIndex=aLength+bLength-1;


    while(aIndex>=0 &&bIndex>=0){

        if(a[aIndex]>b[bIndex]){
            a[mergeIndex]=a[aIndex];
            aIndex--;
        }
        else {
            a[mergeIndex]=a[bIndex];
            bIndex--;
        }

        mergeIndex--;
    }
    while(bIndex>=0){
        a[mergeIndex]=b[bIndex];
        mergeIndex--;
        bIndex--;
    }

}


```












**Find all duplicates**



1. Naive solution (sorting is needed),unique elements from **answer** vector.


```c++

#include <bits/stdc++.h>
using namespace std;


void duplicates(vector<int> elements){
    vector<int> answer;
    int element;

    for (int i = 0; i < elements.size()-1; ++i) {  
        element=elements[i];
        for (int j = i+1; j < elements.size(); ++j) {
            if(element==elements[j]){
                answer.push_back(element);
                break;
            }
        }
    }
    for(auto x:answer){
        cout<<x<<"           ";
    }
}

int main(){
    vector<int> elements={1,2,2,4,5,5,5,6,6,6,10};
    duplicates(elements);


    return 0;
}



```



2. Can we improve it further. **Well done**  O(n)


```c++
#include <bits/stdc++.h>
using namespace std;


void duplicates(vector<int> elements){
    unordered_map <int,int> dictionary;
   for(int k=0;k<elements.size();k++){
       dictionary[k]=0;
   }
    for (int i = 0; i < elements.size(); ++i) {
        dictionary[elements[i]]++;
    }

    for(auto x:dictionary){
        cout<<x.first<<"    "<<x.second<<endl;
    }

    cout<<"*******************************"<<endl;


    for(auto x:dictionary){
        if(x.second>1){
            cout<<x.first<<"       "<<x.second<<endl;
        }
    }

}

int main(){
    vector<int> elements={1,2,3,4,5,6,7,7,8,1,1,1,1,2,2,3,4,5,6,7,7};
    duplicates(elements);


    return 0;
}


20    0
19    0
18    0
17    0
16    0
15    0
14    0
13    0
1

12    0
11    0
10    0
3    2
2    3
1    5
0    0
4    2
5    2
6    2
7    4
8    1
9    0
*******************************
3       2
2       3
1       5
4       2
5       2
6       2
7       4




```





3. Solution of the  teacher(pedagouge)

2,1,2,1
```c++


vector<int> duplicates(vector<int> elements){

    vector<int> answers;
    for(int i=0;i<elements.size();i++){
        int index=abs(elements[i])-1;
        if(elements[index]<0){
            answers.push_back(abs(elements[i]))
    }
    else{
        elements[index]=-elements[index];    

    }
  }

}


```




7. Intersection of two arrays.


```c++

class Solution {
public:
    vector<int> intersection(vector<int>& one, vector<int>& two) {
        
    set<int> elements_one;
    set<int> elements_second;
    vector<int> firstt;
    vector<int> secondd;
    vector<int> answer;

    for(auto x:one){
        elements_one.insert(x);
    }

    for(auto x:two){
        elements_second.insert(x);
    }


    for(auto x:elements_one) firstt.push_back(x);
    for(auto y:elements_second) secondd.push_back(y);


    map<int,int> has;
//    vector<int,int> has;



    for (int i = 0; i < firstt.size(); ++i) {
        has[firstt[i]]++;
    }

    for (int i = 0; i < secondd.size(); ++i) {
        has[secondd[i]]--;
    }

    for(auto x:has){
        if(x.second==0){
            answer.push_back(x.first);
        }
    }

    return answer;



    }
};


```



:heart:


99.04 % faster solution . wooooooooohoooooooooooo and u know what,
memory usage is less than 100% of users.


```c++
class Solution {
public:
    vector<int> intersection(vector<int>& one, vector<int>& two) {
      
    vector<int> answer;
    sort(one.begin(),one.end());
    sort(two.begin(),two.end());
    set<int> elements;

    int i=0,j=0;

    while(i<one.size()&&j<two.size()){
        if(one[i]==two[j]){
            elements.insert(one[i]);
            i++;
            j++;
        }
        else if(one[i]<two[j]){
            i++;
        }
        else{
            j++;
        }
    }
    
    for(auto x:elements){
        answer.push_back(x);
    }




    return answer;


 


    }
};

```



*Editorial*


```java
class Solution {
  public int[] set_intersection(HashSet<Integer> set1, HashSet<Integer> set2) {
    int [] output = new int[set1.size()];
    int idx = 0;
    for (Integer s : set1)
      if (set2.contains(s)) output[idx++] = s;

    return Arrays.copyOf(output, idx);
  }

  public int[] intersection(int[] nums1, int[] nums2) {
    HashSet<Integer> set1 = new HashSet<Integer>();
    for (Integer n : nums1) set1.add(n);
    HashSet<Integer> set2 = new HashSet<Integer>();
    for (Integer n : nums2) set2.add(n);

    if (set1.size() < set2.size()) return set_intersection(set1, set2);
    else return set_intersection(set2, set1);
  }
}
```



*editorial b*

```java

class Solution {
  public int[] intersection(int[] nums1, int[] nums2) {
    HashSet<Integer> set1 = new HashSet<Integer>();
    for (Integer n : nums1) set1.add(n);
    HashSet<Integer> set2 = new HashSet<Integer>();
    for (Integer n : nums2) set2.add(n);

    set1.retainAll(set2);

    int [] output = new int[set1.size()];
    int idx = 0;
    for (int s : set1) output[idx++] = s;
    return output;
  }
}


```