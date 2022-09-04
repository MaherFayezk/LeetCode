import java.util.HashMap;
import java.util.HashSet;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        //using HashMap 
        // initialzie the longestLength var to 0 and the left pointer to 0 
        //define a HashMap that will hold char as key and index as value
        // iterate ove the String and cheack if the char is already added to the map 
        // if the char already in the map move the left pointer forward to the position of the duplicated char or 
        // leave it at its position in cases like abba 
        // if the length of the set > longestLength replace Math.max
        // empty the set and add the new char
        // retrun the longestLength
        // TC: O(n)
        // SC : O(n)

        int length = 0;
        HashMap<Character, Integer> subsequence = new HashMap<>();

        for (int i = 0, j = 0; i < s.length(); i++) {
            if (subsequence.containsKey(s.charAt(i))) {
                j = Math.max(j, subsequence.get(s.charAt(i)) + 1);
            }
            subsequence.put(s.charAt(i), i);
            length = Math.max(length, i - j + 1);
        }

        return length;

    }
    public int lengthOfLongestSubstring2(String s) {
        //using HashSet 
        //initialzie the longestLength var to 0
        //loop over the string
        //if the char is not in the set 
            //Add the char to the set
            //if the length of the set > longestLength replace Math.max
        // else (the set contins the char )
            //remove from the list untill you remove the first repeated then add the new one next iteration 
        //retrun the longestLength
        //TC: O(n)
        //SC : O(n)
       
        int length=0, i=0,j=0;
        HashSet<Character> subsequence=new HashSet<>();
        
        while(i<s.length()){
            if(!subsequence.contains(s.charAt(i))){
                subsequence.add(s.charAt(i));
                i++;
                length=Math.max(length, subsequence.size());
            }
            else {
                subsequence.remove(s.charAt(j));
                j++;
            }
        }
        
        return length;
        
    }
}