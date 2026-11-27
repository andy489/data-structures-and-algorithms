# Solution: 3885. Design Event Manager

## Approach

Use a **lazy deletion max-heap** (priority queue).

- Store `(-priority, eventId)` tuples in a min-heap to simulate max-heap by priority, then by min eventId.
- Keep a map `priorities` from `eventId -> current priority` for active events.
- Keep a set `removed` of eventIds that have been polled out.

**pollHighest:** Pop from heap. If the top is stale (priority doesn't match current priority in map, or event is removed), skip it. Return the first valid one.

**updatePriority:** Update the map. Push a new entry with the new priority. The old entry will be lazily skipped when popped.

This avoids O(n) decrease-key operations.

## Complexity

- **Time:** O(log n) per operation amortized
- **Space:** O(n)
