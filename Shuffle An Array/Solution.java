class Solution {
    int [] nums;
    int [] original;
    Random rand = new Random();

    private int getRandomInRange(int max, int min){
        return rand.nextInt(max - min)+min;
    }
    private void swapByIndex(int i, int j){
        int temp = this.nums[i]; 
        this.nums[i]=this.nums[j];
        this.nums[j] = temp;
    }
    public Solution(int[] nums) {
        this.nums=nums;
        this.original= nums.clone();
        
    }
    
    public int[] reset() {
        this.nums=this.original;
        this.original=original.clone();
        return this.nums;
    }
    
    public int[] shuffle() {
        for(int i=0; i< this.nums.length; i++){
            int random= getRandomInRange(nums.length, i);
            swapByIndex(i,random);
        }
        return this.nums;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */