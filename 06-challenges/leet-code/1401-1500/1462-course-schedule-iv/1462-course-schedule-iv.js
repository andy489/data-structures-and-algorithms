// https://leetcode.com/problems/course-schedule-iv/

var checkIfPrerequisite = function(numCourses, prerequisites, queries) {
    const reach = Array.from({length:numCourses},()=>new Array(numCourses).fill(false));
    for (const [u,v] of prerequisites) reach[u][v] = true;
    for (let k=0;k<numCourses;k++)
        for (let i=0;i<numCourses;i++)
            for (let j=0;j<numCourses;j++)
                if (reach[i][k]&&reach[k][j]) reach[i][j]=true;
    return queries.map(([u,v])=>reach[u][v]);
};
