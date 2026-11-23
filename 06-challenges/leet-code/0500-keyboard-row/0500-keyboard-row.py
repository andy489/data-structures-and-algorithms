# https://leetcode.com/problems/keyboard-row/

class Solution:
    def findWords(self, words: list) -> list:
        rows = [set("qwertyuiop"), set("asdfghjkl"), set("zxcvbnm")]
        char_to_row = {}
        for r, row in enumerate(rows):
            for c in row:
                char_to_row[c] = r

        result = []
        for word in words:
            lower = word.lower()
            row = char_to_row[lower[0]]
            if all(char_to_row[c] == row for c in lower):
                result.append(word)
        return result
