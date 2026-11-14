# 195. Tenth Line — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/tenth-line/

---

## Solution: `sed` — select by line number — O(n) time, O(1) space

**Idea:** `sed -n '10p'` suppresses default output (`-n`) and prints only line 10. If the file has fewer than 10 lines the address never matches — nothing is printed.

**Complexity:**

| | |
|---|---|
| Time | O(n) — reads up to line 10 then exits |
| Space | O(1) — line-by-line streaming |

---

## Solution 2: `awk` — NR counter with early exit — O(n) time, O(1) space

**Idea:** The built-in `NR` (Number of Records) equals the current line number. When `NR==10`, print and `exit` immediately. If the file has fewer than 10 lines, the condition is never true — nothing is printed.

**Complexity:**

| | |
|---|---|
| Time | O(n) — reads up to line 10 then exits |
| Space | O(1) — line-by-line streaming |

---

## Solution 3: `awk` — store line 10, guard at END — O(n) time, O(1) space

**Idea:** Store the contents of line 10 in a variable as awk processes it. In the `END` block, print only if the total line count `NR >= 10` — otherwise output nothing. This correctly handles files shorter than 10 lines.

**Complexity:**

| | |
|---|---|
| Time | O(n) — reads the whole file (no early exit) |
| Space | O(1) — stores one line |

---

## Solution 4: `perl` — line counter — O(n) time, O(1) space

**Idea:** `perl -ne` reads the file line by line (`-n`) and executes the expression (`-e`) for each. `$.` is Perl's built-in line counter. Nothing is printed if the file has fewer than 10 lines.

**Complexity:**

| | |
|---|---|
| Time | O(n) — reads up to line 10 |
| Space | O(1) — line-by-line streaming |

---

## Solution 5: `bash` — while-read loop with counter — O(n) time, O(1) space

**Idea:** Pure bash, no external tools. Increment a counter on each line; when it reaches 10, print the line and `break`. `IFS=` and `-r` preserve whitespace and backslashes in the line content.

**Complexity:**

| | |
|---|---|
| Time | O(n) — reads up to line 10 then breaks |
| Space | O(1) — one line in memory |

---

## Solution 6: `mapfile` (bash 4+) — load into array, index directly — O(n) time, O(n) space

**Idea:** `mapfile -t` reads all lines into a bash array (0-indexed). Then check the array length before accessing index 9. Simple and readable, but loads the entire file into memory.

**Complexity:**

| | |
|---|---|
| Time | O(n) — reads entire file |
| Space | O(n) — whole file in memory |
