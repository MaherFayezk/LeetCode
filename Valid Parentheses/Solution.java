import java.util.Stack;
class Solution {
 public boolean isValid(String s) {
//Create a stack to hold the closing parentheses
//iterate over the String 
//if the parenthes is an opening one add its closing 
//if it is a closing one check if it equals the peek of the stack 
//if the stack is empty or the parenthes != peek return false otherwise pop
//finally check if the sack empty retrun true otherwise false
//TC : O(n) 
//SC: O(n)
     if(s.length()<2){
         return false;
     }
       Stack<Character> holder = new Stack<Character>();
        for (char c : s.toCharArray()) {
            if(c== '('){
                 holder.push(')');
            }
            else if(c== '['){
                 holder.push(']');
            }
            else if(c=='{'){
                holder.push('}');
            }
                    
            else if (holder.isEmpty()|| c != holder.peek()) {
                return false;
            }
            else  {
                holder.pop();
            }
        }

        if (!holder.isEmpty()) {
            return false;
        }
        return true;
    }





}