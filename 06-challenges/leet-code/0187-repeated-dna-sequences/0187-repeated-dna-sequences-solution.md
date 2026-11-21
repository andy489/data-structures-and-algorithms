# 187. Repeated DNA Sequences — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/repeated-dna-sequences/

---

## Solution 1: HashMap of Substrings — O(n) time, O(n) space

**Idea:** Slide a window of length 10 across the string, tracking how many times each substring has been seen. Add to the result set the first time the count reaches 2.

**Algorithm:**
1. If `s.length <= 10`, return empty (no room for two overlapping windows).
2. Use a `HashMap<String, Integer>` (or equivalent) to count occurrences.
3. For each start index `i` from `0` to `n - 10`:
   - Extract `sub = s.substring(i, i + 10)`.
   - Increment its count. If count becomes 2, add `sub` to result.
4. Return result list.

**Complexity:**

| | |
|---|---|
| Time | O(n) — n iterations, each `substring` + hash is O(10) = O(1) |
| Space | O(n) — up to O(n) distinct 10-char substrings stored |

---

## Solution 2: Bit-Encoding Rolling Hash — O(n) time, O(n) space

**Idea:** Encode each nucleotide as 2 bits (`A=00, C=01, G=10, T=11`), represent the 10-mer as a 20-bit integer, and use a rolling update (shift left 2, OR new bits, mask to 20 bits) to advance the window in O(1) per step — avoids string allocation entirely.

**Algorithm:**
1. Map `A→0, C→1, G→2, T→3`.
2. Build the initial hash for the first 10 characters.
3. Slide the window: `hash = ((hash << 2) | encode(s[i+10])) & MASK` where `MASK = (1 << 20) - 1`.
4. Track seen hashes in a `HashSet<Integer>`; on second occurrence decode back to the substring and add to result.

**Complexity:**

| | |
|---|---|
| Time | O(n) — O(1) per window step |
| Space | O(n) — integer hash set |
