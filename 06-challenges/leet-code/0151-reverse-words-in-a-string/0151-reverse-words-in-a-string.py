# https://leetcode.com/problems/reverse-words-in-a-string/

# Solution 1: Split + reverse — O(n) time, O(n) space
class Solution:
    def reverseWords(self, s: str) -> str:
        return ' '.join(reversed(s.split()))


# Solution 2: Reverse all then reverse each word — O(n) time, O(n) space
class Solution2:
    def reverseWords(self, s: str) -> str:
        arr = list(s.strip())
        n = len(arr)

        def reverse(lo: int, hi: int) -> None:
            while lo < hi:
                arr[lo], arr[hi] = arr[hi], arr[lo]
                lo += 1
                hi -= 1

        reverse(0, n - 1)
        start = write = 0
        while start < n:
            while start < n and arr[start] == ' ':
                start += 1
            if start == n:
                break
            if write > 0:
                arr[write] = ' '
                write += 1
            end = start
            while end < n and arr[end] != ' ':
                arr[write] = arr[end]
                write += 1
                end += 1
            reverse(write - (end - start), write - 1)
            start = end
        return ''.join(arr[:write])
