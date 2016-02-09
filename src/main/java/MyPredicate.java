
import java.util.function.Predicate;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author airone
 */
public class MyPredicate implements Predicate<Destruction>{
        public Path resultPath;

        @Override
        public boolean test(Destruction t) {
            for (Square square : resultPath.squares) {
                int R1 = square.R - square.S;
                int R2 = square.R + square.S + 1;
                int C1 = square.C - square.S;
                int C2 = square.C + square.S + 1;
                
                if (R1 <= t.R && t.R < R2 && C1 <= t.C && t.C < C2) {
                    return true;
                }
            }
            return false;
        }
    }
