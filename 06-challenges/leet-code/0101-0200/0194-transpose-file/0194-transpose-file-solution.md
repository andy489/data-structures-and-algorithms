# 194. Transpose File — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/transpose-file/

---

## Solution 1: `awk` — column accumulation — O(n·m) time, O(n·m) space

**Idea:** Use `awk` to accumulate each column as a space-separated string, then print all columns after processing the entire file.

**Algorithm:**
1. For each row, iterate over its fields (columns `1..NF`).
2. Append each field to the string `col[j]`, separated by a space.
3. After all rows are processed (`END`), print each `col[j]`.

**Complexity:**

| | |
|---|---|
| Time | O(n·m) — n rows × m columns |
| Space | O(n·m) — stores the entire transposed matrix in memory |

---

## Solution 2: `awk` with printf — O(n·m) time, O(n·m) space

**Idea:** Same column-accumulation strategy but uses `printf` to avoid a leading/trailing space by printing a space only *between* entries (tracks whether the first entry has been printed).

**Complexity:**

| | |
|---|---|
| Time | O(n·m) — same as Solution 1 |
| Space | O(n·m) — same as Solution 1 |

---

## Solution 3: `paste` + `tr` — O(n·m) time, O(n·m) space

**Idea:** Transpose by extracting each column with `awk` cut, then joining them with `paste`. Works cleanly but requires knowing the column count ahead of time.

**Complexity:**

| | |
|---|---|
| Time | O(n·m) — one `awk` pass per column |
| Space | O(n·m) — intermediate files or subshell output per column |
