


1. **Singly Linked List**

```c
#include<stdio.h>
#include<stdlib.h>

struct node{
 int info;
 struct node *link;
};


struct node *createList(struct node *start);
void displayList(struct node *start);
void countNodes(struct node *start);
void search(struct node *start,int x);
struct node *insertInBeginning(struct node *start,int data);
void insertAtEnd(struct node *start,int data);
void insertAfter(struct node *start,int data,int x);
struct node *insertBefore(struct node *start,int data,int x);
struct node *insertAtPosition(struct node *start,int data,int x);
struct node *deleteNode(struct node *start,int data);
struct node *reverseList(struct node *start);


int main(){

    struct node *start=NULL;
    int choice,data,x,k;


    start=createList(start);

    while(1){
        printf("\n");
        printf("1. Display list \n");
        printf("2. Counter the number of nodes\n");
        printf("3. Search");
        printf("4. Insert in empty list/Insert in beginning of the list\n");
        printf("5. Insert a node at the end of the list\n");
        printf("6. Insert the node after a specified node\n");
        printf("7. Insert the node before a specified node\n");
        printf("8. Insert a node at a given position\n");
        printf("9. Delete a node\n");
        printf("10. Reverse the list\n");
        printf("11. Quit \n\n");

        printf("Enter your choice");
        scanf("%d",&choice);


        if(choice==11)
            break;


        switch(choice){
        case 1:
            displayList(start);
            break;

        case 2:
            countNodes(start);
            break;

        case 3:

            printf("Enter the element to be searched");
            scanf("%d",&data);
            search(start,data);
            break;

        case 4:
                printf("Enter the element to be inserted");
                scanf("%d",&data);
                start=insertInBeginning(start,data);
                break;


        case 5:
                printf("Enter the element to be inserted");
                scanf("%d",&data);
                insertAtEnd(start,data);
                break;

        case 6:
            printf("Enter the element to be inserted");
            scanf("%d",&data);
            printf("Enter the element after which to insert");
            scanf("%d",&x);
            insertAfter(start,data,x);
            break;

        case 7:
            printf("Enter the element to be inserted");
            scanf("%d",&data);
            printf("Enter the element before at which to insert ");
            scanf("%d",&x);
            start=insertBefore(start,data,x);
            break;
        case 8:
            printf("Enter the element to be inserted");
            scanf("%d",&data);
            printf("Enter the position at which to insert");
            scanf("%d",&k);
            start=insertAtPosition(start,data,k);
            break;

        case 9:
            printf("Enter the element to be deleted");
            scanf("%d",&data);
            start=deleteNode(start,data);
            break;

        case 10:
            start=reverseList(start);
            break;
        default:
            printf("Something is wrong with your choice\n\n\n");

        }
    }
}


void displayList(struct node *start){
    struct node *p;

    if(start==NULL){
        printf("Your list is empty\n");
        return ;
    }

    printf("Elements in the list are");
    p=start;
    while(p!=NULL){
        printf("%d",p->info);
        p=p->link;
    }


    printf("\n");


}





void countNodes(struct node *start){
    struct node *p;
    if(start==NULL){
        printf("Currently there are no nodes available \n");
        return;
    }

    p=start;

    int count=0;

    while(p!=NULL){
        count++;
        p=p->link;
    }
    printf("The number of elements are  %d \n",count);



}







struct node *insertInBeginning(struct node *start,int data){
    struct node *temp;
    temp=(struct node *) malloc(sizeof(struct node));

    temp->info=data;
    temp->link=start;

    start=temp;

    return start;


};




void insertAtEnd(struct node *start,int data){
    struct node *temp;
    struct node *p;


    temp=(struct node *)malloc(sizeof(struct node));
    temp->info=data;


    p=start;

    while(p->link!=NULL){

        p=p->link;
    }
    p->link=temp;
    temp->link=NULL;

}








void search(struct node *start,int x){

    struct node *p=start;
    int flag=0;
    int count=1;

    while(p!=NULL){
        if(p->info==x){

            flag=1;
            break;
        }
        count++;
        p=p->link;

    }

    if(p==NULL){
        printf("The element is not found .\n");
    }
    else{
        printf("The element is found at %d\n",count);
    }


}






struct node *createList(struct node *start){
    int i,n,data;

    printf("Enter the number of nodes");
    scanf("%d",&n);

    if(n==0){
        return start;
    }



    printf("Enter the first element to be inserted");
    scanf("%d",&data);

    start=insertInBeginning(start,data);


    for(i=2;i<=n;i++){
        printf("Enter the next element to be inserted");
        scanf("%d",&data);
        insertAtEnd(start,data);
    }

    return start;
};










void insertAfter(struct node *start,int data,int x){

    struct node *temp=(struct node *)malloc(sizeof(struct node));

    struct node *p=start;

    while(p!=NULL){
        if(p->info==x){
            break;
        }
        p=p->link;
    }

    if(p->link==NULL){
        printf("This is element ain't there.");
    }
    else{

        temp->info=data;
        temp->link=p->link;
        p->link=temp;
    }



}
struct node *insertBefore(struct node *start,int data,int x){
    struct node *temp=(struct node *)malloc(sizeof(struct node));
    struct node *p;

    p=start;


    if(start==NULL){
        printf("List is empty\n");
        return start;
    }

    // x is in first node, new node at first node

    if(x==start->info){
        temp->info=data;
        temp->link=start;
        start=temp;
        return start;
    }


    while(p->link!=NULL){
        if(p->link->info==x){
            break;
        }
        p=p->link;
    }

    if(p->link==NULL){
        printf("This ain't present");
    }
    else{
    temp->info=data;
    temp->link=p->link;
    p->link=temp;
    }

    return start;

}
struct node *insertAtPosition(struct node *start,int data,int x){

    struct node *temp=(struct node *)malloc(sizeof(struct node));
    struct node *p=start;

    if(x==1){
        temp->info=data;
        temp->link=start;
        start=temp;
        return temp;
    }

    for(int i=1;i<x-1&&p!=NULL;i++){
        p=p->link;
    }

    if(p==NULL){
        printf("This ain't valid position");
    }
    else{
     temp->info=data;
     temp->link=p->link;
     p->link=temp;
     }

     return start;
}
struct node *deleteNode(struct node *start,int data){
    struct node *p=start;
    struct node *temp;

    if(start==NULL){
        printf("There are no elements to delete");
        return start;
    }
    //  first one
    if(start->info==data){
        temp=start;
        start=start->link;
        free(temp);
        return start;
    }

    // Deletion in between or at the end


    while(p->link!=NULL){
        if(p->link->info==data){
            break;
        }
        p=p->link;
    }

    if(p->link==NULL){
        printf("This element is not present");
    }
    else{
        temp=p->link;
        p->link=temp->link;
        free(temp);

    }
     return start;


}
struct node *reverseList(struct node *start){
    struct node *ptr,*prev,*next;

    ptr=start;
    prev=NULL;

    while(ptr!=NULL){
        next=ptr->link;
        ptr->link=prev;
        prev=ptr;
        ptr=next;
    }

    start=prev;
    return start;
}



```



