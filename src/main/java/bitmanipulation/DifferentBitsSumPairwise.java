package bitmanipulation;

public class DifferentBitsSumPairwise {
    public class Solution {
        public int cntBits(int[] A) {
            int n=A.length;
            int y=0;
            for(int i=0;i<A.length;i++){
                y=Math.max(y,A[i]);
            }
            int l=(int)Math.floor(Math.log(y)/Math.log(2))+1;
            int ans=0;
            int m=1000000007;
            for(int i=0;i<=l;i++){
                int t=0;
                for(int u=0;u<A.length;u++){
                    if(((A[u])&(1<<i))==0){
                        t++;
                    }
                }
                ans=(ans%m+(((2*t)%m)*((n-t)%m))%m)%m;
            }
            return ans%m;
        }
    }
}
