# 1702. Maximum Binary String After Change — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/maximum-binary-string-after-change/

---

## Solution: Greedy Construction — O(n) time, O(n) space

**Idea:** The key insight is that any string of `0`s can be converted to all `1`s except one `0`. Operation 2 lets us push `1`s to the right past `0`s, and operation 1 converts `"00"` to `"10"`. All `1`s before the first `0` are fixed. For the rest, if there are `z` zeros among the remaining characters, we can get all `1`s except for exactly one `0` at position `firstZero + z - 1`.

**Algorithm:**
1. Find the index of the first `0`. All chars before it are already `1`.
2. Count total `0`s in the suffix starting from firstZero. Call it `zeros`.
3. Build result: `firstZero` ones, then `zeros - 1` ones, then one `0`, then remaining `1`s.

**Complexity:**

| | |
|---|---|
| Time | O(n) — linear scan |
| Space | O(n) — output string |
