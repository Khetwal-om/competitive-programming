

1. singly linked list implementation .

```c
#include <bits/stdc++.h>
using namespace std;


struct node {
    int info;
    struct node *link;
};

struct node *createNode(struct node *start);
struct node *insertInBeginning(struct node *start,int data);
void insertAtEnd(struct node* start,int data);
struct node *insertBefore(struct node *start,int data,int x);
void insertAfter(struct node *start,int data,int x);
void countNodes(struct node *start);
void search(struct node *start,int x);

struct node *insertAtPosition(struct node *start,int data,int x);
struct node *deleteNode(struct node *start,int data);
struct node *reverseList(struct node *start);

void displayList(struct node *start);

int main(){

    struct node *start=NULL;
    int choice,data,x,k;


    start=createNode(start);

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




struct node *insertInBeginning(struct node *start,int data){
    struct node *temp;
    temp=(struct node *)malloc(sizeof(struct node));

    temp->info=data;
    temp->link=start;
    start=temp;

    return start;
}






struct node *createNode(struct node *start){
    int n,data;

    printf("Enter the number of elements that you wanna enter \n");
    scanf("%d",&n);
    if(n==0){
        return start;
    }

    printf("Enter your first element \n");
    scanf("%d",&data);

    start=insertInBeginning(start,data);
    printf("Enter remaining elements\n");

    for(int i=1;i<n;i++){
        scanf("%d",&data);
        insertAtEnd(start,data);
    }

    return start;

}


void displayList(struct node* start){
    struct node *p;
    p=start;

    while(p!=NULL){
        printf("%d ",p->info);
        p=p->link;
    }

}



void insertAtEnd(struct node *start,int data){


    struct node *p,*temp;

    temp=(struct node *)malloc(sizeof(struct node));


    p=start;

    while(p->link!=NULL){
        p=p->link;
    }


    temp->info=data;
    p->link=temp;
    temp->link=NULL;


}


void countNodes(struct node *start){


}

void search(struct node *start,int x){


}
















void insertAfter(struct node *start,int data,int x){

}
struct node *insertBefore(struct node *start,int data,int x){


}
struct node *insertAtPosition(struct node *start,int data,int x){


}
struct node *deleteNode(struct node *start,int data){


}

struct node *reverseList(struct node *start){

}

```