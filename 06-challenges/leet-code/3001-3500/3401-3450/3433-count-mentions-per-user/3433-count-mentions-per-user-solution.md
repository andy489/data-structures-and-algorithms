# 3433. Count Mentions Per User — Solution

## Approach

Sort events by timestamp (keeping OFFLINE before MESSAGE at the same timestamp to process status changes first). For each event:

- **OFFLINE:** Record the time the user went offline. They come back at `time + 60`.
- **MESSAGE with ALL:** Add 1 to everyone's count regardless of online status.
- **MESSAGE with HERE:** For each user, check if they are online at the current time (i.e., their offline period has ended), and add 1 if online.
- **MESSAGE with ids:** Parse the id tokens, add 1 for each mention (including duplicates).

**Key detail:** Sort OFFLINE before MESSAGE at the same timestamp.

**Time Complexity:** O(n log n + n * numberOfUsers)
**Space Complexity:** O(numberOfUsers)
