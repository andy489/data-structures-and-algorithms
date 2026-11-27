// https://leetcode.com/problems/check-if-there-is-a-valid-path-in-a-grid/

var hasValidPath = function(grid) {
    const m=grid.length, n=grid[0].length;
    const connects={1:[2,3],2:[0,1],3:[1,2],4:[1,3],5:[0,3],6:[0,2]};
    const dirs=[[-1,0,0],[1,0,1],[0,-1,2],[0,1,3]], opp=[1,0,3,2];
    const visited=Array.from({length:m},()=>new Array(n).fill(false));
    visited[0][0]=true;
    const q=[[0,0]];
    while(q.length){
        const[r,c]=q.shift();
        if(r===m-1&&c===n-1) return true;
        for(const[dr,dc,d]of dirs){
            const[nr,nc]=[r+dr,c+dc];
            if(nr>=0&&nr<m&&nc>=0&&nc<n&&!visited[nr][nc]){
                if(connects[grid[r][c]].includes(d)&&connects[grid[nr][nc]].includes(opp[d])){
                    visited[nr][nc]=true; q.push([nr,nc]);
                }
            }
        }
    }
    return false;
};
