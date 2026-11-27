# https://leetcode.com/problems/destination-city/

class Solution:
    def destCity(self, paths: list[list[str]]) -> str:
        sources = {p[0] for p in paths}
        for _, dst in paths:
            if dst not in sources:
                return dst
        return ""  
