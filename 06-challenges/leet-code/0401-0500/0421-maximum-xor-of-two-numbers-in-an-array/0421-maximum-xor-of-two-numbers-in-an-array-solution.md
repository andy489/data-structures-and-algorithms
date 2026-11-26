# 421. Maximum XOR of Two Numbers in an Array — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/maximum-xor-of-two-numbers-in-an-array/

---

## Solution: Bitwise Trie — O(n) time, O(n) space

**Idea:** Insert all numbers into a binary trie (from MSB to LSB). For each number, greedily traverse the trie choosing the opposite bit at each level to maximize XOR.

**Algorithm:**
1. Build a binary trie inserting each number bit by bit (bit 31 down to 0).
2. For each number, traverse the trie: at each bit, try to go to the child that differs (maximizing XOR); if not possible, go to the same-bit child.
3. Track the running XOR as you traverse and update the global maximum.

**Complexity:**

| | |
|---|---|
| Time | O(n) — 32 operations per number |
| Space | O(n) — trie holds at most 32n nodes |

---

## Solution 2: Bit Masking with HashSet — O(32n) time, O(n) space

**Idea:** Build the answer bit by bit from MSB. For each bit position, check if any two prefixes XOR to the candidate answer (with the current bit set to 1) using the identity `a XOR b = c → a XOR c = b`.

**Algorithm:**
1. For each bit from 31 down to 0, extract all prefixes of that length.
2. Assume the current bit can be 1; check if any two prefixes XOR to this candidate.
3. If yes, keep the bit set; otherwise leave it 0.

**Complexity:**

| | |
|---|---|
| Time | O(32n) — 32 passes over n numbers |
| Space | O(n) — prefix set |
