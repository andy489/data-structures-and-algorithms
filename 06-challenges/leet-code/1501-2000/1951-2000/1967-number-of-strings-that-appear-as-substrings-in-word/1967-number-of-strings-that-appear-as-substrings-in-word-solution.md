# 1967. Number of Strings That Appear as Substrings in Word — Solution

## Approach

Simple linear scan: for each pattern in patterns, check if it appears as a substring in word using built-in string contains/indexOf.

**Complexity:** O(p * n * m) time where p = patterns.length, n = word.length, m = average pattern length. O(1) extra space.
