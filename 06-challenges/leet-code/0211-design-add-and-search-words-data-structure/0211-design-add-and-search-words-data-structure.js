// https://leetcode.com/problems/design-add-and-search-words-data-structure/

// Solution: Trie + DFS for '.' wildcard
class WordDictionary {
    constructor() {
        this.root = { children: {}, isEnd: false };
    }

    addWord(word) {
        let node = this.root;
        for (const c of word) {
            if (!node.children[c]) {
                node.children[c] = { children: {}, isEnd: false };
            }
            node = node.children[c];
        }
        node.isEnd = true;
    }

    search(word) {
        return this._dfs(word, 0, this.root);
    }

    _dfs(word, pos, node) {
        if (pos === word.length) return node.isEnd;
        const c = word[pos];
        if (c === '.') {
            return Object.values(node.children).some(child => this._dfs(word, pos + 1, child));
        }
        if (!node.children[c]) return false;
        return this._dfs(word, pos + 1, node.children[c]);
    }
}
