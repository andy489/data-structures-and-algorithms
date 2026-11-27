# 1348. Tweet Counts Per Frequency — Solution

## Approach
HashMap from tweetName to sorted list of times. For each query, binary search and count per bucket.

## Complexity
- Time: O(n log n) per record, O(n + result_size) per query
- Space: O(n)
