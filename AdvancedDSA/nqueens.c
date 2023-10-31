// N Queens 

# include<stdio.h>
# include <stdbool.h>
# define N 4

void PrintSolution(int board[N][N]){
    for (int i = 0; i < N; i++)
    {
        for (int j = 0; j < N; j++)
            printf(" %d ", board[i][j]);
        printf("\n");
    }
}

bool QueenisSafe(int board[N][N], int row, int column){
    for(int i = 0; i<column;i++){
        if(board[row][i]){
            return false;
        }
    }
    for(int i = row, j = column; i>=0 && j>=0;i--, j--){
        if(board[i][j]){
            return false;
        }
    }
    for(int i = row, j = column;i<N && j>=0;i++, j--){
        if(board[i][j]){
            return false;
        }
    }
    return true;
}

bool SolvetheNqueenProblem(int board[N][N], int column){
    if(column == N){
        return true;
    }
    
    for(int i = 0; i<N;i++){
        if(QueenisSafe(board , i , column)){
            board[i][column] = 1;
            if(SolvetheNqueenProblem(board, column+1)){
                return true;
            }
            board[i][column] = 0;
        }
    }
    return false;
}

bool SolvetheNqueen(){
    int board[N][N] = {
        {0,0,0,0},
        {0,0,0,0},
        {0,0,0,0},
        {0,0,0,0}
    };
    
    if(SolvetheNqueenProblem(board, 0) == false){
        printf("Solution Does not exist ...");
        return false;
    }
    PrintSolution(board);
    return true;
}

int main(){
    printf("N Queens\n");
    SolvetheNqueen();
    return 0;
}
