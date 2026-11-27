# 920. Number of Music Playlists

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/number-of-music-playlists/

---

## Problem Statement

Your music player contains `n` different songs. You want to listen to `goal` songs (not necessarily different) during your trip. To avoid boredom, you will create a playlist so that:
- Every song is played **at least once**.
- A song can only be played again only if `k` other songs have been played since last time it was played.

Given `n`, `goal`, and `k`, return the number of possible playlists that you can create. Since the answer can be very large, return it **modulo** `10^9 + 7`.

---

## Examples

**Example 1:**
```
Input:  goal = 3, n = 3, k = 1
Output: 6
```

**Example 2:**
```
Input:  goal = 2, n = 3, k = 1
Output: 6
```

---

## Constraints

- `0 <= k < n <= goal <= 100`
