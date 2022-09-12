
class TrieNode{
    private TrieNode []links;
    private final int R=26;
    private boolean isEnd=false;
    
    public TrieNode(){
        this.links=new TrieNode[R];
    }
    
    public boolean containsKey(char ch){
        return this.links[ch-'a']!=null;
    }
    public TrieNode get(char ch){
        return this.links[ch-'a'];
    }
    public void put(char ch, TrieNode node){
        this.links[ch-'a']=node;
    }
    public void setEnd(){
        this.isEnd=true;
    }
    public boolean isEnd(){
        return this.isEnd;
    }
}

class Trie {
    private TrieNode root;
    public Trie() {
        this.root=new TrieNode();
    }
    
    public void insert(String word) {
        TrieNode node=this.root;
        for(int i =0;i<word.length();i++){
            char currentChar=word.charAt(i);
            if(!node.containsKey(currentChar)){
                node.put(currentChar, new TrieNode());
            }
            node=node.get(currentChar);
        }
        node.setEnd();
    }
    private TrieNode searchPrefix(String word){
        TrieNode node=this.root;
        for (int i=0;i<word.length();i++){
             char currentChar=word.charAt(i);
            if(!node.containsKey(currentChar)){
                return null;
            }
             node=node.get(currentChar);
        }
        return node;
    }
    public boolean search(String word) {
        TrieNode node=searchPrefix(word);
        return node!=null&&node.isEnd();
    }
    
    public boolean startsWith(String prefix) {
        return searchPrefix(prefix)!=null;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */