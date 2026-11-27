# https://leetcode.com/problems/substring-with-concatenation-of-all-words/

# Solution: Sliding Window with Frequency Maps — O(n · k) time, O(k) space
class Solution:
    def findSubstring(self, s: str, words: list[str]) -> list[int]:
        n, k, w = len(s), len(words), len(words[0])
        need = {}
        for word in words:
            need[word] = need.get(word, 0) + 1

        result = []

        for i in range(w):
            have = {}
            left = i
            matched = 0

            for right in range(i, n - w + 1, w):
                cur = s[right:right + w]

                if cur not in need:
                    have.clear()
                    matched = 0
                    left = right + w
                    continue

                have[cur] = have.get(cur, 0) + 1
                if have[cur] == need[cur]:
                    matched += 1

                while have[cur] > need[cur]:
                    left_word = s[left:left + w]
                    if have[left_word] == need[left_word]:
                        matched -= 1
                    have[left_word] -= 1
                    left += w

                if matched == len(need):
                    result.append(left)

        return result
