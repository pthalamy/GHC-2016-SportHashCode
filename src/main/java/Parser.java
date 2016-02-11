import java.util.Scanner;

/**
 * Created by guillaume on 11/02/16.
 */
public class Parser {

    public static Object parse(String file){
        Scanner sc = new Scanner(file);
        int firstInt;

        if(sc.hasNextInt())
			firstInt = sc.nextInt();
		
        while(sc.hasNext()) {
            String line = sc.next();
            line = line.trim(); //Si il y a des characteres vides devant (normalement ne fait rien)
            for (int i = 0; i < line.length(); i++) {
                char c = line.charAt(i);
                //Si un charactere est un delimiter
                String[] tab = line.split(",");//si , est le delimiter
                for (int j = 0; j < tab.length; j++) {
                    Integer.parseInt(tab[i]);
                }


            }
        }
		
        return null;
    }


}
