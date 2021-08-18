import javax.imageio.IIOException;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class ImageLoader {

    private BufferedImage image;

    public BufferedImage loadImage(String path) throws IOException {
        try{
            image = ImageIO.read(getClass().getResource(path));
        } catch (IIOException e){
            e.printStackTrace();
        }
        return image;
    }
}