2. *Doubly linked list*

```c
#include<stdio.h>
#include<stdlib.h>


struct node {
    struct node *prev;
    int info;
    struct node *next;
};



struct node *createList(struct node *start);
void displayList(struct node *start);
struct node *insertInEmptyList(struct node *start,int data);
struct node *insertInBeginning(struct node *start,int data);
void insertAtEnd(struct node *start,int data);
void insertAfter(struct node *start,int data,int x);
struct node *insertBefore(struct node *start,int data,int x);
struct node *deleteNode(struct node *start,int data);
struct node *reverseList(struct node *start);




int main(){

    struct node *start=NULL;
    int choice,data,x,k;


    start=createList(start);

    while(1){
        printf("\n");
        printf("1. Display list \n");
        printf("2. Insert in empty list\n");
        printf("3. Insert in beginning of the list\n");
        printf("4. Insert a node at the end of the list\n");
        printf("5. Insert the node after a specified node\n");
        printf("6. Insert the node before a specified node\n");
        printf("7. Delete a node\n");
        printf("8. Reverse the list\n");
        printf("9. Quit \n\n");

        printf("Enter your choice");
        scanf("%d",&choice);


        if(choice==9)
            break;


        switch(choice){
        case 1:
            displayList(start);
            break;
        case 2:
            printf("Enter the element to be inserted in empty list");
            scanf("%d",&data);
            start=insertInEmptyList(start,data);
            break;
        case 3:
            printf("Enter the element to be inserted");
            scanf("%d",&data);
            start=insertInBeginning(start,data);
            break;

        case 4:
                printf("Enter the element to be inserted");
                scanf("%d",&data);
                insertAtEnd(start,data);
                break;

        case 5:
            printf("Enter the element to be inserted");
            scanf("%d",&data);
            printf("Enter the element after which to insert");
            scanf("%d",&x);
            insertAfter(start,data,x);
            break;

        case 6:
            printf("Enter the element to be inserted");
            scanf("%d",&data);
            printf("Enter the element before at which to insert ");
            scanf("%d",&x);
            start=insertBefore(start,data,x);
            break;
        case 7:
            printf("Enter the element to be deleted");
            scanf("%d",&data);
            start=deleteNode(start,data);
            break;

        case 8:
            start=reverseList(start);
            break;

        default:
            printf("Something is wrong with your choice\n\n\n");

        }
    }
}


void displayList(struct node *start){
    struct node *p;

    if(start==NULL){
        printf("The list is empty");
        return;
    }
    p=start;
    while(p!=NULL){
        printf("%d ",p->info);
        p=p->next;
    }
    printf("\n");
}






struct node *insertInEmptyList(struct node *start,int data){
    struct node *temp;
    temp=(struct node *)malloc(sizeof(struct node));


    if(start==NULL){
        temp->next=NULL;
        temp->prev=NULL;
        temp->info=data;
        start=temp;
        return start;
    }
};



struct node *insertInBeginning(struct node *start,int data){
    struct node *temp;
    temp=(struct node *)malloc(sizeof(struct node));

    temp->info=data;
    temp->prev=NULL;
    temp->next=start;
    start->prev=temp;
    start=temp;

    return start;
};




void insertAtEnd(struct node *start,int data){
     struct node *temp,*p;
     temp=(struct node *)malloc(sizeof(struct node));

     p=start;
     while(p->next!=NULL){
        p=p->next;
     }

     temp->info=data;
     temp->next=NULL;
     temp->prev=p;
     p->next=temp;

}


struct node *createList(struct node *start){

    int i,n,data;

    printf("Enter the number of nodes:");
    scanf("%d",&n);

    if(n==0){
        return start;
    }

    printf("Enter the first element");
    scanf("%d",&data);
    start=insertInEmptyList(start,data);


    for(i=2;i<=n;i++){
        printf("Enter next elements");
        scanf("%d",&data);
        insertAtEnd(start,data);
    }

    return start;


};










void insertAfter(struct node *start,int data,int x){


}



struct node *insertBefore(struct node *start,int data,int x){

}


struct node *deleteNode(struct node *start,int data){

    struct node *temp;

    if(start==NULL){
        printf("List is empty\n");
        return start;
    }

    if(start->next==NULL){
        if(start->info==data){
            temp=start;
            start=NULL;
            free(temp);
        }
        else{
            printf("Element ain't present");
        }
        return start;
    }

    if(start->info==data){
        temp=start;
        start=start->next;
        start->prev=NULL;
        free(temp);
        return start;
    }


    temp=start->next;
    while(temp->next!=NULL){
        if(temp->info==data){
            break;
        }
        temp=temp->next;
    }

    if(temp->next!=NULL){
        temp->prev->next=temp->next;
        temp->next->prev=temp->prev;
        free(temp);
    }
    else{
        if(temp->info==data){
            temp->prev->next=NULL;
            free(temp);
        }
        else{
            printf("Element is not present");
        }
    }

    return start;

}
struct node *reverseList(struct node *start){
    struct node *p1,p2;

    if(start==NULL){
        return;
    }


    p1=start;
    p2=p1->next;

}






```


