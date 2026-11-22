# https://leetcode.com/problems/design-add-and-search-words-data-structure/

class TrieNode:
    def __init__(self):
        self.children: dict[str, 'TrieNode'] = {}
        self.is_end = False

class WordDictionary:

    def __init__(self):
        self.root = TrieNode()

    def addWord(self, word: str) -> None:
        node = self.root
        for c in word:
            if c not in node.children:
                node.children[c] = TrieNode()
            node = node.children[c]
        node.is_end = True

    def search(self, word: str) -> bool:
        return self._dfs(word, 0, self.root)

    def _dfs(self, word: str, pos: int, node: TrieNode) -> bool:
        if pos == len(word):
            return node.is_end
        c = word[pos]
        if c == '.':
            return any(self._dfs(word, pos + 1, child) for child in node.children.values())
        if c not in node.children:
            return False
        return self._dfs(word, pos + 1, node.children[c])
