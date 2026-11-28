# 3485. Longest Common Prefix of K Strings After Removal — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/longest-common-prefix-of-k-strings-after-removal/

---

## Solution: Trie with Count — O(total_chars) time, O(total_chars) space

**Idea:** Insert all words into a trie, tracking at each node how many words pass through it. The longest common prefix of k words is the deepest node in the trie that has count >= k. When removing word[i], decrement its path in the trie, then find the best LCP among remaining words, then restore.

**Algorithm:**
1. Build a trie and for each node store a count of words passing through it.
2. For each removal index i, decrement counts along word[i]'s path.
3. Find the maximum depth d where trie node count >= k.
4. Record d as answer[i], then re-increment counts.

**Complexity:**

| | |
|---|---|
| Time | O(total_chars) |
| Space | O(total_chars) |
