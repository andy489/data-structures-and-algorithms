# 195. Tenth Line — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/tenth-line/

---

## Solution: `tail` + `head` — skip first 9 lines, take first of remainder — O(n) time, O(1) space

**Idea:** `tail -n +10` outputs every line starting from line 10 (the `+` means "start at line N"). Piping into `head -1` takes only the first of those. If the file has fewer than 10 lines, `tail -n +10` produces no output and `head -1` receives nothing — safe edge case.

**Complexity:**

| | |
|---|---|
| Time | O(n) — tail reads up to line 10, head stops after 1 line |
| Space | O(1) — streaming pipeline |

---

## Solution 2: `sed` — select by line number — O(n) time, O(1) space

**Idea:** `sed -n '10p'` suppresses default output (`-n`) and prints only line 10. If the file has fewer than 10 lines the address never matches — nothing is printed.

**Complexity:**

| | |
|---|---|
| Time | O(n) — reads up to line 10 then exits |
| Space | O(1) — line-by-line streaming |

---

## Solution 3: `awk` — NR counter with early exit — O(n) time, O(1) space

**Idea:** The built-in `NR` (Number of Records) equals the current line number. When `NR==10`, print and `exit` immediately. If the file has fewer than 10 lines, the condition is never true — nothing is printed.

**Complexity:**

| | |
|---|---|
| Time | O(n) — reads up to line 10 then exits |
| Space | O(1) — line-by-line streaming |

---

## Solution 4: `awk` — store line 10, guard at END — O(n) time, O(1) space

**Idea:** Store the contents of line 10 in a variable as awk processes it. In the `END` block, print only if the total line count `NR >= 10` — otherwise output nothing. Reads the whole file but correctly handles the short-file edge case.

**Complexity:**

| | |
|---|---|
| Time | O(n) — reads the whole file (no early exit) |
| Space | O(1) — stores one line |

---

## Solution 5: `perl` — line counter — O(n) time, O(1) space

**Idea:** `perl -ne` reads the file line by line (`-n`) and executes the expression (`-e`) for each. `$.` is Perl's built-in line counter. Nothing is printed if the file has fewer than 10 lines.

**Complexity:**

| | |
|---|---|
| Time | O(n) — reads up to line 10 |
| Space | O(1) — line-by-line streaming |

---

## Solution 6: `grep` + process substitution — O(n) time, O(1) space

**Idea:** Process substitution `<(tail -n +10 file.txt)` feeds the output of `tail -n +10` as a file descriptor to `grep`. `-m1 ""` matches any line and stops after the first match — equivalent to `head -1`. Safe: if `tail` produces nothing, `grep` matches nothing.

**Complexity:**

| | |
|---|---|
| Time | O(n) — tail reads up to line 10, grep stops after first match |
| Space | O(1) — streaming |

---

## Solution 7: `bash` — while-read loop with counter — O(n) time, O(1) space

**Idea:** Pure bash, no external tools. Increment a counter on each line; when it reaches 10, print the line and `break`. `IFS=` and `-r` preserve whitespace and backslashes in the line content.

**Complexity:**

| | |
|---|---|
| Time | O(n) — reads up to line 10 then breaks |
| Space | O(1) — one line in memory |

---

## Solution 8: `bash` — arithmetic built-in increment, no subshell — O(n) time, O(1) space

**Idea:** Same while-read loop as Solution 7 but replaces `$((cnt+1))` (arithmetic expansion, creates a subshell) and `[ ]` (forks an external process) with `(( ++cnt == 10 ))` — a single bash built-in arithmetic evaluation that increments and tests in one step, with no fork at all. Fastest pure-bash variant for small files.

**Complexity:**

| | |
|---|---|
| Time | O(n) — reads up to line 10 then breaks |
| Space | O(1) — one line in memory |

---

## Solution 9: `mapfile` (bash 4+) — load into array, index directly — O(n) time, O(n) space

**Idea:** `mapfile -t` reads all lines into a bash array (0-indexed). Then check the array length before accessing index 9. Simple and readable, but loads the entire file into memory.

**Complexity:**

| | |
|---|---|
| Time | O(n) — reads entire file |
| Space | O(n) — whole file in memory |
