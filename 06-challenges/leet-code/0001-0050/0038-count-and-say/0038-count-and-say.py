# https://leetcode.com/problems/count-and-say/

class Solution:
    def countAndSay(self, n: int) -> str:
        current = "1"
        for _ in range(n - 1):
            result = []
            i = 0
            while i < len(current):
                ch = current[i]
                j = i
                while j < len(current) and current[j] == ch:
                    j += 1
                result.append(str(j - i))
                result.append(ch)
                i = j
            current = "".join(result)
        return current
