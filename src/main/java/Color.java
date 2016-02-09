/**
 * Created by guillaume on 09/02/16.
 */
public enum Color {

    BLANK,BLACK,CHANGED;

    public String toString(){
        return Integer.toString(this.ordinal());
    }


    public static Color depaint(Color cellValue,boolean destroy) {
        switch (cellValue){
            case BLANK:
                return CHANGED;
            case BLACK:
                return BLANK;
            case CHANGED:
                if(destroy)
                    throw new Error("Can't destroy a changed cell");
                return CHANGED;
        }
        return CHANGED;
    }
}
