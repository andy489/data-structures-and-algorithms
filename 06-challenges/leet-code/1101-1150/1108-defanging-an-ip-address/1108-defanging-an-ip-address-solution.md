# 1108. Defanging an IP Address — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/defanging-an-ip-address/

---

## Solution: String Replace — O(n) time, O(n) space

**Idea:** Replace every `'.'` in the address with `'[.]'`.

**Algorithm:**
1. Iterate through each character.
2. If the character is `'.'`, append `'[.]'`; otherwise append the character as-is.
3. Return the resulting string.

**Complexity:**

| | |
|---|---|
| Time | O(n) — single pass through the string |
| Space | O(n) — output string |
