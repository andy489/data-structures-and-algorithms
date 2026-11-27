// https://leetcode.com/problems/defanging-an-ip-address/

// Solution: String Replace — O(n) time, O(n) space
var defangIPaddr = function(address) {
    return address.split('.').join('[.]');
};
