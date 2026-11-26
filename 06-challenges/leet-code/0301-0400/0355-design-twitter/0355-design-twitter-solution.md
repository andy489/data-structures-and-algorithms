# 355. Design Twitter — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/design-twitter/

---

## Solution: HashMap + Min-Heap Merge — O(n log n) getNewsFeed, O(1) others, O(u·t) space

**Idea:** Store each user's tweets as a list (timestamp, tweetId). For `getNewsFeed`, collect the latest tweet from each followed user into a max-heap (by timestamp), then poll up to 10 times.

**Algorithm:**
1. `postTweet`: append `(time++, tweetId)` to user's tweet list.
2. `follow/unfollow`: maintain a `HashSet<Integer>` of followees per user.
3. `getNewsFeed`: seed a max-heap with the most recent tweet from each followee (including self). Poll and re-add the previous tweet of the same user until 10 results collected.

**Complexity:**

| | |
|---|---|
| Time | O(k log k) getNewsFeed where k = number of followed users |
| Space | O(u·t) — users × tweets stored |
