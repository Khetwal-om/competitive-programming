


1. Implementation of singly linked list

```c++
#include <bits/stdc++.h>
using namespace std;

typedef struct node{
    int data;
    struct node* next;
} node;

node *insertAtBeginning(node *head,int data){
    node *temp=(node *)malloc(sizeof(node));

    temp->data=data;
    temp->next=head;
    head=temp;
    return head;

}

void displayHeadVal(node *head){
    cout<<"******"<<endl;
    cout<<head->data;
    cout<<"******"<<endl;

}

node *insertAtEnd(node *head,int data){
    node *temp=(node *)malloc(sizeof(node));
    if(head==NULL){
        temp->data=data;
        temp->next=NULL;
        head=temp;
        return head;
    }
    node *curr=head;

    while(curr->next!=NULL){
        curr=curr->next;
    }

    temp->data=data;
    temp->next=NULL;
    curr->next=temp;
    return head;


}


node *utility(node *head){
    node *node1=(node*)malloc(sizeof(node));
    node1->data=1;
    head=node1;
    node *node2=(node*)malloc(sizeof(node));
    node2->data=2;
    node1->next=node2;
    node *node3=(node*)malloc(sizeof(node));
    node3->data=3;
    node2->next=node3;
    node *node4=(node*)malloc(sizeof(node));
    node4->data=4;
    node3->next=node4;
    node *node5=(node*)malloc(sizeof(node));
    node5->data=5;
    node4->next=node5;
    node5->next=NULL;
    return head;

}

node *insertAtPosition(node *head,int data,int position){

    node *temp=(node*)malloc(sizeof(node));

    if(position==1){
        temp->data=data;
        temp->next=head;
        head=temp;
        return head;
    }
    node *curr=head;
    for(int i=1;i<(position-1)&&(curr);i++){
        curr=curr->next;
    }
    if(curr==NULL){
        cout<<"Nothing found as such\n";
        return head;
    }
    temp->data=data;
    temp->next=curr->next;
    curr->next=temp;

    return head;


}

void displayList(node *head){
    cout<<endl;
    cout<<"*****************"<<endl;

    node *curr=head;
    while(curr!=NULL){
        cout<<curr->data<<"   ";
        curr=curr->next;
    }

    cout<<endl;
    cout<<"*****************"<<endl;

}

int main(){
    node *head=NULL;
    int choice,position;
    int data;
    head=utility(head);
    while(true){
        cout<<"1. Insert the node in the beginning\n2. Insert the node at the end\n3. Insert node at specific position\n4. Display\n7. Bye Ira\n";
        cin>>choice;
        if(choice==7) break;
        switch(choice){
            case 1:
                cin>>data;
                head=insertAtBeginning(head,data);
                break;
            case 2:
                cin>>data;
                head=insertAtEnd(head,data);
                break;
            case 8:
                displayHeadVal(head);
                break;

            case 3:
                cout<<"Enter the value and position";
                cin>>data>>position;
                head=insertAtPosition(head,data,position);
                break;
            case 4:
                displayList(head);
                break;

            default:
                cout<<"Wrong choice";

        }
    }

}
```