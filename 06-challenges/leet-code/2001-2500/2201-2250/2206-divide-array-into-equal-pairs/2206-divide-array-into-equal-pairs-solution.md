# 2206. Divide Array Into Equal Pairs

## Approach

Each element must appear an even number of times so that pairs can be formed. We count the frequency of each element; if any frequency is odd, return false.

**Algorithm:**
1. Use a frequency map (or XOR approach).
2. For each count, if it's odd, return false.
3. Otherwise return true.

**Alternative:** XOR all elements into a set — if any count is odd, an element appears an odd number of times. We can check parity via a HashSet: add element if not present, remove if present. If set is empty at the end, all counts are even.

**Time Complexity:** O(n)  
**Space Complexity:** O(n)
