# 160. Intersection of Two Linked Lists — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/intersection-of-two-linked-lists/

---

## Solution: Two-pointer path equalisation — O(m + n) time, O(1) space

**Idea:** Place pointer `a` at `headA` and `b` at `headB`. Advance both one step at a time. When `a` reaches the end of list A, redirect it to `headB`; when `b` reaches the end of list B, redirect it to `headA`. After at most `m + n` steps both pointers have travelled the same total distance and will meet exactly at the intersection node — or both land on `null` simultaneously if there is no intersection.

**Why it works:** If the lists intersect, let the unique prefix lengths be `a` and `b` and the shared tail be `c`. Pointer `a` travels `a + c + b` steps; pointer `b` travels `b + c + a` steps — equal, so they meet at the intersection. If they don't intersect (`c = 0`) both reach `null` after `m + n` steps.

**Algorithm:**
1. Set `pa = headA`, `pb = headB`.
2. While `pa != pb`:
   - `pa = (pa == null) ? headB : pa.next`
   - `pb = (pb == null) ? headA : pb.next`
3. Return `pa` (either the intersection node or `null`).

**Complexity:**

| | |
|---|---|
| Time | O(m + n) — each pointer traverses at most both lists once |
| Space | O(1) — only two pointer variables |
