///////////////////////////// To Review //////////////////////////////  
//https://leetcode.com/problems/decode-string/description/
/*Given an encoded string, return its decoded string.

The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.

You may assume that the input string is always valid; there are no extra white spaces, square brackets are well-formed, etc. Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there will not be input like 3a or 2[4].

The test cases are generated so that the length of the output will never exceed 105.

 

Example 1:

Input: s = "3[a]2[bc]"
Output: "aaabcbc"
Example 2:

Input: s = "3[a2[c]]"
Output: "accaccacc"
Example 3:

Input: s = "2[abc]3[cd]ef"
Output: "abcabccdcdcdef"
*/
//TC O(n*K)
//SC O(n)
class Solution {
    public String decodeString(String s) {
      
        
        Stack<Integer> numStack=new Stack<>();
        Stack<String> stringStack=new Stack<>();
        StringBuilder sb=new StringBuilder();
        StringBuilder temp=new StringBuilder();
        int len=s.length();
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(Character.isDigit(ch)){
                int num=ch-'0';
                while(i+1<len && Character.isDigit(s.charAt(i+1))){
                    num=num*10+s.charAt(i+1)-'0';
                    i++;
                }
                numStack.push(num);
            }
            else if(s.charAt(i)=='['){
                stringStack.push(sb.toString());
                sb=new StringBuilder();
            }
            else if(s.charAt(i)==']'){
                int num=numStack.pop();
                temp.append(stringStack.pop());
                for(int j=0;j<num;j++){
                    temp.append(sb.toString());
                }
                sb=temp;
                temp=new StringBuilder();
            }
            else {
                sb.append(ch);
            }
        }
       return sb.toString(); 
    }
}