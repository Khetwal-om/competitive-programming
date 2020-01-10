

1. Greedy...   Maximum number of tasks must be completed within time.


*Problem 1: Too much to do!
Let's say you have to maximise the number of tasks that you complete in a 10-hour duration. You are given an array T = [2, 4, 1, 6] where Ti denotes the time required to complete the ith task.*

*The answer to this question would be 3 as you would choose to do tasks T2, T0 and T1 — which take 1, 2 and 4 hours respectively to complete, for a total of 7 hours. Although we can easily calculate the answer in this small case, let's see what our strategy would be in if there were many more tasks.*

*The greedy strategy for this problem is fairly straightforward. We always want to do the task with minimum duration first.*

```c++
#include<bits/stdc++.h>

using namespace std;


int main(){
        int hours=10;
        int n=4;
        int task[]={2,4,1,6};

        sort(task,task+n);
        int sum=0;
        for(int i=0;i<n;i++){
            if(sum+task[i]>hours)
                break;
            sum+=task[i];
        }

        cout<<sum;

        return 0;


}

```

