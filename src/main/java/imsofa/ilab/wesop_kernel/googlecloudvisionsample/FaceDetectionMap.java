/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imsofa.ilab.wesop_kernel.googlecloudvisionsample;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author user
 */
public class FaceDetectionMap {

    public Map facedeMap() throws IOException {
        try {
            URL url = new URL("http://imsofa.rocks:8000");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.connect();

            OutputStream output1 = conn.getOutputStream();
            PrintWriter writer = new PrintWriter(new OutputStreamWriter(output1, "utf-8"));
            writer.flush();
            BufferedReader input1 = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"));


            conn.disconnect();

        } catch (MalformedURLException ex) {
            Logger.getLogger(FaceDetectionMap.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }

}
