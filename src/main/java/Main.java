import java.io.*;

/**
 * Created by guillaume on 09/02/16.
 */
public class Main {

    public static void main(String[] args){

	if (args.length < 1) {
	    System.err.println("error: missing parameter: input file");
	    System.err.println("usage: launch.sh input.in");
	    System.exit(1);
	}

	String inputFileName = args[0];
	int extIndex = inputFileName.lastIndexOf(".in");
        String outputFileName = inputFileName.substring(0, extIndex) + ".out";
	
	File inputFile = new File(inputFileName);
	File outputFile = new File(outputFileName);
	
	Picture pic = Parser.parseInput(inputFile);	

	System.out.println(pic.toString());
    }
}
