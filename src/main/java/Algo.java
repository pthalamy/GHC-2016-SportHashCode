

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author airone
 */
public class Algo {
    /**
     * Trouve le meilleur carré possible de taille k
     * @param currentPicture
     * @param k Taille du carré à chercher
     * @return Retourne un couple formé du carré trouvé ainsi que de nbPixels - nbPixelsVide
     * @throws Exception 
     */
    public static Pair<Square, Integer> findBestSquare(Picture currentPicture, int k) throws Exception {
        int maxI = 0;
        int maxJ = 0;
        int maxValue = 0;
        int tempValue;
        for (int i = 0; i < currentPicture.getN() - k; i++) {
            for (int j = 0; j < currentPicture.getN() - k; j++) {
                if (currentPicture.getCellValue(i, j) == Color.BLACK) {
                    tempValue = currentPicture.getSubPictureBlackCount(i, j, i + k, j + k);
                    if (tempValue > maxValue) {
                        maxValue = tempValue;
                        maxI = i;
                        maxJ = j;
                    }
                }
            }
        }
        
        if (maxValue == 0) {
            throw new Exception("Pas de carré possible");
        }
        
        int s = (k - 1 / 2);
        
        return new Pair<>(new Square(maxI + s, maxJ + s, k), maxValue - s);
    }
    
    public static StepResult stepSquare(Picture currentPicture) throws Exception {
        StepResult ret = new StepResult();
        
        // On cherche la dimension la plus petite entre la largeur
        // et la hauteur de l'image
        int minMN = Integer.min(currentPicture.getN(), currentPicture.getM());
        
        // On cherche le meilleur carré pour tous les k possibles
        Pair<Square, Integer> bestPair = findBestSquare(currentPicture, 3);
        Pair<Square, Integer> tempPair;
        for (int p = 2; 2 * p + 1 < minMN; p++) {
            tempPair = findBestSquare(currentPicture, 2 * p + 1);
            if (tempPair.getValue() > bestPair.getValue()) {
                bestPair = tempPair;
            }
        }
        
        // Si on fait plus de destructions que de paintings, on ne fait rien
        if (bestPair.getValue() < 0) {
            ret.result = false;
        } else {
            ret.result = true;
            
            // On rajoute le square au path
            ret.resultPath.squares.add(bestPair.getKey());
            
            // Puis on rajoute les destructions
            Square square = bestPair.getKey();
            
            int R1 = square.R - square.S;
            int R2 = square.R + square.S + 1;
            int C1 = square.C - square.S;
            int C2 = square.C + square.S + 1;
            
            for (int i = R1; i < R2; i++) {
                for (int j = C1; j < C2; j++) {
                    if (currentPicture.getCellValue(i, j) == Color.BLACK) {
                        ret.nbPixel += 1;
                    } else {
                        ret.resultPath.destructions.add(new Destruction(i, j));
                    }
                }
            }
        }
        
        return ret;
    }
    
    public static StepResult stepVerticalLine(Picture currentPicture) {
        StepResult ret = new StepResult();
        VerticalLine vl = currentPicture.getBestVerticalLine();
        
        ret.resultPath.verticalLines.add(vl);
        ret.nbPixel += vl.size;
        
        return ret;
    }
    
    public static StepResult stepHorizontalLine(Picture currentPicture) {
        StepResult ret = new StepResult();
        HorizontalLine hl = currentPicture.getBestHorizontalLine();
        
        ret.resultPath.horizontalLines.add(hl);
        ret.nbPixel += hl.size;
        
        return ret;
    }
    
    
    public static StepResult step(Picture currentPicture, Path currentPath) throws Exception {
        // D'abord les carrés
        StepResult minResult = stepSquare(currentPicture);
        
        // Puis les lignes
        StepResult auxResult = stepVerticalLine(currentPicture);
        minResult = StepResult.bestStepResult(minResult, auxResult);
        
        auxResult = stepHorizontalLine(currentPicture);
        minResult = StepResult.bestStepResult(minResult, auxResult);
        
        // Fonction de Mallet permettant la "décoloration"
        minResult.resultPath.dePaint(currentPicture);
        
        // On rajoute l'ancien path
        minResult.resultPath.add(currentPath);
        
        return minResult;
    }
}
