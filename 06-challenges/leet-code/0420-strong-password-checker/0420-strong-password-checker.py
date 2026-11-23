# https://leetcode.com/problems/strong-password-checker/

class Solution:
    def strongPasswordChecker(self, s: str) -> int:
        n = len(s)
        has_lower = any(c.islower() for c in s)
        has_upper = any(c.isupper() for c in s)
        has_digit = any(c.isdigit() for c in s)
        missing_types = (0 if has_lower else 1) + (0 if has_upper else 1) + (0 if has_digit else 1)

        runs = []
        i = 0
        while i < n:
            j = i
            while j < n and s[j] == s[i]:
                j += 1
            if j - i >= 3:
                runs.append(j - i)
            i = j

        if n < 6:
            return max(6 - n, missing_types)

        repeat_replacements = sum(length // 3 for length in runs)

        if n <= 20:
            return max(repeat_replacements, missing_types)

        to_delete = n - 20
        deletions = to_delete

        for k in range(len(runs)):
            if runs[k] % 3 == 0 and to_delete > 0:
                runs[k] -= 1
                repeat_replacements -= 1
                to_delete -= 1

        for k in range(len(runs)):
            if runs[k] % 3 == 1 and to_delete > 0:
                reduce = min(2, to_delete)
                runs[k] -= reduce
                repeat_replacements -= reduce // 2
                to_delete -= reduce

        for k in range(len(runs)):
            if to_delete > 0 and runs[k] >= 3:
                reduce = min(runs[k] - 2, (to_delete // 3) * 3)
                runs[k] -= reduce
                repeat_replacements -= reduce // 3
                to_delete -= reduce

        return deletions + max(repeat_replacements, missing_types)
