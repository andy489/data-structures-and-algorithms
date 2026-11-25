// https://leetcode.com/problems/contain-virus/

var containVirus = function(grid) {
    const m = grid.length, n = grid[0].length;
    const dirs = [[0,1],[0,-1],[1,0],[-1,0]];
    let total = 0;
    while (true) {
        const visited = Array.from({length:m},()=>new Array(n).fill(false));
        const regions=[], threats=[], walls=[];
        for (let i=0;i<m;i++) for (let j=0;j<n;j++) {
            if (grid[i][j]===1 && !visited[i][j]) {
                const region=[], threat=new Set(); let wall=0;
                const q=[[i,j]]; visited[i][j]=true;
                while (q.length) {
                    const [r,c]=q.shift(); region.push([r,c]);
                    for (const [dr,dc] of dirs) {
                        const nr=r+dr,nc=c+dc;
                        if (nr>=0&&nr<m&&nc>=0&&nc<n) {
                            if (grid[nr][nc]===1&&!visited[nr][nc]) { visited[nr][nc]=true; q.push([nr,nc]); }
                            else if (grid[nr][nc]===0) { threat.add(nr*n+nc); wall++; }
                        }
                    }
                }
                if (threat.size) { regions.push(region); threats.push(threat); walls.push(wall); }
            }
        }
        if (!regions.length) break;
        let worst=0;
        for (let i=1;i<threats.length;i++) if (threats[i].size>threats[worst].size) worst=i;
        total+=walls[worst];
        for (const [r,c] of regions[worst]) grid[r][c]=-1;
        for (let i=0;i<regions.length;i++) if (i!==worst) {
            for (const [r,c] of regions[i]) for (const [dr,dc] of dirs) {
                const nr=r+dr,nc=c+dc;
                if (nr>=0&&nr<m&&nc>=0&&nc<n&&grid[nr][nc]===0) grid[nr][nc]=1;
            }
        }
    }
    return total;
};
