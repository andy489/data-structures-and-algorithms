## Task 1 – Reporter 

You are a reporter for the local sports newspaper. At the moment you are taking an interview from a hockey player. At some point during the interview he begins to stutter and repeats some of the words twice and even three times. The player must be in a shock after the heavy game because we also repeats whole phrases within the same sentence. 

At the end of the interview the player asks you to “clear” the interview of his stutter and repeats of whole phrases before you publish it. 

In the input interview they may be more than one sentences. Each sentence is constructed from **whitespace** delimited words and **ends** with a ‘.’ (dot) symbol. The dot symbol is also **whitespace** delimited from neighbor words. 

Your program should eliminate the duplicate words within each sentence – only the first occurrence of any word should be kept.<br> NOTE: two sentences can have the same word in them. <br>
Example input: *You You* did a great job *You* . You too <br>Example output: You did a great job . You too 
 
#### Input 
First read a single integer (N) indicating how many lines of data you should read. <br>
Next read N **lines** of data that will hold the whole interview. <br>
NOTE: end of the line does **Not** mean end of sentence. The symbol ‘.’(dot) marks the end of sentence. <br>
NOTE2: The ‘.’ (dot) symbol is **Not assured** to be present for the last sentence. <br>
#### Restrictions 
Time limit: 250ms (0.25s)<br> Memory limit: 16 MB 
 
#### Examples 
Input|Output 
-|-
1<br>So I I was about about to score a goal|So I was about to score a goal  
2<br>and then everything then happened . It<br>was all all clear to me all .|and then everything happened . It was all clear to me .  
3<br>How is this How<br>even possible .<br>I do not do not know know|How is this even possible . I do not know  
