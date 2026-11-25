# https://leetcode.com/problems/flood-fill/

class Solution:
    def floodFill(self, image: list[list[int]], sr: int, sc: int, color: int) -> list[list[int]]:
        orig = image[sr][sc]
        if orig == color:
            return image
        def dfs(r, c):
            if not (0 <= r < len(image) and 0 <= c < len(image[0])):
                return
            if image[r][c] != orig:
                return
            image[r][c] = color
            dfs(r + 1, c); dfs(r - 1, c); dfs(r, c + 1); dfs(r, c - 1)
        dfs(sr, sc)
        return image
