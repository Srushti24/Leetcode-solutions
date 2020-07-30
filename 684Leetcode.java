class Solution {
    HashMap<Integer,Node> hashmap=new HashMap<>();
    boolean found=false;
    int ans[]=new int []{-1,-1};
    public int[] findRedundantConnection(int[][] edges) {
        for(int i=1;i<=edges.length;i++)
        {
            add(i);
        }
        for(int [] temp: edges)
        {
            union(temp[0],temp[1]);
            if(found)
            {
                return ans;
            }
        }
         return ans; 
    }
    
    
    
    
    
    
     void add(int data)
    {
        Node temp=new Node(data);
        temp.parent=temp;
        hashmap.put(data,temp);
    }
    
    
    
   Node getParent(Node n)
    {
        Node temp=n.parent;
        if(temp==n)
        {
            return temp;
        }
        n.parent= getParent(n.parent);
        return n.parent;
    }
    
    
    
     void union(int d1, int d2)
    {
        Node temp1=getParent(hashmap.get(d1));
        Node temp2=getParent(hashmap.get(d2));
        if(temp1==temp2)
        {
            found=true;
            ans[0]=d1;
            ans[1]=d2;
        }
        else if(temp1.rank>temp2.rank)
        {
            temp2.parent=temp1;
        }
        else
        {
            temp2.rank=temp2.rank+1;
            temp1.parent=temp2;
        }
    }
    
    
    
    
    
    class Node
    {
        
        int data;
        Node parent;
        int rank;
        public Node(int d)
        {
           data=d;
            rank=1;
        }
    }
}
