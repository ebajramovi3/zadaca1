package ba.unsa.etf.rpr;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.Optional;

public class ExpressionEvaluatorTest {

    @Test
    public void testMultiplication() {
        String input = new String("( 26 * 7 )");
        Assert.assertEquals(Optional.of((double) 182), ExpressionEvaluator.evaluate(input));
    }

    @Test
    public void testAddition() {
        String input = new String("( 11 + 6 )");
        Assert.assertEquals(Optional.of((double) 17), ExpressionEvaluator.evaluate(input));
    }

    @Test
    public void testSubtraction(){
        String input = new String("( 9 - 3 )");
        Assert.assertEquals(Optional.of((double) 6), ExpressionEvaluator.evaluate(input));
    }

    @Test
    public void testDivision(){
        String input = new String("( 24 / 5 )");
        Assert.assertEquals(Optional.of(4.8), ExpressionEvaluator.evaluate(input));
    }

    @Test
    public void testRoot(){
        String input = new String("sqrt ( 16 )");
        Assert.assertEquals(Optional.of((double) 4), ExpressionEvaluator.evaluate(input));
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
        Assert.assertEquals(Optional.of((double) 208), ExpressionEvaluator.evaluate(input));
    }
}
