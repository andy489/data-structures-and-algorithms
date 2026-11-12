# 193. Valid Phone Numbers — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/valid-phone-numbers/

---

## Solution: `grep` with anchored ERE pattern — O(n) time, O(1) space

**Idea:** Use `grep -E` (extended regex) with a pattern anchored to the full line (`^...$`) that alternates between the two valid formats. Any line not matching is silently dropped.

**Pattern breakdown:**
- `^(\([0-9]{3}\) |[0-9]{3}-)` — either `(ddd) ` or `ddd-` at the start
- `[0-9]{3}-[0-9]{4}$` — followed by `ddd-dddd` at the end

**Complexity:**

| | |
|---|---|
| Time | O(n) — single pass over the file |
| Space | O(1) — streaming, no buffering |
