package DicomParse;

import java.awt.image.BufferedImage;

public interface PixelParser 
{
	public BufferedImage getDCMBufferedImage();
	
	public int[] getRGBComponents(BufferedImage image); 
	
	public int[][] getRGBpixelvalues(BufferedImage image);

}
