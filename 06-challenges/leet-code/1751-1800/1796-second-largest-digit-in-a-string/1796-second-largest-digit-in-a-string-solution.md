# 1796. Second Largest Digit in a String — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/second-largest-digit-in-a-string/

---

## Solution: Track Top Two Distinct Digits — O(n) time, O(1) space

**Idea:** Scan through the string maintaining the largest and second largest distinct digit seen so far.

**Algorithm:**
1. Initialize `first = -1`, `second = -1`.
2. For each character, if it is a digit `d`:
   - If `d > first`: update `second = first`, `first = d`.
   - Else if `d < first` and `d > second`: update `second = d`.
3. Return `second`.

**Complexity:**

| | |
|---|---|
| Time | O(n) — single pass |
| Space | O(1) — constant extra space |
