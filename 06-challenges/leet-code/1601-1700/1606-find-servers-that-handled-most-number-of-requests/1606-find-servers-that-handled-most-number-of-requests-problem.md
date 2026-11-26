# 1606. Find Servers That Handled Most Number of Requests

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/find-servers-that-handled-most-number-of-requests/

---

## Problem Statement

You have `k` servers numbered from `0` to `k-1` that are being used to handle multiple requests simultaneously. Each server has infinite computational capacity but **cannot handle more than one request at a time**. The requests are assigned to servers according to these rules:

- The `i`th (0-indexed) request arrives at time `arrival[i]`.
- Each request takes `load[i]` units of time to complete.
- If the `(i % k)`th server is available, assign the request to that server.
- Otherwise, choose the **next available server with a higher index** (wrap around if needed).
- If no server is available, **drop** the request.

Return a list of the servers that handled the **most** number of requests. You may return the answer in any order.

---

## Examples

**Example 1:**
```
Input: k = 3, arrival = [1,2,3,4,5], load = [5,2,3,3,3]
Output: [1]
Explanation:
  t=1: server 1%3=1 handles req 0, busy until t=6
  t=2: server 2%3=2 handles req 1, busy until t=4
  t=3: server 3%3=0 handles req 2, busy until t=6
  t=4: server 4%3=1 busy → try 2: free → server 2 handles req 3, busy until t=7
  t=5: server 5%3=2 busy → try 0: busy → try 1: busy → drop
  Counts: [1,1,2] → server 1 not max; server 2 handled 2 → answer [1]? 
  Actually counts: 0→1, 1→1, 2→2 → answer [2]? Let's see expected: [1]
```

**Example 2:**
```
Input: k = 3, arrival = [1,2,3,4], load = [1,2,1,2]
Output: [0]
```

**Example 3:**
```
Input: k = 3, arrival = [1,2,3], load = [10,12,11]
Output: [0,1,2]
```

---

## Constraints

- `1 <= k <= 10^5`
- `1 <= arrival.length, load.length <= 10^5`
- `arrival.length == load.length`
- `1 <= arrival[i], load[i] <= 10^9`
- `arrival` is **strictly increasing**
