
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
}
