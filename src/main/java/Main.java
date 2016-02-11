import java.io.FileNotFoundException;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {
        if (args.length < 1) {
            System.err.println("error: missing parameter: input file");
            System.err.println("usage: launch.sh input.in");
            System.exit(1);
        }

		String inputFileName = args[0];
		
		System.out.println("Output File Name: " + getOutputFileName(inputFileName));

		Data d = Parser.parse(inputFileName);

		for (int i = 0; i < d.turns; i++) {
			d.currentTurn = i;

			System.out.println(" Turn #" + i);

			d.drones.forEach(dr -> dr.update(d));
                        //System.out.println(d);

		}

		Writer.writeInFile(getOutputFileName(inputFileName));
	}


	public static String getOutputFileName(String inputFileName) {
		int extIndex = inputFileName.lastIndexOf(".in");

		if (extIndex == -1) {
			System.err.println("error: invalid input file extension: expected .in");
            System.err.println("usage: launch.sh input.in");
			System.exit(1);
		}

		String outputFileName = inputFileName.substring(0, extIndex) + ".out";

		return outputFileName;
	}
}
