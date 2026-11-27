# 468. Validate IP Address — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/validate-ip-address/

---

## Solution: Split and Validate — O(1) time, O(1) space

**Idea:** Check which separator is present (`.` or `:`), split, and validate each token against the respective rules.

**Algorithm:**
1. If contains `.`: split by `.`, must have exactly 4 parts. Each part: non-empty, no leading zero (except "0"), all digits, value 0–255.
2. If contains `:`: split by `:`, must have exactly 8 parts. Each part: length 1–4, all valid hex chars.
3. Otherwise: "Neither".

**Complexity:**

| | |
|---|---|
| Time | O(1) — fixed max 8 parts each of fixed max length |
| Space | O(1) |
