# https://leetcode.com/problems/count-items-matching-a-rule/

class Solution:
    def countMatches(self, items: list[list[str]], ruleKey: str, ruleValue: str) -> int:
        idx = {"type": 0, "color": 1, "name": 2}[ruleKey]
        return sum(1 for item in items if item[idx] == ruleValue)
