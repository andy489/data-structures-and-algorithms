# 2030. Smallest K-Length Subsequence With Occurrences of a Letter — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/smallest-k-length-subsequence-with-occurrences-of-a-letter/

---

## Solution: Monotone Stack — O(n) time, O(k) space

**Idea:** Greedy with monotone stack. At each position decide whether to pop previous characters.

**Algorithm:**
1. Use a stack. For each char, pop if: remaining chars suffice, letter count after pop still achievable.
2. Ensure at least `repetition` letters appear.
3. Take first k from stack.

**Complexity:**

| | |
|---|---|
| Time | O(n) |
| Space | O(k) |
