# https://leetcode.com/problems/distribute-money-to-maximum-children/
class Solution:
    def distMoney(self, money: int, children: int) -> int:
        if money < children:
            return -1
        money -= children
        eights = min(money // 7, children)
        money -= eights * 7
        children -= eights
        if children == 0 and money > 0:
            eights -= 1
        elif children == 1 and money == 3:
            eights -= 1
        return eights
