# 496. Next Greater Element I — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/next-greater-element-i/

---

## Solution: Monotonic Stack + HashMap — O(m + n) time, O(n) space

**Idea:** Process nums2 with a monotonic decreasing stack. When we pop an element because a larger element is found, record that larger element as the "next greater" for the popped element in a map. Then look up each nums1 element in the map.

**Algorithm:**
1. Iterate nums2 with a stack of elements waiting for their next greater.
2. If current > stack top: pop and map top → current.
3. Push current onto stack.
4. All remaining elements in stack map to -1.
5. For each element in nums1, return map.getOrDefault(el, -1).

**Complexity:**

| | |
|---|---|
| Time | O(m + n) — one pass through nums2, one lookup per nums1 element |
| Space | O(n) — stack and map |
