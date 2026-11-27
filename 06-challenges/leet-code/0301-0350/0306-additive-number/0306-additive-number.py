# https://leetcode.com/problems/additive-number/

class Solution:
    def isAdditiveNumber(self, num: str) -> bool:
        n = len(num)
        for i in range(1, n // 2 + 1):
            for j in range(i + 1, n):
                a, b = num[:i], num[i:j]
                if (len(a) > 1 and a[0] == '0') or (len(b) > 1 and b[0] == '0'):
                    continue
                seq = [int(a), int(b)]
                pos = j
                while pos < n:
                    nxt = str(seq[-1] + seq[-2])
                    if not num.startswith(nxt, pos):
                        break
                    seq.append(int(nxt))
                    pos += len(nxt)
                if pos == n and len(seq) >= 3:
                    return True
        return False
