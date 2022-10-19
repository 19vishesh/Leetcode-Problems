// Given an array of strings words and an integer k, return the k most frequent strings.

// Return the answer sorted by the frequency from highest to lowest. Sort the words with the same frequency by their lexicographical order.

 

// Example 1:

// Input: words = ["i","love","leetcode","i","love","coding"], k = 2
// Output: ["i","love"]
// Explanation: "i" and "love" are the two most frequent words.
// Note that "i" comes before "love" due to a lower alphabetical order.
// Example 2:

// Input: words = ["the","day","is","sunny","the","the","the","sunny","is","is"], k = 4
// Output: ["the","is","sunny","day"]
// Explanation: "the", "is", "sunny" and "day" are the four most frequent words, with the number of occurrence being 4, 3, 2 and 1 respectively.
 

// Constraints:

// 1 <= words.length <= 500
// 1 <= words[i].length <= 10
// words[i] consists of lowercase English letters.
// k is in the range [1, The number of unique words[i]]
 

// Follow-up: Could you solve it in O(n log(k)) time and O(n) extra space?

class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        
        ArrayList<String> res = new ArrayList<>();        
        TreeMap<String, Integer> map = new TreeMap<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int i=0; i<words.length; i++)
           map.put(words[i], map.getOrDefault(words[i], 0)+1);
               
        for(int var : map.values())
            pq.add(var);     
        
        while(k-->0){
            int a = pq.poll();
            res.add(getKey(map, a));
            map.remove(getKey(map, a));
        }
        
        return res;
    }
    
    public static <K, V> K getKey(Map<K, V> map, V value)
    {
        for (Map.Entry<K, V> entry: map.entrySet())
        {
            if (value.equals(entry.getValue())) {
                return entry.getKey();
            }
        }
        return null;
    }
}
