package DicomParse;

import java.awt.image.BufferedImage;
import java.io.File;

public interface PixelParser 
{
	public BufferedImage getDCMBufferedImage(File dcm);
	
	public int[][][] getRGBComponents(BufferedImage image); 
	
	public int[][] getRGBpixelvalues(BufferedImage image);

}
