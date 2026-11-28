# https://leetcode.com/problems/longest-common-prefix-of-k-strings-after-removal/

class Solution:
    def longestCommonPrefix(self, words: list[str], k: int) -> list[int]:
        from collections import defaultdict

        # Trie node: children dict + count
        trie = {}

        def insert(word, delta):
            node = trie
            node['#'] = node.get('#', 0) + delta
            for c in word:
                if c not in node:
                    node[c] = {}
                node = node[c]
                node['#'] = node.get('#', 0) + delta

        def query(k):
            node = trie
            depth = 0
            while True:
                found = False
                for c in 'abcdefghijklmnopqrstuvwxyz':
                    if c in node and node[c].get('#', 0) >= k:
                        node = node[c]
                        depth += 1
                        found = True
                        break
                if not found:
                    break
            return depth

        n = len(words)
        for word in words:
            insert(word, 1)

        answer = []
        for i in range(n):
            if n - 1 < k:
                answer.append(0)
                continue
            insert(words[i], -1)
            answer.append(query(k))
            insert(words[i], 1)
        return answer
