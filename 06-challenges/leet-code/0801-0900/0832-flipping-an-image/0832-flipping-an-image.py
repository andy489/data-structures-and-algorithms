# https://leetcode.com/problems/flipping-an-image/

class Solution:
    def flipAndInvertImage(self, image: list[list[int]]) -> list[list[int]]:
        for row in image:
            l, r = 0, len(row) - 1
            while l <= r:
                if row[l] == row[r]:
                    row[l] = row[r] = row[l] ^ 1
                l += 1
                r -= 1
        return image
