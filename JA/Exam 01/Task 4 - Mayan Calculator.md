## Task 4 – Mayan Calculator 

Since ancient times the Mayan people had special flow of describing numbers.<br>
Your job is to understand their technique of describing numbers and start re-using it.<br>
You will be provided with exact description for the digits “0123456789” (exactly in that order).<br>
Their representation **may span on several lines**.<br>
After that you will be provided with a simple integer, which you should represent in the provided Mayan representation. 

NOTE: the width of the numbers is not provided to you, but you are assured that:<br>
width of digit 0 == width of digit 1 == width of digit 2 == … == width of digit 9 <br>
```
Example input: 
2                           //number of lines for Mayan digits representation 
aabbccddeeffgghhiijj        //digits ‘0123456789’ 1st row  
aabbccddeeffgghhiijj        //digits ‘0123456789’ 2nd row 
8330                        //number to represent 
 
Example output: 
iiddddaa 
iiddddaa 
``` 
#### Input 
First a single integers (N) indicating how many lines of ‘digit representing data’.<br>
Next read (N) lines of ‘digit representing data’. Digit will only be represented in the ‘0123456789’ exact order.<br>
On the last row – read a single integer (T) – the number to represent (print to the console) with the Mayan description.
#### Restrictions 
Number to represent (T) **will never begin with a leading zero (0)**. <br>
Time limit: 250ms (0.25s)<br>
Memory limit: 16 MB 

#### Examples

Input|Output
-|-
1<br>0123456789<br>20024|20024 
2<br>aabbccddeeffgghhiijj<br>aabbccddeeffgghhiijj<br>8330|iiddddaa<br>iiddddaa 
4<br>*-- //\/\ /----------*<br>*||/| / //_|_|_ |\/||*<br>*|| |/  \ | ||| //\-|*<br>*------\/ -----/ ----*<br>1370425869|
* //\---- //\--------* | *
/| / |||/_ /|_\/|_||  | \ /|| |/  |/\||-| 
--\// -- ----------- 
