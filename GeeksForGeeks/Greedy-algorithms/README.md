
```c++
#include <bits/stdc++.h>

using namespace std;

struct node *Activity{
    int start;
    int finish;
};

int printMaxAction(Activity actions[],int n){

    sort(actions,actions+n);
    int j=0;
    cout<<actions[0].start,actions[0].finish;

    for(int i=1;i<n;i++){
        if(actions[i].start>=actions[j].finish){
            cout<<actions[i].start,actions[i].finish;
            j=i;
        }

    }
}


int main(){

}





```




1. Fractional knapsack


```c++

// C/C++ program to solve fractional Knapsack Problem
#include <bits/stdc++.h>

using namespace std;

// Structure for an item which stores weight and corresponding
// value of Item
struct Item
{
    int value, weight;

    // Constructor
    Item(int value, int weight) : value(value), weight(weight)
    {}
};

// Comparison function to sort Item according to val/weight ratio
bool cmp(struct Item a, struct Item b)
{
    double r1 = (double)a.value / a.weight;
    double r2 = (double)b.value / b.weight;
    return r1 > r2;
}

// Main greedy function to solve problem
double fractionalKnapsack(int W, struct Item arr[], int n)
{
    // sorting Item on basis of ratio
    sort(arr, arr + n, cmp);

    // Uncomment to see new order of Items with their ratio

    for (int i = 0; i < n; i++)
    {
        cout << arr[i].value << " " << arr[i].weight << " : "
            << ((double)arr[i].value / arr[i].weight) << endl;
    }


    int curWeight = 0; // Current weight in knapsack
    double finalvalue = 0.0; // Result (value in Knapsack)

    // Looping through all Items
    for (int i = 0; i < n; i++)
    {
        // If adding Item won't overflow, add it completely
        if (curWeight + arr[i].weight <= W)
        {
            curWeight += arr[i].weight;
            finalvalue += arr[i].value;
        }

            // If we can't add current Item, add fractional part of it
        else
        {
            int remain = W - curWeight;   //20
            finalvalue += arr[i].value * ((double) remain / arr[i].weight);
            break;
        }
    }

    // Returning final value
    return finalvalue;
}

// driver program to test above function
int main()
{
    int W = 50; // Weight of knapsack
    Item arr[] = {{60, 10}, {100, 20}, {120, 30}};

    int n = sizeof(arr) / sizeof(arr[0]);

    cout << "Maximum value we can obtain = "
         << fractionalKnapsack(W, arr, n);
    return 0;
}



```




# 6 Job Scheduling


1. Greedy Approach for job scheduling

```c++




struct Job{
    char id;
    int deadline;
    int profit;
};


bool comparison(Job a,Job b){
    return (a.profit>b.profit);
}



void printJobScheduling(Job arr[],int n){
    sort(arr,arr+n,comparison);

    int result[n];
    bool slot[n];

    for(int i=0;i<n;i++){
        slot[i]=false;
    }

    for(int i=0;i<n;i++){
        for(int j=min(n,arr[i].deadline)-1;j>=0;j--){
            if(slot[j]==false){
                result[j]=i;
                slot[j]=true;
                break;
            }
        }
    }


    for(int i=0;i<n;i++){
        if(slot[i]){
            cout<<arr[result[i]].id<<" ";
        }
    }
}


```



7. Kruskal's algo for minimum spanning tree

  1. Sort all edges in increasing order.
  2. Pick smallest edge , add it in graph if it doesn't  form a cycle with the
  spanning tree formed so far. 
  3. Repeat step 2 until there are (V-1) edges.  


```c++


void KruskalMST(Graph* graph){
    int V=graph->V;
    Edge result[V];

    int e=0;
    int i=0;

    qsort(graph->edge,graph-E,sizeof(graph->edge[0]),myComp);


    subset *subsets=new subset[(V *sizeof(subset))];


    for(int v=0;v<V;++v){
        subsets[v].parent=v;
        subsets[v].rank=0;
    }


    while(e<V-1 && i<graph->E){
        Edge next_edge=graph->edge[i++];
        int x=find(subsets,next_edge.src);
        int y=find(subsets,next_edge.dest);


        if(x!=y){
            result[e++]=next_edge;
            Union(subsets,x,y);
        }
    }

    cout<<"The edges constructed \n";
    
    for(int i=0;i<e;i++){
        cout<<result[i].src<<"--"<<result[i].dest<<"="<<result[i].weight;
    }

}


```



:heart:


---

# Fractional Knapsack 


1. Greedy Approach:
 1. Calculate the ratio  (value/weight) for each item.
 2. Sort
 3. Take the item with highest ratio and add them until we can't add the next item as whole.
 4. Eventually add the next item as much(fraction) as we can.
 
 
 
 










---


#10 Minimum number of coins


```c++

void findMin(int V){
    vector<int> ans;
    for(int i=n-1;i>=0;i--){
      while(V>=denomination[i]){
        V-=denomination[i];
        ans.push_back(denomination[i]);
      }
}
 for(int i=0;i<ans.size();i++){
    cout<<ans[i]<<"  ";
 }

}

```





---

# Huffman coding


```c++


struct MinHeadNode* buildHuffmanTree(char data[],int freq[],int size){
    struct MinHeapNode *left,*right,*top;
    
    // step 1 : create a min heap of capacity equal to size,
    // there nodes equal to size.
    
    struct MinHeap *minHeap=createAndBuildMinHeap(data,freq,size);
    
//    Iterate while size of heap doesn't become 1


    while(!isSizeOne(minHeap)){
//        step 2: Extract the two minimum freq items from min heap
        left=extractMin(minHeap);
        right=extractMin(minHeap);
        
        top=newNode('5',left->freq+right->freq);
        top->left=left;
        top->right=right;
        insertMinHeap(minHeap,top);
    }
    
// step 4:  The remaining node is the root node and the tree is complete.      
    return extractMin(minHeap);
}



```
---



:heart:

# Efficient Huffman Algorithm



---

1. Create two empty queues
2. Create a leaf node for each unique character and Enqueue it
to the first queue in non-decreasing order of frequency .
Initially second queue is empty.
   *Run while queues contain more than one node,Finally,first
   queue will be empty and second queue will contain only
   one node*
   
3. Dequeue two nodes nodes with the minimum frequency by
examining the front of both queues.
4. Create a new internal node with frequency equal to the
sum of the two nodes frequencies,  Enqueue this node to second queue.







```c++
struct QueueNode* buildHuffmanTree(char data[],int freq[],int size){
    struct QueueNode *left,*right,*top;
    struct Queue* firstQueue=createQueue(size);
    struct Queue* secondQueue=createQueue(size);
    
    for(int i=0;i<size;i++){
        enQueue(firstQueue,newNode(data[i],freq[i]));
    } 
    
    
   
   while(!(isEmpty(firstQueue,secondQueue))){
     left=findMin(firstQueue,secondQueue);
     right=findMin(firstQueue,secondQueue);
     
     top=newNode('',left->freq+right->freq);
     top->left=left;
     top->right=right;
     
     enQueue(secondQueue,top);
   
   }
   
   return deQueue(secondQueue);
    
    
}


A function to get minimum item from two queues

struct QueueNode* findMin(struct Queue* firstQueue,struct Queue* secondQueue){
  if(isEmpty(firstQueue))
      return deQueue(secondQueue);
  if(isEmpty(secondQueue))
      return deQueue(sec
}


```


---





---



---

# 13. Maximum equal sum possible in three stacks


---




```c++


```