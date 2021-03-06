package entrainement;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author airone
 */
class Square {
    public int R;
    public int C;
    public int S;

    public Square(int r, int c, int s) {
        R = r;
        C = c;
        S = s;
    }

    @Override
    public Square clone(){
        return new Square(R,C,S);
    }
	
    public void paint(Picture pic) {
        for (int i = R - S; i <= R + S ; i++) {
            for (int j = C - S; j <= C + S ; j++) {
				pic.setCell(i, j, Color.BLACK);
            }
        }
    }

    public void depaint(Picture pic) {
        for (int i = R - S ; i <= R + S; i++) {
            for (int j = C - S ; j <= C + S; j++) {
                pic.setCell(i, j, Color.depaint(pic, pic.getCellValue(i,j),false));
            }
        }
    }

	public String toString() {
		return "R " + this.R + " C " + this.C + " S " + this.S;
	}
}
