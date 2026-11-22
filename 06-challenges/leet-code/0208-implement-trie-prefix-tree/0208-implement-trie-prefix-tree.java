// https://leetcode.com/problems/implement-trie-prefix-tree/

// Solution: Array-backed TrieNode — O(m) per operation, O(ALPHABET·m·n) space
class Trie {
    private static class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isEnd;
    }

    private final TrieNode root = new TrieNode();

    public void insert(String word) {
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
        TrieNode node = traverse(word);
        return node != null && node.isEnd;
    }

    public boolean startsWith(String prefix) {
        return traverse(prefix) != null;
    }

    private TrieNode traverse(String s) {
        TrieNode node = root;

        for (char c : s.toCharArray()) {
            node = node.children[c - 'a'];

            if (node == null) {
                return null;
            }
        }

        return node;
    }
}
