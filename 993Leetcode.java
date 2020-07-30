/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    HashMap<Integer ,Integer> level_map;
    HashMap<Integer, TreeNode> parent_map;
   
    public boolean isCousins(TreeNode root, int x, int y) {
        
        level_map=new HashMap<Integer, Integer>();
        parent_map=new HashMap<Integer, TreeNode>();
        dfs(root,null,0);
     
        return (level_map.get(x)==level_map.get(y) && parent_map.get(x)!=parent_map.get(y));
    }
                
                
                
                void dfs(TreeNode root,TreeNode parent,int level)
                {
                    if(root==null)
                    {
                        return;
                    }
                    level_map.put(root.val,level);
                    parent_map.put(root.val,parent);
                    dfs(root.left, root,level+1);
                        dfs(root.right, root,level+1);
                }
}
