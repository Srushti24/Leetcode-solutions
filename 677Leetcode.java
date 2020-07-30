class MapSum {
  HashMap<String, Integer> hashmap;
    Trie root;
    /** Initialize your data structure here. */
    public MapSum() {
        hashmap=new HashMap<>();
        root=new Trie();
    }
    
    public void insert(String key, int val) {
        if(hashmap.containsKey(key))
        {
            insertion(key,val, hashmap.get(key));
            hashmap.put(key,val);
        }
        else
        {
            hashmap.put(key,val);
             insertion(key,val,0);
        }
    }
    
    public int sum(String prefix) {
        return returnSum(prefix);
    }
    
    
    
    
     int returnSum(String s)
     {
         Trie root1=root;
         for(int i=0;i<s.length();i++)
         {
             
           root1=root1.hashmap.get(s.charAt(i));
              if (root1 == null) return 0;
         }
         return root1.freq;
     }

    
    
    
     void insertion(String temp,int add, int delete)
     {
         if(root==null)
         {
             root=new Trie();
         }
         Trie root1=root;
         for(int i=0;i<temp.length();i++)
         {
             if(!root1.hashmap.containsKey(temp.charAt(i)))
             {
                 Trie t=new Trie();
                 root1.hashmap.put(temp.charAt(i),t);
                    
             }
            root1=root1.hashmap.get(temp.charAt(i));
            root1.freq=root1.freq+add-delete;
         }
          root1.endOfWord=true;
     }
    
    
  class Trie{
         HashMap<Character,Trie> hashmap;
         boolean endOfWord;
         int freq;
         public Trie()
         {
             freq=0;
             hashmap=new HashMap<>();
             endOfWord=false;
         }
     }   
}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */
