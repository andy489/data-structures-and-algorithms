# 1371. Find the Longest Substring Containing Vowels in Even Counts — Solution

## Approach
Bitmask for vowel parity (5 vowels = 32 states). Track first occurrence of each state. Answer = max(i - first[state]).

## Complexity
- Time: O(n)
- Space: O(32)
