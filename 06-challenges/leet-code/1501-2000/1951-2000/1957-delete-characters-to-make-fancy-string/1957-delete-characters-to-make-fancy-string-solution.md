# 1957. Delete Characters to Make Fancy String — Solution

## Approach

Build the result character by character. Only add a character if it would not create three consecutive equal characters. Check if the last two characters in the result are the same as the current character.

**Complexity:** O(n) time, O(n) space.
