
import java.util.LinkedList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author airone
 */
class Path {
    LinkedList<Square> squares = new LinkedList<Square>();
    LinkedList<HorizontalLine> horizontalLines = new LinkedList<HorizontalLine>();
    LinkedList<VerticalLine> verticalLines = new LinkedList<VerticalLine>();
    LinkedList<Destruction> destructions = new LinkedList<Destruction>();
    
    public int nbOperations() {
        return squares.size() + horizontalLines.size() + verticalLines.size()
                + destructions.size();
    }

    public Path clone(){
        Path p = new Path();
        this.squares.forEach(f -> p.squares.add(f.clone()));
        this.horizontalLines.forEach(f -> p.horizontalLines.add(f.clone()));
        this.verticalLines.forEach(f -> p.verticalLines.add(f.clone()));
        this.destructions.forEach(f -> p.destructions.add(f.clone()));
        return p;
    }
    
    public void add(Path anotherPath) {
        
    }
	
    /** Recreates the original picture of dimension N x M from this instance of path */
    public Picture rePaint(int N, int M) {
        Picture repic = new Picture(N, M);

        for (Square sq : this.squares) {
            sq.paint(repic);
        }

        for (HorizontalLine hl : this.horizontalLines) {
            hl.paint(repic);
        }

        for (VerticalLine vl : this.verticalLines) {
            vl.paint(repic);
        }

        for (Destruction d : this.destructions) {
            d.paint(repic);
        }

        return repic;
    }

    /** Recreates the original picture of dimension N x M from this instance of path */
    public Picture dePaint(Picture repic) {
        for (Square sq : this.squares) {
            sq.depaint(repic);
        }

        for (HorizontalLine hl : this.horizontalLines) {
            hl.depaint(repic);
        }

        for (VerticalLine vl : this.verticalLines) {
            vl.depaint(repic);
        }

        for (Destruction d : this.destructions) {
            d.depaint(repic);
        }

        return repic;
    }
}
