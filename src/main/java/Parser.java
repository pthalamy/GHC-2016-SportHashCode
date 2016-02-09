
import java.io.*;

public class Parser {

    public static Picture parseInput(File inputFile) {

	Scanner sc = new Scanner(inputFile);
	
	int N = sc.nextInt();
	int M = sc.nextInt();
	
	Picture pic = new Picture(N, M);

	String cellChar;
	
	for (int R = 0; R < N; R++) {
	    for (int C = 0; C < M; C++) {

		cellChar = sc.next();
		
		if (cellChar.equals("#"))
		    pic.setCell(R, C, 1);		    
		else 
		    pic.setCell(R, C, 0);
	    }
	}

	return pic;
    }
}
