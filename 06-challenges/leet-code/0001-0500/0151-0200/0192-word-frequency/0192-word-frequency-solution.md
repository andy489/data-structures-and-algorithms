# 192. Word Frequency — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/word-frequency/

---

## Solution 1: tr + sort + uniq Pipeline — O(n log n) time, O(n) space

**Idea:** Normalize all whitespace to newlines so each word is on its own line, sort, count with `uniq -c`, then sort by count descending.

**Algorithm:**
1. `tr -s ' ' '\n'` — squeeze runs of spaces, replace each with a newline (one word per line).
2. `grep -v '^$'` — drop any blank lines from leading/trailing spaces.
3. `sort` — group identical words together.
4. `uniq -c` — count consecutive identical lines; outputs `  N word`.
5. `sort -rn` — sort numerically in reverse (highest count first).
6. `awk '{ print $2, $1 }'` — reorder to `word count`.

**Complexity:**

| | |
|---|---|
| Time | O(n log n) — dominated by sort |
| Space | O(n) — intermediate lines |

---

## Solution 2: awk Word-Count Map — O(n) time, O(n) space

**Idea:** Use an awk associative array to count each word in a single pass, then sort by count in the END block.

**Algorithm:**
1. For each field `$i` on each line, increment `freq[$i]`.
2. In the `END` block, pipe output through `sort -rn` externally (or use a manual sort within awk).

**Complexity:**

| | |
|---|---|
| Time | O(n) counting pass + O(k log k) sort (k = distinct words) |
| Space | O(k) — associative array |
