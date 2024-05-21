class Solution {
    public int myAtoi(String s) {
        int sign = 1;
        int i=0;
        int sLen= s.length();
        while(i < sLen && s.charAt(i) == ' '){
            i++;
        }
        if(i >= sLen) return 0;

        if(s.charAt(i) == '+' || s.charAt(i) == '-'){
            sign = s.charAt(i) == '+'? +1 : -1;
            i++;
        }
        if(i >= sLen) return 0;

        int num = 0;
        for(; i< sLen && s.charAt(i) >= '0' && s.charAt(i) <= '9'; i++){

            if(num > Integer.MAX_VALUE / 10 || (num == Integer.MAX_VALUE / 10 && 
            s.charAt(i) - '0' > Integer.MAX_VALUE % 10)){
                return sign == -1? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            num = num*10 + (s.charAt(i)-'0');
        }

        return num * sign;
    }
}