# https://leetcode.com/problems/happy-number/

# Solution: Floyd's cycle detection — O(log n) time, O(1) space
class Solution:
    def isHappy(self, n: int) -> bool:
        def nxt(x: int) -> int:
            s = 0
            while x:
                x, d = divmod(x, 10)
                s += d * d
            return s

        slow, fast = n, nxt(n)
        while fast != 1 and slow != fast:
            slow = nxt(slow)
            fast = nxt(nxt(fast))
        return fast == 1


# Solution 2: Hash set cycle detection — O(log n) time, O(log n) space
class Solution2:
    def isHappy(self, n: int) -> bool:
        seen = set()
        while n != 1 and n not in seen:
            seen.add(n)
            n = sum(int(d) ** 2 for d in str(n))
        return n == 1
