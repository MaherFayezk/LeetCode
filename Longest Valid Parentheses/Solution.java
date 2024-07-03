/////////////////// To Review ///////////////////////////
/*  V2 should use DP
https://leetcode.com/problems/longest-valid-parentheses/description/
Given a string containing just the characters '(' and ')', return the length of the longest valid (well-formed) parentheses 
substring
Example 1:

Input: s = "(()"
Output: 2
Explanation: The longest valid parentheses substring is "()".
Example 2:

Input: s = ")()())"
Output: 4
Explanation: The longest valid parentheses substring is "()()".
Example 3:

Input: s = ""
Output: 0
*/

class Solution {
    public int longestValidParentheses(String s) {
        int longest = 0;
        int pLen = 0;
        Stack<Integer> temp = new Stack();
        temp.push(-1);
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(c=='(')
                temp.push(i);
            else{
                temp.pop();
                if(temp.isEmpty())
                    temp.push(i);
                else
                    longest = Math.max(longest, i-temp.peek());
                }
        }
        return longest;
    }

}