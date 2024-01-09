// https://leetcode.com/problems/implement-trie-prefix-tree/description/

class Trie {
    class TrieNode {
        TrieNode[] children;
        boolean isEndOfWord;

        TrieNode() {
            isEndOfWord = false;
            children = new TrieNode[26];
        }
    }
    TrieNode root;
    public Trie() {
        root = new TrieNode();
    }
    public void insert(String word) {
        TrieNode crawler = root;
        for (int i=0; i<word.length();i++) {
            int index = word.charAt(i) - 'a';
            if (crawler.children[index] == null)
                crawler.children[index] = new TrieNode();
            crawler = crawler.children[index];
        }
        crawler.isEndOfWord = true;
    }
    
    public boolean search(String word) {
        TrieNode crawler = root;
        for (int i=0; i<word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (crawler.children[index] == null)
                return false;
            crawler = crawler.children[index];
        }
        return crawler.isEndOfWord;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode crawler = root;
        int i = 0;
        for (; i<prefix.length(); i++) {
            int index = prefix.charAt(i) - 'a';
            if (crawler.children[index] == null)
                return false;
            crawler = crawler.children[index];
        }
        return i==prefix.length();
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */