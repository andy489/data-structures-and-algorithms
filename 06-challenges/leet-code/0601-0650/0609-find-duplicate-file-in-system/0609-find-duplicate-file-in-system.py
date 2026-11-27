# https://leetcode.com/problems/find-duplicate-file-in-system/

from collections import defaultdict

class Solution:
    def findDuplicate(self, paths: list[str]) -> list[list[str]]:
        content_to_files = defaultdict(list)
        for path in paths:
            parts = path.split(" ")
            directory = parts[0]
            for i in range(1, len(parts)):
                paren_idx = parts[i].index('(')
                file_name = parts[i][:paren_idx]
                content = parts[i][paren_idx + 1:-1]
                content_to_files[content].append(directory + "/" + file_name)
        return [files for files in content_to_files.values() if len(files) >= 2]
