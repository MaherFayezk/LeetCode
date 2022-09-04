import java.util.Stack;
class Solution {
    public String decodeString(String s) {
        //the Brute force solution to this problem is to iterate over the string 
        //if [ found, loop to find the most inner [] 
        //get the substring between [] and insert this string the number of time ex 3[a]
        
        //Better solution 
        //Create a string builder and a temp String and 2 stackes one for nums 
        //and one for characters 
        //iterate over the codeed String 
        //if char is a numm add it to the num stack 
        //else if it is [ insert what is insdie the sb to the string stack and sb=""
        //if we have ] pop from the num stack 
        //repeat whatever in sb number poped 
        //pop from string stack and add to the temp
        //append sb to the temp 
        //now empty the temp
        //else (apphabitic char) add it to the sb 
        //TC O(n*K)
        //SC O(n)
        
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