


1. Print numbers in increasing order.

```c++

#include <bits/stdc++.h>
using namespace std;

void print(int n){
    if(n==0){
        printf("%d ",n);
        return;
    }

    print(n-1);
    printf("%d",n);

}


int main(){
    int n;
    cin>>n;

   print(n);

   return 0;
}
```



2. Now print in decreasing order.

```c++

#include <bits/stdc++.h>
using namespace std;

void print(int n){
    if(n==0){
        printf("%d ",n);
        return;
    }
    printf("%d",n);
    print(n-1);


}


int main(){
    int n;
    cin>>n;

   print(n);

   return 0;
}




```

3. Solve Knight.

```c++
#include <bits/stdc++.h>
using namespace std;
const int D=8;

void printBoard(int board[D][D],int n){
    for(int i=0;i<n;i++) {
        for (int j = 0; j < n; j++) {
            cout << board[i][j]<<"  ";
        }
    cout<<endl;
    }
}
bool canPlace(int board [D][D],int n,int curRow,int curCol){

    return
       curRow>=0 && curRow<n
       && curCol>=0 && curCol<n
       && board[curRow][curCol]==0;
}

bool solveKnight(int board[D][D],int n,int move_no,int curRow,int curCol){
    if(move_no==n*n){
        return true;
    }
    int rowDir[]={+2,+1,-1,-2,-2,-1,+1,+2};
    int colDir[]={+1,+2,+2,+1,-1,-2,-2,-1};

    for (int curDir = 0; curDir < 8; ++curDir) {
        int nextRow=curRow+rowDir[curDir];
        int nextCol=curCol+colDir[curDir];
        if(canPlace(board,n,nextRow,nextCol)){
            board[nextRow][nextCol]=move_no+1;
            bool isSuccessful=solveKnight(board,n,move_no+1,nextRow,nextCol);
            if(isSuccessful) return true;
            board[nextRow][nextCol]=0;
        }
    }
    return false;
}


int main(){
    int board[D][D]={0};
    int n;cin>>n;
    board[0][0]=1;
    bool ans=solveKnight(board,n,1,0,0);
    if(ans){
        printBoard(board,n);
    }
    else{
        cout<<"Nope";
    }
   return 0;
}
```


**Sudoku   solver** 
*fix*

```c++
#include <bits/stdc++.h>
using namespace std;

const int D=10;


bool canPlace(int board[D][D],int n,int row,int col,int curNum) {
    for (int x = 0; x < n; ++x) {
        if (board[r][x] == curNum) return false;
        if (board[x][c] == curNum) return false;
    }

    int rootn = sqrt(n);
    int boxRow = row / rootn;
    int boxCol = col / rootn;
    int boxStartCellRow = boxRow * rootn;
    int boxStartCellCol = boxCol * rootn;

    for (int i = boxStartCellRow; i < boxStartCellRow + rootn; ++i) {
        for (int j = boxStartCellCol; j < boxStartCellCol + rootn; ++j) {
            if (board[i][j] == curNum) return false;
        }
    }
    return true;
}



bool solveSudoku(int board[D][D],int n,int row,int col){
    if(row==n){
        return true;
//        [0,n] rows are solved
    }
    if(col==n){
//        start with a new row
    return solveSudoku(board,n,row+1,0);
    }

    if(board[row][col]!=0){
        return solveSudoku(board,n,row,col+1);
    }
    if(curNum=1;curNum<=n;++curNum){
        if(canPlace(board,n,row,col,curNum)==true){
            board[row][col]=curNum;
            bool success=solveSudoku(board,n,row,col+1);
            if(success==true) return true;
            board[row][col]=0;
        }
    }
    return true;
}





int main(){
    int board[D][D]={};
    int n;cin>>n;

    bool success=solveSudoku(board,n,0,0);
    if(success){
        printBoard(board,n);
    }
    else{
        cout<<"no";
    }
}


```