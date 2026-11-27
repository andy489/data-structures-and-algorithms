# https://leetcode.com/problems/decode-the-slanted-ciphertext/

class Solution:
    def decodeCiphertext(self, encodedText: str, rows: int) -> str:
        if rows == 1:
            return encodedText
        n = len(encodedText)
        cols = n // rows
        res = []
        for col in range(cols):
            r, c = 0, col
            while r < rows and c < cols:
                res.append(encodedText[r * cols + c])
                r += 1; c += 1
        return ''.join(res).rstrip()
