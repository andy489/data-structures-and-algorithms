# https://leetcode.com/problems/implement-trie-prefix-tree/

# Solution: Array-backed TrieNode — O(m) per operation, O(ALPHABET·m·n) space
class TrieNode:
    def __init__(self) -> None:
        self.children: list[TrieNode | None] = [None] * 26
        self.is_end = False

class Trie:
    def __init__(self) -> None:
        self.root = TrieNode()

    def insert(self, word: str) -> None:
        node = self.root

        for c in word:
            idx = ord(c) - ord('a')

            if not node.children[idx]:
                node.children[idx] = TrieNode()

            node = node.children[idx]

        node.is_end = True

    def search(self, word: str) -> bool:
        node = self._traverse(word)
        return node is not None and node.is_end

    def startsWith(self, prefix: str) -> bool:
        return self._traverse(prefix) is not None

    def _traverse(self, s: str) -> TrieNode | None:
        node = self.root

        for c in s:
            node = node.children[ord(c) - ord('a')]

            if not node:
                return None

        return node
