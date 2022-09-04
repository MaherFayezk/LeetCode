import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        HashMap<String, List<String>> map= new HashMap<>();
        List<List<String>> result= new ArrayList();
        for(String str:strs){
            char[] tempArr=str.toCharArray();
            Arrays.sort(tempArr);
            String sortedStr=new String (tempArr);
            if(map.containsKey(sortedStr)){
                map.get(sortedStr).add(str);
            }
            else {
                List<String> newList=new ArrayList();
                newList.add(str);
                map.put(sortedStr, newList);
            }
        }
        
        for(String key:map.keySet()){
            result.add(map.get(key));
        }
        
        return result;
        //this solution will take a SC : O(n)
        //And TC O(n*klogk) where k is the length of largest String 
        // klogk for sorting the String and n for iterating for strs
    }
 public List<List<String>> groupAnagrams2(String[] strs) {
        
        HashMap<String, List<String>> map= new HashMap<>();
        
        for(String str:strs){
            int[] tempArr=new int[26];
            
            for(int i=0;i<str.length();i++){
                tempArr[str.charAt(i)-'a']++;
            }
            
            String strKey=Arrays.toString(tempArr);
            if(!map.containsKey(strKey)){
                map.put(strKey, new ArrayList<>());
            }
            map.get(strKey).add(str);
        }
        
        return new ArrayList(map.values());
        //this is another approach where we store the number of each char occurence in an
        // array each position represent a char ex a->index 0 so in index 0 store # of occurneces
        //
    }
    
    
}