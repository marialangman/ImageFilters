import java.awt.Color;
/**
 * Write a description of class MirrorFilter here.
 * 
 * @author Maria Langman 
 * @version 2015.12.05
 */
public class MirrorFilter extends Filter
{
    /**
	 * Constructor for objects of class MirrorFilter.
     * @param name The name of the filter.
	 */
	public MirrorFilter(String name)
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
        for(int y = 0; y < height; y++) {
            for(int x = 0; x < (int) width/2; x++) {
                Color currentPixel = image.getPixel(x, y);
                Color mirrorPixel = image.getPixel(width-1-x, y);
                //swap the pixels
                image.setPixel(x, y, mirrorPixel);
                image.setPixel(width-1-x, y, currentPixel);
            }
        }
    }
}
