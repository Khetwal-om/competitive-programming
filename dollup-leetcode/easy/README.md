


1. two-sum


```c++
class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
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
};

```

2. Reverse a linked list


```c++
/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */ 
class Solution {
public:
    ListNode* reverseList(ListNode* head) {
        ListNode *current=head;
        ListNode *previous=NULL;
        ListNode *next=NULL;
        
        while(current!=NULL){
            next=current->next;
            current->next=previous;
            previous=current;
            current=next;
        }
        
        return previous;
    }
};
```






2. 283 move zeroes


1. Using extra space

[:)](https://leetcode.com/problems/move-zeroes/)

```c++
class Solution {
public:
    void moveZeroes(vector<int>& nums) {
        int count=0;
        vector<int> partial;
        for(int i=0;i<nums.size();i++){
            if(nums[i]==0){
                count++;
            }
            else{
                partial.push_back(nums[i]);
            }
        }
        while(count){
            partial.push_back(0);
            count--;
        }
        nums.erase(nums.begin(),nums.end());
        for(auto x:partial){
            nums.push_back(x);
        }
    }
};

```