Given a vector containing numbers, move all the zeros in the vector 
a) at its end;
b) at its beginning.

*Example:*

vec = {1, 0, 4, 5, 3, 0, 7, 8, 0, 10}

output = {1, 4, 5, 3, 7, 8, 10, 0, 0, 0}

*Solution:*

а) The idea is to move non-zero elements sequentially to next available position starting from 0. After all elements in the array are processed, we fill all remaining indexes by 0.
