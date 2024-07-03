///////////////////////  review ///////////////////////
/*
https://leetcode.com/problems/valid-parentheses/description/
Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:
Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Every close bracket has a corresponding open bracket of the same type.
 

Example 1:

Input: s = "()"
Output: true
Example 2:

Input: s = "()[]{}"
Output: true
Example 3:

Input: s = "(]"
Output: false
*/


class Solution {
 public boolean isValid(String s) {
        Stack<Character> stack = new Stack();
        for(char c : s.toCharArray()){
            if(c=='(') 
                stack.push(')');
            else if(c=='{') 
                stack.push('}');
            else if(c=='[') 
                stack.push(']');
            else if(stack.isEmpty() || stack.pop() != c) 
                return false;
        }
        return stack.isEmpty();
    }

    public boolean isValid2(String s) {
        Stack<Character> stack = new Stack();
        Map<Character, Character> map = new HashMap();
        map.put('(', ')');
        map.put('{', '}');
        map.put('[', ']');
        for(char c : s.toCharArray()){
            if(map.containsKey(c)) 
                stack.push(c);
            else if(stack.isEmpty() || map.get(stack.pop()) != c) 
                return false;
        }
        return stack.isEmpty();
    }
}