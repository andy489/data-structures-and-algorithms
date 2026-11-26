# https://leetcode.com/problems/magical-string/

class Solution:
    def magicalString(self, n: int) -> int:
        if n <= 3:
            return 1
        magic = [1, 2, 2]
        head = 2
        next_digit = 1
        ones_count = 1

        while len(magic) < n:
            copies = magic[head]
            for _ in range(copies):
                if len(magic) >= n:
                    break
                magic.append(next_digit)
                if next_digit == 1:
                    ones_count += 1
            next_digit = 3 - next_digit
            head += 1

        return ones_count
