# 335. Self Crossing — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/self-crossing/

---

## Solution: Case Analysis — O(n) time, O(1) space

**Idea:** A crossing can only happen in one of three geometric cases involving the last 3–6 distances. Check each case at every step.

**Algorithm:**
For index `i >= 3`, check:
1. **Case 1:** `d[i] >= d[i-2] && d[i-1] <= d[i-3]` — 4th line crosses 1st.
2. **Case 2:** `i >= 4 && d[i-1] == d[i-3] && d[i] + d[i-4] >= d[i-2]` — 5th crosses 2nd.
3. **Case 3:** `i >= 5 && d[i-2] >= d[i-4] && d[i] + d[i-4] >= d[i-2] && d[i-1] <= d[i-3] && d[i-1] + d[i-5] >= d[i-3]` — 6th crosses 3rd.

If any case matches, return `true`.

**Complexity:**

| | |
|---|---|
| Time | O(n) |
| Space | O(1) |
