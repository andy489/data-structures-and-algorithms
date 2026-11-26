// https://leetcode.com/problems/design-add-and-search-words-data-structure/

// Solution: Trie + DFS for '.' wildcard — O(m) addWord, O(26^m) worst-case search
class WordDictionary {
    private static class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isEnd;
    }

    private final TrieNode root = new TrieNode();

    public void addWord(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            int idx = c - 'a';
            if (node.children[idx] == null) {
                node.children[idx] = new TrieNode();
            }
            node = node.children[idx];
        }
        node.isEnd = true;
    }

    public boolean search(String word) {
        return dfs(word, 0, root);
    }

    private boolean dfs(String word, int pos, TrieNode node) {
        if (pos == word.length()) {
            return node.isEnd;
        }
        char c = word.charAt(pos);
        if (c == '.') {
            for (TrieNode child : node.children) {
                if (child != null && dfs(word, pos + 1, child)) {
                    return true;
                }
            }
            return false;
        }
        TrieNode child = node.children[c - 'a'];
        return child != null && dfs(word, pos + 1, child);
    }
}
