class Solution {
    List<String> sentences = new ArrayList();
    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet(wordDict);
         wordBreak(wordSet, s, 0, "");
         return sentences;
    }

    private void wordBreak(Set<String> wordSet, String s, int pos, String sentence){
        if(pos==s.length()){
            sentences.add(sentence);
            return;
        }
        for(int i=pos; i<s.length(); i++){
            String word= s.substring(pos, i+1);
            if(wordSet.contains(word)){
                if(sentence.length() == 0){
                     wordBreak(wordSet, s, i+1, sentence + word);
                }else {
                    wordBreak(wordSet, s, i+1, sentence +" "+ word);
                }
            }
        }
    }
}
//TC O(2^n)