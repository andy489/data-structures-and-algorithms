// https://leetcode.com/problems/average-salary-excluding-the-minimum-and-maximum-salary/

var average = function(salary) {
    return (salary.reduce((s,x)=>s+x,0) - Math.min(...salary) - Math.max(...salary)) / (salary.length - 2);
};
