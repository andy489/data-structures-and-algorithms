# 2248. Intersection of Multiple Arrays — Solution

## Approach

Use a frequency count array of size 1001 (since values are at most 1000). For each number in each sub-array, increment its count. Then collect all numbers whose count equals the number of arrays (`nums.length`).

## Complexity

- **Time:** O(total elements + 1000)
- **Space:** O(1000) = O(1)
