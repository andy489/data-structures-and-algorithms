# 2935. Maximum Strong Pair XOR II — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/maximum-strong-pair-xor-ii/

---

## Solution: Trie with Sliding Window — O(n log C) time, O(n log C) space

**Idea:** The strong pair condition `|x - y| <= min(x, y)` is equivalent to (assuming WLOG `x <= y`) `y <= 2*x`. Sort `nums`. Use a sliding window over sorted `nums` with a pointer `l` such that `nums[l] * 2 >= nums[r]`. Maintain a trie of valid elements (sliding window). For each `r`, add `nums[r]` to the trie and remove elements from the left that violate `nums[l] * 2 < nums[r]`. Then query the trie for the maximum XOR with `nums[r]`.

**Algorithm:**
1. Sort `nums`.
2. Build a trie supporting insert, delete (count references), and max XOR query.
3. Use two-pointer: for each `r`, remove expired left elements, insert `nums[r]`, query max XOR.
4. Track global maximum.

**Complexity:**

| | |
|---|---|
| Time | O(n log C) where C = 2^20 |
| Space | O(n log C) |
