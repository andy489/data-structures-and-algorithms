# 2910. Minimum Number of Groups to Create a Valid Assignment — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/minimum-number-of-groups-to-create-a-valid-assignment/

---

## Solution: Frequency Count + Greedy — O(n) time, O(n) space

**Idea:** Count the frequency of each distinct value. The minimum frequency `minFreq` determines the maximum group size we can try. For each candidate group size `k` (from `minFreq` down to 1), check if all frequencies can be split into groups of size `k` or `k+1`. The number of boxes for a frequency `f` with group size `k` is `ceil(f / (k+1))` groups of size `k+1` and the rest of size `k`.

**Algorithm:**
1. Count frequencies of all values; find `minFreq`.
2. For each group size `k` from `minFreq` down to 1:
   - For each frequency `f`, compute the number of boxes: `f / (k + 1)` boxes of size `k+1` and handle remainder.
   - If valid (all frequencies can be distributed), return total boxes.
3. The check: for frequency `f` with group size `k`, we need `f % (k+1)` groups of size `k` and `f / (k+1)` groups of size `k+1`, which is valid only if `f % (k+1) == 0` or we can accommodate the remainder.

**Complexity:**

| | |
|---|---|
| Time | O(n) |
| Space | O(n) |
