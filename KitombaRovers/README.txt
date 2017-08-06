KITOMBA ROVERS by Gregory Graham

Thank you for choosing Kitomba for your rovers, we hope that this application
will meet your requirements.


SOURCE CODE:
Source code for this application is available at 
https://github.com/gregorydgraham/KitombaRoversApp

The application is written in Java using Maven and NetBeans.

Please feel free to investigate the other projects at my GitHub, I recommend 
https://github.com/gregorydgraham/DBvolution


RUNNING THE APPLICATION:
To execute the application use Powershell, Terminal, or the shell of your 
preference to navigate to the folder containing the 
KitombaRovers-1.0-SNAPSHOT.jar and execute the following command:
    java -jar KitombaRovers-1.0-SNAPSHOT.jar

To execute the supplied test input automatically, execute the command:
    java -jar KitombaRovers-1.0-SNAPSHOT.jar TEST

To enter your own test data, follow the prompts to enter the bounds and each 
rovers' starting position, heading, and instructions. Enter a blank line to 
execute all rovers' commands in order.


EXAMPLE 1:
Executing the automatic test:

$ java -jar KitombaRovers-1.0-SNAPSHOT.jar TEST
Enter Bounds>
<5 5
Enter Rover-1>
<1 2 N LMLMLMLMM
Enter Rover-2>
<3 3 E MMRMMRMRRM
Enter Rover-3>
<2 3 E MMRMMRMRRM
Enter Rover-4>
<
MOVE RESULTS
1 3 N
5 1 E
4 1 E


EXAMPLE 2:
Executing with NASA specified input:

$ java -jar KitombaRovers-1.0-SNAPSHOT.jar
Enter Bounds>
6 6
<6 6
Enter Rover-1>
1 2 N
<1 2 N
LMLMLMLMM
<LMLMLMLMM
Enter Rover-2>
2 3 E
<2 3 E
MMRMMRMRRM
<MMRMMRMRRM
Enter Rover-3>

<
MOVE RESULTS
1 3 N
4 1 E


EXAMPLE 3:
Executing with compact format:

$ java -jar KitombaRovers-1.0-SNAPSHOT.jar
Enter Bounds>
6 6 
<6 6
Enter Rover-1>
1 2 N LMLMLMLMM
<1 2 N LMLMLMLMM
Enter Rover-2>
2 3 E MMRMMRMRRM
<2 3 E MMRMMRMRRM
Enter Rover-3>

<
MOVE RESULTS
1 3 N
4 1 E


INPUT SYNTAX:
The application handles 2 different input formats. These are consistent with the 
2 formats provided in the text: one in the specification and the second in the 
test data. The specification clearly states that the rover-specific data should 
be 2 lines with the location and heading on the first line and moves on the 
second. The test input appeared to be specified as one continuous line with 
moves separated from the heading by a space. The application can distinguish 
both formats and the formats are incompatible so there can be no confusion about 
the meaning of the input.

NASA Specification:
    - the first line will be 2 integers, representing the maximum X and Y bounds, 
      separated by a space
    - the second line will be 2 integers and a direction, representing the starting
      position and heading of the rover, all separated by spaces
    - the third line will be a continuous series of moves (L, R, or M) i.e. 
      LMMR
    - the following lines will repeat the 2nd and 3rd lines for each rover
    - the final line will be empty/blank

Compact format:
    - the first line will be 2 integers, representing the maximum X and Y bounds, 
      separated by a space i.e. 4 5
    - the second line will be 2 integers and a direction, representing the 
      starting position and heading of the rover, all separated by spaces, and 
      then a space followed by a continuous series of moves (L, R, or M) i.e. 
      2 3 N LMRM
    - the following lines will be the same format as the second for each rover
    - the final line will be empty/blank


INPUT ERRORS: 
The input processing is deliberately particular about the input format and 
contents. The software has been written with the needs and restrictions of NASA 
in mind, and aims to avoid damaging irreplaceable rovers and wasting valuable 
Interplanetary Internet time.

Consequently the following input will be rejected:
    - non-integer numbers
    - negative numbers
    - directions other than N, S, E, or W
    - long form directions, for example North
    - lowercase directions or moves
    - Moves other than L, R, and M
    - leading, trailing, or extra spaces


MOVEMENT:
The minimum bound of the plateau is assumed to be at location 0 0 and that
rovers cannot pass beyond the 0 bound in any direction.  Similarly they can not
pass beyond the maximum bounds specified in the input. Move will change the 
location of the rover by 1 or -1 in the direction of its current heading. For a 
heading of N or S the Y value will be changed while E and W change the X value. 
N and E will change the location value by +1 while S and W change it by -1.

All rover moves are checked one step ahead so a dangerous move can be avoided.
Successful moves are performed by updating the location and heading then 
removing the completed move from the list of instructions.


MOVEMENT ERRORS:
Given that the rovers are irreplaceable and very expensive, error handling has 
been included in the application. An error during moving causes the rover to 
stop in place immediately before the dangerous move, retaining all remaining 
instructions, and an exception is reported. The error-causing move will be the 
first instruction in the queue.
The application does not attempt to correct the exceptions but future 
applications can handle the exceptions and successfully update the rover.

Movement errors are:
    - moving beyond the maximum bound
    - moving beyond the minimum bound (assumed to be 0)
    - moving to a space occupied by another rover

