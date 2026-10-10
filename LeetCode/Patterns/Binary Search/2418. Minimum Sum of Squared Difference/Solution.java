class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        int n=nums1.length;
        int[] diff=new int[n];
        long total=0;
        int maxd=0;
        for(int i=0;i<n;i++){
            diff[i]=Math.abs(nums1[i]-nums2[i]);
            total+=diff[i];
            maxd=Math.max(maxd,diff[i]);
        }
        long k=(long)k1+k2;
        if(k>=total) return 0;
        int[] count=new int[maxd+1];
        for(int d: diff) count[d]++;
        for(int i=maxd;i>0&&k>0;i--){
            if(count[i]==0)continue;
            long r=Math.min((long) count[i],k);
            count[i]-=r;
            count[i-1]+=r;
            k-=r;
        }
        long ans=0;
        for(int i=0;i<=maxd;i++){
            if(count[i]>0) ans+=(long) count[i]*i*i;
        }
        return ans;
    }
}