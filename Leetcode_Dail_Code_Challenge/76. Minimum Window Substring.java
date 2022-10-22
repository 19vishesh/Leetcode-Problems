// Given two strings s and t of lengths m and n respectively, return the minimum window substring of s such that every character in t (including duplicates) is included in the window. If there is no such substring, return the empty string "".

// The testcases will be generated such that the answer is unique.

// A substring is a contiguous sequence of characters within the string.

 

// Example 1:

// Input: s = "ADOBECODEBANC", t = "ABC"
// Output: "BANC"
// Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.
// Example 2:

// Input: s = "a", t = "a"
// Output: "a"
// Explanation: The entire string s is the minimum window.
// Example 3:

// Input: s = "a", t = "aa"
// Output: ""
// Explanation: Both 'a's from t must be included in the window.
// Since the largest window of s only has one 'a', return empty string.
 

// Constraints:

// m == s.length
// n == t.length
// 1 <= m, n <= 105
// s and t consist of uppercase and lowercase English letters.
 

// Follow up: Could you find an algorithm that runs in O(m + n) time?

class Solution {
    public static String minWindow(String s, String t) {
        if (s.length() == 0 || t.length() == 0) {
            return "";
        }

        int[] map = new int[128];
        for (char c : t.toCharArray()) {
            map[c]++;
        }

        int left = 0, right = 0, minLeft = 0, minLen = Integer.MAX_VALUE, counter = t.length();

        while (right < s.length()) {
            char c = s.charAt(right);
            if (map[c] > 0) {
                counter--;
            }
            map[c]--;
            right++;

            while (counter == 0) {
                if (right - left < minLen) {
                    minLeft = left;
                    minLen = right - left;
                }
                char c2 = s.charAt(left);
                map[c2]++;
                if (map[c2] > 0) {
                    counter++;
                }
                left++;
            }
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(minLeft, minLeft + minLen);
    }
}
