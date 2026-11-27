# 2211. Count Collisions on a Road

## Approach

Key insight: cars going 'L' at the left end and cars going 'R' at the right end will never collide (they escape to infinity). Every other moving car will eventually collide.

Simpler observation: strip leading 'L' (they go left forever, no collision) and trailing 'R' (they go right forever, no collision). In the remaining substring, every 'L' and 'R' contributes 1 collision (they all eventually stop). Count all non-'S' characters in the trimmed string.

**Algorithm:**
1. Find first index that is not 'L'.
2. Find last index that is not 'R'.
3. Count all characters != 'S' in the range [left, right].

**Time Complexity:** O(n)  
**Space Complexity:** O(1)
