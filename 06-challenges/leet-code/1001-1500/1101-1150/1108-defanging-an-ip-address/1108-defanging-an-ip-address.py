# https://leetcode.com/problems/defanging-an-ip-address/

# Solution: String Replace — O(n) time, O(n) space
class Solution:
    def defangIPaddr(self, address: str) -> str:
        return address.replace('.', '[.]')
