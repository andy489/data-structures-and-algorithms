# 1248. Count Number of Nice Subarrays — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/count-number-of-nice-subarrays/

---

## Solution: Prefix Sum — O(n) time, O(n) space

**Idea:** Replace each number with its parity (1 if odd, 0 if even), then count subarrays summing to k using prefix sums.

**Algorithm:**
1. Compute prefix parity sums.
2. Use a count map of prefix sums.
3. For each i: answer += count[prefix[i] - k].

**Complexity:**

| | |
|---|---|
| Time | O(n) |
| Space | O(n) |
