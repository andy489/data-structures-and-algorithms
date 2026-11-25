// https://leetcode.com/problems/keys-and-rooms/

var canVisitAllRooms = function(rooms) {
    const visited = new Set([0]);
    const stack = [0];
    while (stack.length) {
        const room = stack.pop();
        for (const key of rooms[room]) {
            if (!visited.has(key)) {
                visited.add(key);
                stack.push(key);
            }
        }
    }
    return visited.size === rooms.length;
};
