# 1545. Find Kth Bit in Nth Binary String — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/find-kth-bit-in-nth-binary-string/

---

## Solution: Recursive Bit Identification — O(n) time, O(n) space

**Idea:** S_n has length `2^n - 1`. The middle element (position `2^(n-1)`) is always '1'. The first half is S_{n-1}. The second half is the inversion+reversal of S_{n-1}. So for k in the second half, the corresponding bit is the inverse of bit at position `len - k + 1` in S_{n-1}.

**Algorithm:**
1. Base: n=1 → '0'.
2. Compute len = `2^n - 1`, mid = `len / 2 + 1`.
3. If k == mid: return '1'.
4. If k < mid: recurse on S_{n-1} with same k.
5. If k > mid: recurse on S_{n-1} with position `len - k + 1`, then flip the result.

**Complexity:**

| | |
|---|---|
| Time | O(n) — recursion depth at most n |
| Space | O(n) — call stack |
