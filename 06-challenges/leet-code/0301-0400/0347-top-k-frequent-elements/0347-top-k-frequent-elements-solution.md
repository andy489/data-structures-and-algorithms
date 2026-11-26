# 347. Top K Frequent Elements — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/top-k-frequent-elements/

---

## Solution: Bucket Sort — O(n) time, O(n) space

**Idea:** Count frequencies, then use bucket sort where bucket index = frequency. Collect from highest frequency bucket down until we have k elements.

**Algorithm:**
1. Count frequencies in a HashMap.
2. Create `n+1` buckets (index = frequency). Place each number in its frequency bucket.
3. Scan from bucket `n` down to `1`, collecting elements until we have k.

**Complexity:**

| | |
|---|---|
| Time | O(n) |
| Space | O(n) |

---

## Solution 2: Min-Heap — O(n log k) time, O(n + k) space

**Idea:** Count frequencies, then maintain a min-heap of size k. Faster for small k.

**Complexity:**

| | |
|---|---|
| Time | O(n log k) |
| Space | O(n + k) |
