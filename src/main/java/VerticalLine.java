/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author airone
 */
class VerticalLine {
    public int R1;
    public int R2;
    public int C;

    public int size;
    
    public VerticalLine(int r1, int r2, int c) {
        R1 = r1;
        R2 = r2;
        C = c;
        this.size = r2 - r1;
    }

    public VerticalLine clone(){
        return new VerticalLine(R1,R2,C);
    }
    
    public void paint(Picture pic) {
        for (int i = R1; i <= R2; i++) {
            pic.setCell(i, C, Color.BLACK);
        }
    }

    public void depaint(Picture pic) {
        for (int i = R1; i <= R2; i++) {
            pic.setCell(i, C, Color.depaint(pic, pic.getCellValue(i,C),false));
        }
    }
}
