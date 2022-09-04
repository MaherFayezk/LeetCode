class Solution {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        String[] words = s.trim().split(" +");
        for (int i = words.length - 1; i > 0; i--) {
            sb.append(words[i] + " ");
        }
        sb.append(words[0]);

        return sb.toString();
    }

    public String reverseWords2(String s) {
        char[] str = s.toCharArray();

        reverseArray(str, 0, str.length - 1);

        int left = 0, right = 0;

        while (left < str.length && right < str.length) {
            if (str[left] != ' ') {
                right++;
                if (right < str.length && str[right] == ' ') {
                    reverseArray(str, left, right - 1);
                    left = right + 1;
                }
            } else {
                left++;
                right++;
            }

        }

        return new String(str);

    }

    private void reverseArray(char[] str, int start, int end) {
        while (start < end) {
            char temp = str[start];
            str[start] = str[end];
            str[end] = temp;
            start++;
            end--;
        }
    }

}