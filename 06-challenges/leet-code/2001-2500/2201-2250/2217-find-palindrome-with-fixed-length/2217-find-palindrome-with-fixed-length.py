# https://leetcode.com/problems/find-palindrome-with-fixed-length/
class Solution:
    def kthPalindrome(self, queries: List[int], intLength: int) -> List[int]:
        half_len = (intLength + 1) // 2
        start = 10 ** (half_len - 1)
        end = 10 ** half_len
        answer = []
        for q in queries:
            half = start + q - 1
            if half >= end:
                answer.append(-1)
                continue
            half_str = str(half)
            skip = 1 if intLength % 2 == 1 else 0
            palindrome = int(half_str + half_str[-1 - skip::-1])
            answer.append(palindrome)
        return answer
