# 3941. Password Strength

## Approach

Iterate over the password characters, tracking which characters have been seen using a HashSet. For each unseen character, determine its type and add the corresponding points:
- Lowercase letter: 1 point
- Uppercase letter: 2 points
- Digit: 3 points
- Special character from `"!@#$"`: 5 points

## Complexity

- **Time:** O(n) — single pass through the password
- **Space:** O(1) — bounded character set (at most 26+26+10+4 = 66 distinct characters)
