/*
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
}
