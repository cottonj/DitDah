# DitDah
A Morse Code Generator

To run a test of this program, download the dit.jar file, the ditdah.bat file.  Modify the bat file to point to your Java installation and to a source text file to be played. You can set the parms for tone and words per minute.   

To compile:
the "main" method is in DitDah.java - you can set the default frequency tone and words per minute (wpm) here.  

The module "beta.java" is an array of letters 'a' thru 'z' and '0' thru '9' plus punctuation.  The method setBetaLetters()  will generate a bit array containing a wave file to be played - for each letter/number/punctuation.  

The program first initates the array to contain the letters, etc. Then opens a text file to play in morse code.  
The text file may be a local file or a file on the internet.  A different version of this program gets Google News, strips the tags, etc. and plays the news in Morse Code.   

Joe Cotton, W3TTT
