# https://leetcode.com/problems/number-of-students-unable-to-eat-lunch/

class Solution:
    def countStudents(self, students: list[int], sandwiches: list[int]) -> int:
        count = [0, 0]
        for s in students:
            count[s] += 1
        for sandwich in sandwiches:
            if count[sandwich] == 0:
                return count[0] + count[1]
            count[sandwich] -= 1
        return 0
