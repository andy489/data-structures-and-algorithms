# https://leetcode.com/problems/check-if-the-sentence-is-pangram/

class Solution:
    def checkIfPangram(self, sentence: str) -> bool:
        return len(set(sentence)) == 26
