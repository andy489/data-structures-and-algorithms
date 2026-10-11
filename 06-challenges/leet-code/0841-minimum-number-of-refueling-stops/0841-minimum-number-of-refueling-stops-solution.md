# 841. Minimum Number of Refueling Stops — Solution

---

## Key Insight

Use a **greedy + max-heap** approach: drive as far as possible, and when you run out of fuel, retroactively pick up the largest fuel amount from any station you passed. This greedy choice is always optimal — taking the biggest available refuel minimizes the number of stops.

---

## Algorithm

1. Use a max-heap (priority queue) to track fuel amounts of passed stations.
2. Iterate: while current fuel < next station (or target), pop the largest fuel from the heap and add it. Increment stop count.
3. If heap is empty and still can't reach → return `-1`.
4. Otherwise return stop count.

```
fuel = startFuel
stops = 0
heap = max-heap

for each station (and target as final checkpoint):
    while fuel < next_position:
        if heap is empty: return -1
        fuel += heap.pop_max()
        stops++
    if not at target: heap.push(station.fuel)

return stops
```

---

## Complexity

| | |
|---|---|
| Time | O(n log n) — each station pushed/popped at most once |
| Space | O(n) — heap size |
