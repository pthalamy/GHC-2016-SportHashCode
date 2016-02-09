/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author airone
 */
public class StepResult {
    
    /**
     * Si une solution a été trouvée ou non à l'étape courante
     */
    public boolean result;
    
    /**
     * Nombre de pixels restants à colorer
     */
    public int nbPixel;
    
    /**
     * Le chemin qui a permis d'arriver à une telle solution
     */
    public Path resultPath = new Path();
    
    public static StepResult bestStepResult(StepResult a, StepResult b) throws Exception {
        if (a.result && b.result) {
            if (a.nbPixel - a.resultPath.nbOperations() >
                    b.nbPixel - b.resultPath.nbOperations()) {
                return a;
            } else {
                return b;
            }
        } else if (a.result) {
            return b;
        } else if (b.result) {
            return a;
        }
        
        throw new Exception("Impossible de trouver le minimum");
    }
}
