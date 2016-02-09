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
    public StepResult stepSquare(Picture currentPicture, Path currentPath) {
        StepResult ret = new StepResult();
        
        return ret;
    }
    
    public StepResult stepVerticalLine(Picture currentPicture, Path currentPath) {
        StepResult ret = new StepResult();
        
        return ret;
    }
    
    public StepResult stepHorizontalLine(Picture currentPicture, Path currentPath) {
        StepResult ret = new StepResult();
        
        return ret;
    }
    
    
    public StepResult step(Picture currentPicture, Path currentPath) throws Exception {
        // D'abord les carrés
        StepResult minResult = stepSquare(currentPicture, currentPath);
        
        // Puis les lignes
        StepResult auxResult = stepVerticalLine(currentPicture, currentPath);
        minResult = StepResult.bestStepResult(minResult, auxResult);
        
        auxResult = stepHorizontalLine(currentPicture, currentPath);
        minResult = StepResult.bestStepResult(minResult, auxResult);
        
        
        return minResult;
    }
}
