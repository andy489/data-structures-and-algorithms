// https://leetcode.com/problems/determine-color-of-a-chessboard-square/

var squareIsWhite = function(coordinates) {
    return (coordinates.charCodeAt(0) - 97 + coordinates.charCodeAt(1) - 49) % 2 === 1;
};
