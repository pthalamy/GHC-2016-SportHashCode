/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author airone
 */
class Destruction {
    public int R;
    public int C;

    public Destruction(int r, int c) {
        R = r;
        C = c;
    }

    public Destruction clone(){
        return new Destruction(R,C);
    }

    public void paint(Picture pic) {
	pic.setCell(R, C, Color.BLANK);
    }
}
