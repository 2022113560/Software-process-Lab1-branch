/* Copyright (c) 2015-2016 MIT 6.005 course staff, all rights reserved.
 * Redistribution of original or derived work requires permission of course staff.
 */
package P1.poet;

import java.io.File;
import java.io.IOException;

/**
 * Example program using GraphPoet.
 * 
 * <p>PS2 instructions: you are free to change this example class.
 */
public class Main {
    
    /**
     * Generate example poetry.
     * 
     * @param args unused
     * @throws IOException if a poet corpus file cannot be found or read
     */
    public static void main(String[] args) throws IOException {
        final GraphPoet nimoy = new GraphPoet(new File("src/P1/poet/mugar-omni-theater.txt"));
        final String input = "Test the system.";
        System.out.println(input + "\n>>>\n" + nimoy.poem(input));
        System.out.println("------------------------------------");
        
      //"Stopping by Woods on a Snowy Evening" by Robert Frost
        final GraphPoet graphPoet = new GraphPoet(new File("src/P1/poet/Stopping by Woods on a Snowy Evening.txt"));
        final String inputString = "He will see me here";
        final String output = graphPoet.poem(inputString);
        System.out.println(inputString + "\n>>>\n" + output);
    }
    
}
