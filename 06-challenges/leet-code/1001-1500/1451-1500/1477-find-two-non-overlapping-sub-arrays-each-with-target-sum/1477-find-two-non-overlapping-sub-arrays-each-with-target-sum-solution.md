# 1477. Find Two Non Overlapping Sub Arrays Each With Target Sum — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/find-two-non-overlapping-sub-arrays-each-with-target-sum/

---

## Solution: Prefix Sum + Sliding Window — O(n) time, O(n) space

**Idea:** Use a sliding window to find subarrays with target sum. For each ending index, record shortest subarray ending there. Then combine with best from the left side.

**Algorithm:**
1. Sliding window to find valid subarrays. Record minLen[i] = min subarray length ending at i (or INF).
2. Prefix minLen: minLeft[i] = min(minLeft[i-1], minLen[i]).
3. For each valid subarray [i+1..j]: ans = min(ans, minLeft[i] + (j-i)).

**Complexity:**

| | |
|---|---|
| Time | O(n) |
| Space | O(n) |
