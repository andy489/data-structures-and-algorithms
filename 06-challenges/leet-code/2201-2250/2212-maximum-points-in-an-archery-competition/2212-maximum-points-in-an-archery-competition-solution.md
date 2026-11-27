# 2212. Maximum Points in an Archery Competition

## Approach

Enumerate all 2^11 subsets of scoring sections 1..11 (section 0 is worth 0 points so it's never beneficial for Bob). For each subset, Bob uses aliceArrows[k] + 1 arrows to win section k. If total arrows used <= numArrows, put remaining arrows in section 0.

Track the subset yielding maximum points, then reconstruct bobArrows.

**Time Complexity:** O(2^11 * 11) = O(22528) — constant  
**Space Complexity:** O(1)
