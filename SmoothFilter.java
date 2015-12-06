import java.awt.Color;
/**
 * Write a description of class SmoothFilter here.
 * 
 * @author Maria Langman
 * @version 2015.12.05
 */
public class SmoothFilter extends Filter
{
    /**
     * Constructor for objects of class SmoothFilter
     */
    public SmoothFilter(String name)
    {
        super(name);
    }

    /**
     * Apply this filter to an image.
     * 
     * @param  image  The image to be changed by this filter.
     */
    public void apply(OFImage image)
    {
        int height = image.getHeight();
        int width = image.getWidth();
        OFImage original = new OFImage(image);

        for(int y = 0; y < height; y++) {
            for(int x = 0; x < width; x++) {

                int pixel = original.getPixel(x,y).getRGB();
                if (x!=0 && y!=0 && x!=width-1 && y!=height-1)
                {
                    //get the neighboring pixels
                    int pixelNW = original.getPixel(x-1, y-1).getRGB();
                    int pixelN = original.getPixel(x, y-1).getRGB();
                    int pixelNE = original.getPixel(x+1, y-1).getRGB();
                    int pixelW = original.getPixel(x-1, y).getRGB();
                    int pixelE = original.getPixel(x+1, y).getRGB();
                    int pixelSW = original.getPixel(x-1, y+1).getRGB();
                    int pixelS = original.getPixel(x, y+1).getRGB();
                    int pixelSE = original.getPixel(x+1, y+1).getRGB();

                    //average out the neighboring pixels and the current pixel from original image
                    pixel = (pixelNW + pixelN + pixelNE + pixelW + pixel + pixelE + pixelSW + pixelS + pixelSE)/9;
                }
                image.setPixel(x,y,new Color(pixel));
            }
        }
    }
}
