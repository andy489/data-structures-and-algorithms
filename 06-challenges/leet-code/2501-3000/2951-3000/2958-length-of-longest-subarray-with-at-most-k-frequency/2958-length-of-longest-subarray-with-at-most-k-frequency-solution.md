# 2958. Length of Longest Subarray With at Most K Frequency — Solution

## Approach: Sliding Window

Use a two-pointer sliding window with a frequency map. Expand the right pointer; when any element's frequency exceeds k, shrink the left pointer until all frequencies are at most k. Track the maximum window length.

## Complexity

| | Time | Space |
|---|---|---|
| Sliding window | O(n) | O(n) for freq map |
