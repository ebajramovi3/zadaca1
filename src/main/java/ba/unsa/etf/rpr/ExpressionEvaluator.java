package ba.unsa.etf.rpr;

import java.util.Stack;
import static java.lang.Double.parseDouble;

public class ExpressionEvaluator {
    private java.util.Stack<String> operators;
    private java.util.Stack<Double> values;

    ExpressionEvaluator() {
        operators = new Stack<String>();
        values = new Stack<Double>();
    }

    public Double evaluate(String str) throws Exception {
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
                        result = result / values.pop();
                    else if(operator.equals("+"))
                        result = result + values.pop();
                    else if(operator.equals("-"))
                        result = result - values.pop();
                    else if(operator.equals("sqrt"))
                        result = Math.sqrt(result);
                    values.push(result);
            }
            else if(!izraz[i].equals("("))
                try {
                    values.push(parseDouble(izraz[i]));
                }catch(NumberFormatException exception){
                    Exception RuntimeException = new Exception("Izraz nije validan");
                    throw RuntimeException;
                }
            }
        return values.pop();
    }
}
