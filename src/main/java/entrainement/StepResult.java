package entrainement;/*
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
            System.out.println("Solutions");
            if (a.nbPixel > b.nbPixel) {
                System.out.println("A Solution");
                return a;
            } else {
                System.out.println("B Solution");
                return b;
            }
        } else if (a.result) {
            System.out.println("A Solution");
            return a;
        } else if (b.result) {
            System.out.println("B Solution");
            return b;
        }
        
        throw new Exception("Impossible de trouver le minimum");
    }
}
