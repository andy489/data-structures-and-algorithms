# 193. Valid Phone Numbers — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/valid-phone-numbers/

---

## Solution: `grep -E` (anchored ERE pattern) — O(n) time, O(1) space

**Idea:** Use `grep -E` (extended regex) with a pattern anchored to the full line (`^...$`) that alternates between the two valid formats. Any line not matching is silently dropped.

**Pattern breakdown:**
- `^(\([0-9]{3}\) |[0-9]{3}-)` — either `(ddd) ` or `ddd-` at the start
- `[0-9]{3}-[0-9]{4}$` — followed by `ddd-dddd` at the end

**Complexity:**

| | |
|---|---|
| Time | O(n) — single pass over the file |
| Space | O(1) — streaming, no buffering |

---

## Solution 2: `grep -P` (Perl-compatible regex) — O(n) time, O(1) space

**Idea:** `-P` switches `grep` to the PCRE engine, enabling `\d` shorthand. Same semantics as `grep -E` but more compact — the cleanest one-liner of the five.

**Complexity:**

| | |
|---|---|
| Time | O(n) — single pass |
| Space | O(1) — streaming, no buffering |

---

## Solution 3: `awk` — implicit match — O(n) time, O(1) space

**Idea:** `awk` with a bare regex condition prints every record (line) where the pattern matches — no action block needed. `awk` uses ERE natively, so no flag is required.

**Complexity:**

| | |
|---|---|
| Time | O(n) — single pass |
| Space | O(1) — line-by-line streaming |

---

## Solution 4: `sed` — print only matching lines — O(n) time, O(1) space

**Idea:** `sed -n` suppresses default output; the `/pattern/p` command prints only lines that match. `-E` enables the same extended regex as `grep -E`.

**Complexity:**

| | |
|---|---|
| Time | O(n) — single pass |
| Space | O(1) — line-by-line streaming |

---

## Solution 5: `perl` — O(n) time, O(1) space

**Idea:** `perl -ne` reads the file line by line (`-n`) and executes the script (`-e`) for each line. `\d` is Perl's digit shorthand, making the pattern more compact than `[0-9]`.

**Complexity:**

| | |
|---|---|
| Time | O(n) — single pass |
| Space | O(1) — line-by-line streaming |
