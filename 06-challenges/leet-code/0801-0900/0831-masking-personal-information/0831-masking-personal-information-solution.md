# 831. Masking Personal Information — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/masking-personal-information/

---

## Solution: String Parsing — O(n) time, O(n) space

**Idea:** Distinguish email vs phone by presence of '@'. Apply masking rules for each type.

**Algorithm:**
1. If '@' is in s: mask email → first_char + "*****" + last_char + "@" + lowercase domain.
2. Otherwise: extract digits, last 4 digits always shown, prefix based on extra digit count.

**Complexity:**

| | |
|---|---|
| Time | O(n) — single scan |
| Space | O(n) — output string |
