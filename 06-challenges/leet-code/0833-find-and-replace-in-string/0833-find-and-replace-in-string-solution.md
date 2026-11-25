# 833. Find And Replace in String — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/find-and-replace-in-string/

---

## Solution: Index Mapping + Build — O(n·k) time, O(n+k) space

**Idea:** Build a replacement map from index to (source, target). Walk s left-to-right, applying replacements when found.

**Algorithm:**
1. Build map: index → (source, target) for each operation where source matches.
2. Iterate s; at each position, if replacement exists and source matches, append target and skip source length; else append s[i].

**Complexity:**

| | |
|---|---|
| Time | O(n·k) — checking source match per operation |
| Space | O(n+k) — output and map |
