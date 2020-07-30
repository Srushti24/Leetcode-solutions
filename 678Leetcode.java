class Solution {
    public boolean checkValidString(String s) {
     Stack<Integer> stack=new Stack<Integer>();
     int open=0;
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)=='(')
            {
                open++;
            }
            else if(s.charAt(i)==')')
            {
                if(open>0)
                {
                    open--;
                }
                else if(!stack.isEmpty())
                {
                    stack.pop();
                }
                else
                {
                    return false;
                }
            }
            else
            {
                stack.push(i);
            }
        }
        
        if(open==0)
        {
            return true;
        }
        if( open>stack.size())
        {
            return false;
        }
       int j=s.length()-1;
        while(open>0)
        {
            if(s.charAt(j)=='(')
            {
                int temp=stack.pop();
                System.out.println("temp is"+temp);
                System.out.println("j is"+j);
                if(temp<j)
                {
                    return false;
                }
                open--;
            }
            j--;
        }
        return true;
    }
}
