import java.util.Arrays;

class Solution {

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length())
            return false;

        int[] sCharOccu = new int[26];
        int[] tCharOccu = new int[26];

        for (int i = 0; i < s.length(); i++) {
            sCharOccu[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            tCharOccu[t.charAt(i) - 'a']++;
        }
        return Arrays.toString(tCharOccu).equals(Arrays.toString(sCharOccu));
    }

    // we can also solve this problem using 2 Hashmap
    // each HashMap will hold the char as key and the # of occurence as value
    // Then we compare both HashMaps

    public boolean isAnagram2(String s, String t) {
        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();
        Arrays.sort(sArr);
        Arrays.sort(tArr);
        s = new String(sArr);
        t = new String(tArr);

        return s.equals(t);
    }
}