/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author airone
 */
class HorizontalLine {
    public int R;
    public int C1;
    public int C2;

    public HorizontalLine(int r, int c1, int c2) {
        R = r;
        C1 = c1;
        C2 = c2;
    }

    public HorizontalLine clone(){
        return new HorizontalLine(R,C1,C2);
    }

    public void paint(Picture pic) {
	for (int j = C1; j <= C2; j++) {
	    pic.setCell(R, j, Color.BLACK);
	}
    }


    public void depaint(Picture pic) {
        for (int j = C1; j <= C2; j++) {
            pic.setCell(R, j, Color.depaint(pic.getCellValue(R,j),false));
        }
    }
}
