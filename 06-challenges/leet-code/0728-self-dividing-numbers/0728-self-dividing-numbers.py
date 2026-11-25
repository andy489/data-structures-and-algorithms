# https://leetcode.com/problems/self-dividing-numbers/

class Solution:
    def selfDividingNumbers(self, left: int, right: int) -> List[int]:
        def is_self_dividing(n):
            for d in str(n):
                if d == '0' or n % int(d) != 0:
                    return False
            return True
        return [n for n in range(left, right + 1) if is_self_dividing(n)]
