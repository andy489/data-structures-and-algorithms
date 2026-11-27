// https://leetcode.com/problems/boats-to-save-people/

var numRescueBoats = function(people, limit) {
    people.sort((a, b) => a - b);
    let lo = 0, hi = people.length - 1, boats = 0;
    while (lo <= hi) {
        if (people[lo] + people[hi] <= limit) lo++;
        hi--; boats++;
    }
    return boats;
};
