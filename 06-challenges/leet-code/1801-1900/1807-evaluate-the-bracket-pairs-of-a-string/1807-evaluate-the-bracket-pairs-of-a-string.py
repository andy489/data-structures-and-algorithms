# https://leetcode.com/problems/evaluate-the-bracket-pairs-of-a-string/

import re

class Solution:
    def evaluate(self, s: str, knowledge: list[list[str]]) -> str:
        dic = dict(knowledge)
        return re.sub(r'\((\w+)\)', lambda m: dic.get(m.group(1), '?'), s)
