# 739. Daily Temperatures — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/daily-temperatures/

---

## Solution: Monotonic Stack — O(n) time, O(n) space

**Idea:** Maintain a stack of indices with decreasing temperatures. For each day, pop all indices from the stack where the current temperature is warmer — their wait is `i - popped_index`.

**Algorithm:**
1. Initialize `answer` array of zeros, stack of indices.
2. For each `i`, while stack not empty and `temperatures[i] > temperatures[stack.top]`: pop index `j`, set `answer[j] = i - j`.
3. Push `i` onto stack.

**Complexity:**

| | |
|---|---|
| Time | O(n) — each index pushed/popped once |
| Space | O(n) — stack |
