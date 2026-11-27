# Solution: Design Task Manager

## Approach

Use a TreeMap/TreeSet (sorted by (priority, taskId)) to maintain tasks sorted by priority (descending) and taskId (descending) for tie-breaking. Also maintain a HashMap from taskId to (userId, priority) for O(1) lookup on edit/rmv.

- **add**: insert into map, record in taskMap.
- **edit**: remove old (priority, taskId) from sorted set, add new entry, update taskMap.
- **rmv**: remove from sorted set and taskMap.
- **execTop**: poll the max element from the sorted set, remove from taskMap, return userId.

In Java, use a TreeSet with a comparator on (priority DESC, taskId DESC). The first element is the top task.

## Complexity

| | Complexity |
|---|---|
| Time | O(log n) per operation |
| Space | O(n) |
