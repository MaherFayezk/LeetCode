class Solution {
    public String longestPalindrome(String s) {
        //broute force approach generate all possible substrings and check 
        //each one of them is a palindrome takse O(n^3)
        //The best Approach is Expand around the Center Approach 
        //We have 2n-1 centers Why? because the center of even # of chars palindrome 
        //is between the chars a|a|b|b|a|a  each char can be a center and between each 2 
        //chars there is center 
        //The  idea here is, for each character, we expand around it as long as the result is a palindrome 
        // or we expand around an in between 2 characters
        //We take the max length between thoses two cases 
        //then check if this max len > the differnce between the start and end positions of the previous 
        //palindorm if yes update the positions to be start =middel position - (max len -1)/2
        // and the end is simply middel + max len/2 
        
        if(s==null || s.length()==0){
            return "";
        }
        int start=0, end=0;
        
        for(int i=0;i<s.length();i++){
            
            int len1=expandFromMiddel(s,i,i);
            int len2=expandFromMiddel(s,i,i+1);
            int maxLen=Math.max(len1,len2);
            
            if(maxLen>end -start){
                start=i-((maxLen-1)/2);
                end=i+(maxLen/2);
            }
        }
        return s.substring(start,end+1);
        
    }
    
    private int expandFromMiddel(String s, int left, int right){
        if(s==null || left>right){
            return 0;
        }
        while(left>=0 && right<s.length()&& s.charAt(left)==s.charAt(right)){
            left--;
            right++;
        }
        return right-left-1;
    }
    
}