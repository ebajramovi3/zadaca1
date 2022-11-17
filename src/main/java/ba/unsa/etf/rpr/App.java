package ba.unsa.etf.rpr;

import java.sql.SQLOutput;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ){
        if (args.length < 2){
            System.err.println("Nedovoljan broj argumenata java -jar rpr-zadaca1.jar [funkcija] [argument]");
        } else if (!args[0].equals("evaluate")) {
            System.err.println("Nevalidna funkcija, evaluate je podrzana funkcija");
        }else{
        String input = new String();
        for(int i = 0; i < args.length; i++){
            if(i >= 2)
            input = input + " " + args[i];
            else if(i == 1)
                input = args[i];
        }
            System.out.println(input);
        ExpressionEvaluator result = new ExpressionEvaluator();
        try{
            System.out.println(result.evaluate(input));
        }catch(Exception exception){
            System.out.println(exception.getMessage());
        }
        }

}
}
