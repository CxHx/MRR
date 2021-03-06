    package lambdacalc;

import java.util.Scanner;
import java.util.function.IntBinaryOperator;

/**
 *
 * @author Pieter van den Hombergh {@code <p.vandenhombergh@fontys.nl>}
 */
public class Calculator {

    public static void main( String[] args ) {
        Scanner scanner = new Scanner( System.in );
        System.out.print( "calc: " );
        String line = scanner.nextLine();
        String[] tokens = line.split( "\\s+" );
        while ( tokens.length >= 3 ) {
            System.out.println( line + " = " + compute( tokens ) );
            System.out.print( "calc: " );
            line = scanner.nextLine();
            tokens = line.split( "\\s+" );
        }
    }

    static int compute( String... tokens ) {
        if ( tokens.length < 3 ) {
            return 0;
        }
        int a = Integer.parseInt( tokens[ 0 ] );
        int b = Integer.parseInt( tokens[ 2 ] );
        String symbol = tokens[ 1 ];

        return Operation.get( symbol ).compute( a, b );
    }

}
