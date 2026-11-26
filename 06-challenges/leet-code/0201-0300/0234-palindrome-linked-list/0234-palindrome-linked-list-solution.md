# 234. Palindrome Linked List — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/palindrome-linked-list/

---

## Solution: Find Middle + Reverse Second Half — O(n) time, O(1) space

**Idea:** Use slow/fast pointers to find the midpoint. Reverse the second half in-place. Compare first half with reversed second half. Optionally restore the list.

**Algorithm:**
1. Find middle with `slow`/`fast` pointers.
2. Reverse from `slow.next` to end.
3. Compare `head` and the reversed half node-by-node.
4. Return `true` if all values match.

**Complexity:**

| | |
|---|---|
| Time | O(n) — three linear passes |
| Space | O(1) — in-place reversal |
