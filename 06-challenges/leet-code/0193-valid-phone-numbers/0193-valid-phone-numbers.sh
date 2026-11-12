# https://leetcode.com/problems/valid-phone-numbers/

# Solution: grep with anchored ERE pattern — O(n) time, O(1) space
grep -E '^(\([0-9]{3}\) |[0-9]{3}-)[0-9]{3}-[0-9]{4}$' file.txt
