# 1224. Maximum Equal Frequency — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/maximum-equal-frequency/

---

## Solution: Frequency Tracking — O(n) time, O(n) space

**Idea:** Track freq of each element, freq of freq, and max frequency. At each index, check if removing one element makes all equal.

**Algorithm:**
1. Maintain count[x] = frequency of x, cntCnt[f] = how many elements have frequency f, maxFreq.
2. After each insertion, check validity conditions.
3. Conditions: maxFreq==1, maxFreq*(cntCnt[maxFreq])==len, cntCnt[maxFreq]==1 and (maxFreq==len or maxFreq*(cntCnt[maxFreq]+1)==len)...

**Complexity:**

| | |
|---|---|
| Time | O(n) |
| Space | O(n) |
