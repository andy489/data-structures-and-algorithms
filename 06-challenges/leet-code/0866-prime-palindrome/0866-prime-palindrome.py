# https://leetcode.com/problems/prime-palindrome/

class Solution:
    def primePalindrome(self, n: int) -> int:
        def is_prime(x):
            if x < 2: return False
            if x < 4: return True
            if x % 2 == 0 or x % 3 == 0: return False
            i = 5
            while i * i <= x:
                if x % i == 0 or x % (i + 2) == 0:
                    return False
                i += 6
            return True

        def build_palindrome(half, length):
            s = str(half)
            if length % 2 == 1:
                return int(s + s[-2::-1])
            return int(s + s[::-1])

        for length in range(1, 10, 2):
            start = 10 ** ((length - 1) // 2)
            end = 10 ** ((length + 1) // 2)
            for half in range(start, end):
                pal = build_palindrome(half, length)
                if pal >= n and is_prime(pal):
                    return pal
        return -1
