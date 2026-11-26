# 1707. Maximum XOR With an Element From Array — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/maximum-xor-with-an-element-from-array/

---

## Solution: Offline Processing + Trie — O((n + q) log(max)) time, O(n + q) space

**Idea:** Sort queries by their limit `m_i`. Sort `nums`. Process queries in increasing order of `m_i`, inserting nums into a Trie as they become eligible (nums[j] <= m_i). For each query, find the max XOR in the trie by greedily choosing the opposite bit at each level.

**Algorithm:**
1. Sort `nums`. Index queries by their original position and sort by `m_i`.
2. Use a pointer to insert nums into trie as queries are processed.
3. For each query, if no nums are eligible, answer is -1; otherwise query the trie.

**Complexity:**

| | |
|---|---|
| Time | O((n + q) log(max)) — trie depth is at most 30 bits |
| Space | O(n * 30) — trie nodes |
