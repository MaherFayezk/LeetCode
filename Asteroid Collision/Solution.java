//To review

class Solution {

    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for(int a: asteroids){
            while(!stack.isEmpty() && a<0 && stack.peek()>0){
                int diff = a+stack.peek();
                if(diff<0){
                    stack.pop();
                } else if(diff>0){
                    a=0;
                } else {
                    a=0;
                    stack.pop();
                }
            }
            if(a!=0) stack.push(a);
        }
        int[] res = new int[stack.size()];
        for(int i=res.length-1;i>=0;i--){
            res[i] = stack.pop();
        }
        return res;
        
    }
}