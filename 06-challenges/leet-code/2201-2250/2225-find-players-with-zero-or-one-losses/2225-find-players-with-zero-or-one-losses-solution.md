# 2225. Find Players With Zero or One Losses — Solution

**Approach:** Hash Map

Track each player's loss count using a map. Players who appear only as winners have 0 losses; track them as well by marking them in the map with 0 if not already present. Collect players with 0 and 1 losses, sort, and return.

**Time Complexity:** O(n log n) — sorting the results.

**Space Complexity:** O(n) — for the map.
