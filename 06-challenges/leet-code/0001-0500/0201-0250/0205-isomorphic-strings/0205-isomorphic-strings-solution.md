# 205. Isomorphic Strings — Solution

**Difficulty:** Easy  
**Link:** https://leetcode.com/problems/isomorphic-strings/

---

## Solution: Bidirectional Map — O(n) time, O(1) space

**Idea:** Maintain two maps: `sToT` (s-char → t-char) and `tToS` (t-char → s-char). For each position, verify that both mappings are consistent. If a conflict is found, the strings are not isomorphic.

**Algorithm:**
1. Iterate over each index `i`.
2. Let `cs = s[i]`, `ct = t[i]`.
3. If `sToT` has `cs` mapped to something other than `ct`, return `false`.
4. If `tToS` has `ct` mapped to something other than `cs`, return `false`.
5. Record `sToT[cs] = ct` and `tToS[ct] = cs`.
6. Return `true`.

**Complexity:**

| | |
|---|---|
| Time | O(n) — single pass |
| Space | O(1) — at most 128 ASCII characters in each map |
