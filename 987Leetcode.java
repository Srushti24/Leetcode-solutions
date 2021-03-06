class Solution {
    int min=Integer.MAX_VALUE;
    int max=Integer.MIN_VALUE;
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        ArrayList<ArrayList<Integer>> arraylist=new ArrayList<>();
    HashMap<Integer,ArrayList<Node>> hashmap=new HashMap<Integer,ArrayList<Node>>();          dfs(root,hashmap,0,0);
        for(int i=min;i<=max;i++)
        {
            ArrayList<Node> temp=hashmap.get(min);
            Collections.sort(temp,new Sorter());
            
        }
        
        
    }
    
    
    
    dfs(TreeNode root, HashMap<Integer,ArrayList<Node>> hashmap,int position,int level)
    {
        if(root==null)
        {
            return;
        }
        ArrayList<Node> temp=new ArrayList<Node>();
        if(hashmap.containsKey(position))
        {
            temp=hashmap.get(position);
        }
        min=min>position?position:min;
        max=max<position?position:max;
        temp.add(newNode(root.val,level));
        hashmap.put(position,temp);
         dfs(root.left, hashmap, position-1,level+1);
        dfs(root.right, hashmap, position+1,level+1);
    }
    
     class Sorter implements Comparator<Node>{
        public int compare(Node n1,Node n2)
        {
            if(n1.level!=n2.level)
            {
                return n1.level-n2.level;
            }
            else
            {
                return n1.val-n2.val;
            }
        }
    }
    
    
    
    
    
    class Node{
        int data;
        int level;
        public Node(int d, int l)
        {
            data=d;
            level=l;
        }
    }
}
