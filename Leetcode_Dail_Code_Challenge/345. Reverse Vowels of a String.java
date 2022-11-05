// Given a string s, reverse only all the vowels in the string and return it.

// The vowels are 'a', 'e', 'i', 'o', and 'u', and they can appear in both lower and upper cases, more than once.

 

// Example 1:

// Input: s = "hello"
// Output: "holle"
// Example 2:

// Input: s = "leetcode"
// Output: "leotcede"
 

// Constraints:

// 1 <= s.length <= 3 * 105
// s consist of printable ASCII characters.
  
  class Solution {
    public String reverseVowels(String s) {
        
        char[] ch = s.toCharArray();    // Converting string into char array    
        int i=0, j=s.length()-1;        // Stating i at start, and j at end
        
        List<Character> list = Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');
        
        while(i < j){
            if(!list.contains(ch[i]))
                i++;
            if(!list.contains(ch[j]))
                j--;
            
            if(i < j){
                if(list.contains(ch[i]) && list.contains(ch[j])){
                    swap(ch, i, j);
                    i++; j--;
                }
            }
        }
        return (new String(ch));       // return the string
    }
    
    // Function for swaping
    public static void swap(char[] ch, int i, int j){
        char temp = ch[i];
        ch[i] = ch[j];
        ch[j] = temp;
    }
}
