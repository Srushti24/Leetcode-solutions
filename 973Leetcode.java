class Solution {
    public int[][] kClosest(int[][] points, int K) {
    Arrays.sort(points, new Com());
        int ans[][]=new int[K][2];
        for(int i=0;i<K;i++)
        {
            ans[i][0]=points[i][0];
            ans[i][1]=points[i][1];
        }
        return ans;
    }
    
    
    
    class Com implements Comparator<int[]>{
        
        public int compare(int[] a, int [] b)
        {
            return(a[0]*a[0]+a[1]*a[1]) - (b[0]*b[0]+b[1]*b[1]);
        }
    }
    
    
    
   
}
