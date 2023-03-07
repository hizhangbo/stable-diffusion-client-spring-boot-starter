package io.github.hizhangbo.sd.util;

import com.luciad.imageio.webp.WebPWriteParam;

import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageWriteParam;
import javax.imageio.ImageWriter;
import javax.imageio.stream.FileImageOutputStream;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

public class ImageUtil {

    /**
     * Base64 to WebP format
     */
    public static File base64ToWebP(String base64Img, String savePath) throws IOException {
        byte[] imageBytes = javax.xml.bind.DatatypeConverter.parseBase64Binary(base64Img);
        BufferedImage img = ImageIO.read(new ByteArrayInputStream(imageBytes));

        return webpWithLossyCompression(img, savePath);
    }

    private static File webpWithLossyCompression(BufferedImage image, String savePath) throws IOException {
        ImageWriter writer = ImageIO.getImageWritersByMIMEType("image/webp").next();

        WebPWriteParam writeParam = new WebPWriteParam(writer.getLocale());
        //Notify encoder to consider WebPWriteParams
        writeParam.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
        //Set lossy compression
        writeParam.setCompressionType(writeParam.getCompressionTypes()[WebPWriteParam.LOSSY_COMPRESSION]);
        //Set 80% quality. Allowed values are between 0 and 1
        writeParam.setCompressionQuality(0.8f);

        // Save the image
        String localPath = savePath + LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")) + "/";
        String filename = UUID.randomUUID().toString() + ".webp";
        final File path = new File(localPath);

        if (!path.exists()) {
            path.mkdir();
        }
        File localImage = new File(localPath + filename);

        writer.setOutput(new FileImageOutputStream(localImage));
        writer.write(null, new IIOImage(image, null, null), writeParam);
        return localImage;
    }
}
