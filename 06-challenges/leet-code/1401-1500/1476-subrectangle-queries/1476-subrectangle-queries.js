// https://leetcode.com/problems/subrectangle-queries/

class SubrectangleQueries {
    constructor(rectangle) { this.rect=rectangle; this.updates=[]; }
    updateSubrectangle(r1,c1,r2,c2,v){ this.updates.push([r1,c1,r2,c2,v]); }
    getValue(row,col){
        for(let i=this.updates.length-1;i>=0;i--){
            const [r1,c1,r2,c2,v]=this.updates[i];
            if(row>=r1&&row<=r2&&col>=c1&&col<=c2)return v;
        }
        return this.rect[row][col];
    }
}