---

### Insert a node before a specified node. I did this on my own.

:heart:

:+1:

:yellow_heart:

```c

struct node *insertBefore(struct node *start,int data,int x){

    struct node *temp=(struct node *)malloc(sizeof(struct node));

    struct node *p;

    if(start->info==x){
        temp->info=data;
        temp->prev=NULL;
        temp->next=start;
        start->prev=temp;
        start=temp;
        return start;
    }

    p=start;

    while(p->next!=NULL){
        if(p->next->info==x){
            break;
        }
        p=p->next;
    }

    if(p->next==NULL){
        printf("The element ain't found \n");

    }
    else
     {
      temp->info=data;
      temp->prev=p;
      temp->next=p->next;
      p->next->prev=temp;
      p->next=temp;

     }

    return start;

}


```



---




---

### Insert after a specified node


```c



void insertAfter(struct node *start,int data,int x){

    struct node *temp=(struct node *)malloc(sizeof(struct node));

    struct node *p=start;

    while(p!=NULL){
        if(p->info==x){
            break;
        }
        p=p->next;
    }


    if(p==NULL){
        printf("Common  \n");
    }

    else{

        if(p->next==NULL){

        temp->info=data;
        temp->next=NULL;
        temp->prev=p;
        p->next=temp;
        }
        else{

        temp->info=data;
        temp->next=p->next;
        temp->prev=p;
        p->next->prev=temp;
        p->next=temp;

        }
    }




}

```




---




3. *Circular linked list*

