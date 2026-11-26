// https://leetcode.com/problems/count-negative-numbers-in-a-sorted-matrix/

var countNegatives = function(grid) {
    const m=grid.length, n=grid[0].length;
    let i=0, j=n-1, cnt=0;
    while(i<m&&j>=0){
        if(grid[i][j]<0){cnt+=m-i;j--;}
        else i++;
    }
    return cnt;
};
