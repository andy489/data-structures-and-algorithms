# 1312. Minimum Insertion Steps to Make a String Palindrome — Solution

## Approach
DP. dp[i][j] = min insertions to make s[i..j] palindrome. If s[i]==s[j], dp[i][j]=dp[i+1][j-1], else dp[i][j]=1+min(dp[i+1][j], dp[i][j-1]).

## Complexity
- Time: O(n^2)
- Space: O(n^2)
