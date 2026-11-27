// https://leetcode.com/problems/defanging-an-ip-address/

// Solution: String Replace — O(n) time, O(n) space
class Solution {
    public String defangIPaddr(String address) {
        return address.replace(".", "[.]");
    }
}
