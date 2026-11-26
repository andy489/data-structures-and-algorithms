# 394. Decode String — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/decode-string/

---

## Solution: Stack — O(n · max_k) time, O(n) space

**Idea:** Use a stack to handle nested encodings. When encountering `[`, push the current string and repeat count. When encountering `]`, pop and repeat.

**Algorithm:**
1. Scan characters; build current number and string.
2. On `[`: push (currentString, currentNum) onto stack; reset both.
3. On `]`: pop (prevString, num); set current = prevString + repeat(current, num).
4. On letter: append to current string.
5. On digit: accumulate number.

**Complexity:**

| | |
|---|---|
| Time | O(n · max_k) where max_k is maximum repeat count |
| Space | O(n) — stack depth |
