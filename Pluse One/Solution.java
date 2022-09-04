class Solution {
    public int[] plusOne(int[] digits) {
        int digitsLen=digits.length;
        int carry=0;
        for(int i=digitsLen-1; i>=0;i--){
            if(digits[i]==9){
                digits[i]=0;
                carry=1;
            }
            else {
                digits[i]=digits[i]+1;
                carry=0;
                break;
            }
        }
        if(carry==1){
            int [] newDigits= new int[digitsLen+1]; 
            newDigits[0]=1;
            return newDigits;
        }
        return digits;
    }
}