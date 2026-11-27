# 2914. Minimum Number of Changes to Make Binary String Beautiful — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/minimum-number-of-changes-to-make-binary-string-beautiful/

---

## Solution 1: Greedy Pair Scan — O(n) time, O(1) space

**Idea:**

A beautiful string partitions into even-length substrings of uniform characters. The cheapest strategy is to fix each consecutive pair `(s[2i], s[2i+1])` independently. If both characters in a pair are the same (`"00"` or `"11"`), it is already a valid length-2 block and costs nothing. If they differ (`"01"` or `"10"`), exactly one change is needed to make them uniform. Summing costs over all `n/2` pairs gives the global minimum, because:

- No change to a uniform pair can help a different pair.
- Changing one character in a mixed pair always costs 1 regardless of which character we pick.

**Algorithm:**
1. Iterate `i = 0, 2, 4, …, n-2`.
2. If `s[i] != s[i+1]`, increment the answer.
3. Return the answer.

**Complexity:**

| | |
|---|---|
| Time | O(n) — single pass over n/2 pairs |
| Space | O(1) — only a counter |

---

## Solution 2: Greedy Segment Scan — O(n) time, O(1) space

**Idea:**

Walk character by character tracking the current run length. Whenever the character changes, the current run ends. If the run length is odd, the trailing character cannot be paired with a same-character neighbour on the left, so we must change it (1 cost) — it then "merges" into the next run by initialising the new run length to 1 instead of 0. This is equivalent to Solution 1 but makes the partitioning structure explicit.

**Algorithm:**
1. Initialise `len = 1`, `changes = 0`.
2. For each index `i` from 1 to `n-1`:
   - If `s[i] == s[i-1]`, increment `len`.
   - Otherwise: if `len` is odd, increment `changes`; reset `len = 1`.
3. Return `changes`.

**Complexity:**

| | |
|---|---|
| Time | O(n) — single pass |
| Space | O(1) |
