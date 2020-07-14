class Solution {
    boolean ans=false;
    public boolean checkInclusion(String s1, String s2) {
        
        HashMap<Character,Integer> hashmap=new HashMap<Character,Integer>();
        for(int i=0;i<s1.length();i++)
        {
            if(hashmap.containsKey(s1.charAt(i)))
            {
                int temp=hashmap.get(s1.charAt(i));
                hashmap.put(s1.charAt(i),temp+1);
            }
            else
            {
                hashmap.put(s1.charAt(i),1);
            }
        }
        
        for(int i=0;i<s2.length();i++)
        {
            if(hashmap.containsKey(s2.charAt(i)))
            {     
                  if(checkIncluded(i,s2,s1,hashmap))
                  {
                      return true ;
                  }
            }
            
        }
        return false;
        
    }
    
    boolean checkIncluded(int i, String s2, String s1, HashMap<Character,Integer> hashmap)
    {
      
        int temp=s1.length();
        if(i+temp-1<s2.length())
        {
        String t=s2.substring(i,i+temp);
       
         char tempArray[] = t.toCharArray(); 
          
    
        Arrays.sort(tempArray); 
        char [] array=s1.toCharArray();
        Arrays.sort(array);
        String te=new String(tempArray);
        String fe=new String(array);
       
        return te.equals(fe);
        }
        else
        {
            return false;
        }
    
    }
    
    
    
}