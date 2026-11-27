# 2039. The Time When the Network Becomes Idle — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/the-time-when-the-network-becomes-idle/

---

## Solution: BFS + Math — O(V + E) time, O(V + E) space

**Idea:** BFS to find shortest dist from 0 to each server. Then compute when last echo arrives per server.

**Algorithm:**
1. BFS from node 0 to find dist[i].
2. For each server i: round trip = 2*dist[i]. Resends floor((2*d-1)/patience[i]) times. Last send time = patience[i]*resends. Last reply arrives at last_send + 2*d. Latest such time + 1 is answer.

**Complexity:**

| | |
|---|---|
| Time | O(V + E) |
| Space | O(V + E) |
