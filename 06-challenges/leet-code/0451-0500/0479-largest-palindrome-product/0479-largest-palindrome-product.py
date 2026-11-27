# https://leetcode.com/problems/largest-palindrome-product/

class Solution:
    def largestPalindrome(self, n: int) -> int:
        if n == 1:
            return 9
        max_val = 10 ** n - 1
        min_val = 10 ** (n - 1)
        for upper in range(max_val, min_val - 1, -1):
            s = str(upper)
            palindrome = int(s + s[::-1])
            divisor = max_val
            while divisor * divisor >= palindrome:
                if palindrome % divisor == 0:
                    other = palindrome // divisor
                    if min_val <= other <= max_val:
                        return palindrome % 1337
                divisor -= 1
        return 0
