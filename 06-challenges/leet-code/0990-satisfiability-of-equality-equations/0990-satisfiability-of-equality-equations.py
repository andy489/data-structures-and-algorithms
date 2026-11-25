# https://leetcode.com/problems/satisfiability-of-equality-equations/

class Solution:
    def equationsPossible(self, equations: list[str]) -> bool:
        parent = list(range(26))

        def find(x):
            while parent[x] != x:
                parent[x] = parent[parent[x]]
                x = parent[x]
            return x

        for eq in equations:
            if eq[1] == '=':
                parent[find(ord(eq[0])-97)] = find(ord(eq[3])-97)

        for eq in equations:
            if eq[1] == '!' and find(ord(eq[0])-97) == find(ord(eq[3])-97):
                return False
        return True
