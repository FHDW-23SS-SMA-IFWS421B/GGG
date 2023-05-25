package ampel;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.function.IntPredicate;

public class StateMachine {
    
    public static void main(String[] args) throws FileNotFoundException, InterruptedException {
        	ContextManager myContextManager = new ContextManager();
            while(true){
                String event = input();
                if (event.equals("b")){
                    myContextManager.onButton();
                }
                /*if (event.equals("s")){
                    myContextManager.onTimeoutStart();;
                }
                if (event.equals("t")){
                    myContextManager.onTimeoutStop();
                                }
                if (event.equals("e")){
                    myContextManager.onTimeoutEnd();;
                }*/
                myContextManager.update();
                Thread.sleep(1000);
            }
            
    }

    public static String input()
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));
        String input ="";
        try {
        input = in.readLine();
    }
    catch (IOException e) {
        e.printStackTrace();
    }

        return input;
    }
}
