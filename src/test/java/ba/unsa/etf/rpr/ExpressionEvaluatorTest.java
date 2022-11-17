package ba.unsa.etf.rpr;

import junit.framework.TestCase;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class ExpressionEvaluatorTest extends TestCase {

    @Test
    public void testMultiplication() {
        String input = new String("( 26 * 7 )");
        assertEquals( (double)182, ExpressionEvaluator.evaluate(input));
    }

    @Test
    public void testAddition() {
        String input = new String("( 11 + 6 )");
        assertEquals( (double)17, ExpressionEvaluator.evaluate(input));
    }

    @Test
    public void testSubtraction(){
        String input = new String("( 9 - 3 )");
        assertEquals( (double)6, ExpressionEvaluator.evaluate(input));
    }

    @Test
    public void testDivision(){
        String input = new String("( 24 / 5 )");
        assertEquals( 4.8, ExpressionEvaluator.evaluate(input));
    }

    @Test
    public void testRoot(){
        String input = new String("sqrt ( 16 )");
        assertEquals( (double)4, ExpressionEvaluator.evaluate(input));
    }

    @Test
    public void testExceptionWithoutSpaces() {
        String input = new String("(24 / 81 )");
        Assertions.assertThrows( RuntimeException.class, () -> ExpressionEvaluator.evaluate(input), "Izraz nije validan");
    }

    @Test
    public void testExceptionWithoutParenthesis() {
        String input = new String("( (  26 * 7 ) + 25 ) - sqrt ( 9 ) ) )");
        Assertions.assertThrows( RuntimeException.class, () -> ExpressionEvaluator.evaluate(input), "Izraz nije validan");
    }

    @Test
    public void testComplexExpressions(){
        String input = new String("( ( ( 26 * 7 ) + 25 ) + ( ( 24 / 6 ) - sqrt ( 9 ) ) )");
        assertEquals( (double)208, ExpressionEvaluator.evaluate(input));
    }
}
