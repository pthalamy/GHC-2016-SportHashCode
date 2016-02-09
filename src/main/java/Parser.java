
import java.io.*;
import java.util.Scanner;

public class Parser {

    public static Picture parseInput(File inputFile) {

		FileReader sc = null;
		try {
			sc = new FileReader(inputFile);
			int N = sc.read();
			int M = sc.read();

			Picture pic = new Picture(N, M);
			int cellChar;
			for (int R = 0; R < N; R++) {
				for (int C = 0; C < M; C++) {

					cellChar = sc.read();

					if (cellChar == '#') {
                        pic.setCell(R, C, Color.BLACK);
                        pic.incCount();
                    }
					else
						pic.setCell(R, C, Color.BLANK);
				}
			}

			return pic;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
    }
}
