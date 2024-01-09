// https://leetcode.com/problems/design-add-and-search-words-data-structure/

class WordDictionary {
    class TrieNode {
        TrieNode[] children;
        boolean isEndOfWord;

        TrieNode() {
            isEndOfWord = false;
            children = new TrieNode[26];
        }
    }
    TrieNode root;
    public WordDictionary() {
        root = new TrieNode();        
    }
    
    public void addWord(String word) {
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
        return searchUtil(root, word);
    }
    public boolean searchUtil(TrieNode root, String word) {
        TrieNode crawler = root;
        for (int i=0; i<word.length(); i++) {
            char currchar =  word.charAt(i);
            if (currchar == '.') {
                for (int j=0; j<26; j++) {
                    TrieNode temp = crawler.children[j];
                    if(temp != null && searchUtil(temp, word.substring(i+1)) == true) 
                        return true;
                }
                return false;
            } else if (crawler.children[currchar-'a'] == null) {
                return false;
            } 
            crawler = crawler.children[currchar-'a'];
        }
        return (crawler != null && crawler.isEndOfWord);
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */