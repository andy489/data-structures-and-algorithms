// https://leetcode.com/problems/cinema-seat-allocation/

var maxNumberOfFamilies = function(n, reservedSeats) {
    const rows=new Map();
    for(const[r,s]of reservedSeats) if(s>=2&&s<=9) rows.set(r,(rows.get(r)||0)|(1<<s));
    let cnt=2*(n-rows.size);
    const LM=(1<<2)|(1<<3)|(1<<4)|(1<<5);
    const MM=(1<<4)|(1<<5)|(1<<6)|(1<<7);
    const RM=(1<<6)|(1<<7)|(1<<8)|(1<<9);
    for(const mask of rows.values()){
        const l=!(mask&LM), m=!(mask&MM), r=!(mask&RM);
        if(l&&r) cnt+=2; else if(l||m||r) cnt++;
    }
    return cnt;
};
