# 332. Reconstruct Itinerary

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/reconstruct-itinerary/

---

## Problem Statement

You are given a list of airline `tickets` represented by pairs of departure and arrival airports `[from, to]`. Reconstruct the itinerary in order and return it.

All of the tickets must be used once and only once. The itinerary must begin with `"JFK"`. If there are multiple valid itineraries, return the itinerary that has the smallest lexical order when read as a single string.

---

## Examples

**Example 1:**
```
Input:  tickets = [["MUC","LHR"],["JFK","MUC"],["SFO","SJC"],["LHR","SFO"]]
Output: ["JFK","MUC","LHR","SFO","SJC"]
```

**Example 2:**
```
Input:  tickets = [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
Output: ["JFK","ATL","JFK","SFO","ATL","SFO"]
Explanation: Another possible reconstruction is ["JFK","SFO","ATL","JFK","ATL","SFO"] but it is larger in lexical order.
```

---

## Constraints

- `1 <= tickets.length <= 300`
- `tickets[i].length == 2`
- `from_i.length == 3`
- `to_i.length == 3`
- `from_i` and `to_i` consist of uppercase English letters.
- `from_i != to_i`
