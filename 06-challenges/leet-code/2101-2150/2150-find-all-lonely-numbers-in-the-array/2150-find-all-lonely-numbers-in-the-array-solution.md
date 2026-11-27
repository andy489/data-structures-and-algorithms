# 2150. Find All Lonely Numbers in the Array — Solution

## Approach: Frequency Map

**Key insight:** A number `x` is lonely if:
1. It appears exactly once in the array.
2. `x - 1` does not appear in the array.
3. `x + 1` does not appear in the array.

Build a frequency map, then check each unique number against these three conditions.

**Algorithm:**
1. Build a frequency map (number → count).
2. For each key in the map, if `freq[x] == 1` and `freq[x-1] == 0` and `freq[x+1] == 0`, add `x` to result.

## Complexity

| | Time | Space |
|---|---|---|
| Build map + iterate | O(n) | O(n) |
| **Total** | **O(n)** | **O(n)** |
