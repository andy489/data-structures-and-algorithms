# https://leetcode.com/problems/minimum-number-of-people-to-teach/

class Solution:
    def minimumTeachings(self, n: int, languages: list[list[int]], friendships: list[list[int]]) -> int:
        lang_sets = [set(langs) for langs in languages]
        candidates = set()
        for u, v in friendships:
            u -= 1; v -= 1
            if not lang_sets[u] & lang_sets[v]:
                candidates.add(u)
                candidates.add(v)
        if not candidates:
            return 0
        return min(
            sum(lang not in lang_sets[user] for user in candidates)
            for lang in range(1, n + 1)
        )
