# 2210. Count Hills and Valleys in an Array

## Approach

First, deduplicate consecutive equal elements (they form the same hill/valley). Then scan the deduplicated array: index i (1-based, not first or last) is a hill if dedup[i-1] < dedup[i] > dedup[i+1], and a valley if dedup[i-1] > dedup[i] < dedup[i+1].

**Algorithm:**
1. Build dedup array by removing consecutive duplicates.
2. Count hills and valleys in dedup array (indices 1..n-2).

**Time Complexity:** O(n)  
**Space Complexity:** O(n)
