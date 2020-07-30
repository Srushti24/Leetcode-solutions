class Solution {
  public int widthOfBinaryTree(TreeNode root) {
        int max=0;
    if(root==null)
    {
        return 0;
    }
       
        else
        {
            Deque<TreeNode> q = new ArrayDeque<>();
              
            HashMap<TreeNode,Integer> hashmap=new HashMap<TreeNode, Integer>();
            q.offer(root);
            hashmap.put(root,0);
            while(!q.isEmpty())
            { //System.out.println("a");
                max=Math.max(max,1+hashmap.get(q.peekLast())-hashmap.get(q.peekFirst()) );
                int len=q.size();
                for(int i=len;i>0;i--)
                {
                    TreeNode temp=q.poll();
                    if(temp.left!=null)
                    {
                        q.offer(temp.left);
                         hashmap.put(temp.left,hashmap.get(temp)*2);
                    }
                    if(temp.right!=null)
                    {
                        q.offer(temp.right);
                         hashmap.put(temp.right,hashmap.get(temp)*2+1);
                    }
                }
            }
          }
        return max;
        }

    }
