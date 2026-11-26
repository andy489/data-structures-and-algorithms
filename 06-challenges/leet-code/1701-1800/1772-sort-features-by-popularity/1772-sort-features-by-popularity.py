# https://leetcode.com/problems/sort-features-by-popularity/

class Solution:
    def sortFeatures(self, features: list[str], responses: list[str]) -> list[str]:
        count = {}
        for response in responses:
            for word in set(response.split()):
                count[word] = count.get(word, 0) + 1
        return sorted(features, key=lambda f: -count.get(f, 0))
