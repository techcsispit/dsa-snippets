#include <stdio.h>
#include <string.h>
int arr[20][20];
char S1[20];
char S2[20];
int i, j, m, n;
void LongestCommonSubsequence(){
    m = strlen(S1);
    n = strlen(S2);
    for(int i = 0;i<m;i++){
            arr[i][0] = 0;
    }
    for(int i = 0;i<n;i++){
            arr[0][i] = 0;
    }
    
    for(i=1;i<=m;i++){
        for(j=1;j<=n;j++){
            if(S1[i-1] == S2[j-1]){
                arr[i][j] = arr[i-1][j-1] + 1;
            }
            else if(arr[i-1][j]>arr[i][j-1]){
                arr[i][j] = arr[i-1][j];
            }
            else{
                arr[i][j] = arr[i][j-1];
            }
        }
    }
    int lastvalue = arr[m][n];
    char lengthofLCS[lastvalue+1];
    lengthofLCS[lastvalue] = '\0';
    
    i = m;
    j = n;
    while(i>0 && j> 0){
        if(S1[i-1] == S2[j-1]){ // If both are eqaul lets say a and a
            lengthofLCS[lastvalue-1] = S1[i-1]; // Then place any from either string 1 or 2 in the final string
            i--;
            j--;
            lastvalue--;
        }
        else{
            if(arr[i-1] > arr[j-1]){  // check if topmost value is greater or leftmost and accordingly decrement
                i--;
            }
            else{
                j--;
            }
        }
    }
    printf("The Longest common subsequence is : %s", lengthofLCS);
    
}

int main()
{
    printf("Longest Common Sub-Sequence\n");
    printf("Enter the String 1 : ");
    scanf("%s", &S1);
    printf("Enter the String 2 : ");
    scanf("%s", &S2);
    // printf("%s", S1);
    LongestCommonSubsequence();

    return 0;
}
