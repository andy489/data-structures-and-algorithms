// https://leetcode.com/problems/binary-watch/

var readBinaryWatch = function(turnedOn) {
    const times = [];
    for (let h = 0; h < 12; h++) {
        for (let m = 0; m < 60; m++) {
            const bits = (h).toString(2).split('').filter(c => c === '1').length
                       + (m).toString(2).split('').filter(c => c === '1').length;
            if (bits === turnedOn) {
                times.push(`${h}:${String(m).padStart(2, '0')}`);
            }
        }
    }
    return times;
};