```c

#include<stdio.h>
#include<stdlib.h>

struct node {
    int info;
    struct node *link;
};


struct node *createList(struct node *last);
void displayList(struct node *last);
struct node *insertInEmptyList(struct node *last,int data);
struct node *insertInBeginning(struct node *last,int data);
struct node *insertAfter(struct node *last,int data,int x);
struct node *insertAtEnd(struct node *last,int data);
struct node *deleteNode(struct node *last,int x);

int main(){

    int choice,data,x;
    struct node *last=NULL;

    last=createList(last);

    while(1){

    printf("1. Display list\n");
    printf("2. Insert in empty list\n");
    printf("3. Insert in the beginning\n");
    printf("4. Insert at the end\n");
    printf("5. Insert after a node\n");
    printf("6. Delete a node\n");
    printf("7. Quit\n");


    printf("Enter your choice\n");



    scanf("%d",&choice);

    if(choice==7){
        break;
    }

    switch(choice){
    case 1:
        displayList(last);
        break;

    case 2:
        printf("Enter the element to be inserted\n");
        scanf("%d",&data);
        last=insertInEmptyList(last,data);
        break;


    case 3:
        printf("Enter the element to be inserted\n");
        scanf("%d",&data);
        last=insertInBeginning(last,data);
        break;


    case 4:
        printf("Enter the element to be inserted \n");
        scanf("%d",&data);
        last=insertAtEnd(last,data);
        break;

    case 5:
        printf("Enter the element to be inserted\n");
        scanf("%d",&data);
        printf("Enter the element after which this element should be inserted \n");
        scanf("%d",&x);
        last=insertAfter(last,data,x);
        break;




    case 6:
        printf("Enter the element to be deleted\n");
        scanf("%d",&data);
        last=deleteNode(last,data);
        break;

    default:
        printf("Something is wrong with the input choice\n");
        break;

    }


    }


}
















struct node *insertInEmptyList(struct node *last,int data){

    struct node *temp;
    temp=(struct node *)malloc(sizeof(struct node));


    temp->info=data;
    last=temp;
    last->link=last;

    return last;



};




struct node *insertInBeginning(struct node *last,int data)
{
   struct node *temp;
   temp=(struct node *)malloc(sizeof(struct node ));


   temp->info=data;

   temp->link=last->link;
   last->link=temp;

};




struct node *insertAtEnd(struct node *last,int data){
    struct node *temp;
    temp=(struct node *)malloc(sizeof(struct node));
    temp->info=data;
    temp->link=last->link;
    last->link=temp;
    last=temp;
};






struct node *createList(struct node *last){
    int i,n,data;
    printf("Enter the  number of nodes :   ");
    scanf("%d",&n);
    last=NULL;
    if(n==0){
        return last;
    }

    printf("Enter the element to be inserted :  ");
    scanf("%d",&data);
    last=insertInEmptyList(last,data);


    for(int i=2;i<=n;i++){
        printf("Enter the element to be inserted : ");
        scanf("%d",&data);
        last=insertAtEnd(last,data);
    }


    return last;
};



struct node *insertAfter(struct node *last,int data,int x){

    struct node *temp,*p;
    p=last->link;

    do{
        if(p->info==x){
            break;
        }
        p=p->link;
    }
    while(p!=last->link);


    if(p==last->link && p->info!=x){
        printf("This element is not present");
    }
    else{
        temp=(struct node *)malloc(sizeof(struct node));
        temp->info=data;


        temp->link=p->link;
        p->link=temp;
        if(p==last){
            last=temp;
        }
    }


    return last;

};


void displayList(struct node *last){
    struct node *p;


    if(last==NULL){
        printf("No elements to display \n");
        return ;
    }
    p=last->link;

    do{
        printf(" %d",p->info);
        p=p->link;
    }while(p!=last->link);


    printf("\n");
}




struct node *deleteNode(struct node* last,int x){
    struct node *temp,*p;


    if(last==NULL){
        printf("No element available to  delete\n");
        return last;
    }


    if(last->link==last && last->info==x){
        temp=last;
        last=NULL;
        free(temp);
        return last;
    }



    if(last->link->info==x){
        temp=last->link;
        last->link=temp->link;
        free(temp);
        return last;
    }



    p=last->link;

    while(p->link!=last){
        if(p->link->info==x){
            break;
        }
        p=p->link;
    }


    if(p->link!=last){
        temp=p->link;
        p->link=temp->link;
        free(temp);
    }



    else{
        if(last->info==x){
            temp=last;
            p->link=last->link;
            last=p;
            free(temp);
        }
        else{
            printf("Element ain't present \n");
        }
    }
    return last;


};







```


4. *Singular linked list with cycle*

```c




struct node *removeCycle(struct node *start,struct node *pC){

    struct node *p,*q;
    int i,lengthList,lengthCycle,lengthRemaining;

    p=q=pC;

    printf("Node at which cycle was detected  "+pc->info);

    lengthCycle=0;
    lengthRemaining=0;

    do(){
        lengthCycle++;
        q=q->link;
    }
    while(p!=q);

    printf("Length of the cycle is  "+lengthCycle);

    p=start;

    while(p!=q){
        lengthRemaining+=1;
        p=p->link;
        q=q->link;
    }

    printf("Length of remaining list is "+lengthRemaining);

    lengthList=lengthCycle+lengthRemaining;

    printf("Length of the whole         list "+lengthList);


    p=start;

    for(int i=1;i<=lengthList-1;i++){
        p=p->link;

    }
    p->link=NULL;



};



void insertCycle(struct node *start,int x){

    struct node *p,*px=NULL,*prev,*ptr;

    p=start;

    while(p!NULL){
        if(p->info==x){
            px=p;
        }

        prev=p;
        p=p->link;
    }


    if(px!=NULL){
        prev-link->px;
    }


}




struct node *findCycle(struct node *start){

    struct node *slowP,*fastP;

    if(start->link==NULL){
        return NULL;
    }

    slowP=fastP=start;

    while(fastP!=NULL && fastP->link!=NULL){
        slowP=slowP->link;
        fastP=fastP->link->link;

        if(slowP==fastP){
            return slowP;
        }
    }

    return NULL;


};

```

---



#  Stack



---



1.  Implementation of stack using array


