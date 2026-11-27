# 804. Unique Morse Code Words — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/unique-morse-code-words/

---

## Solution: Hash Set — O(n·L) time, O(n·L) space

**Idea:** Encode each word to its Morse representation and add to a set. Return the set size.

**Algorithm:**
1. For each word, map each character to its Morse code and concatenate.
2. Add the encoded string to a set.
3. Return set size.

**Complexity:**

| | |
|---|---|
| Time | O(n·L) — n words of average length L |
| Space | O(n·L) — storing encoded strings |
