# https://leetcode.com/problems/people-whose-list-of-favorite-companies-is-not-a-subset-of-another-list/

class Solution:
    def peopleIndexes(self, favoriteCompanies: list[list[str]]) -> list[int]:
        sets = [set(fc) for fc in favoriteCompanies]
        return [i for i, s in enumerate(sets) if not any(s < other for j, other in enumerate(sets) if j != i)]
