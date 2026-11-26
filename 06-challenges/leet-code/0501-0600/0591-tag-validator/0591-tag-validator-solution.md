# 591. Tag Validator — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/tag-validator/

---

## Solution: Stack-based Parsing — O(n) time, O(n) space

**Idea:** Scan the string character by character, maintaining a stack of open tags. Handle three token types:
1. **CDATA**: `<![CDATA[...]]>` — skip entire contents, any `<` inside is ignored.
2. **Closing tag**: `</TAG>` — must match top of stack; pop it.
3. **Opening tag**: `<TAG>` — TAG must be 1–9 uppercase letters; push onto stack.
4. After processing, stack must be empty AND the entire string was consumed (no trailing chars after the last closing tag at level 0).

**Edge cases:** tag name > 9 chars is invalid, lowercase letters invalid, empty tag name invalid.

**Complexity:**

| | |
|---|---|
| Time | O(n) |
| Space | O(n) — stack depth |
