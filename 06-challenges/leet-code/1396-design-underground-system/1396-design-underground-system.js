// https://leetcode.com/problems/design-underground-system/

class UndergroundSystem {
    constructor(){this.trips=new Map();this.routes=new Map();}
    checkIn(id,station,t){this.trips.set(id,[station,t]);}
    checkOut(id,station,t){
        const[st,st_t]=this.trips.get(id); this.trips.delete(id);
        const key=`${st}#${station}`, r=this.routes.get(key)||[0,0];
        this.routes.set(key,[r[0]+t-st_t,r[1]+1]);
    }
    getAverageTime(s,e){const[tot,cnt]=this.routes.get(`${s}#${e}`);return tot/cnt;}
}
