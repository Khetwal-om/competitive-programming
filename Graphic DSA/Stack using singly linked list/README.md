

1. Implementation of stack  (single pointer).


```c++
#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <ctype.h>


typedef struct node{
    int info;
    struct node* next;
}nodetype;


nodetype* push(nodetype*,int);
nodetype* pop(nodetype*);
void display(nodetype*);


int main(){
    nodetype* top=NULL;
    int number,option;
    char choice;

    do{
        printf("Please select the option \n");
        scanf("%d",&option);
        if(option==1){
            printf("Enter the element to insert\n");
            scanf("%d",&number);
            top=push(top,number);
        }
        else if(option==2){
            if(top!=NULL){
                top=pop(top);
            }
            else{
                printf("Can't pop from  empty list\n");
            }
        }
        else if(option==3){
            if(top!=NULL){
                display(top);
            }
        }
        else{
            printf("Wrong option\n");
        }
        fflush(stdin);
        printf("Do you want to continue \n");
        scanf("%c",&choice);
    }
    while (choice=='y');

    return 0;
}

nodetype* push(nodetype* top,int number){
    nodetype* temp=(nodetype*)malloc(sizeof(nodetype*));
    if(temp==NULL){
        printf("No memory allocated\n");
        return top;
    }
    else{
        temp->info=number;
        temp->next=top;
        top=temp;
    }
    return top;
}





nodetype* pop(nodetype* top){

    nodetype* temp;
    temp=top;
    printf("The popped element is %d \n",temp->info);
    top=top->next;
    free(temp);
    return top;
}



void display(nodetype* top){
    while (top!=NULL){
        printf("%d ",top->info);
        top=top->next;
    }
}
```





2. Implementation of stack using double pointer 

```c++
#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <ctype.h>


typedef struct node{
    int info;
    struct node* next;
}nodetype;


void push(nodetype**,int);
void pop(nodetype**);
void display(nodetype*);


int main(){
    nodetype* top=NULL;
    int number,option;
    char choice;

    do{
        printf("Please select the option \n");
        scanf("%d",&option);
        if(option==1){
            printf("Enter the element to insert\n");
            scanf("%d",&number);
            push(&top,number);
        }
        else if(option==2){
            if(top!=NULL){
                pop(&top);
            }
            else{
                printf("Can't pop from  empty list\n");
            }
        }
        else if(option==3){
            if(top!=NULL){
                display(top);
            }
        }
        else{
            printf("Wrong option\n");
        }
        fflush(stdin);
        printf("Do you want to continue \n");
        scanf("%c",&choice);
    }
    while (choice=='y');

    return 0;
}

void push(nodetype** top,int number){
    nodetype* temp=(nodetype*)malloc(sizeof(nodetype*));
    if(temp==NULL){
        printf("No memory allocated\n");

    }
    else{
        temp->info=number;
        temp->next=*top;
        *top=temp;
    }

}




void pop(nodetype** top){

    nodetype* temp;
    temp=*top;
    printf("The popped element is %d \n",temp->info);
    *top=(*top)->next;
    free(temp);
}



void display(nodetype* top){
    while (top){
        printf("%d ",top->info);
        top=top->next;
    }
}
```


3. Circular linked list : Insertion at the beginning of the list


```c++
#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <ctype.h>


typedef struct node{
    int info;
    struct node* next;
}node;


node* insert(node* last,int element){
    node *temp=(node*)malloc(sizeof(node));
    temp->info=element;
    if(last==NULL){
        last=temp;
        last->next=temp;
        return last;
    }
    temp->next=last->next;
    last->next=temp;

    return last;
}



void display(node* last){
    node* temp=last->next;
   
        do{
            printf(" %d ",temp->info);
            temp=temp->next;
        }
        while (temp!=last->next);

    
}


int main(){
    node* head=NULL;
    int number,option;
    char choice;

    do{
        printf("Please select the option \n1. Insert the node\n2. Display the list");
        scanf("%d",&option);
        if(option==1){
            printf("Enter the element to insert\n");
            scanf("%d",&number);
            head=insert(head,number);
        }
        
        else if(option==2){
            if(head!=NULL){
                display(head);
            }
        }
        else{
            printf("Wrong option\n");
        }
        fflush(stdin);
        printf("Do you want to continue \n");
        scanf("%c",&choice);
    }
    while (choice=='y');

    return 0;
}


```


4. Insertion at the end of the circular linked list :smile:



```c++





#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <ctype.h>


typedef struct node{
    int info;
    struct node* next;
}node;


node* insert(node* last,int element){
    node *temp=(node*)malloc(sizeof(node));
    temp->info=element;
    if(last==NULL){
        last=temp;
        last->next=temp;
        return last;
    }
    temp->next=last->next;
    last->next=temp;
    last=temp;
    return last;
}



void display(node* last){
    node* temp=last->next;

        do{
            printf(" %d ",temp->info);
            temp=temp->next;
        }
        while (temp!=last->next);


}


int main(){
    node* head=NULL;
    int number,option;
    char choice;

    do{
        printf("Please select the option \n1. Insert the node\n2. Display the list");
        scanf("%d",&option);
        if(option==1){
            printf("Enter the element to insert\n");
            scanf("%d",&number);
            head=insert(head,number);
        }

        else if(option==2){
            if(head!=NULL){
                display(head);
            }
        }
        else{
            printf("Wrong option\n");
        }
        fflush(stdin);
        printf("Do you want to continue \n");
        scanf("%c",&choice);
    }
    while (choice=='y');

    return 0;
}









```





5. Implementation of queue using double pointer

```c++
#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <ctype.h>


typedef struct node{
    int info;
    struct node* next;
}nodetype;


void enqueue(nodetype**,int);
void deque(nodetype**);
void display(nodetype*);


int main(){
    nodetype* front=NULL;
    nodetype* rear=NULL;
    int number,option;
    char choice;

    do{
        printf("Please select the option \n");
        scanf("%d",&option);
        if(option==1){
            printf("Enter the element to insert\n");
            scanf("%d",&number);
            enqueue(&rear,number);
            if(front==NULL){
                front=rear;
            }
        }
        else if(option==2){
            if(front!=NULL){
                deque(&front);
                if(front==NULL){
                    rear=front;
                }
            }
            else{
                printf("Can't pop from  empty list\n");
            }
        }
        else if(option==3){
            if(front!=NULL){
                display(front);
            }
        }
        else{
            printf("Wrong option\n");
        }
        fflush(stdin);
        printf("Do you want to continue \n");
        scanf("%c",&choice);
    }
    while (choice=='y');

    return 0;
}

void enqueue(nodetype** rear,int number){
    nodetype* temp=(nodetype*)malloc(sizeof(nodetype));
    if(temp==NULL){
        printf("No memory allocated\n");
        return ;
    }
    temp->info=number;

    if(*rear==NULL){
        *rear=temp;
    }

    temp->next=NULL;
    (*rear)->next=temp;
    *rear=temp;


    //    else{
//        temp->info=number;
//        temp->next=*top;
//        *top=temp;
//    }

}




void deque(nodetype** front){

    nodetype* temp;
    temp=*front;
    printf("The popped element is %d \n",temp->info);

    if((*front)->next==NULL){
        *front=NULL;
    }

    *front=(*front)->next;
    free(temp);
}



void display(nodetype* front){

    while (front){
        printf("%d ",front->info);
        front=front->next;
    }
}
```