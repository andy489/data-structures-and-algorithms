# 3330. Find the Original Typed String I

## Approach

Alice may have pressed exactly one key too long at most once. The original string could be:
1. The word itself (no key was held too long), OR
2. A string where one run of consecutive identical characters has its length reduced by 1

**Algorithm:**
- Count the number of consecutive runs where the same character repeats (length > 1)
- Each such run gives one additional possible original string (by reducing that run by exactly 1)
- Result = 1 (the word itself) + number of runs with length > 1

## Complexity

- **Time:** O(n) where n = word.length
- **Space:** O(1)
