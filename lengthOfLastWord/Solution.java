class Solution {
    public int lengthOfLastWord(String s) {
       
        /*
        s=s.trim();
        int count=0;
        for(int i=s.length()-1;i>=0;i--){
            if(s.charAt(i)==' '){
                break;
            }
            count++;
        }
        return count;
        */
        int right=s.length()-1;
        
        while(right>=0 && s.charAt(right)==' '){
            right--;
        }
        int left=right;
        while(left>=0 && s.charAt(left)!=' '){
            left--;
        }
        return right-left;
    }
}