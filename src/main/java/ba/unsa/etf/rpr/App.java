package ba.unsa.etf.rpr;

/**
 * Main program
 * converts command line input to one string separated with blank spaces
 */

public class App
{
    public static void main( String[] args ){
        StringBuilder input = new StringBuilder();
        for(int i = 0; i < args.length; i++) {
            if (i >= 1)
                input.append(" ").append(args[i].trim());
            else
                input.append(args[i].trim());
        }
        try{
            System.out.println((ExpressionEvaluator.evaluate(input.toString())).toString());
        }catch(Exception exception){
            System.out.println(exception.getMessage());
        }

    }
}