```c

#include<stdio.h>
#include<stdlib.h>
#define MAX 50


int a[MAX];
int top;



void initializeStack();
int isEmpty();
int isFull();
int size();
int peek();
void push(int x);
int pop();
void display();



int main(){

    int choice,x;
    initializeStack();
    while(1){
        printf("1. Push an element on the stack\n");
        printf("2. Pop an element from the stack\n");
        printf("3. Display the top element\n");
        printf("4. Display all stack elements\n");
        printf("5. Display size of the stack\n");
        printf("6. Quit \n");
        printf("Enter your choice\n");
        scanf("%d",&choice);


        if(choice==6){
            break;
        }

        switch(choice){

    case 1:
        printf("Enter the element to be inserted \n");
        scanf("%d",&x);
        push(x);
        break;

    case 2:
        x=pop();
        printf("Popped element is %d\n",x);
        break;


    case 3:
        printf("Element at the top is %d \n",peek());
        break;

    case 4:
        display();
        break;

    case 5:
        printf("Size of the stack  is %d",size());
        break;


    default:
        printf("Something is wrong with the choice\n");






        }

    }




}






int isEmpty(){
    if(top==-1){
        return 1;
    }
    else
        return 0;
}



int size(){

    return top+1;

}


void initializeStack(){
    top=-1;
}




void push(int x){

    if(isFull()){
        printf("The stack is full no more elements can be inserted \n");
        return ;
    }

    top+=1;
    a[top]=x;
}


int pop(){
    int x;
    if(isEmpty()){
        printf("No more elements to pop, the stack is already empty");
        exit(1);
    }

    x=a[top];
    top-=1;
    return x;
}



int isFull(){

    if(top==MAX-1){
        return 1;
    }
    else{
        return 0;

    }

}




int peek(){

   if(isEmpty()){

        printf("No elements present\n");
        exit(1);
   }

   return a[top];

}







void display(){


    int i;

    printf("Topmost element %d",top);



    if(isEmpty()){
        printf("Nothing here\n");
        return;
    }

    printf("Elements in stack are \n");

    for(i=top;i>=0;i--){

        printf("%d \n",a[i]);


    }

    printf("\n");







}

```



2. *LinkedListIMplementation of stack*

```c


 #include<stdio.h>
 #include<stdlib.h>


 struct node {
    int info;
    struct node *link;
 };


struct node *top;

void initializeStack();
int isEmpty();
int isFull();
int size();
int peek();
void push(int x);
int pop();
void display();


int main(){

    int choice,x;
    initializeStack();
    while(1){
        printf("1. Push an element on the stack\n");
        printf("2. Pop an element from the stack\n");
        printf("3. Display the top element\n");
        printf("4. Display all stack elements\n");
        printf("5. Display size of the stack\n");
        printf("6. Quit \n");
        printf("Enter your choice\n");
        scanf("%d",&choice);


        if(choice==6){
            break;
        }

        switch(choice){

    case 1:
        printf("Enter the element to be inserted \n");
        scanf("%d",&x);
        push(x);
        break;

    case 2:
        x=pop();
        printf("Popped element is %d\n",x);
        break;


    case 3:
        printf("Element at the top is %d \n",peek());
        break;

    case 4:
        display();
        break;

    case 5:
        printf("Size of the stack  is %d",size());
        break;


    default:
        printf("Something is wrong with the choice\n");

    }

  }
}


void initializeStack(){
    top=NULL;

}


void push(int x){

    struct node *temp;
    temp=(struct node *)malloc(sizeof(struct node));



    if(temp==NULL){
        printf("No memory : stack overflow\n");
        return ;
    }


        temp->info=x;
        temp->link=top;
        top=temp;




}

int pop(){

    struct node *temp;
    int x;

    if(isEmpty()){
        printf("Stack underflow\n");
        exit(1);
    }



    temp=top;
    x=temp->info;
    top=top->link;
    free(temp);
    return x;





}

int size(){
    int elements=0;
    struct node *p=top;

    if(p==NULL){
        printf("No elements present \n");
        return 0;
    }

    while(p!=NULL){
        elements+=1;
        p=p->link;
    }

    return elements;


}




int peek(){

    if(isEmpty()){
        printf("Under flow ");
        exit(1);
    }

    return top->info;


}





int isEmpty(){
    if(top==NULL){
        return 1;
    }
    else{
        return 0;
    }
}





void display(){
    struct node *p;
    p=top;


    if(p==NULL){
        printf("Nothing to display\n");
        return ;
    }

    while(p!=NULL){
        printf("%d",p->info);
        p=p->link;
    }
}

```


3. *Queue implementation*

