# 3921. Score Validator — Solution

## Approach: Simulation

Simulate the event processing loop, maintaining `score` and `counter`. Stop early if `counter` reaches 10.

For each event:
- If it's a digit string (`"0"`, `"1"`, `"2"`, `"3"`, `"4"`, `"6"`), parse and add to score.
- If it's `"W"`, increment counter; stop if counter reaches 10.
- If it's `"WD"` or `"NB"`, add 1 to score.

## Complexity

- **Time:** O(n) — single pass through events
- **Space:** O(1) — only two integer variables
