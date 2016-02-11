package entrainement;

/**
 * Created by guillaume on 09/02/16.
 */
public enum Color {

    BLANK,BLACK,CHANGED;

    public String toString(){
        return Integer.toString(this.ordinal());
    }


    public static Color depaint(Picture pic, Color cellValue,boolean destroy) {
        switch (cellValue){
            case BLANK:
                return CHANGED;
            case BLACK:
                pic.decCount();
                return BLANK;
            case CHANGED:
                if(destroy)
                    throw new Error("Can't destroy a changed cell");
                return CHANGED;
        }
        return CHANGED;
    }


    public static void main(String[] args){

        Picture p = new Picture(10,10);
        /*for(int i = 2; i < 5; i ++){
            for(int j = 2; j < 5;j++){
                p.setCell(i,j,Color.BLACK);
                p.incCount();
            }
        }*/
        System.out.println(p);
        Path d = new Path();
        d.squares.add(new Square(4,4,3));
        System.out.println(d.rePaint(10,10));


    }
}
