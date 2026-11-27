# 508. Most Frequent Subtree Sum — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/most-frequent-subtree-sum/

---

## Solution: Post-order DFS + HashMap — O(n) time, O(n) space

**Idea:** Post-order traversal computes each subtree sum. Store counts in a HashMap. Track max frequency while updating, then collect all sums with max frequency.

**Algorithm:**
1. DFS: return left sum + right sum + node.val.
2. Increment count for this sum in frequency map.
3. Update maxFreq.
4. After traversal, collect all sums where count == maxFreq.

**Complexity:**

| | |
|---|---|
| Time | O(n) — single traversal |
| Space | O(n) — frequency map + recursion stack |
