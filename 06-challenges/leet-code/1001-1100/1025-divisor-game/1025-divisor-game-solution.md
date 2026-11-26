# 1025. Divisor Game — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/divisor-game/

---

## Solution: Math — O(1) time, O(1) space

**Idea:** Alice wins if and only if n is even. With even n, Alice picks x=1 (odd), leaving odd n for Bob; from odd n, any divisor is odd, odd−odd=even, so Alice always gets even again. With odd n, all divisors are odd, odd−odd=even, so Bob gets even.

**Complexity:**

| | |
|---|---|
| Time | O(1) |
| Space | O(1) |
