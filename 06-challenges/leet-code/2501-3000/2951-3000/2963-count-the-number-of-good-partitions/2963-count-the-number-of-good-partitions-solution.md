# 2963. Count the Number of Good Partitions — Solution

## Approach: Greedy — Track Last Occurrence

For a partition to be "good", no two subarrays contain the same number. This means: if a number appears at indices i and j (i < j), they must be in the same subarray.

**Algorithm:**
1. For each number, record its last occurrence index.
2. Scan left to right, maintaining `minEnd` = the minimum right boundary of the current segment (the furthest last occurrence we've seen so far).
3. When we reach `minEnd`, we can "cut" here — a new subarray can begin at the next index. Each valid cut point doubles the count of partitions (we can either cut or not cut).

**Key insight:** The number of valid cut points `c` gives `2^c` total good partitions.

## Complexity

| | Time | Space |
|---|---|---|
| Single pass + last occurrence map | O(n) | O(n) |
