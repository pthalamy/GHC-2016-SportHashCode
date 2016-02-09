import java.io.*;

/**
 * Created by guillaume on 09/02/16.
 */
public class Main {

    public static void main(String[] args){
	
	File inputFile = new File(args[0]);
      
	System.out.println("arg[0] " + args[0]);
	
	Picture pic = Parser.parseInput(inputFile);

	System.out.println(pic.toString());
    }
}
