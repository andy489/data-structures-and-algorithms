# 1334. Find the City With the Smallest Number of Neighbors at a Threshold Distance — Solution

## Approach
Floyd-Warshall for all-pairs shortest paths, then count reachable cities within threshold for each city.

## Complexity
- Time: O(n^3)
- Space: O(n^2)
