



# 29 January ,  Singly linked list



1. Delete, reverse the list.

```c

#include <stdio.h>
#include <stdlib.h>

struct node {
    int info;
    struct node *link;
};

struct node *createList(struct node *start);
struct node *insertInBeginning(struct node *start,int data);
void insertAtEnd(struct node *start,int data);
struct node *insertBefore(struct node *start,int data,int x);
void insertAfter(struct node *start,int data,int x);
struct node *insertAtPosition(struct node *start,int data,int x);
void displayList(struct node *start);
void countNodes(struct node *start);
void search(struct node *start,int data);
struct node *deleteNode(struct node *start,int data);
struct node *reverseList(struct node *start);


int main() {
    struct node *start = NULL;

    start=createList(start);
    int choice;
    int data, x, k;
    while (1) {
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
        scanf("%d", &choice);


        if (choice == 11)
            break;


        switch (choice) {
            case 1:
                displayList(start);
                break;

            case 2:
                countNodes(start);
                break;

            case 3:

                printf("Enter the element to be searched");
                scanf("%d", &data);
                search(start, data);
                break;

            case 4:
                printf("Enter the element to be inserted");
                scanf("%d", &data);
                start = insertInBeginning(start, data);
                break;


            case 5:
                printf("Enter the element to be inserted");
                scanf("%d", &data);
                insertAtEnd(start, data);
                break;

            case 6:
                printf("Enter the element to be inserted");
                scanf("%d", &data);
                printf("Enter the element after which to insert");
                scanf("%d", &x);
                insertAfter(start, data, x);
                break;

            case 7:
                printf("Enter the element to be inserted");
                scanf("%d", &data);
                printf("Enter the element before at which to insert ");
                scanf("%d", &x);
                start = insertBefore(start, data, x);
                break;
            case 8:
                printf("Enter the element to be inserted");
                scanf("%d", &data);
                printf("Enter the position at which to insert");
                scanf("%d", &k);
                start = insertAtPosition(start, data, k);
                break;

            case 9:
                printf("Enter the element to be deleted");
                scanf("%d", &data);
                start = deleteNode(start, data);
                break;

            case 10:
                start = reverseList(start);
                break;
            default:
                printf("Something is wrong with your choice\n\n\n");


        }
    }


}



struct node *createList(struct node *start){
    int data;
    int n;
    int i;

    printf("HOw  many elements do you want to enter \n");
    scanf("%d",&n);


    if(n==0){
        return start;
    }

    printf("Enter your first element\n");
    scanf("%d",&data);

    start=insertInBeginning(start,data);
    printf("Enter the next element \n");

    for(i=2;i<=n;i++){
        scanf("%d",&data);
        insertAtEnd(start,data);
    }

    return start;

}



struct node *insertInBeginning(struct node *start,int data){
    struct node *temp;

    temp=(struct node *)malloc(sizeof(struct node));
    temp->info=data;
    temp->link=start;
    start=temp;

    return start;


}


void insertAtEnd(struct node *start,int data){

    struct node *temp,*p;
    temp=(struct node *)malloc(sizeof(struct node ));

    p=start;

    while(p->link!=NULL){
        p=p->link;
    }

        temp->info=data;
        p->link=temp;
        temp->link=NULL;

}

struct node *insertBefore(struct node *start,int data,int x){
    struct node *temp,*p;

    if(start==NULL){
        printf("No elements found \n");
        return 0;
    }

    p=start;

    temp=(struct node *)malloc(sizeof(struct node));

    if(start->info==x){
        temp->info=data;
        temp->link=start;
        start=temp;
        return start;
    }

    while(p!=NULL){
        if(p->link->info==x){
            break;
        }
        p=p->link;
    }

    if(p==NULL){
        printf("No element was found as such\n");

    }
    else{
        temp->info=data;
        temp->link=p->link;
        p->link=temp;
    }

    return start;

}


void insertAfter(struct node *start,int data,int x){
    struct node *temp,*p;

    p=start;
    temp=(struct node *)malloc(sizeof(struct node));

    while(p!=NULL){
        if(p->info==x){
            break;
        }
        p=p->link;
    }

    if(p->link==NULL){
        printf("The element is not found \n");
    }
    else{
        temp->info=data;
        temp->link=p->link;
        p->link=temp;
    }

}

struct node *insertAtPosition(struct node *start,int data,int k){

}




void displayList(struct node *start){

    if(start==NULL){
        printf("No elements in the list\n");
        return ;
    }

    struct node *p;

    p=start;

    while(p!=NULL){
        printf("%d  ",p->info);
        p=p->link;
    }

}


void countNodes(struct node *start){
    int count=0;
    if(start==NULL){
        printf("No elements in the list\n");
        return ;
    }

    struct node *p;

    p=start;

    while(p!=NULL){
        p=p->link;
        count+=1;
    }

    printf("The number of elements are %d",count);
    printf("\n");

}




void search(struct node *start,int data){
    int count=1;
    if(start==NULL){
        printf("No elements in the list\n");
        return ;
    }


    struct node *p;

    p=start;

    while(p!=NULL){
        if(p->info==data){
            printf("Element found at index %d",count);
            return;
        }
        p=p->link;
        count+=1;
    }


}


struct node *deleteNode(struct node *start,int data){
    
    
    

}



struct node *reverseList(struct node *start){

}

```