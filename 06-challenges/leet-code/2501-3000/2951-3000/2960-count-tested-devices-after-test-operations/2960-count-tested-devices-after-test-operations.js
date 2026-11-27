// https://leetcode.com/problems/count-tested-devices-after-test-operations/
var countTestedDevices = function(batteryPercentages) {
    let tested = 0;
    for (const b of batteryPercentages) {
        if (b - tested > 0) {
            tested++;
        }
    }
    return tested;
};
