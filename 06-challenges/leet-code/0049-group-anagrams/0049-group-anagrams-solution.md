# 49. Group Anagrams — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/group-anagrams/

---

## Solution: Sort-key hash map — O(n · k log k) time, O(n · k) space

**Idea:** Two strings are anagrams iff their sorted character sequences are identical. Use a hash map keyed by the sorted string; append each word to its group. Collect and return all map values.

**Algorithm:**
1. Create a `Map<String, List<String>>`.
2. For each string `s`: sort its characters to get key `k`. Append `s` to `map.computeIfAbsent(k, x -> new ArrayList<>())`.
3. Return `new ArrayList<>(map.values())`.

**Complexity:**

| | |
|---|---|
| Time | O(n · k log k) — sorting each of n strings of length at most k |
| Space | O(n · k) — map stores all strings |

---

## Solution 2: Frequency-count key hash map — O(n · k) time, O(n · k) space

**Idea:** Instead of sorting, encode each string as a length-26 frequency count array serialised to a string `"#2#0#0...#1..."`. This avoids the log-k sort factor.

**Algorithm:**
1. For each string `s`: build a `int[26]` count array, then serialise to a canonical key string.
2. Group into the map exactly as above.

**Complexity:**

| | |
|---|---|
| Time | O(n · k) — counting characters is linear in k |
| Space | O(n · k) — same map storage |
