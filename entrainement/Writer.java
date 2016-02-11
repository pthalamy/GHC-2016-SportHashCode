package entrainement;

import java.io.File;
import java.io.FileWriter;

/**
 * Created by guillaume on 09/02/16.
 */
public class Writer {
    private static StringBuilder builder = new StringBuilder();
    private static int count = 0;

    public static void writeInFile(String file){
        try {
            File f = new File(file);
            FileWriter out = new FileWriter(f);
            out.write(Integer.toString(count));
            out.write("\n");
            out.write(builder.toString());
            out.flush();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void paintSquare(int row,int column,int size){
        builder.append("PAINT_SQUARE ").append(row).append(" ").append(column).append(" ").append(size).append("\n");
        count++;
    }

    public static void paintLine(int row1,int column1,int row2,int column2){
        builder.append("PAINT_LINE ").append(row1).append(" ").append(column1).append(" ")
                .append(row2).append(" ").append(column2).append("\n");
        count++;
    }

    public static void eraseCell(int row,int column){
        builder.append("ERASE_CELL ").append(row).append(" ").append(column).append("\n");
        count++;
    }

    public static void display(){
        System.out.println(count);
        System.out.println(builder.toString());
    }
    
    public static void write(String file,Path path){
        path.verticalLines.forEach(f -> paintLine(f.R1,f.C,f.R2,f.C));
        path.horizontalLines.forEach(f -> paintLine(f.R,f.C1,f.R,f.C2));
        path.squares.forEach(c -> paintSquare(c.R,c.C,c.S));
        path.destructions.forEach(d -> eraseCell(d.R,d.C));
        writeInFile(file);
    }
    
    public static void main(String[] args){
        paintSquare(1,2,3);
        paintLine(1,2,3,4);
        eraseCell(1,2);
        display();
        writeInFile("test.t");
    }
}
