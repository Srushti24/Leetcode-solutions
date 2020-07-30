class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> count=new HashMap<String,Integer>();
        for(int i=0;i<words.length;i++)
        {
            count.put(words[i],count.getOrDefault(words[i],0)+1);
        }
        PriorityQueue<String> heap=new PriorityQueue<String>(
            (w1,w2)->count.get(w1).equals(count.get(w2))?
            w2.compareTo(w1): count.get(w1)-count.get(w2) );
        
        
        for (String word: count.keySet()) {
            heap.offer(word);
            if (heap.size() > k) heap.poll();
        }

        List<String> ans = new ArrayList();
        while (!heap.isEmpty()) ans.add(heap.poll());
        Collections.reverse(ans);
        return ans;
    }
}
