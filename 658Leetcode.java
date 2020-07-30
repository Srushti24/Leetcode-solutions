class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
     PriorityQueue<Data> pq=new PriorityQueue<>( new Com());
        List<Integer> result=new ArrayList<>();
        for(int i=0;i<arr.length;i++)
        {
            int dist=Math.abs(arr[i]-x);
            pq.add(new Data(arr[i],dist));
        }
        
        int counter=0;
        while(counter<k)
        {
            result.add(pq.poll().val);
            counter++;
        }
        Collections.sort(result);
        return result;
    }
    
    
    
    
    
    class Com implements Comparator<Data>
    {
        public int compare(Data a, Data b)
        {
            int byDist=a.getDist().compareTo(b.dist);
            int byVal=a.getVal().compareTo(b.val);
            if(byDist==0)
            {
                return a.val-b.val;
            }
            return a.dist-b.dist;
        }
    }
    
    
    class Data{
        int val;
        int dist;
        
        public Data(int v, int d)
        {
            val=v;
            dist=d;
        }
        
        
        public int getVal()
        {
            return val;
        }
        
        public int getDist()
        {
            return dist;
        }
    }
}
