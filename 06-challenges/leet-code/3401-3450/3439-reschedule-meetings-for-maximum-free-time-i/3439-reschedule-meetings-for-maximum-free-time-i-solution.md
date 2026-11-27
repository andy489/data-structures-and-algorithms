# 3439. Reschedule Meetings for Maximum Free Time I — Solution

## Approach

Compute the gaps (free time intervals) between consecutive meetings, including before the first and after the last meeting.

There are `n+1` gaps in total:
- `gap[0] = startTime[0]` (before first meeting)
- `gap[i] = startTime[i] - endTime[i-1]` for i in [1, n-1]
- `gap[n] = eventTime - endTime[n-1]` (after last meeting)

By rescheduling `k` consecutive meetings together, we merge `k+1` consecutive gaps into one. Use a sliding window of size `k+1` over the gaps array to find the maximum sum.

**Algorithm:**
- Build gaps array of size `n+1`.
- Sliding window sum of size `k+1` over gaps.
- Return the maximum window sum.

**Time Complexity:** O(n)
**Space Complexity:** O(n)
