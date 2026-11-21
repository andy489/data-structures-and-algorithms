# https://leetcode.com/problems/word-ladder-ii/

# Solution: BFS DAG + DFS Backtrack — O(n·L·26 + P) time, O(n·L) space
class Solution:
    def findLadders(self, beginWord: str, endWord: str, wordList: list[str]) -> list[list[str]]:
        word_set = set(wordList)
        if endWord not in word_set:
            return []

        parents: dict[str, list[str]] = {}
        current_level = {beginWord}
        found = False

        while current_level and not found:
            word_set -= current_level
            next_level: set[str] = set()
            for word in current_level:
                for i, orig in enumerate(word):
                    for c in 'abcdefghijklmnopqrstuvwxyz':
                        if c == orig:
                            continue
                        nxt = word[:i] + c + word[i + 1:]
                        if nxt in word_set:
                            next_level.add(nxt)
                            parents.setdefault(nxt, []).append(word)
                            if nxt == endWord:
                                found = True
            current_level = next_level

        ans: list[list[str]] = []
        if not found:
            return ans

        def dfs(word: str, path: list[str]) -> None:
            if word == beginWord:
                ans.append(path[::-1])
                return
            for parent in parents.get(word, []):
                path.append(parent)
                dfs(parent, path)
                path.pop()

        dfs(endWord, [endWord])
        return ans
