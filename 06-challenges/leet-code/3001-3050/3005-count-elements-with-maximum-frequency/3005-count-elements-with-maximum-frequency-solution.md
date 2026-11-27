# 3005. Count Elements With Maximum Frequency — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/count-elements-with-maximum-frequency/

---

## Solution: HashMap + Linear Scan — O(n) time, O(n) space

**Idea:** Count frequencies with a map, find the max frequency, then sum all frequencies equal to max.

**Algorithm:**
1. Build frequency map.
2. Find maxFreq.
3. Sum all freq[x] where freq[x] == maxFreq.
4. Return sum.

**Complexity:**

| | |
|---|---|
| Time | O(n) — O(n) — two passes |
| Space | O(n) — O(n) |
