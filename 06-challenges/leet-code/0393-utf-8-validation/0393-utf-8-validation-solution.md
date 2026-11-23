# 393. UTF-8 Validation — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/utf-8-validation/

---

## Solution: Bit Masking — O(n) time, O(1) space

**Idea:** Iterate through the data array. For each byte, determine how many continuation bytes follow by checking the leading bits. Verify that the required continuation bytes each start with `10`.

**Bit patterns:**
- `0xxxxxxx`: 1-byte char (leading bit 0)
- `110xxxxx`: start of 2-byte char
- `1110xxxx`: start of 3-byte char
- `11110xxx`: start of 4-byte char
- `10xxxxxx`: continuation byte

**Complexity:**

| | |
|---|---|
| Time | O(n) |
| Space | O(1) |
