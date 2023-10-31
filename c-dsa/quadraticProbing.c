#include <stdio.h>

int main(){
    int size,hashkey,hashvalue,count = 0,linearhash;
    printf("Quadratic Hashing (Shasvat Shah - 60004220126)\n");
    printf("Enter the size of the Hash Table : ");
    scanf("%d",&size);
    int hashtable[size]; // array initialization...
    for(int n = 0; n < size ; n++){
        hashtable[n] = 0;
    }
    while(count < size){
        printf("\nEnter the Hashkey : ");
        scanf("%d",&hashkey);
        hashvalue = hashkey % size;
        if(hashtable[hashvalue] != 0){
            printf("\nCollision at spot %d : ",hashtable[hashvalue]);
            for(int i = 1;i<=size;i++){
                
                linearhash = (hashvalue + i*i)%size;
                if(hashtable[linearhash]==0){
                    hashtable[linearhash] = hashkey;
                    break;
            }
                else{
                    printf("\nCollision detected at Location %d",hashtable[hashvalue]);
            }
        }
        }
        else{
            hashtable[hashvalue] = hashkey;
        }
        
        
        count++;
    }
    
    printf("\nThe hash table is : ");
    for(int n = 0; n<size;n++){
        printf("%d ",hashtable[n]);
    }
    return 0;
}
