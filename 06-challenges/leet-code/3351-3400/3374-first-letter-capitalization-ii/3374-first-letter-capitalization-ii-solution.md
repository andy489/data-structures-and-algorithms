# 3374. First Letter Capitalization II — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/first-letter-capitalization-ii/

---

## Solution: Recursive CTE Word Splitting — O(n · w) time, O(n · w) space

**Idea:** MySQL lacks a built-in title-case function, so we split `content_text` word by word using a recursive CTE. For each word, we apply the capitalisation rules: if the first character is not a letter, leave it unchanged; otherwise apply `CONCAT(UPPER(first_letter), LOWER(rest))` to each hyphen-delimited part. Reassemble words with spaces.

**Algorithm:**
1. Use a recursive CTE (`split`) to extract one word per row together with the remaining text and position.
2. For each extracted word, check whether its first character is a letter (`REGEXP '^[a-zA-Z]'`).
   - If not, keep it unchanged.
   - If it starts with a letter and contains a hyphen, split on `-` and capitalise each part.
   - Otherwise capitalise first letter, lowercase rest.
3. Use `GROUP_CONCAT(... ORDER BY pos SEPARATOR ' ')` to reassemble the words per `content_id`.

**Complexity:**

| | |
|---|---|
| Time | O(n · w) — n rows, w words per row |
| Space | O(n · w) — recursive CTE intermediate rows |
