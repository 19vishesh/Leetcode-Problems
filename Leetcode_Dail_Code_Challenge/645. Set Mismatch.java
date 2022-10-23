// You have a set of integers s, which originally contains all the numbers from 1 to n. Unfortunately, due to some error, one of the numbers in s got duplicated to another number in the set, which results in repetition of one number and loss of another number.

// You are given an integer array nums representing the data status of this set after the error.

// Find the number that occurs twice and the number that is missing and return them in the form of an array.

 

// Example 1:

// Input: nums = [1,2,2,4]
// Output: [2,3]
// Example 2:

// Input: nums = [1,1]
// Output: [1,2]
 

// Constraints:

// 2 <= nums.length <= 104
// 1 <= nums[i] <= 104

class Solution {
    public int[] findErrorNums(int[] nums) {
        int[] res = new int[2];
        
        Map<Integer, Integer> map = new HashMap<>();
        for(int var : nums)
            map.put(var, map.getOrDefault(var, 0)+1);       
        
        for(int var : map.keySet()){
            if(map.get(var)==2){
                res[0] = var; break;
            }
        }
        // int repeatedElmt = getkey(map, 2);
        // res[0] = repeatedElmt;
        
        for(int i=1; i<=nums.length; i++){
            if(!map.containsKey(i)){
                res[1] = i; break;
            }
        }
        
        return res;
    }
    
    // Function to get KeyValue
    public static Integer getkey(Map<Integer, Integer> map, Integer value){
        for(Map.Entry<Integer, Integer> ent : map.entrySet()){
            if(value.equals(ent.getValue()))
                return ent.getKey();
        }
        return null;
    }
}
