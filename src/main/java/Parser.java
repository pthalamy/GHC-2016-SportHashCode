
import java.io.*;
import java.util.Scanner;

public class Parser {

    public static Picture parseInput(File inputFile) {

        try {
            Scanner sc = new Scanner(inputFile);
            int N = sc.nextInt();
            int M = sc.nextInt();

            Picture pic = new Picture(N, M);
            String cellChar;
            for (int R = 0; R < N; R++) {
                cellChar = sc.next();
                for (int C = 0; C < M; C++) {


                    if (cellChar.charAt(C) == '#') {
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
