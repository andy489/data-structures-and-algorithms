# 1803. Count Pairs With XOR in a Range — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/count-pairs-with-xor-in-a-range/

---

## Solution: Trie + Prefix Count — O(n * log(max)) time, O(n * log(max)) space

**Idea:** Use the standard "count pairs with XOR < limit" trick on a binary trie. For the range `[low, high]`, compute `countLess(high + 1) - countLess(low)`. We build the trie incrementally: for each new number, query how many previously inserted numbers XOR with it produce a value less than the given limit, then insert the number.

**Algorithm:**
1. For `countLess(num, limit)`: traverse 15 bits from MSB to LSB. At each bit, if the limit bit is 1, the XOR bit can be 0 (freely, all subtree counts added) or 1 (must continue to constrain). If the limit bit is 0, the XOR bit must be 0 (continue with the matching child).
2. Each trie node stores a child count so we can quickly sum subtrees.
3. Process numbers left to right: query first (using all previously inserted numbers), then insert.

**Complexity:**

| | |
|---|---|
| Time | O(n * log(max)) — 15 bits per number, n numbers |
| Space | O(n * log(max)) — trie nodes |
