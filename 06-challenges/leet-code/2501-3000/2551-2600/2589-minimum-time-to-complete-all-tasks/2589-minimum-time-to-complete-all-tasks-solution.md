# Solution: 2589. Minimum Time to Complete All Tasks

## Approach

Sort tasks by their end time. Use a boolean array `running[1..2000]` to track which time slots the computer is on.

For each task (sorted by end), count how many time slots in `[start, end]` are already running. If that count is enough for `duration`, no new slots are needed. Otherwise, greedily assign the remaining needed slots from the **right end** of `[start, end]` (to maximize overlap potential for future tasks).

This greedy strategy works because tasks sorted by end time means later-ending tasks have already been processed, and assigning slots at the right end of a task's window maximizes the chance of overlap with future tasks.

## Complexity

- **Time:** O(n log n + n * T) where T is the max time (2000)
- **Space:** O(T) for the running array
