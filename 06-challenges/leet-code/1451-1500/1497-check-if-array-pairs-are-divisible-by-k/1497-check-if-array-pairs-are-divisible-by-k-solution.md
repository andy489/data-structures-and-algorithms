# 1497. Check If Array Pairs Are Divisible By K — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/check-if-array-pairs-are-divisible-by-k/

---

## Solution: Remainder Frequency — O(n) time, O(k) space

**Idea:** For each pair to sum to multiple of k, their remainders must add to 0 or k. Count remainders and check pairing.

**Algorithm:**
1. Compute freq of arr[i] % k for all i.
2. freq[0] must be even.
3. For r in 1..k/2: freq[r] must equal freq[k-r].
4. If k is even: freq[k/2] must be even.

**Complexity:**

| | |
|---|---|
| Time | O(n) |
| Space | O(k) |
