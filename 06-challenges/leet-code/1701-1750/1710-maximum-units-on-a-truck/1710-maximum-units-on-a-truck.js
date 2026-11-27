// https://leetcode.com/problems/maximum-units-on-a-truck/

var maximumUnits = function(boxTypes, truckSize) {
    boxTypes.sort((a, b) => b[1] - a[1]);
    let units = 0;
    let remaining = truckSize;
    for (const [count, perBox] of boxTypes) {
        const take = Math.min(count, remaining);
        units += take * perBox;
        remaining -= take;
        if (remaining === 0) {
            break;
        }
    }
    return units;
};
