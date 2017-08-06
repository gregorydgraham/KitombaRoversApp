Kitomba Rovers by Gregory Graham.

Thank you for choosing Kitomba for your rovers, we hope that this application
will meet your requirements.

To execute the application use Powershell, Terminal, or the shell of your 
preference to navigate to the folder containing the 
KitombaRovers-1.0-SNAPSHOT.jar and execute the following command:
    java -jar KitombaRovers-1.0-SNAPSHOT.jar

To execute the supplied test input automatically execute the command:
    java -jar KitombaRovers-1.0-SNAPSHOT.jar TEST

To enter your own test data, follow the prompts to enter the bounds and the 
rovers. Enter a blank line to execute the rovers' commands.

EXAMPLES:

$ java -jar KitombaRovers-1.0-SNAPSHOT.jar TEST
Enter Bounds>
5 5
Enter Rover-1>
1 2 N
LMLMLMLMM
Enter Rover-2>
3 3 E
MMRMMRMRRM
Enter Rover-3>
2 3 E
MMRMMRMRRM
Enter Rover-4>

MOVE RESULTS
1 3 N
5 1 E
4 1 E

$ java -jar KitombaRovers-1.0-SNAPSHOT.jar
Enter Bounds>
6 6 
6 6
Enter Rover-1>
1 2 N LMLMLMLMM
1 2 N LMLMLMLMM
Enter Rover-2>
2 3 E MMRMMRMRRM
2 3 E MMRMMRMRRM
Enter Rover-3>


MOVE RESULTS
1 3 N
4 1 E

INPUT SYNTAX:
The specification clearly states that the rover-specific data should be 2 lines 
with the location and heading on the first line and moves on the second. The 
test input shown was less ambiguous. Due to this inconsistency the rover data 
can entered as specified or as one continuous line with moves separated from the 
heading by a space. The 2 formats are incompatible (see next paragraph) so there 
can be no confusion about the meaning of the input.

The input processing is very particular about the input format and contents. The 
software has been written with the needs and restrictions of NASA in mind, and 
aims to avoid damaging irreplaceable rovers and wasting valuable Interplanetary 
Internet time.
The following input will be rejected:
    - non-integer numbers
    - directions other than N, S, E, or W
    - long form directions, for example North
    - lowercase directions or moves
    - Moves other than L, R, and M
    - leading, trailing, or extra spaces

ERROR HANDLING:
The specification had very little to say about error conditions and their 
handling.  Maximum bounds are mentioned and have been handled as an exception.
Also checked are the minimum bounds and other rovers.  No rover may move to a 
negative grid reference.  No rover may enter a grid reference occupied by 
another rover.  Both cases generate exceptions and cause the rover to stop at
immediately storing it's location, heading, and remaining moves. 

The application does not attempt to correct the exceptions but future 
applications can handle the exceptions and successfully update the rover.

