# 3361. Shift Distance Between Two Strings — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/shift-distance-between-two-strings/

---

## Solution: Prefix Sum on Circular Alphabet — O(n + 26) time, O(26) space

**Idea:** For each character pair `(s[i], t[i])`, we need the minimum cost to shift from `s[i]` to `t[i]` going either forward (next) or backward (previous) through the alphabet.

- **Forward cost** from `a` to `b`: sum of `nextCost[a], nextCost[(a+1)%26], ..., nextCost[(b-1+26)%26]`
- **Backward cost** from `a` to `b`: sum of `previousCost[a], previousCost[(a-1+26)%26], ..., previousCost[(b+1+26)%26]`

Computing each path naively is O(26). To speed this up, precompute prefix sums on a doubled alphabet (length 52) so any contiguous range query is O(1).

**Algorithm:**
1. Build `nextPrefix[0..51]` where `nextPrefix[i] = nextCost[i % 26]` (doubled for wrap-around).
2. For forward shift from `a` to `b` (steps = `(b - a + 26) % 26`): sum = `nextPrefix[a+1..a+steps]`.
3. Similarly build `prevPrefix` doubled (but traversed in reverse direction).
4. For backward shift from `a` to `b` (steps = `(a - b + 26) % 26`): sum = `prevPrefix[a..a+steps-1]` on reversed/doubled array.
5. For each position, add `min(forwardCost, backwardCost)` to the answer.

**Complexity:**

| | |
|---|---|
| Time | O(n + 26) — precompute prefix sums in O(26), then O(n) for all character pairs |
| Space | O(26) — prefix arrays of size 52 |
