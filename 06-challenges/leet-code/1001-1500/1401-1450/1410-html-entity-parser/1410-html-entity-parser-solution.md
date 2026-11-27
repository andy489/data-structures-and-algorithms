# 1410. Html Entity Parser — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/html-entity-parser/

---

## Solution: String Replace — O(n) time, O(n) space

**Idea:** Replace each entity in the correct order (&amp; last to avoid double-replacement).

**Algorithm:**
1. Replace entities in order: `&quot;`, `&apos;`, `&gt;`, `&lt;`, `&frasl;`, then `&amp;` last.

**Complexity:**

| | |
|---|---|
| Time | O(n) |
| Space | O(n) |
