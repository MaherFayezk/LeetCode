class Solution {
    public int strStr(String haystack, String needle) {
        int firstOcc=-1; 
        if(needle.length()>haystack.length()){
            return -1;
        }else if(needle.equals(haystack)){
            return 0;
        }
        for(int i=0; i<haystack.length(); i++){
            if(haystack.charAt(i)==needle.charAt(0)){
                int needleLen=needle.length();
                if(doesStr1ContainsStr2(haystack, needle, i, needleLen)){
                    firstOcc=i;
                    break;
                }
            }
        }
        return firstOcc;
    }
    private boolean doesStr1ContainsStr2(String str1, String str2, int index, int str2Len){
        return (index+str2Len <=str1.length() && str2.equals(str1.substring(index, index+str2Len)));
    }
}