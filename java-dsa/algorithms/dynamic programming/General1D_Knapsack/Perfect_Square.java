//link to the problem statement: https://leetcode.com/problems/perfect-squares/

public class Perfect_Square {
    public int numSquares(int n){
        //int coins=minCount(n,1,0);
        //return coins;
        return minCount2(n);
    }

    int minCount(int no, int pointer, int count){//Recursive
        if(no ==0){
            return count;
        }else if(pointer >no){
            return Integer.MAX_VALUE-1;
        } else{
            int min=Math.min(minCount(no-(pointer*pointer),pointer,count+1),
                    minCount(no,pointer+1,count));
            return min;
        }
    }

    int minCount2(int no){//Dynamic programming
        int[][] t=new int[101][no+1];
        for(int i=0;i<=no;i++){
            t[0][i] = Integer.MAX_VALUE-1;
        }
        for(int i=0;i<=100;i++){
            t[i][0] = 0;
        }
        for(int i=1;i<=100;i++){
            for(int j=1;j<=no;j++){
                if((i*i)>j){
                    t[i][j] = t[i-1][j];
                }else{
                    t[i][j] = Math.min(1+t[i][j-(i*i)],t[i-1][j]);
                }
            }
        }
        return t[100][no];
    }

    public static void main(String[] args) {
        Perfect_Square ob=new Perfect_Square();
        System.out.println(ob.numSquares(7168));
    }
}
