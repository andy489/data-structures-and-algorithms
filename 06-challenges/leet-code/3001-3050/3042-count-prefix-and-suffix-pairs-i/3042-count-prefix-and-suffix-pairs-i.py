# https://leetcode.com/problems/count-prefix-and-suffix-pairs-i/

class Solution:
    def countPrefixSuffixPairs(self, words: list[str]) -> int:
        count = 0
        for i in range(len(words)):
            for j in range(i+1, len(words)):
                if words[j].startswith(words[i]) and words[j].endswith(words[i]):
                    count += 1
        return count