```c

#include<stdio.h>
#include<stdlib.h>
#define MAX 50


int que[MAX];
int front;
int rear;




void initializeQueue();
int isEmpty();
int isFull();
int size();
int peek();
void insert(int x);
int Delete();
void display();



int main(){

    int choice,x;
    initializeQueue();
    while(1){
        printf("1. Push an element on the queue\n");
        printf("2. Pop an element from the queue\n");
        printf("3. Display the top element\n");
        printf("4. Display all queue elements\n");
        printf("5. Display size of the queue\n");
        printf("6. Quit \n");
        printf("Enter your choice\n");
        scanf("%d",&choice);


        if(choice==6){
            break;
        }

        switch(choice){

    case 1:
        printf("Enter the element to be inserted \n");
        scanf("%d",&x);
        insert(x);
        break;

    case 2:
        x=Delete();
        printf("Popped element is %d\n",x);
        break;


    case 3:
        printf("Element at the top is %d \n",peek());
        break;

    case 4:
        display();
        break;

    case 5:
        printf("Size of the stack  is %d",size());
        break;


    default:
        printf("Something is wrong with the choice\n");
        }

    }




}






int isEmpty(){
   if ((front-rear==1)|| (front==-1 && rear==-1)){
    return 1;
   }
   else{
    return 0;
   }
}



int size(){
    if(isEmpty()){
        return 0;
    }
    else
    {
        return rear-front+1;
    }

}


void initializeQueue(){
    rear=-1;
    front=-1;
}




void insert(int x){

    if(isFull()){
        printf("No more elements can be inserted\n");
        return ;

    }
    if(front==-1){
        front=0;
    }
    rear+=1;
    que[rear]=x;

}


int Delete(){
    if(isEmpty()){
        printf("Now more elements can be deleted\n");
        exit(1);
    }


    front+=1;


    return que[front-1];

}



int isFull(){
     if(MAX-1==rear){
        return 1;
     }
     else{
        return 0;
     }
}




int peek(){
    if(isEmpty()){
        printf("No elements \n");
        exit(1);
    }
    else{
        return que[front];
    }
}







void display(){

    if(isEmpty()){
        printf("No  elements to display\n");
        return ;
    }

    for(int i=front;i<=rear;i++){
        printf("%d ",que[i]);
    }

    printf("\n");

}


```


4. *Implementation of queue using linked list*

```c


#include<stdio.h>
#include<stdlib.h>


struct node {
    int info;
    struct node *link;
 };


struct node *rear;
struct node *front;

void initializeQueue();
int isEmpty();
int isFull();
int size();
int peek();
void push(int x);
int pop();
void display();


int main(){

    int choice,x;
    initializeQueue();
    while(1){
        printf("1. Push an element on the Queue\n");
        printf("2. Pop an element from the Queue\n");
        printf("3. Display the top element\n");
        printf("4. Display all queue elements\n");
        printf("5. Display size of the queue\n");
        printf("6. Quit \n");
        printf("Enter your choice\n");
        scanf("%d",&choice);

        if(choice==6){
            break;
        }

        switch(choice){

    case 1:
        printf("Enter the element to be inserted \n");
        scanf("%d",&x);
        insert(x);
        break;

    case 2:
        x=Delete();
        printf("Popped element is %d\n",x);
        break;


    case 3:
        printf("Element at the top is %d \n",peek());
        break;

    case 4:
        display();
        break;

    case 5:
        printf("Size of the stack  is %d",size());
        break;


    default:
        printf("Something is wrong with the choice\n");

    }

  }
}


void initializeQueue(){
    rear=NULL;
    front=NULL;
}



void insert(int x){

    struct node *temp;
    temp=(struct node *)malloc(sizeof(struct node ));

    //

    if(front==NULL){

        temp->info=x;
        front=temp;
        rear=temp;
        temp->link=NULL;
    }


    temp->info=x;
    rear->link=temp;
    rear=temp;
    temp->link=NULL;


}

int Delete(){

    struct node *temp;
    int x;

    if(isEmpty()){
        printf("No elements in Queue");
        exit(1);
    }

    temp=front;
    x=temp->info;
    front=front->link;
    free(temp);
    return x;
}

int size(){

    if(front==NULL){
       return 0;
    }

    int elements;
    struct node *p=front;
    while(p!=NULL){
        elements+=1;
        p=p->link;
    }
    return elements;

}




int peek(){

    if(isEmpty()){
        printf("No elements to peek\n");
        exit(1);
    }
    return front->info;

}





int isEmpty(){
    if(front==NULL){
        return 1;
    }
    else{
        return 0;
    }

}





void display(){

    struct node *p=front;
    if(isEmpty()){
        printf("No elements to display\n");
        return;
    }
    while(p!=NULL){
        printf("%d ",p->info);
        p=p->link;
    }

    printf("\n");

}

```





5. *Implementation of queue using circular  linked list*


