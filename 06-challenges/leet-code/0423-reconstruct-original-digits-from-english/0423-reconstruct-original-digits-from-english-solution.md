# 423. Reconstruct Original Digits from English — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/reconstruct-original-digits-from-english/

---

## Solution: Letter Frequency Fingerprinting — O(n) time, O(1) space

**Idea:** Certain digits have unique letters that appear in no other digit's spelling. Use those as anchors to subtract counts, then resolve the rest in dependency order.

**Algorithm:**
1. Count frequency of each letter in `s`.
2. Determine digit counts using unique-letter anchors in this order:
   - `'z'` only in "zero" → count[0]
   - `'w'` only in "two" → count[2]
   - `'u'` only in "four" → count[4]
   - `'x'` only in "six" → count[6]
   - `'g'` only in "eight" → count[8]
   - `'o'` in "zero","two","four" (all counted) → remaining = count[1]
   - `'h'` in "eight" (counted) → remaining = count[3]
   - `'f'` in "four" (counted) → remaining = count[5]
   - `'s'` in "six" (counted) → remaining = count[7]
   - `'i'` in "five","six","eight" (counted) → remaining = count[9]
3. Build result string from sorted digit counts.

**Complexity:**

| | |
|---|---|
| Time | O(n) — single pass for frequency + O(1) digit resolution |
| Space | O(1) — fixed 26-letter count array |
