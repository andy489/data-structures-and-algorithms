// https://leetcode.com/problems/angle-between-hands-of-a-clock/

var angleClock = function(hour, minutes) {
    const ma=minutes*6, ha=(hour%12)*30+minutes*0.5;
    const diff=Math.abs(ma-ha);
    return Math.min(diff,360-diff);
};
