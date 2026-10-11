# 886C. Petya and Catacombs — Solution

---

## Key Insight

To minimize the number of rooms, we want to **reuse rooms as aggressively as possible**. When Petya enters a room at minute *i* with note *tᵢ*:

- If *tᵢ* > 0: there must be a room last visited at minute *tᵢ*. Reuse that room (update its last-visit time to *i*).
- If *tᵢ* = 0: either reuse a room that was last visited at time 0 (i.e., a room entered for the first time at some previous minute that was new then), or create a new room.

**Greedy:** Maintain a multiset (or frequency map) of "available rooms by their last-visit time". At minute *i* with note *tᵢ*, try to find a room last visited at *tᵢ*. If found: reuse it (remove *tᵢ* from the map, add *i*). If not found: create a new room (increment room counter, add *i* to the map).

---

## Algorithm

1. Maintain `available`: a map from `last_visit_time → count`.
2. For each minute `i` with note `t`:
   - If `available[t] > 0`: decrement `available[t]`, increment `available[i]`.
   - Else: `rooms++`, increment `available[i]`.
3. Return `rooms`.

**Why greedy is optimal:** Any room that *could* be reused (last visited at the right time) should be reused immediately — deferring never helps since future minutes will need their own rooms anyway.

---

## Complexity

| | |
|---|---|
| Time | O(n) with hash map, O(n log n) with ordered map |
| Space | O(n) |
