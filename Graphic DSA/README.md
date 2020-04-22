




1. Queue implementation

```c

#include <bits/stdc++.h>
#include <ctype.h>
#define MAX 10

using namespace std;

int insert(int [],int,int);
int serve(int [],int,int);
void display(int [],int,int);

int main()
{
    int queue[MAX];
    
    int front=-1,rear=-1;
    int choice;
    char c;
    do{
        printf("1. Insert\n2. Serve\n3. Display\n");
        scanf("%d",&choice);
        switch(choice){
            case 1:
                if(front==rear+1||((rear==MAX-1) && (front==0))){
                    printf("Queue is full\n");
                }
                else{
                    if(front==-1 && rear==-1){
                        front=0;
                    }
                    rear=insert(queue,front,rear);
                }
                break;

            case 2:
                if(front==-1 && rear==-1){
                    printf("No elements to delete\n");
                }
                else{
                    front=serve(queue,front,rear);

                }
                break;
            case 3:
                if(front==-1 && rear==-1){
                    printf("No elements to display\n");
                }
                else{
                    display(queue,front,rear);
                }
                break;

        }
        printf("Do you wanna continue\n");
        fflush(stdin);
        scanf("%c",&c);
    }
    while (toupper(c)=='Y');

    return 0;
}

int insert(int queue[],int front,int rear){
    int element;
    printf("Enter the element \n");
    scanf("%d",&element);

    if(rear==MAX-1){
        rear=0;
        queue[rear]=element;
        return rear;
    }
    queue[rear++]=element;
    return rear;
}

int serve(int queue[],int front,int rear){
    int element;
    element=queue[front];
    printf("The element served is %d\n",element);
    if(front==rear){
        front=rear=-1;
    }
    else if(front==MAX-1){
        front=0;
    }
    else{
        front-=1;
    }

    return front;

}

void display(int queue[],int front,int rear){
    int temp;
    if(front<=rear){
        for(int i=front;i<rear;i++){
            printf("%d  ",queue[i]);
        }
    }
    else{
        for(int i=front;i<=MAX-1;i++){
            printf("%d ",queue[i]);
        }
        temp=rear;
        for(int k=0;k<temp;k++){
            printf("%d ",queue[k]);
        }
    }
    printf("\n");
}
```



**Edited above a bit**

```c
#include <bits/stdc++.h>
#include <ctype.h>
#define MAX 10

using namespace std;

int insert(int [],int,int);
int serve(int [],int,int);
void display(int [],int,int);

int main()
{
    int queue[MAX];

    int front=-1,rear=-1;
    int choice;
    char c;
    do{
        printf("1. Insert\n2. Serve\n3. Display\n");
        scanf("%d",&choice);
        switch(choice){
            case 1:
                if(front==rear+1||((rear==MAX-1) && (front==0))){
                    printf("Queue is full\n");
                }
                else{
                    if(front==-1 && rear==-1){
                        front=0;
                    }
                    rear=insert(queue,front,rear);
                }
                break;

            case 2:
                if(front==-1 && rear==-1){
                    printf("No elements to delete\n");
                }
                else{
                    front=serve(queue,front,rear);

                }
                break;
            case 3:
                if(front==-1 && rear==-1){
                    printf("No elements to display\n");
                }
                else{
                    display(queue,front,rear);
                }
                break;

        }
        printf("Do you wanna continue\n");
        fflush(stdin);
        scanf("%c",&c);
    }
    while (toupper(c)=='Y');

    return 0;
}

int insert(int queue[],int front,int rear){
    int element;
    printf("Enter the element \n");
    scanf("%d",&element);

    if(rear==MAX-1){
        rear=0;
        queue[rear]=element;
        return rear;
    }
    rear+=1;
    queue[rear]=element;
    return rear;
}

int serve(int queue[],int front,int rear){
    int element;
    element=queue[front];
    if(front==rear){
        printf("The element served is %d\n",element);
        front=-1;
        rear=-1;
        return front;
    }
    else if(front==MAX-1){
        printf("The element served is %d\n",element);
        front=0;
    }
    return front;

}

void display(int queue[],int front,int rear){

    if (rear >= front)
    {
        for (int i = front; i <= rear; i++)
            printf("%d ",queue[i]);
    }
    else
    {
        for (int i = front; i < MAX; i++)
            printf("%d ", queue[i]);

        for (int i = 0; i <= rear; i++)
            printf("%d ", queue[i]);
    }
    printf("\n");
}
```