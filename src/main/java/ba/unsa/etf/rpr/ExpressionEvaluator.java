package ba.unsa.etf.rpr;

import java.util.Stack;
import static java.lang.Double.parseDouble;

/**
 * class ExpressionEvaluator
 * two private attributes
 * Dijkstra’s Algorithm
 */
public class ExpressionEvaluator {
    private static final java.util.Stack<String> operators = new Stack<>();
    private static final java.util.Stack<Double> values = new Stack<>();

    public static Double evaluate(String str) throws RuntimeException {
        String[] expression = str.split(" ");
        Double result;
        for(int i = 0; i < expression.length; i++) {
            if (expression[i].equals("*") || expression[i].equals("/") || expression[i].equals("+") || expression[i].equals("-") || expression[i].equals("sqrt"))
                operators.push(expression[i]);
            else if (expression[i].equals(")")) {
                String operator;
                try {
                    result = values.pop();
                    operator = operators.pop();
                } catch (Exception exception) {
                    throw new RuntimeException("Izraz nije validan");
                }
                switch (operator) {
                    case "*":
                        result = result * values.pop();
                        break;
                    case "/":
                        result = values.pop() / result;
                        break;
                    case "+":
                        result = result + values.pop();
                        break;
                    case "-":
                        result = values.pop() - result;
                        break;
                    case "sqrt":
                        result = Math.sqrt(result);
                        break;
                }
                values.push(result);
            } else if (!expression[i].equals("(")) {
                if (i == 0)
                    throw new RuntimeException("Izraz nije validan");

                try {
                    values.push(parseDouble(expression[i]));
                } catch (NumberFormatException exception) {
                    throw new RuntimeException("Izraz nije validan");
                }

            }
        }
        if(operators.size() != 0) throw new RuntimeException("Izraz nije validan");
        return values.pop();
    }
}
