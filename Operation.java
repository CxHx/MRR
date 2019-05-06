package lambdacalc;

import java.util.HashMap;
import java.util.Map;
import java.util.function.IntBinaryOperator;

/**
 *
 * @author Pieter van den Hombergh {@code <p.vandenhombergh@fontys.nl>}
 */
public enum Operation {
    //TODO
    ADD("+",(i,j) -> i+j), 
    SUBTRACT("-", (i,j) -> i-j),  
    MULTIPLY("*", (i,j) -> i*j),
    //*not working* DIVIDE("/", (i,j) -> i/j), 
    //*not working* POWER("^", Math::pow);
;
    /**
     * Get the operator using its symbol.
     * This method does a linear search through the values of the values.
     *
     * @param symbol to search
     * @return operation when found, null otherwise.
     */
    public static Operation get( String symbol ) {
        //TODO 4 implement getOperator
        for (Operation operations : Operation.values()) {
            if (operations.symbol.equals(symbol)) {
                return operations;
            }
        }
        return null;
    }
    
    //Use a static map to store the symbol-> value mapping.
    //TODO 6 alternate simpler (as in lazy) solution. 
    
    /**
     * The operation is a IntBinaryOperator.{
     *
     * @see java.util.function.IntBinaryOperation}.
     */
    private final IntBinaryOperator operator;
    /**
     * The symbol that identifies the operation.
     */
    private final String symbol;

    /**
     * The constructor to create the Operation instances.
     *
     * @param symbol
     * @param operator
     */
    //TODO 3 create constructor
    private Operation(String symbol, IntBinaryOperator operator) {
        this.symbol = symbol;
        this.operator = operator;
    }

    /**
     * Execute the calculation.
     *
     * @param a first param
     * @param b second param
     * @return result get the computation.
     */
    public int compute( int a, int b ) {
        //TODO 5 implement compute
        return (int) operator.applyAsInt(a, b);
        //*divide and power is never returning int*
    }

    private String getSymbol() {
        return symbol;
    }
}
