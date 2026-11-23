# https://leetcode.com/problems/reconstruct-original-digits-from-english/

class Solution:
    def originalDigits(self, s: str) -> str:
        from collections import Counter
        freq = Counter(s)
        count = [0] * 10

        count[0] = freq['z']
        count[2] = freq['w']
        count[4] = freq['u']
        count[6] = freq['x']
        count[8] = freq['g']
        count[1] = freq['o'] - count[0] - count[2] - count[4]
        count[3] = freq['h'] - count[8]
        count[5] = freq['f'] - count[4]
        count[7] = freq['s'] - count[6]
        count[9] = freq['i'] - count[5] - count[6] - count[8]

        return ''.join(str(d) * count[d] for d in range(10))
