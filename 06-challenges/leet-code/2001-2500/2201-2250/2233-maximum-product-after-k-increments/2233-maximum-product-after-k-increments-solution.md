# 2233. Maximum Product After K Increments

**Difficulty:** Medium

**Link:** https://leetcode.com/problems/maximum-product-after-k-increments/

## Approach: Greedy with Min-Heap

To maximize the product, always increment the smallest element (this gives the greatest relative gain).

**Algorithm:**
1. Put all elements in a min-heap.
2. Repeat k times: pop the minimum, increment it by 1, push it back.
3. Compute the product of all elements modulo 10^9 + 7.

**Complexity:**
- Time: O((n + k) log n)
- Space: O(n)
