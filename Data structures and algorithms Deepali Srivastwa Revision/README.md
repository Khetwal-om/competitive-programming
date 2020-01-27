# Revision


1.

```c


```


2. Doubly linked list


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

//    if(start==NULL){
//        return;
//    }


//    p1=start;
//    p2=p1->next;

}









```



---

# Doubly linked list

---



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
        printf(" No elements to display  \n");
        return ;
    }
    p=start;

    while(p!=NULL){
        printf("%d  ",p->info);
        p=p->next;
    }

    printf("\n");

}






struct node *insertInEmptyList(struct node *start,int data){
    struct node *temp;
    temp=(struct node *)malloc(sizeof(struct node ));

    temp->info=data;
    temp->prev=NULL;
    temp->next=NULL;
    start=temp;

    return start;
};



struct node *insertInBeginning(struct node *start,int data){
    struct node *temp;
    temp=(struct node *)malloc(sizeof(struct node));

    temp->info=data;
    temp->prev=NULL;
    temp->next=start;
    start=temp;

    return start;
};




void insertAtEnd(struct node *start,int data){
    struct node *p,*temp;
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

    int data;
    int n;

    printf("Enter the number of elements that you wanna enter \n");
    scanf("%d",&n);

    if(n==0){
        return 0;
    }
    printf("Enter the first element that you wanna enter \n");
    scanf("%d",&data);

    start=insertInEmptyList(start,data);
    printf("Enter the next elements \n");
    for(int i=2;i<=n;i++) {
        scanf("%d",&data);
        insertAtEnd(start,data);
    }

    return start;

};










void insertAfter(struct node *start,int data,int x){
    struct node *temp,*p;

    p=start;

    while(p!=NULL){
        if(p->info==x){
            break;
        }
        p=p->next;
    }

    if(p==NULL){
        printf("Element not found ");
    }
    else{
        temp=(struct node *)malloc(sizeof(struct node));
        temp->info=data;
        temp->next=p->next;
        temp->prev=p;
        if(p->next!=NULL)
            p->next->prev=temp; //  >>> fix me
        p->next=temp;
    }


}



struct node *insertBefore(struct node *start,int data,int x){
     struct node *temp,*p;

     temp=(struct node *)malloc(sizeof(struct node));


    if(start->info==x){
        temp->info=data;
        temp->next=start;
        start->prev=temp;
        temp->prev=NULL;
        start=temp;
        return start;
    }


     p=start;




     while(p!=NULL){
         if(p->info==x){
             break;
         }
         p=p->next;
     }

     if(p==NULL){
         printf("The element ain't found \n");
         return 0;
     }
     else{
         temp->info=data;
         temp->next=p;
         temp->prev=p->prev;
         p->prev->next=temp;
         p->prev=temp;
     }

    return start;


}


struct node *deleteNode(struct node *start,int data){
    struct node *temp,*p;

    if(start->info==data) {
        temp=start;
        start=start->next;
        start->next->prev=NULL;
        free(temp);
        return start;
    }


    p=start->next;

    while(p->next!=NULL){
        if(p->info==data){
            break;
        }
        p=p->next;
    }

    if(p==NULL){
        printf("The element ain't     found \n");
    }
    else{

        if(p->next==NULL){
            p->prev->next=NULL;

        }
        else{
            p->prev->next=p->next;
            p->next->prev=p->prev;
        }

        free(p);
    }

    return start;


}
struct node *reverseList(struct node *start){

}





```





---


# Circular linked list  



---


1. Skeleton

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

  
    

};




struct node *insertInBeginning(struct node *last,int data)
{

    
};




struct node *insertAtEnd(struct node *last,int data){
    
    
};






struct node *createList(struct node *last){
    
    

};



struct node *insertAfter(struct node *last,int data,int x){


    
};


void displayList(struct node *last){
    
    
    
}




struct node *deleteNode(struct node* last,int x){
    
    
    

};


```



**Further code**



1. 