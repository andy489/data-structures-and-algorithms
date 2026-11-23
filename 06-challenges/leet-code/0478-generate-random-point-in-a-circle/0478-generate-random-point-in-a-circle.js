// https://leetcode.com/problems/generate-random-point-in-a-circle/

var Solution = function(radius, x_center, y_center) {
    this.radius = radius;
    this.xCenter = x_center;
    this.yCenter = y_center;
};

Solution.prototype.randPoint = function() {
    const angle = 2 * Math.PI * Math.random();
    const r = this.radius * Math.sqrt(Math.random());
    return [this.xCenter + r * Math.cos(angle), this.yCenter + r * Math.sin(angle)];
};
