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

    public VerticalLine(int r1, int r2, int c) {
        R1 = r1;
        R2 = r2;
        C = c;
    }

    public VerticalLine clone(){
        return new VerticalLine(R1,R2,C);
    }
}