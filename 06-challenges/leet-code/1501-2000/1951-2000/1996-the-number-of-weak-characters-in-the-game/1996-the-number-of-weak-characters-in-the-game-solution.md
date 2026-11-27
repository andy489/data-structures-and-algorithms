# Solution: The Number of Weak Characters in the Game

## Approach: Sort + Greedy

Sort characters by attack descending. For equal attack values, sort defense ascending (to avoid counting same-attack characters as dominating each other).

Then iterate through the sorted array tracking the maximum defense seen so far. A character is weak if its defense is less than the current max defense.

**Time:** O(n log n)  
**Space:** O(1)
