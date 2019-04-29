/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imsofa.ilab.wesop_kernel.googlecloudvisionsample;

import com.github.kevinsawicki.http.HttpRequest;
import com.google.gson.Gson;
import java.util.List;
import java.util.Map;

/**
 *
 * @author lendle
 */
public class EmotionDetectionRequest {
    private String apiKey=null;
    private String imageBase64=null;
    private static final String URL="https://vision.googleapis.com/v1/images:annotate";

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public String getImageBase64() {
        return imageBase64;
    }

    public void setImageBase64(String imageBase64) {
        this.imageBase64 = imageBase64;
    }
    
    public EmotionDetectionResponse send(){
        String ret=HttpRequest.post(URL+"?key="+this.apiKey+"&fields=responses(faceAnnotations(angerLikelihood%2CblurredLikelihood%2CheadwearLikelihood%2CjoyLikelihood%2CsorrowLikelihood%2CsurpriseLikelihood))").contentType("json").
                send("{ \"requests\": [ { \"image\": { \"content\": \""+imageBase64+"\" }, \"features\": [ { \"type\": \"FACE_DETECTION\" } ] } ] }").body();
        Map json=new Gson().fromJson(ret, Map.class);
        Map responses=(Map) ((List)json.get("responses")).get(0);
        Map faceAnnotations=(Map) ((List)responses.get("faceAnnotations")).get(0);
        EmotionDetectionResponse res=new EmotionDetectionResponse();
        res.setAngerLikelihood(Likelihood.valueOf(""+faceAnnotations.get("angerLikelihood")));
        res.setJoyLikelihood(Likelihood.valueOf(""+faceAnnotations.get("joyLikelihood")));
        res.setSorrowLikelihood(Likelihood.valueOf(""+faceAnnotations.get("sorrowLikelihood")));
        res.setSurpriseLikelihood(Likelihood.valueOf(""+faceAnnotations.get("surpriseLikelihood")));
        res.setBlurredLikelihood(Likelihood.valueOf(""+faceAnnotations.get("blurredLikelihood")));
        res.setHeadwearLikelihood(Likelihood.valueOf(""+faceAnnotations.get("headwearLikelihood")));
        return res;
    }
}
