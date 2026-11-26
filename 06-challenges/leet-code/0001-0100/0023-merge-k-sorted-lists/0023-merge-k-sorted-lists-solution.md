# 23. Merge k Sorted Lists — Solution

**Difficulty:** Hard  
**Link:** https://leetcode.com/problems/merge-k-sorted-lists/

---

## Solution

### Min-Heap (Priority Queue) — O(N log k) time, O(k) space

**Idea:** At any moment, the next node to append to the result is the minimum among all current list heads. A min-heap lets us find and remove this minimum in O(log k).

**Algorithm:**
1. Push the head of every non-empty list into a min-heap keyed by node value.
2. While the heap is non-empty:
   - Pop the minimum node `curr`.
   - Append it to the result list.
   - If `curr` has a `next`, push `curr.next` into the heap.
3. Return the result list (using a dummy head to simplify pointer management).

**Why O(N log k)?** Each of the N total nodes is pushed and popped exactly once. Each heap operation costs O(log k). Total: O(N log k).

**Complexity:**

| | |
|---|---|
| Time | O(N log k) where N = total nodes, k = number of lists |
| Space | O(k) — heap holds at most k nodes at a time |

---

### Divide and Conquer — O(N log k) time, O(log k) space

**Idea:** Merge lists pairwise. In the first pass, merge lists 0&1, 2&3, 4&5, etc. (k/2 merges). Repeat until one list remains. This is a bottom-up merge sort on the lists.

**Why O(N log k)?** log k rounds of merging, each round processes all N nodes total. Same asymptotic complexity as the heap but with O(log k) recursive stack space instead of O(k) heap space.

---

### Naive — O(kN) time — not recommended

Sequentially merge each list into the result one by one. Each merge of two lists of sizes `a` and `b` is O(a+b). In the worst case (equal-length lists) this degrades to O(kN).
