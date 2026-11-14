# 195. Tenth Line — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/tenth-line/

---

## Solution: `sed` — select by line number — O(n) time, O(1) space

**Idea:** `sed -n '10p'` reads lines silently (`-n` suppresses default output) and prints (`p`) only line 10. If the file has fewer than 10 lines the address never matches and nothing is printed.

**Complexity:**

| | |
|---|---|
| Time | O(n) — reads up to line 10 then exits |
| Space | O(1) — line-by-line streaming |

---

## Solution 2: `awk` — line counter — O(n) time, O(1) space

**Idea:** The built-in variable `NR` (Number of Records) counts lines processed. The condition `NR==10` is true exactly once; `{print; exit}` prints that line and stops reading.

**Complexity:**

| | |
|---|---|
| Time | O(n) — reads up to line 10 then exits |
| Space | O(1) — line-by-line streaming |

---

## Solution 3: `head` + `tail` — pipeline — O(1) time, O(1) space

**Idea:** `head -10` extracts the first 10 lines; `tail -1` selects the last of those. If the file has fewer than 10 lines, `head` returns all lines and `tail -1` returns the last one (not line 10) — but the problem leaves that edge case undefined.

**Complexity:**

| | |
|---|---|
| Time | O(1) — both tools stop after 10 lines |
| Space | O(1) — streaming pipeline |
