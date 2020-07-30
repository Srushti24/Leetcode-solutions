class Solution {
    public ListNode[] splitListToParts(ListNode root, int k) {
         ListNode root1=root;
        ListNode[] result=new ListNode[k];
        int size=totalSize(root1);
       if(size<=k)
       {
           dfs(result,1,root,0);
       }
        else 
        {
            int temp=size%k;
            int s=size/k;
            dfs(result,s,root,temp);
        }
       return result;   
    }
    
    
    
    
    
    
    
    void dfs(ListNode[] result,int size, ListNode root,int extra)
    {
        int more=extra;
        int start=0;
        int counter=0;
        while(root!=null && start<result.length)
        {
            result[start]=root;
            start++;
            counter++;
            while(counter<size && root!=null)
            {
             root=root.next;
                counter++;
            }
            if(more>0)
            {
                root=root.next;
                more--;
            }
            ListNode root1=root.next;
            root.next=null;
            root=root1;
            counter=0;
        }
    }
    
    
    
    
    
    
    
    
    
    
     int totalSize(ListNode root1)
    {
        int total=0;
        while(root1!=null)
        {
            total++;
            root1=root1.next;
        }
        return total;
    }
}
