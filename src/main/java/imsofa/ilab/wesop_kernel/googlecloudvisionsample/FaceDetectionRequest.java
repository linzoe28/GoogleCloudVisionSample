/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imsofa.ilab.wesop_kernel.googlecloudvisionsample;

import com.github.kevinsawicki.http.HttpRequest;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

/**
 *
 * @author user
 */
public class FaceDetectionRequest {

    private String apiKey = null;
    private String imageBase64 = null;
    private static final String URL = "https://vision.googleapis.com/v1/images:annotate";

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

    public List<FaceDetectionResponse> send() {
        String ret = HttpRequest.post(URL + "?key=" + this.apiKey + "&fields=responses(faceAnnotations(angerLikelihood%2CblurredLikelihood%2CheadwearLikelihood%2CjoyLikelihood%2CsorrowLikelihood%2CsurpriseLikelihood))").contentType("json").
                send("{ \"requests\": [ { \"image\": { \"content\": \"" + imageBase64 + "\" }, \"features\": [ { \"type\": \"FACE_DETECTION\" } ] } ] }").body();
        Logger.getLogger(this.getClass().getName()).info(ret);
        Map json = new Gson().fromJson(ret, Map.class);
        Map responses = (Map) ((List) json.get("responses")).get(0);
        Map faceAnnotations = (Map) ((List) responses.get("faceAnnotations")).get(0);
        Map landmarks = (Map) ((List) faceAnnotations.get("landmarks")).get(0);
        List<FaceDetectionResponse> res = new ArrayList<>();
        for (int i = 0; i < landmarks.size(); i++) {
            FaceDetectionResponse f = new FaceDetectionResponse();
            Map type = (Map) ((List) landmarks.get("type")).get(i);
            Map position = (Map) ((List) landmarks.get("position")).get(i);
            f.setType(type.toString());
            f.setX((double) position.get("x"));
            f.setY((double) position.get("y"));
            f.setZ((double) position.get("z"));
            res.add(f);
        }
      
        return  res;
    }

}
