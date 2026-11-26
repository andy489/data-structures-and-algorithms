# 402. Remove K Digits — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/remove-k-digits/

---

## Solution: Monotonic Stack (Greedy) — O(n) time, O(n) space

**Idea:** Use a monotone increasing stack. For each digit, pop from the stack while the top is larger than the current digit and we still have removals left. This greedily removes higher digits in more significant positions.

**Algorithm:**
1. Iterate through each digit; maintain a monotone increasing stack.
2. While stack is non-empty, top > current digit, and k > 0: pop the stack and decrement k.
3. Push current digit.
4. If k > 0 after the loop, remove k trailing digits.
5. Strip leading zeros; return "0" if empty.

**Complexity:**

| | |
|---|---|
| Time | O(n) — each digit pushed/popped at most once |
| Space | O(n) — stack |
