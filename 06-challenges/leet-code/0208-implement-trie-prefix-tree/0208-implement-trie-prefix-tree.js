// https://leetcode.com/problems/implement-trie-prefix-tree/

// Solution: Array-backed TrieNode — O(m) per operation, O(ALPHABET·m·n) space
class TrieNode {
    constructor() {
        this.children = new Array(26).fill(null);
        this.isEnd = false;
    }
}

class Trie {
    constructor() {
        this.root = new TrieNode();
    }

    insert(word) {
        let node = this.root;

        for (const c of word) {
            const idx = c.charCodeAt(0) - 97;

            if (!node.children[idx]) {
                node.children[idx] = new TrieNode();
            }

            node = node.children[idx];
        }

        node.isEnd = true;
    }

    search(word) {
        const node = this._traverse(word);
        return node !== null && node.isEnd;
    }

    startsWith(prefix) {
        return this._traverse(prefix) !== null;
    }

    _traverse(s) {
        let node = this.root;

        for (const c of s) {
            node = node.children[c.charCodeAt(0) - 97];

            if (!node) {
                return null;
            }
        }

        return node;
    }
}
