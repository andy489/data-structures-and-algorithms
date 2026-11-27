# https://leetcode.com/problems/split-array-into-fibonacci-sequence/

class Solution:
    def splitIntoFibonacci(self, num: str) -> list[int]:
        def backtrack(idx, seq):
            if idx == len(num) and len(seq) >= 3:
                return True
            for end in range(idx + 1, len(num) + 1):
                part = num[idx:end]
                if len(part) > 1 and part[0] == '0':
                    break
                val = int(part)
                if val > 2**31 - 1:
                    break
                if len(seq) >= 2 and val != seq[-1] + seq[-2]:
                    if val > seq[-1] + seq[-2]:
                        break
                    continue
                seq.append(val)
                if backtrack(end, seq):
                    return True
                seq.pop()
            return False

        seq = []
        backtrack(0, seq)
        return seq
