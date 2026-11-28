# 3498. Reverse Degree of a String — Solution

**Difficulty:** Easy  
**Link:** https://leetcode.com/problems/reverse-degree-of-a-string/

---

## Solution: Linear Scan — O(n) time, O(1) space

**Idea:** For each character at 1-indexed position `i`, its reversed-alphabet value is `27 - (c - 'a' + 1)` = `26 - (c - 'a')`. Multiply by position `i` and accumulate.

**Algorithm:**
1. Initialize `result = 0`.
2. Iterate over each character with 1-based index `i`.
3. Compute `reverseVal = 26 - (c - 'a')`.
4. Add `i * reverseVal` to `result`.
5. Return `result`.

**Complexity:**

| | |
|---|---|
| Time | O(n) |
| Space | O(1) |
