// https://leetcode.com/problems/construct-the-rectangle/

var constructRectangle = function(area) {
    let w = Math.floor(Math.sqrt(area));
    while (area % w !== 0) w--;
    return [area / w, w];
};
