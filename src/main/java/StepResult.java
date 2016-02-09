/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author airone
 */
class StepResult {
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
    public Path resultPath;
}
