class Solution {
    TreeNode parent=null;
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        HashMap<Integer,Integer> hashmap=new HashMap<Integer,Integer>();
        for(int i=0;i<nums.length;i++)
        {
            hashmap.put(nums[i],i);
        }
    if(nums==null)
    {
        return parent;
    }
        else
        {
        return createTree(nums,0,nums.length,hashmap);  
            
        }
    
    }
    
    public TreeNode createTree( int[] nums,int min, int max                                                                  ,HashMap<Integer,Integer> hashmap)
    {
        if(min==max)
        { 
            return null;
        }
        
        int max1=sortTheSubArray(nums,min,max);
        int index=hashmap.get(max1);
        //System.out.println("index is"+index);
        TreeNode temp=new TreeNode(max1);
        temp.left= createTree(nums,min,index,hashmap);
        temp.right=createTree(nums,index+1,max,hashmap);
        return temp;
    }
     
    
    public int sortTheSubArray(int[] nums, int min, int max)
    {
        
            ArrayList<Integer> arraylist=new ArrayList<Integer>();
            System.out.println("min is"+min);
            System.out.println("max is"+max);
            for(int i=min;i<max;i++)
            {
                arraylist.add(nums[i]);
            }
            Collections.sort(arraylist);
            return arraylist.get(arraylist.size()-1);
        
        
    }
}