```c


#include<stdio.h>
#include<stdlib.h>


struct node {
    int info;
    struct node *link;
 };


struct node *rear;


void initializeQueue();
int isEmpty();
int isFull();
int size();
int peek();
void insert(int x);
int Delete();
void display();


int main(){

    int choice,x;
    initializeQueue();
    while(1){
        printf("1. insert an element on the Queue\n");
        printf("2. delete an element from the Queue\n");
        printf("3. Display the top element\n");
        printf("4. Display all queue elements\n");
        printf("5. Display size of the queue\n");
        printf("6. Quit \n");
        printf("Enter your choice\n");
        scanf("%d",&choice);

        if(choice==6){
            break;
        }

        switch(choice){

    case 1:
        printf("Enter the element to be inserted \n");
        scanf("%d",&x);
        insert(x);
        break;

    case 2:
        x=Delete();
        printf("Popped element is %d\n",x);
        break;


    case 3:
        printf("Element at the top is %d \n",peek());
        break;

    case 4:
        display();
        break;

    case 5:
        printf("Size of the stack  is %d",size());
        break;


    default:
        printf("Something is wrong with the choice\n");

    }

  }
}


void initializeQueue(){
    rear=NULL;

}



void insert(int x){

    struct node *temp;
    temp=(struct node *)malloc(sizeof(struct node ));

    //

    if(isEmpty()){
        temp->info=x;
        rear=temp;
        rear->link=rear;

    }


    temp->link=rear->link;
    rear->link=temp;
    rear=temp;


}

int Delete(){

    struct node *temp;
    int x;

    if(isEmpty()){
        printf("No elements in Queue");
        exit(1);
    }

    if(rear->link==rear){
        temp=rear;
        rear=NULL;
    }


    free(temp);
    return x;
}

int size(){

    if(front==NULL){
       return 0;
    }

    int elements;
    struct node *p=front;
    while(p!=NULL){
        elements+=1;
        p=p->link;
    }
    return elements;

}




int peek(){

    if(isEmpty()){
        printf("No elements to peek\n");
        exit(1);
    }
    return front->info;

}





int isEmpty(){
    if(rear==NULL){
        return 1;
    }
    else{
        return 0;
    }

}





void display(){

    struct node *p=front;
    if(isEmpty()){
        printf("No elements to display\n");
        return;
    }
    while(p!=NULL){
        printf("%d ",p->info);
        p=p->link;
    }

    printf("\n");

}

```



---

# Priority Queue using linked list


```c


#include<stdio.h>
#include <stdlib.h>



struct node {
    int priority;
    int info;
    struct node *liik;
};



struct node *front;


void initializeQueue();
void insert(int element,int elementPriority);

int Delete();
void display();
int isEmpty();


int main(){
    int choice,element,elementPriority;


    initializeQueue();

    while(1){
        printf("1. Insert a new element\n");
        printf("2. Delete an element\n");
        printf("3. Display the queue\n");
        printf("4. Bye\n");
        printf("Take your pick\n");
        scanf("%d",&choice);

        if(choice==4)
            break;

        switch(choice){
            case 1:
                printf("Enter the element to be inserted\n");
                scanf("%d",&element);
                printf("Enter its priority \n");
                scanf("%d",&elementPriority);
                insert(element,elementPriority);
                break;

            case 2:
                printf("Deleted element is %d\n",Delete());
                break;

            case 3:
                display();
                break;

            default:
                printf("Wrong choice\n");


        }

    }
}



void initializeQueue(){

}


void insert(int element,int elementPriority){

}

int Delete(){

}


void display(){

}



int isEmpty(){

}



```




**Implementation**







---




---


# Binary Tree

---



1. Implementation of binary tree

```c
#include<stdio.h>
#include<stdlib.h>

struct node{
   struct node *lchild;
   char info;
   struct node *rchild;
};

struct node *getnode(char x);
void display(struct node *p,int level);
void preorder(struct node *p);
void postorder(struct node *p);
void inorder(struct node *p);
void levelOrder(struct node *root);
int height(struct node *p);


#define MAX 100
struct node *queue[MAX];
int front=-1,rear=-1;
void insertQueue(struct node *item);
struct node *deleteQueue();
int queueEmpty();


int main(){

    struct node *root=NULL;
    root=getnode('P');
    root->lchild=getnode('Q');
    root->rchild=getnode('R');
    root->lchild->lchild=getnode('A');
    root->lchild->rchild=getnode('B');
    root->rchild->lchild=getnode('X');


    display(root,0);
    printf("\n \n");

    printf("Preorder :  ");
    preorder(root);

    printf("Inorder  :  ");
    inorder(root);

    printf("Postorder : ");
    postorder(root);

    printf("Height of binary treeeee is %d\n",height(root));


}



struct node *getnode(char x){
    struct node *p;
    p=(struct node *)malloc(sizeof(struct node));
    p->info=x;
    p->lchild=NULL;
    p->rchild=NULL;
};


void display(struct node *p,int level){
    int i;
    if(p==NULL){
        return ;
    }

    display(p->rchild,level+1);
    printf("\n");

    for(i=0;i<level;i++){
        printf("  ");
    }
    printf("%c",p->info);

    display(p->lchild,level+1);

}

void preorder(struct node *p){

    if(p==NULL)
        return ;

    printf("%c ",p->info);
    preorder(p->lchild);
    preorder(p->rchild);
}


void inorder(struct node *p){

    if(p==NULL)
        return ;

    inorder(p->lchild);
    printf("%c ",p->info);
    inorder(p->rchild);
}



void postorder(struct node *p){

    if(p==NULL)
        return;

    postorder(p->lchild);
    postorder(p->rchild);
    printf("%c ",p->info);

}




int height(struct node *p){
    int hL,hR;
    if(p==NULL){
        return 0;
    }

    hL=height(p->lchild);
    hR=height(p->rchild);

    if(hL>hR){
        return hL+1;
    }
    else{
        return hR+1;
    }
}

void levelOrder(struct node *p){
    if(p==NULL){
        printf("Tree is empty\n");
        return ;
    }
    insertQueue(p);
    while(!queueEmpty()){
        p=deleteQueue();
        printf("5c ",p->info);
        if(p->lchild!=NULL)
            insertQueue(p->lchild);
        if(p->rchild!=NULL)
            insertQueue(p->rchild);
    }
}







void insertQueue(struct node *item){

    if(rear==MAX-1){
        printf("Overflow \n");
        return;
    }

    if(front==-1){
        front=0;
    }

    rear=rear+1;
    queue[rear]=item;


}


struct node *deleteQueue(){

    struct node *item;
    if(front==-1 || front==rear+1){
        printf("Queue Underflow\n");
        return 0;
    }

    item=queue[front];
    front=front+1;
    return item;

};



int queueEmpty(){
    if(front==-1 || front==rear+1){
        return 1;
    }
    else{
        return 0;
    }
}

```


