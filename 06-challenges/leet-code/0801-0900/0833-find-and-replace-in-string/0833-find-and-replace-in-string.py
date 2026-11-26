# https://leetcode.com/problems/find-and-replace-in-string/

class Solution:
    def findReplaceString(self, s: str, indices: list[int], sources: list[str], targets: list[str]) -> str:
        ops = {}
        for i, (idx, src) in enumerate(zip(indices, sources)):
            if s[idx:idx+len(src)] == src:
                ops[idx] = i
        result = []
        i = 0
        while i < len(s):
            if i in ops:
                op = ops[i]
                result.append(targets[op])
                i += len(sources[op])
            else:
                result.append(s[i])
                i += 1
        return ''.join(result)
