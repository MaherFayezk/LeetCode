class Solution {
    
public boolean isPalindrome(String s) {
        
        int left=0,right=s.length()-1;
        
        while(left<right){
           if(!Character.isLetterOrDigit(s.charAt(left))){
               left++;
           }
            else if(!Character.isLetterOrDigit(s.charAt(right))){
                right--;
            }
            else {
                if(Character.toLowerCase(s.charAt(left))!=Character.toLowerCase(s.charAt(right))){
                    return false;
                }
                left++;
                right--;
            }
        }
        return true;
        
    }

public boolean isPalindrome2(String s) {
        
        s=cleanString(s);

        if(s.length()==1){
            return true;
        }
        s=s.toLowerCase();
        
        int left=0,right=s.length()-1;
        
        while(left<right){
            if(s.charAt(left)!=s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
        
    }
    
    String cleanString(String s){
        
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if((c>=65&& c<=90)||(c>=97 && c<=122)||(c>=48 && c<=57)){
                sb.append(c);
            }
        }
        return sb.toString();
    }
}