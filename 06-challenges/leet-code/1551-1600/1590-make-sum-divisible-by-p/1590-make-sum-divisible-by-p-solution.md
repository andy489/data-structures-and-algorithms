# 1590. Make Sum Divisible by P — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/make-sum-divisible-by-p/

---

## Solution: Prefix Sum + HashMap — O(n) time, O(n) space

**Idea:** We need to remove the shortest subarray whose sum ≡ `totalSum % p (mod p)`. Use prefix sums modulo `p` and a hashmap to find the shortest such subarray in O(n).

**Algorithm:**
1. Compute `totalMod = sum(nums) % p`. If 0, return 0.
2. Track prefix sum mod `p` in `prefMod`, store last seen index in a map.
3. For each prefix `prefMod`, the needed prior prefix is `(prefMod - totalMod + p) % p`.
4. If found, update `minLen`. Return -1 if `minLen == n`.

**Complexity:**

| | |
|---|---|
| Time | O(n) — single pass |
| Space | O(n) — hashmap of prefix mods |
