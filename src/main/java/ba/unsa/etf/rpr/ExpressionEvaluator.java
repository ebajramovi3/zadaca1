package ba.unsa.etf.rpr;

import java.util.Stack;
import static java.lang.Double.parseDouble;

public class ExpressionEvaluator {
    private static java.util.Stack<String> operators;
    private static java.util.Stack<Double> values;

    ExpressionEvaluator() {
        operators = new Stack<String>();
        values = new Stack<Double>();
    }

    public static Double evaluate(String str) throws RuntimeException {
        String[] izraz = str.split(" ");
        Double result = (double) 0;
        for(int i = 0; i < izraz.length; i++){
            if(izraz[i].equals( "*") || izraz[i].equals("/") || izraz[i].equals("+") || izraz[i].equals("-") || izraz[i].equals("sqrt"))
                 operators.push(izraz[i]);
            else if(izraz[i].equals(")")) {
                result = values.pop();
                String operator = operators.pop();
                    if(operator.equals("*"))
                        result = result * values.pop();
                    else if(operator.equals("/"))
                        result = values.pop() / result;
                    else if(operator.equals("+"))
                        result = result + values.pop();
                    else if(operator.equals("-"))
                        result = values.pop() - result;
                    else if(operator.equals("sqrt"))
                        result = Math.sqrt(result);
                    values.push(result);
            }
            else if(!izraz[i].equals("("))
                try {
                    values.push(parseDouble(izraz[i]));
                }catch(NumberFormatException exception){
                    throw new RuntimeException("Izraz nije validan");
                }

            }
        if(operators.size() != 0) throw new RuntimeException("Izraz nije validan");
        return values.pop();
    }
}