2. Implementation of binary search tree

```c


#include<stdio.h>
#include<stdlib.h>

struct node {
  struct node *lchild;
  int info;
  struct node *rchild;
};


struct node *getnode(int x);
void display(struct node *p,int level);
struct node *search(struct node *p,int x);
struct node *insertNode(struct node *root,int x);
struct node *deleteNode(struct node *root,int x);
struct node *Min(struct node *p);
struct node *Max(struct node *p);




int main(){
    struct node *root=NULL,*p;

    int choice,x;


    while(1){

        printf("\n");
        printf("1. Display \n");
        printf("2. Search \n");
        printf("3. Insert a new node \n");
        printf("4. Delete a node \n");
        printf("5. Find minimum\n");
        printf("6. Find maximum\n");
        printf("7. Quit \n");
        printf("8. Enter your choice ");
        scanf("%d",&choice);
        if(choice==7){
            break;
        }


        switch(choice)
        {

        case 1:
            break;
        case 2:
            break;
        case 3:
            printf("Enter the key to be inserted :");
            scanf("%d",&x);
            root=insertNode(root,x);
            break;
        case 4:
                printf("Enter the key to be deleted :");
            scanf("%d",&x);
            root=deleteNode(root,x);
            break;

        case 5:
            p=Min(root);
            if(p==NULL){
                printf("Empty Tree \n");
            }
            else{
                printf("Minimum key  is %d \n",p->info);
            }
            break;
        case 6:
            p=Max(root);
            if(p==NULL){
                printf("Empty Tree \n");
            }
            else{
                printf("Maximum key is %d \n",p->info);

            }
            break;
        }
    }
}


struct node *getnode(int x){
    struct node *p=(struct node *)malloc(sizeof(struct node));

    p->info=x;
    p->lchild=NULL;
    p->rchild=NULL;

    return p;
};


struct node *insertNode(struct node *root,int x){
    struct node *temp,*par,*p;

    p=root;
    par=NULL;


    while(p!=NULL){
        par=p;

        if(x<p->info){
            p=p->lchild;
        }
        else if(x>p->info){
            p=p->rchild;
        }
        else{
            printf("This element is already present \n");
            return root;
        }
    }

    temp=getnode(x);
    if(par==NULL){
        root=temp;
    }
    else if(x<par->info){
        par->lchild=temp;
    }
    else{
        par->rchild=temp;
    }

    return root;

};




struct node *recursiveInsertNode(struct node *p,int x){

    if(p==NULL){
        p=getnode(x);
    }

    else if(x<p->info){
        p->lchild=recursiveInsertNode(p->lchild,x);
    }

    else if(x>p->info){
        p->rchild=recursiveInsertNode(p->rchild,x);
    }

    else{
        printf("Already present :) \n ");
    }

    return p;

};





struct node *search(struct node *p,int x){
    while(p!=NULL){

        if(p->info<x){
            p=p->lchild;
        }
        else if(p->info>x){
            p=p->rchild;
        }
        else{
            return p;
        }
    }
    return NULL;
};


struct node *deleteNode(struct node *root,int x){
    struct node *par,*p,*ch,*s,*ps;


    p=root;
    par=NULL;

    while(p!=NULL){
        if(x==p->info){
            break;
        }
        par=p;
        if(x<p->info){
            p=p->lchild;
        }
        else{
            p=p->rchild;
        }



        if(p==NULL){
            printf("Element not found \n");
            return root;
        }


        // 2 children ,find inorder successor and its parent

        if(p->lchild!=NULL && p->child!=NULL){
            ps=p;
            s=p->rchild;
            while(s->lchild!=NULL){
                ps=s;
                s=s->lchild;
            }
            p->info=s->info;
            p=s;
            par=ps;

        }


        // 1 or no child


        if(p->lchild!=NULL){
            ch=p->lchild;
        }
        else{
            ch=p->rchild;
        }


        if(par=NULL){
            root=ch;
        }
        else if(p==par->lchild){
            par->lchild=ch;
        }
        else{
            par->rchild=ch;
        }

        free(p);
        return root;
    }
};

```