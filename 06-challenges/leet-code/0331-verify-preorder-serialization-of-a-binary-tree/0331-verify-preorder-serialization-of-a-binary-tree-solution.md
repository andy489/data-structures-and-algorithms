# 331. Verify Preorder Serialization of a Binary Tree — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/verify-preorder-serialization-of-a-binary-tree/

---

## Solution: Slot Counting — O(n) time, O(1) space

**Idea:** A null node consumes one slot but adds zero. A non-null node consumes one slot but adds two (for its children). Start with 1 slot (for root). Valid serialization ends with exactly 0 slots remaining.

**Algorithm:**
1. Split by `','`. Initialize `slots = 1`.
2. For each token: decrement `slots` by 1. If `slots < 0`, return false. If token != `'#'`, add 2.
3. Return `slots == 0`.

**Complexity:**

| | |
|---|---|
| Time | O(n) — single pass |
| Space | O(1) — ignoring input split |
