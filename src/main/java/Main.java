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

		Picture pic = Parser.parseInput(inputFile);

		System.out.println(pic.toString());

        Path p = simple(pic);

	Picture repic = p.rePaint(pic.getN(), pic.getM());
	System.out.println(repic.toString());	
	
	if (pic.equals(repic)) {
	    System.out.println("OUTPUT OK");
	} else {
	    System.out.println("INVALID OUTPUT");
	}
	
        Writer.write("test.t",p);
    }

    public static Path simple(Picture pic){
        Path path = new Path();

        int last = 0;
        boolean b;
        for(int i = 0; i < pic.getN();i++){
            b = false;
            for(int j = 0; j < pic.getM();j++){
                if(pic.getCellValue(i,j) == Color.BLACK){
                    if(!b) {
                        b = true;
                        last = j;
                    }
                }
                else if(pic.getCellValue(i,j) == Color.BLANK){
                    if(b){
                        path.horizontalLines.add(new HorizontalLine(i,last,j-1));
                        last = 0;
                        b = false;
                    }
                }
            }
        }
        return path;
    }
}
