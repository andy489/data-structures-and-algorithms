// https://leetcode.com/problems/queens-that-can-attack-the-king/

var queensAttacktheKing = function(queens, king) {
    const s=new Set(queens.map(([r,c])=>r*8+c)); const res=[];
    for(let dr=-1;dr<=1;dr++) for(let dc=-1;dc<=1;dc++){
        if(!dr&&!dc)continue;
        let r=king[0]+dr,c=king[1]+dc;
        while(r>=0&&r<8&&c>=0&&c<8){
            if(s.has(r*8+c)){res.push([r,c]);break;}
            r+=dr;c+=dc;
        }
    }
    return res;
};
