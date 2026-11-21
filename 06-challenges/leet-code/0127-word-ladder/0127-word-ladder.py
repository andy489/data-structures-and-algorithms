# https://leetcode.com/problems/word-ladder/

# Solution 1: BFS — O(n·L·26) time, O(n·L) space
class Solution:
    def ladderLength(self, beginWord: str, endWord: str, wordList: list[str]) -> int:
        word_set = set(wordList)
        if endWord not in word_set:
            return 0
        from collections import deque
        queue = deque([(beginWord, 1)])
        word_set.discard(beginWord)
        while queue:
            word, steps = queue.popleft()
            for i in range(len(word)):
                for c in 'abcdefghijklmnopqrstuvwxyz':
                    if c == word[i]:
                        continue
                    nxt = word[:i] + c + word[i + 1:]
                    if nxt == endWord:
                        return steps + 1
                    if nxt in word_set:
                        word_set.discard(nxt)
                        queue.append((nxt, steps + 1))
        return 0


# Solution 2: Bidirectional BFS — O(n·L·26) time, O(n·L) space
class Solution2:
    def ladderLength(self, beginWord: str, endWord: str, wordList: list[str]) -> int:
        word_set = set(wordList)
        if endWord not in word_set:
            return 0
        front_a, front_b = {beginWord}, {endWord}
        word_set.discard(beginWord)
        word_set.discard(endWord)
        steps = 1
        while front_a and front_b:
            if len(front_a) > len(front_b):
                front_a, front_b = front_b, front_a
            steps += 1
            nxt: set[str] = set()
            for word in front_a:
                for i in range(len(word)):
                    for c in 'abcdefghijklmnopqrstuvwxyz':
                        if c == word[i]:
                            continue
                        neighbor = word[:i] + c + word[i + 1:]
                        if neighbor in front_b:
                            return steps
                        if neighbor in word_set:
                            word_set.discard(neighbor)
                            nxt.add(neighbor)
            front_a = nxt
        return 0
