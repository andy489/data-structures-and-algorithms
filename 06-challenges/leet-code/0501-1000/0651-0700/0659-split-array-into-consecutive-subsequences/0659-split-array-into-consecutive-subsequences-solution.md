# 659. Split Array into Consecutive Subsequences — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/split-array-into-consecutive-subsequences/

---

## Solution: Greedy with Two Maps — O(n) time, O(n) space

**Idea:** Use a frequency map and an "appendFreq" map. For each number, prefer appending to an existing sequence rather than starting a new one. A new sequence can start only if the next two numbers exist.

**Algorithm:**
1. Build `freq` map of counts.
2. For each `num`: if appendFreq[num] > 0, decrement appendFreq[num] and increment appendFreq[num+1].
3. Else if freq[num] > 0 and freq[num+1] > 0 and freq[num+2] > 0: start new sequence, decrement those three, increment appendFreq[num+3].
4. Otherwise return false.

**Complexity:**

| | |
|---|---|
| Time | O(n) |
| Space | O(n) |
