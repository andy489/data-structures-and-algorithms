# https://leetcode.com/problems/word-search-ii/

class TrieNode:
    def __init__(self):
        self.children: dict[str, 'TrieNode'] = {}
        self.word: str | None = None

class Solution:
    def findWords(self, board: list[list[str]], words: list[str]) -> list[str]:
        root = TrieNode()
        for w in words:
            node = root
            for c in w:
                if c not in node.children:
                    node.children[c] = TrieNode()
                node = node.children[c]
            node.word = w

        m, n = len(board), len(board[0])
        result: list[str] = []

        def dfs(r: int, c: int, node: TrieNode) -> None:
            if r < 0 or r >= m or c < 0 or c >= n:
                return
            ch = board[r][c]
            if ch == '#' or ch not in node.children:
                return
            node = node.children[ch]
            if node.word:
                result.append(node.word)
                node.word = None
            board[r][c] = '#'
            for dr, dc in ((1, 0), (-1, 0), (0, 1), (0, -1)):
                dfs(r + dr, c + dc, node)
            board[r][c] = ch

        for r in range(m):
            for c in range(n):
                dfs(r, c, root)
        return result
