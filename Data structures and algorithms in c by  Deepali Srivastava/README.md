


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