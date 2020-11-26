package controller.servlets;

import javax.servlet.http.Part;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class UploadPhoto {
    public static void saveImage(String fileName, Part image) throws IOException {
        File folder = new File("car_images");
        if (!folder.exists()) {
            folder.mkdir();
        }
        File file = new File(folder + File.separator + fileName);
        try (FileOutputStream out = new FileOutputStream(file)) {
            out.write(image.getInputStream().readAllBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
