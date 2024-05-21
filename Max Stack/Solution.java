class MaxStack {
    Stack<Integer> data;
    Stack<Integer> max;

    public MaxStack() {
        // do intialization if necessary
        data = new Stack();
        max = new Stack();
    }

    /*
     * @param number: An integer
     * @return: nothing
     */    
    public void push(int x) {
        // write your code here
        data.push(x);
        if(max.isEmpty()){
            max.push(x);
        }else {
            max.push(Math.max(max.peek(), x) );
        }
    }

    public int pop() {
        // write your code here
        max.pop();
        return data.pop();
    }

    /*
     * @return: An integer
     */    
    public int top() {
        // write your code here
        return data.peek();
    }

    /*
     * @return: An integer
     */    
    public int peekMax() {
        // write your code here
        return max.peek();
    }

    /*
     * @return: An integer
     */ 
//TC O(n)
//SC O(n)   
    public int popMax() {
        // write your code here
        int res = max.peek();
        Stack<Integer> tmp = new Stack<Integer>();
        while (data.peek() != res) {
            tmp.push(data.pop());
            max.pop();
        }
        data.pop();
        max.pop();
        while (!tmp.isEmpty()) {
            push(tmp.pop());
        }
        return res;
    }
}