# 3440. Reschedule Meetings for Maximum Free Time II — Solution

## Approach

We can reschedule at most one meeting. The key insight: when we remove meeting `i`, it creates a merged free gap = `gap[i] + duration[i] + gap[i+1]`. We can then place the meeting in any free gap of size >= `duration[i]`.

For each meeting `i`:
1. The free gap created by removing it is `gap[i] + duration[i] + gap[i+1]`.
2. If the meeting fits into any other free gap (or in the merged gap minus the meeting), the new free time = `gap[i] + duration[i] + gap[i+1]`.
3. Otherwise, the meeting must stay in the same slot: free time = `gap[i] + gap[i+1]` (but this reduces to the sliding window case with k=1 from version I).

**Efficient check:** Precompute prefix max and suffix max of gaps. For meeting `i`:
- Check if any gap (excluding `gap[i]` and `gap[i+1]`) >= `duration[i]`.
- If yes, answer candidate = `gap[i] + duration[i] + gap[i+1]`.
- If no, answer candidate = `gap[i] + gap[i+1]`.

Take the maximum over all meetings.

**Time Complexity:** O(n)
**Space Complexity:** O(n)
