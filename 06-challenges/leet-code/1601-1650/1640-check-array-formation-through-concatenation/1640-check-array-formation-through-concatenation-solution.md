# 1640. Check Array Formation Through Concatenation — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/check-array-formation-through-concatenation/

---

## Solution: HashMap of First Elements — O(n) time, O(n) space

**Idea:** Since all integers are distinct, index each piece by its first element. Walk through `arr`; at each position, look up whether a piece starts with `arr[i]`, then verify the full piece matches.

**Algorithm:**
1. Build a map from `pieces[j][0]` to `pieces[j]`.
2. Traverse `arr` with pointer `i`:
   - If no piece starts with `arr[i]`, return `false`.
   - Otherwise verify that all elements of the matched piece match `arr[i], arr[i+1], ...`, advancing `i`.
3. If all of `arr` is consumed, return `true`.

**Complexity:**

| | |
|---|---|
| Time | O(n) — single pass through arr |
| Space | O(n) — the map |
