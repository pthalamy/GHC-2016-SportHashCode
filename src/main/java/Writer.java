import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by guillaume on 09/02/16.
 */
public class Writer {
    private static List<Line> builder = new LinkedList<>();
    private static int count = 0;

    public static void writeInFile(String file){
        try {
            File f = new File(file);
            FileWriter out = new FileWriter(f);
            builder.forEach(s -> {
                try {
                    out.write(s.toString());
                    out.write("\n");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            out.flush();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void add(Line l){
        count++;
        builder.add(l);
    }

    public static Line add(String s){
        count++;
        Line l = new Line(s);
        builder.add(l);
        return l;
    }

    public static Line add(Object o){
        count++;
        return add(o.toString());
    }

    public static Line add(String s,int index){
        count++;
        Line l = new Line(s);
        builder.add(index,l);
        return l;
    }

    public static void add(Line l,int index){
        count++;
        builder.add(index,l);
    }

    public static Line add(Object o,int index){
        count++;
        return add(o.toString(),index);
    }

    public static void display(){
        System.out.println(count);
        builder.forEach(System.out::println);
    }

    public static void main(String[] args){

        display();
        writeInFile("test.t");
    }
}
