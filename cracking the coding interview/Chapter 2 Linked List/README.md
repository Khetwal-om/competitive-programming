






1. Duplicate elements must be removed


---


**Approach 1**


---

*I can't make 100% out of this*

**But I am sure that I will :) figure this out**

```java


private class Node{
	private int val;
	private Node next;
}


public void dedup(Node n){
	if(n==null) return ;

	HashSet<Integer> nodes=new HashSet<Integer>();
	Node prev=null;

	while(n!=null){
		if(nodes.contains(n.val)){
			prev.next=n.next;
		}
		else{
			nodes.add(n.val);
			prev=n;
		}
		n=n.next();
	}
}
```






---

**Approach 2**


```java
private class Node{
	private int val;
	private Node next;
}

public void dedup(Node n){
	while(n!=null){
		Node curr=n;
		while(curr->next!=null){
			if(curr.next.val==n.val){
				curr.next=curr.next.next=;
			}
			else{
				curr=curr.next;
			}
		}
		curr=curr.next;
	}
}
```

---





2. Kth element to last node.


**This ain't best way to do , this is what she says :)   coz we have to traverse through the linked list twice.**



> *O(2/*n)*  which turns out to be O(n)

```java


void *kthToLast(node *head,int k){
    node *p;
    int count=0;
    p=head;


    while (p!=NULL){
        count+=1;
        p=p->next;
    }
    int position=count-k;
    cout<<count<<" is the count"<<position<<" is the position"<<endl;
    p=head;
    for(int i=1;i<position&&p!=NULL;i++){
        p=p->next;
    }
    cout<<p->data<<" is what you are looking for???"<<endl;


}


```

---

```c++
#include <bits/stdc++.h>

using namespace std;

typedef struct node{
    int data;
    struct node *next;
}node;

node* insertNode(node *head,int info){
    node *temp=(node *)malloc(sizeof(node));
    if(head==NULL){
        temp->data=info;
        temp->next=NULL;
        head=temp;
        return head;
    }

    node *p;
    p=head;
    while (p->next!=NULL){
        p=p->next;
    }

    temp->data=info;
    temp->next=NULL;
    p->next=temp;
    return head;

}

void displayList(node *head){
    node *p=head;
    while (p!=NULL){
        printf("%d  ",p->data);
        p=p->next;
    }
    printf("\n");
}


node* removeDuplicates(node *head){

}


void *kthToLast(node *head,int k){
    node *p;
    int count=0;
    p=head;


    while (p!=NULL){
        count+=1;
        p=p->next;
    }
    int position=count-k;
    cout<<count<<" is the count"<<position<<" is the position"<<endl;
    p=head;
    for(int i=1;i<position&&p!=NULL;i++){
        p=p->next;
    }
    cout<<p->data<<" is what you are looking for???"<<endl;


}




node *deleteNode(node *head,int value){
    node *p=head;
    node *temp;

    if(head->data==value){
        temp=head;
        head=head->next;
        free(temp);
        return head;
    }

    while (p->next!=NULL){
        if(p->next->data==value){
            break;
        }
        p=p->next;
    }

    // I messed this with p==NULL , so test this too :)

    if(p->next==NULL){
        printf("Element isn't found that you wanna delete\n");
        return head;
    }
    temp=p->next;
    p->next=temp->next;
    free(temp);
    return head;
}



node* countFrequencies(node *head){
    unordered_map<int,int> frequencies;

    node *p=head;
    while (p!=NULL){
        frequencies[p->data]++;
        p=p->next;
    }

    for(auto x:frequencies){
        if(x.second==2){
            head=deleteNode(head,x.first);
        }
//        cout<<x.first<<"  "<<x.second<<endl;
    }
    return head;

}

int main(){
    node*head = NULL;
    int val,k;  // k   is position here
    int choice;
    char c;

    do{
        printf("-1 KthToLast \n0. Call countFrequencies \n1. To insert \n2. Remove duplicate elements from the linked list.\n3. Display the list to me.\n4. Delete any node\n");
        scanf("%d",&choice);

        switch (choice){
            case -1:
                printf("Enter the Kth position :) ");
                scanf("%d",&k);
                kthToLast(head,k);
                break;
            case 0:
                countFrequencies(head);
                break;
            case 1:
                printf("Enter the element to insert\n");
                scanf("%d",&val);
                head=insertNode(head,val);
                break;
            case 2:
                printf("");
                break;
            case 3:
                displayList(head);
                break;
            case 4:
                printf("ENter the element that you wanna delete \n");
                scanf("%d",&val);
                head=deleteNode(head,val);
                break;
            default:
                printf("Wrong choice\n");
                break;
        }
        printf("Do you  wanna continue\n");
        fflush(stdin);
        scanf("%c",&c);

    }
    while (toupper(c)=='Y');

    return 0;
}
```



2. **WIthin one loop**

```c++
void *kthToLastAnotherApproach(node *head,int k){
    node *p,*current;
    p=head;
    current=head;
    int counter=0;
    while (p!=NULL){
        if(counter<=k){
            p=p->next;
        }
        else{
            p=p->next;
            current=current->next;
        }
        counter++;
    }

    cout<<current->data<<" is what you are looking for???"<<endl;


}
```

---


**Solution from byte by byte**


```c++
void *kthToLastAnotherApproach(node *head,int k){
    node *p,*current;
    p=head;
    current=head;

    for(int i=0;i<k&&p!=NULL;i++){
        p=p->next;
    }


    while (p->next!=NULL){
            p=p->next;
            current=current->next;
    }

    cout<<current->data<<" is what you are looking for???"<<endl;


}
```

---



3. Delete middle node (head element isn't provide as such) , It can be any middle element except last


```c++
#include <iostream>

struct Node {
  char data;
  Node * next;
  Node( char c ) : data{ c }, next{ nullptr } { }
};

/**
 * [printList - Helper routine to print the list]
 * @param head [head of the list]
 */
void printList( Node * head ) {
  while( head ) {
    std::cout << head->data << "-->";
    head = head->next;
  }
  std::cout << "nullptr" << std::endl;
}

/**
 * [deleteNode - delete the "node" from the list]
 * @param node [node to be deleted]
 */
void deleteNode( Node * node ) {
  if ( node == nullptr || node->next == nullptr ) {
    return;
  }
  Node * nextNode = node->next;
  node->data = nextNode->data;
  node->next = nextNode->next;
  delete nextNode;
}

int main() {
  Node * head = new Node('a');
  head->next = new Node('b');
  head->next->next = new Node('c');
  head->next->next->next = new Node('d');
  head->next->next->next->next = new Node('e');
  std::cout << "List before deletion:\n";
  printList(head);
  std::cout << "Deleting node containing data as 'c'\n";
  deleteNode(head->next->next);
  std::cout << "List after deletion:\n";
  printList(head);
  return 0;
}
```






---

### Cracking the coding interview whole code


```c++
#include <bits/stdc++.h>

using namespace std;

typedef struct node{
    int data;
    struct node *next;
}node;

node* insertNode(node *head,int info){
    node *temp=(node *)malloc(sizeof(node));
    if(head==NULL){
        temp->data=info;
        temp->next=NULL;
        head=temp;
        return head;
    }
    else{
    node *p;
    p=head;
    while (p->next!=NULL){
        p=p->next;
    }

    temp->data=info;
    temp->next=NULL;
    p->next=temp;
    return head;
    }
}


void displayList(node *head){
    node *p=head;
    while (p!=NULL){
        printf("%d  ",p->data);
        p=p->next;
    }
    printf("\n");
}

node *reverseList(node *head){
    node *current=head;
    node *prev=NULL;
    node *next=NULL;

    while(current!=NULL){
        next=current->next;
        current->next=prev;
        prev=current;
        current=next;
    }
    return prev;
}




bool isPalindromeUsingStack(node *head){
    node *slow=head;
    node *fast=head;
    stack<int> stack1;
    while(fast!=NULL&&fast->next!=NULL){
        stack1.push(slow->data);
        slow=slow->next;
        fast=fast->next->next;
    }

    // just in case if odd no. of elements
    if(fast!=NULL){
        slow=slow->next;
    }
    int element;
    while (slow!=NULL){
        element=stack1.pop();
        if(element!=slow->data){
            return false;
        }
        slow=slow->next;
    }
    return true;

}







bool isPalindrome(node *head){
    node* reversedList=head;
    reversedList=reverseList(reversedList);
    head=reverseList(head);
//    node *currentOriginal=head;
//    node *currentReversed=reversedList;
//    while(currentOriginal!=NULL){
//        if(!currentOriginal->data==currentReversed->data){
//            cout<<"False"<<endl;
//            return false;
//        }
//        currentOriginal=currentOriginal->next;
//        currentReversed=currentReversed->next;
//    }
//    cout<<"It worked?"<<endl;
    cout<<"this output is for the originl head"<<endl;
    node *temp=head;
    while (temp!=NULL){
        cout<<temp->data<<"   ";
        temp=temp->next;
    }
    cout<<" it printed"<<endl;
    cout<<"this output is for the new reversed one "<<endl;
    node *tempo=reversedList;
    while (tempo!=NULL){
        cout<<tempo->data<<"   ";
        tempo=tempo->next;
    }
    cout<<" it printed"<<endl;



    return true;
}



void partitionList(node *head,int value){
    node* beforeStart=NULL;
    node *beforeEnd=NULL;
    node *afterStart=NULL;
    node *afterEnd=NULL;
    node *curr=head;
    while (curr){
        node *temp=curr->next;
        if(curr->data<value){
            if(beforeStart==NULL){
               beforeStart=temp;
               beforeEnd=beforeStart;
            }
            else{
                beforeEnd->next=temp;
                beforeEnd=temp;
            }
        }
        else{
            if(afterStart==NULL){
                afterStart=temp;
                afterEnd=afterStart;
            }
            else{
                afterEnd->next=temp;
                afterEnd=temp;
            }

        }
        curr=curr->next;
    }

//    displayList(smallerElements);
//    displayList(largerElements);
//    cout<<smallerElements->data<<"first element of smallerElements"<<endl;
//    cout<<largerElements->data<<"first element of largerElements"<<endl;

    cout<<endl;


}





node* removeDuplicates(node *head){

}



void deleteMiddle(node *head){
    node *fast=head;
    node *slow=head;


    while(fast->next->next!=NULL){
        slow=slow->next;
        fast=fast->next->next;
    }

    cout<<slow->data<<" is this the one to  be deleted"<<endl;

}



void *kthToLast(node *head,int k){
    node *p;
    int count=0;
    p=head;


    while (p!=NULL){
        count+=1;
        p=p->next;
    }
    int position=count-k;
    cout<<count<<" is the count"<<position<<" is the position"<<endl;
    p=head;
    for(int i=1;i<position&&p!=NULL;i++){
        p=p->next;
    }
    cout<<p->data<<" is what you are looking for???"<<endl;


}





void *kthToLastAnotherApproach(node *head,int k){
    node *p,*current;
    p=head;
    current=head;

    for(int i=0;i<k&&p!=NULL;i++){
        p=p->next;
    }


    while (p->next!=NULL){
            p=p->next;
            current=current->next;
    }

    cout<<current->data<<" is what you are looking for???"<<endl;


}




node *deleteNode(node *head,int value){
    node *p=head;
    node *temp;

    if(head->data==value){
        temp=head;
        head=head->next;
        free(temp);
        return head;
    }

    while (p->next!=NULL){
        if(p->next->data==value){
            break;
        }
        p=p->next;
    }

    // I messed this with p==NULL , so test this too :)

    if(p->next==NULL){
        printf("Element isn't found that you wanna delete\n");
        return head;
    }
    temp=p->next;
    p->next=temp->next;
    free(temp);
    return head;
}



node* countFrequencies(node *head){
    unordered_map<int,int> frequencies;

    node *p=head;
    while (p!=NULL){
        frequencies[p->data]++;
        p=p->next;
    }

    for(auto x:frequencies){
        if(x.second==2){
            head=deleteNode(head,x.first);
        }
//        cout<<x.first<<"  "<<x.second<<endl;
    }
    return head;

}

int main(){
    node*head = NULL;
    int val,k;  // k   is position here
    int choice;
    char c;

    do{
        printf("-1 KthToLast \n0. Call countFrequencies \n1. To insert \n2. Remove duplicate elements from the linked list.\n3. Display the list to me.\n4. Delete any node\n5. Kth to last\n6. Delete mid\n7. Partition\n8. Reverse List\n9. Palindrome\n");
        scanf("%d",&choice);

        switch (choice){
            case 8:
                head=reverseList(head);
                break;
            case 7:
                printf("Enter partition element\n");
                val=scanf("%d",&val);
                partitionList(head,val);
                break;
            case -1:
                printf("Enter the Kth position :) ");
                scanf("%d",&k);
                kthToLast(head,k);
                break;
            case 0:
                countFrequencies(head);
                break;
            case 1:
                printf("Enter the element to insert\n");
                scanf("%d",&val);
                head=insertNode(head,val);
                break;
            case 2:
                printf("");
                break;
            case 3:
                displayList(head);
                break;
            case 4:
                printf("ENter the element that you wanna delete \n");
                scanf("%d",&val);
                head=deleteNode(head,val);
                break;
            case 5:
                printf("ENter the position please.\n");
                scanf("%d",&k);
                kthToLastAnotherApproach(head,k);
                break;
            case 6:
                deleteMiddle(head);
                break;
            case 9:
                cout<<isPalindrome(head);
                head=reverseList(head);
                break;
            default:
                printf("Wrong choice\n");
                break;
        }
        printf("Do you  wanna continue\n");
        fflush(stdin);
        scanf("%c",&c);

    }
    while (toupper(c)=='Y');

    return 0;
}
```


---













#### Fix this too

```c++
#include <bits/stdc++.h>

using namespace std;

int maxi(int a,int b){
    if(a<b)
        return b;
    else
        return a;
}

int main(){
    vector<long> elements;

    int element;
    int t,n;
    cin>>t;
    while(t){
        cin>>n;
        for(int j=0;j<n;j++){
            cin>>element;
            elements.push_back(element);
        }

        int maximum=INT_MIN;
        for(int i=0;i<elements.size()-1;i++){
            for(int j=0;j<elements.size()-i-1;j++){
                if(elements[j]>elements[j+1]){
                    maximum=maxi(maximum,abs(elements[j]-elements[j+1]));
//            int temp=elements[j];
//            elements[j]=elements[j+1];
//            elements[j+1]=temp;
                    swap(elements[j],elements[j+1]);
                }
            }
        }
        cout<<maximum;
        maximum=INT_MIN;
        t--;
        elements.erase(elements.begin(),elements.end());
    }


}
```






# The implementation of ctci data structure in c++

```c++
#include <bits/stdc++.h>

using namespace std;

typedef struct node{
    int data;
    struct node *next;
}node;

node* insertNode(node *head,int info){
    node *temp=(node *)malloc(sizeof(node));
    if(head==NULL){
        temp->data=info;
        temp->next=NULL;
        head=temp;
        return head;
    }
    else{
        node *p;
        p=head;
        while (p->next!=NULL){
            p=p->next;
        }

        temp->data=info;
        temp->next=NULL;
        p->next=temp;
        return head;
    }
}


void displayList(node *head){
    node *p=head;
    while (p!=NULL){
        printf("%d  ",p->data);
        p=p->next;
    }
    printf("\n");
}

node *reverseList(node *head){
    node *current=head;
    node *prev=NULL;
    node *next=NULL;

    while(current!=NULL){
        next=current->next;
        current->next=prev;
        prev=current;
        current=next;
    }
    return prev;
}




bool isPalindromeUsingStack(node *head){
    node *slow=head;
    node *fast=head;
    stack<int> stack1;
    while(fast!=NULL&&fast->next!=NULL){
        stack1.push(slow->data);
        slow=slow->next;
        fast=fast->next->next;
    }

    // just in case if odd no. of elements
    if(fast!=NULL){
        slow=slow->next;
    }
    int element;
    while (slow!=NULL){
        element=stack1.pop();
        if(element!=slow->data){
            return false;
        }
        slow=slow->next;
    }
    return true;

}







bool isPalindrome(node *head){
    node* reversedList=head;
    reversedList=reverseList(reversedList);
    head=reverseList(head);
//    node *currentOriginal=head;
//    node *currentReversed=reversedList;
//    while(currentOriginal!=NULL){
//        if(!currentOriginal->data==currentReversed->data){
//            cout<<"False"<<endl;
//            return false;
//        }
//        currentOriginal=currentOriginal->next;
//        currentReversed=currentReversed->next;
//    }
//    cout<<"It worked?"<<endl;
    cout<<"this output is for the originl head"<<endl;
    node *temp=head;
    while (temp!=NULL){
        cout<<temp->data<<"   ";
        temp=temp->next;
    }
    cout<<" it printed"<<endl;
    cout<<"this output is for the new reversed one "<<endl;
    node *tempo=reversedList;
    while (tempo!=NULL){
        cout<<tempo->data<<"   ";
        tempo=tempo->next;
    }
    cout<<" it printed"<<endl;



    return true;
}



void partitionList(node *head,int value){
    node* beforeStart=NULL;
    node *beforeEnd=NULL;
    node *afterStart=NULL;
    node *afterEnd=NULL;
    node *curr=head;
    while (curr){
        node *temp=curr->next;
        if(curr->data<value){
            if(beforeStart==NULL){
                beforeStart=temp;
                beforeEnd=beforeStart;
            }
            else{
                beforeEnd->next=temp;
                beforeEnd=temp;
            }
        }
        else{
            if(afterStart==NULL){
                afterStart=temp;
                afterEnd=afterStart;
            }
            else{
                afterEnd->next=temp;
                afterEnd=temp;
            }

        }
        curr=curr->next;
    }

//    displayList(smallerElements);
//    displayList(largerElements);
//    cout<<smallerElements->data<<"first element of smallerElements"<<endl;
//    cout<<largerElements->data<<"first element of largerElements"<<endl;

    cout<<endl;


}





node* removeDuplicates(node *head){

}



void deleteMiddle(node *head){
    node *fast=head;
    node *slow=head;


    while(fast->next->next!=NULL){
        slow=slow->next;
        fast=fast->next->next;
    }

    cout<<slow->data<<" is this the one to  be deleted"<<endl;

}



void *kthToLast(node *head,int k){
    node *p;
    int count=0;
    p=head;


    while (p!=NULL){
        count+=1;
        p=p->next;
    }
    int position=count-k;
    cout<<count<<" is the count"<<position<<" is the position"<<endl;
    p=head;
    for(int i=1;i<position&&p!=NULL;i++){
        p=p->next;
    }
    cout<<p->data<<" is what you are looking for???"<<endl;


}





void *kthToLastAnotherApproach(node *head,int k){
    node *p,*current;
    p=head;
    current=head;

    for(int i=0;i<k&&p!=NULL;i++){
        p=p->next;
    }


    while (p->next!=NULL){
        p=p->next;
        current=current->next;
    }

    cout<<current->data<<" is what you are looking for???"<<endl;


}




node *deleteNode(node *head,int value){
    node *p=head;
    node *temp;

    if(head->data==value){
        temp=head;
        head=head->next;
        free(temp);
        return head;
    }

    while (p->next!=NULL){
        if(p->next->data==value){
            break;
        }
        p=p->next;
    }

    // I messed this with p==NULL , so test this too :)

    if(p->next==NULL){
        printf("Element isn't found that you wanna delete\n");
        return head;
    }
    temp=p->next;
    p->next=temp->next;
    free(temp);
    return head;
}



node* countFrequencies(node *head){
    unordered_map<int,int> frequencies;

    node *p=head;
    while (p!=NULL){
        frequencies[p->data]++;
        p=p->next;
    }

    for(auto x:frequencies){
        if(x.second==2){
            head=deleteNode(head,x.first);
        }
//        cout<<x.first<<"  "<<x.second<<endl;
    }
    return head;

}

int main(){
    node*head = NULL;
    int val,k;  // k   is position here
    int choice;
    char c;

    do{
        printf("-1 KthToLast \n0. Call countFrequencies \n1. To insert \n2. Remove duplicate elements from the linked list.\n3. Display the list to me.\n4. Delete any node\n5. Kth to last\n6. Delete mid\n7. Partition\n8. Reverse List\n9. Palindrome\n");
        scanf("%d",&choice);

        switch (choice){
            case 8:
                head=reverseList(head);
                break;
            case 7:
                printf("Enter partition element\n");
                val=scanf("%d",&val);
                partitionList(head,val);
                break;
            case -1:
                printf("Enter the Kth position :) ");
                scanf("%d",&k);
                kthToLast(head,k);
                break;
            case 0:
                countFrequencies(head);
                break;
            case 1:
                printf("Enter the element to insert\n");
                scanf("%d",&val);
                head=insertNode(head,val);
                break;
            case 2:
                printf("");
                break;
            case 3:
                displayList(head);
                break;
            case 4:
                printf("ENter the element that you wanna delete \n");
                scanf("%d",&val);
                head=deleteNode(head,val);
                break;
            case 5:
                printf("ENter the position please.\n");
                scanf("%d",&k);
                kthToLastAnotherApproach(head,k);
                break;
            case 6:
                deleteMiddle(head);
                break;
            case 9:
                cout<<isPalindrome(head);
                head=reverseList(head);
                break;
            default:
                printf("Wrong choice\n");
                break;
        }
        printf("Do you  wanna continue\n");
        fflush(stdin);
        scanf("%c",&c);

    }
    while (toupper(c)=='Y');

    return 0;
}
```







### Reverse from middle


```c++
#include <bits/stdc++.h>

using namespace std;

typedef struct node{
    int data;
    struct node *next;
}node;

node* insertNode(node *head,int info){
    node *temp=(node *)malloc(sizeof(node));
    if(head==NULL){
        temp->data=info;
        temp->next=NULL;
        head=temp;
        return head;
    }
    else{
        node *p;
        p=head;
        while (p->next!=NULL){
            p=p->next;
        }

        temp->data=info;
        temp->next=NULL;
        p->next=temp;
        return head;
    }
}


void displayList(node *head){
    node *p=head;
    while (p!=NULL){
        printf("%d  ",p->data);
        p=p->next;
    }
    printf("\n");
}


void displayListWithAddress(node *head){
    node *p=head;
    while (p!=NULL){
        printf("%d   :  %u",p->data,p);
        p=p->next;
        printf("\n");
    }
    printf("\n");
}


node *reverseList(node *head){
    node *current=head;
    node *prev=NULL;
    node *next=NULL;

    while(current!=NULL){
        next=current->next;
        current->next=prev;
        prev=current;
        current=next;
    }



    return prev;
}






//
//bool isPalindromeUsingStack(node *head){
//    node *slow=head;
//    node *fast=head;
//    stack<int> stack1;
//    while(fast!=NULL&&fast->next!=NULL){
//        stack1.push(slow->data);
//        slow=slow->next;
//        fast=fast->next->next;
//    }
//
//    // just in case if odd no. of elements
//    if(fast!=NULL){
//        slow=slow->next;
//    }
//    int element;
//    while (slow!=NULL){
//        element=stack1.pop();
//        if(element!=slow->data){
//            return false;
//        }
//        slow=slow->next;
//    }
//    return true;
//
//}







bool isPalindrome(node *head){
    node* reversedList=head;
    reversedList=reverseList(reversedList);
    head=reverseList(head);
//    node *currentOriginal=head;
//    node *currentReversed=reversedList;
//    while(currentOriginal!=NULL){
//        if(!currentOriginal->data==currentReversed->data){
//            cout<<"False"<<endl;
//            return false;
//        }
//        currentOriginal=currentOriginal->next;
//        currentReversed=currentReversed->next;
//    }
//    cout<<"It worked?"<<endl;
    cout<<"this output is for the originl head"<<endl;
    node *temp=head;
    while (temp!=NULL){
        cout<<temp->data<<"   ";
        temp=temp->next;
    }
    cout<<" it printed"<<endl;
    cout<<"this output is for the new reversed one "<<endl;
    node *tempo=reversedList;
    while (tempo!=NULL){
        cout<<tempo->data<<"   ";
        tempo=tempo->next;
    }
    cout<<" it printed"<<endl;



    return true;
}



void partitionList(node *head,int value){
    node* beforeStart=NULL;
    node *beforeEnd=NULL;
    node *afterStart=NULL;
    node *afterEnd=NULL;
    node *curr=head;
    while (curr){
        node *temp=curr->next;
        if(curr->data<value){
            if(beforeStart==NULL){
                beforeStart=temp;
                beforeEnd=beforeStart;
            }
            else{
                beforeEnd->next=temp;
                beforeEnd=temp;
            }
        }
        else{
            if(afterStart==NULL){
                afterStart=temp;
                afterEnd=afterStart;
            }
            else{
                afterEnd->next=temp;
                afterEnd=temp;
            }

        }
        curr=curr->next;
    }

//    displayList(smallerElements);
//    displayList(largerElements);
//    cout<<smallerElements->data<<"first element of smallerElements"<<endl;
//    cout<<largerElements->data<<"first element of largerElements"<<endl;

    cout<<endl;


}





node* removeDuplicates(node *head){

}



void deleteMiddle(node *head){
    node *fast=head;
    node *slow=head;


    while(fast->next->next!=NULL){
        slow=slow->next;
        fast=fast->next->next;
    }

    cout<<slow->data<<" is this the one to  be deleted"<<endl;

}



void *kthToLast(node *head,int k){
    node *p;
    int count=0;
    p=head;


    while (p!=NULL){
        count+=1;
        p=p->next;
    }
    int position=count-k;
    cout<<count<<" is the count"<<position<<" is the position"<<endl;
    p=head;
    for(int i=1;i<position&&p!=NULL;i++){
        p=p->next;
    }
    cout<<p->data<<" is what you are looking for???"<<endl;


}





void *kthToLastAnotherApproach(node *head,int k){
    node *p,*current;
    p=head;
    current=head;

    for(int i=0;i<k&&p!=NULL;i++){
        p=p->next;
    }


    while (p->next!=NULL){
        p=p->next;
        current=current->next;
    }

    cout<<current->data<<" is what you are looking for???"<<endl;


}




node *deleteNode(node *head,int value){
    node *p=head;
    node *temp;

    if(head->data==value){
        temp=head;
        head=head->next;
        free(temp);
        return head;
    }

    while (p->next!=NULL){
        if(p->next->data==value){
            break;
        }
        p=p->next;
    }

    // I messed this with p==NULL , so test this too :)

    if(p->next==NULL){
        printf("Element isn't found that you wanna delete\n");
        return head;
    }
    temp=p->next;
    p->next=temp->next;
    free(temp);
    return head;
}


void *reverseFromMid(node *head,int m,int n){

        node *midHead=head;
        node *midTail=head;
        node *nextTail=NULL;
        node *beforeTail=NULL;
        for(int i=1;i<m;i++){
            beforeTail=midHead;
            midHead=midHead->next;
        }
        for(int x=m;x<=n;x++){
            midTail=midTail->next;
            nextTail=midTail->next;
        }

        node *current=midHead;
        node *previous=beforeTail;
        node *next=NULL;
        while(current->next!=nextTail){
            next=current->next;
            current->next=previous;
            previous=current;
            current=next;
        }
        beforeTail=midTail;
        midHead=nextTail;


        printf("\n");
        printf("%u  :   %d\n",midHead,midHead->data);


        printf("\n");
        printf("%u  :   %d\n",midTail,midTail->data);

        printf("This is the beforeTail : %u\n",beforeTail);
        printf("This is the nextTail : %u\n",nextTail);


//        node *simple=head;
//        while(simple!=NULL){
//            cout<<simple->data<<"   ";
//            simple=simple->next;
//        }
//

}

node* countFrequencies(node *head){
    unordered_map<int,int> frequencies;

    node *p=head;
    while (p!=NULL){
        frequencies[p->data]++;
        p=p->next;
    }

    for(auto x:frequencies){
        if(x.second==2){
            head=deleteNode(head,x.first);
        }
//        cout<<x.first<<"  "<<x.second<<endl;
    }
    return head;

}

int main(){
    node*head = NULL;
    int val,k;  // k   is position here
    int choice;
    char c;

    do{
        printf("-1 KthToLast \n0. Call countFrequencies \n1. To insert \n2. Remove duplicate elements from the linked list.\n3. Display the list to me.\n4. Delete any node\n5. Kth to last\n6. Delete mid\n7. Partition\n8. Reverse List\n9. Palindrome\n10. Reverse from halfway down the list");
        scanf("%d",&choice);

        switch (choice){
            case 8:
                head=reverseList(head);
                break;
            case 7:
                printf("Enter partition element\n");
                val=scanf("%d",&val);
                partitionList(head,val);
                break;
            case -1:
                printf("Enter the Kth position :) ");
                scanf("%d",&k);
                kthToLast(head,k);
                break;
            case 0:
                countFrequencies(head);
                break;
            case 10:
                reverseFromMid(head,2,4);
                break;
            case 1:
                printf("Enter the element to insert\n");
                scanf("%d",&val);
                head=insertNode(head,val);
                break;
            case 2:
                printf("");
                break;
            case 3:
                displayList(head);
                break;
            case 4:
                printf("ENter the element that you wanna delete \n");
                scanf("%d",&val);
                head=deleteNode(head,val);
                break;
            case 5:
                printf("ENter the position please.\n");
                scanf("%d",&k);
                kthToLastAnotherApproach(head,k);
                break;
            case 6:
                deleteMiddle(head);
                break;
            case 9:
                cout<<isPalindrome(head);
                head=reverseList(head);
                break;

            case 11:
                displayListWithAddress(head);
                break;
            default:
                printf("Wrong choice\n");
                break;
        }
        printf("Do you  wanna continue\n");
        fflush(stdin);
        scanf("%c",&c);

    }
    while (toupper(c)=='Y');

    return 0;
}
```