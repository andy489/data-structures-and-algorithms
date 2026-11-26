# https://leetcode.com/problems/remove-sub-folders-from-the-filesystem/

class Solution:
    def removeSubfolders(self, folder: list[str]) -> list[str]:
        folder.sort()
        res, last = [], ""
        for f in folder:
            if not last or not f.startswith(last + '/'):
                res.append(f)
                last = f
        return res
