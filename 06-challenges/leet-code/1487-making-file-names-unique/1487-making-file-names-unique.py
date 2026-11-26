# https://leetcode.com/problems/making-file-names-unique/

class Solution:
    def getFolderNames(self, names: list[str]) -> list[str]:
        cloned = {}
        res = []
        for name in names:
            if name not in cloned:
                res.append(name)
                cloned[name] = 1
            else:
                k = cloned[name]
                while f"{name}({k})" in cloned:
                    k += 1
                new_name = f"{name}({k})"
                res.append(new_name)
                cloned[name] = k + 1
                cloned[new_name] = 1
        return res
