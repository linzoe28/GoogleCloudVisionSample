/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imsofa.ilab.wesop_kernel.googlecloudvisionsample;

/**
 *
 * @author lendle
 */
public class EmotionDetectionResponse {
    private Likelihood joyLikelihood, sorrowLikelihood, angerLikelihood, 
            surpriseLikelihood, blurredLikelihood, headwearLikelihood;

    public Likelihood getJoyLikelihood() {
        return joyLikelihood;
    }

    public void setJoyLikelihood(Likelihood joyLikelihood) {
        this.joyLikelihood = joyLikelihood;
    }

    public Likelihood getSorrowLikelihood() {
        return sorrowLikelihood;
    }

    public void setSorrowLikelihood(Likelihood sorrowLikelihood) {
        this.sorrowLikelihood = sorrowLikelihood;
    }

    public Likelihood getAngerLikelihood() {
        return angerLikelihood;
    }

    public void setAngerLikelihood(Likelihood angerLikelihood) {
        this.angerLikelihood = angerLikelihood;
    }

    public Likelihood getSurpriseLikelihood() {
        return surpriseLikelihood;
    }

    public void setSurpriseLikelihood(Likelihood surpriseLikelihood) {
        this.surpriseLikelihood = surpriseLikelihood;
    }

    public Likelihood getBlurredLikelihood() {
        return blurredLikelihood;
    }

    public void setBlurredLikelihood(Likelihood blurredLikelihood) {
        this.blurredLikelihood = blurredLikelihood;
    }

    public Likelihood getHeadwearLikelihood() {
        return headwearLikelihood;
    }

    public void setHeadwearLikelihood(Likelihood headwearLikelihood) {
        this.headwearLikelihood = headwearLikelihood;
    }
    
}
