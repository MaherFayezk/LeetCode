class Solution {
//TC O(n) 
//SC O(n)
    public int fib(int n) {
        int [] mem=new int[n+1];
        
        return fibRecursive(mem,n);
    }
    
    int fibRecursive(int[]mem, int n){
        if(n<2){
            return n;
        }
        if(mem[n]!=0){
            return mem[n];
        }
        mem[n]=fibRecursive(mem,n-1)+fibRecursive(mem,n-2);
        
        return mem[n];
    }

//Botom up approach
//TC O(n) 
//SC O(1)
 public int fib(int n) {
       if(n<2) {return n;}
        if(n==2) {return 1;}
        int fib1=1;
        int fib2=1;
        int current=0;
        for(int i=3;i<=n;i++){
            current=fib1+fib2;
            fib1=fib2;
            fib2=current;
        }
        return current;
    }
    
}