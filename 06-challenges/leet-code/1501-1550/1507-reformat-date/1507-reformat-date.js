// https://leetcode.com/problems/reformat-date/

var reformatDate = function(date) {
    const MONTHS = {Jan:1,Feb:2,Mar:3,Apr:4,May:5,Jun:6,Jul:7,Aug:8,Sep:9,Oct:10,Nov:11,Dec:12};
    const [dayStr, monthStr, year] = date.split(' ');
    const day = parseInt(dayStr);
    const month = MONTHS[monthStr];
    return `${year}-${String(month).padStart(2,'0')}-${String(day).padStart(2,'0')}`;
};
