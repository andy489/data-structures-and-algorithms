# 1647. Minimum Deletions to Make Character Frequencies Unique — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/minimum-deletions-to-make-character-frequencies-unique/

---

## Solution: Greedy with Seen-Frequencies Set — O(n) time, O(1) space

**Idea:** Count frequencies, then for each frequency (sorted descending), if it is already used, keep decrementing it by 1 (each decrement = one deletion) until it reaches 0 or finds an unused slot.

**Algorithm:**
1. Count character frequencies.
2. Sort frequencies in descending order.
3. Use a set `seen` of taken frequencies.
4. For each frequency `f`:
   - While `f > 0` and `f` is in `seen`: `f--`, `deletions++`.
   - Add `f` to `seen`.
5. Return total deletions.

**Complexity:**

| | |
|---|---|
| Time | O(n + 26 * max_freq) ≈ O(n) for the fixed 26-char alphabet |
| Space | O(26) = O(1) |
