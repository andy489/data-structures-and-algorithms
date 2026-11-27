# https://leetcode.com/problems/capitalize-the-title/
class Solution:
    def capitalizeTitle(self, title: str) -> str:
        words = title.split()
        result = []
        for w in words:
            if len(w) <= 2:
                result.append(w.lower())
            else:
                result.append(w.capitalize())
        return ' '.join(result)
