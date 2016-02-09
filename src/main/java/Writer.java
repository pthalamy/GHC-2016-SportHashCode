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

    public static void paintSquare(byte row,byte column,byte size){
        builder.append("PAINT_SQUARE ").append(row).append(" ").append(column).append(" ").append(size).append("\n");
        count++;
    }

    public static void paintLine(byte row1,byte column1,byte row2,byte column2){
        builder.append("PAINT_LINE ").append(row1).append(" ").append(column1).append(" ")
                .append(row2).append(" ").append(column2).append("\n");
        count++;
    }

    public static void eraseCell(byte row,byte column){
        builder.append("ERASE_CELL ").append(row).append(" ").append(column).append("\n");
        count++;
    }

    public static void display(){
        System.out.println(count);
        System.out.println(builder.toString());
    }
    
    public static void main(String[] args){
        paintSquare((byte)1,(byte)2,(byte)3);
        paintLine((byte)1,(byte)2,(byte)3,(byte)4);
        eraseCell((byte)1,(byte)2);
        display();
        writeInFile("test.t");
    }
}
