import java.util.HashMap;
import java.util.Scanner;

public class Money {
        public int maxProfit(int[] prices) {
            /*if(descendingArray(prices, 0) == true){
                return 0;
            } else if( ascendingArray(prices,0) == true){
                return prices[prices.length-1] - prices[0];
            }*/
            HashMap<Long,Long> hm=new HashMap<Long,Long>();
            int maxkey=prices[0];
            for(int i=0;i< prices.length;i++){
                if(hm.containsKey((long)prices[i]) || (prices[i] > maxkey)) {
                    continue;
                }
                if(prices[i] > maxkey){
                    maxkey = prices[i];
                }
                int profit=0;
                for(int j=i+1;j<prices.length;j++){
                    if((prices[j] - prices[i]) > profit){
                        profit = prices[j] - prices[i];
                    }
                }
                hm.put((long)prices[i], (long)profit);
            }
            Long[] profits = hm.values().toArray(new Long[0]);
            long maxpro=0;
            for(int i=0;i<profits.length;i++){
                if(profits[i]> maxpro){
                    maxpro=profits[i];
                }
            }
            return (int)maxpro;
        }


        boolean descendingArray(int[] arr, int ind){
            if(ind == arr.length-1){
                return true;
            }
            else if(arr[ind] >= arr[ind+1]){
                return descendingArray(arr,++ind);
            } else if(arr[ind] < arr[ind+1]){
                return false;
            }
            return true;
        }

        boolean ascendingArray(int[] arr, int ind){
            if(ind == arr.length-1){
                return true;
            }
            else if(arr[ind] <= arr[ind+1]){
                return ascendingArray(arr,++ind);
            } else if(arr[ind] > arr[ind+1]){
                return false;
            }
            return true;
        }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter length of array: ");
        int N=sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
                arr[i] = sc.nextInt();
                System.out.print("\t");
        }
        Money ob=new Money();
        System.out.println(ob.maxProfit(arr));
    }
    }

