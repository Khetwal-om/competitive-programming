

1. Two Sum


**Naive Solution**    
*Time complexity O(n^2)*

```c++
class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        
        for(int i=0;i<nums.size();i++){
            for(int j=1;j<nums.size();j++){
                if(nums[i]+nums[j]==target&& i!=j){
                    return {i,j};
                }
            }
        }
        return {0,0};
    }
};
```



*n(logn)* solution.   :heart:  :mountain:    :earth:


```C++

#include <bits/stdc++.h>
using namespace std;


vector<int> twoSum(vector<int>& nums,int target){

        vector< pair<int,int> > nums2;
        for(int k=0;k<nums.size();k++){
            pair<int,int> temp(nums[k],k);
            nums2.push_back(temp);
        }

        sort(nums2.begin(),nums2.end());

        int i=0,j=nums2.size()-1;
        while(i<j){
            if(nums2[i].first+nums2[j].first==target){
                return {nums2[i].second,nums2[j].second};
            }
            else if(nums2[i].first+nums2[j].first>target){
                j--;
            }
            else{
                ++i;
            }
        }

        return {0,0};
}


int main(){

    vector<int> nums={3,2,4};
    int target=6;
    vector<int> answer;
    answer=twoSum(nums,target);
    for(auto x:answer){cout<<x<<"  ";}

    return 0;
}

``` 


*wohooooooooooooooooooooo*  :snow:    :mountain: 


**The basic idea is to maintain a hash table for each element num in nums, using num as key and its index (0-based) as value. For each num, search for target - num in the hash table. If it is found and is not the same element as num, then we are done. \
The code is as follows. Note that each time before we add num to mp, we search for target - num first and so we will not hit the same element** 



```c++
class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        unordered_map <int,int> values;
        int i=0;
        int j=nums.size();
        for(i=0;i<nums.size();i++) {
            if(values.find(target-nums[i])!=values.end()) {                
                return {values[target-nums[i]],i};
            }
           values[nums[i]]=i;
        }
        
        
        return {};
                     
        }
    
    
};

```

---


**Explore**

```c++
class Solution {
public:
    
    // Our custom sorting function 
    static bool cmp(std::pair<int, int>& p1, std::pair<int, int>& p2)
    {
        // This function is called during sorting
        // Compare numbers in the pair and return the smaller number to sort from least -> greatest
        return p1.first < p2.first; 
    }
    
    vector<int> twoSum(vector<int>& nums, int target) {
        
        // Idea: Sort the array
        // Start from the endpoints, and keep adjusting min/max until found a sum
        // We use a vector of pairs to keep track of the number *and* it's index in the unsorted array
        
        vector<std::pair<int, int>> v;
        
        // 1. Put all numbers into vector of pairs
        for(int i = 0; i < nums.size(); i++)
        {
            // The curly braces {} are used to make a pair
            // Alternatively, you can use C++ "make_pair" function 
            v.push_back({nums[i], i}); // Insert <number, index>
        }
        
        // 2. Sort vector
        sort(v.begin(), v.end()); // cmp is our custom sorting function 
        
        // 3. Search vector
        int min = 0, max = v.size() - 1;
        while(min <= max)
        {
            if( (v[min].first + v[max].first) > target )
            {
                max--; // We overshot, so decrement max
            }
            else if( (v[min].first + v[max].first) < target )
            {
                min++; // Smaller than the target, so increment min 
            }
            else // Found a match!
            {
                // Get indices of numbers
                int idx1 = v[min].second;
                int idx2 = v[max].second;
                return vector<int> {idx1, idx2};
            }
        }
        return vector<int>(); // Return empty vector if no solution (not tested)
        
        /*
        O(N^2) solution 
        for(int i = 0; i < nums.size(); i++)
        {
            for(int j = i+1; j < nums.size(); j++)
            {
                if(nums[i] + nums[j] == target) return vector<int> {i,j};
            }
        }
        */
        
        /*
        // O(N*log(N)) solution 
        unordered_map<int, int> m;
        for(int i = 0; i < nums.size(); i++)
        {
            m.insert({nums[i], i});
        }
        
        for(int i = 0; i < nums.size(); i++)
        {
            int n1 = nums[i];
            int n2 = target - n1;
            if(m.find(n2) != m.end() && i != m[n2]) return vector<int>{i, m[n2]};
        }
        return vector<int>();
        */
        
    }
};
```





---