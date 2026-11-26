# https://leetcode.com/problems/largest-multiple-of-three/

class Solution:
    def largestMultipleOfThree(self, digits: list[int]) -> str:
        digits.sort()
        rem = sum(digits) % 3
        if rem:
            # Try removing 1 digit with remainder `rem` (smallest first)
            for i in range(len(digits)):
                if digits[i] % 3 == rem:
                    digits = digits[:i] + digits[i+1:]
                    break
            else:
                # Remove 2 digits with remainder 3-rem
                cnt = 0
                new_d = []
                for d in digits:
                    if cnt < 2 and d % 3 == 3-rem:
                        cnt += 1
                    else:
                        new_d.append(d)
                digits = new_d
        if not digits:
            return ""
        digits.sort(reverse=True)
        if digits[0] == 0:
            return "0"
        return ''.join(map(str, digits))
