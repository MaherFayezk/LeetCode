import java.util.TreeSet;

// leetcode: https://leetcode.com/problems/is-subsequence/

class Solution {
    public boolean isSubsequence(String s, String t) {
        int p1 = 0;
        int p2 = 0;
        while(p1<s.length() && p2 < t.length()){
            if(s.charAt(p1)==t.charAt(p2))
                p1++;
            p2++;
        }
        return p1 == s.length();
    }
/*Follow up: Suppose there are lots of incoming s, say s1, s2, ..., sk where k >= 109, 
and you want to check one by one to see if t 
has its subsequence. In this scenario, how would you change your code?*/
    public boolean isSubsequence2(String s, String t) {
        Map<Character, TreeSet<Integer>> map = new HashMap();
        for(int i=0; i<t.length(); i++){
            char c= t.charAt(i);
            map.putIfAbsent(c, new TreeSet());
            map.get(c).add(i);
        }
        int index = -1;
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(map.containsKey(c) && map.get(c).higher(index) != null){
                index = map.get(c).higher(index);
            }else{
                return false;
            }
        }
        return true;
    }
}