package Graphics;

import java.io.File;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;

import DicomParse.dicomParser;



public class Application 
{
	
	protected int[][][] dcmPixelComponents =new int[512][512][3];
	protected dicomParser dcmParser = new dicomParser();
	public Application()
	{
		/*
		File dcm = new File("C:\\Users\\Kapil\\Downloads\\Whole_body_Bone_1mm_16\\IM-0005-0111.dcm");
	   dcmPixelComponents = dcmParser.getRGBComponents(dcmParser.getDCMBufferedImage(dcm));
		*/
		try{
			Display.setDisplayMode(new DisplayMode(800, 600));
			Display.setTitle("Point Cloud Action");
			Display.create();
			
			begin();
		   }
		
		catch(LWJGLException e)
		{
			e.printStackTrace();
			System.exit(-1);  // this application is hardware accelerated.
		}
		
	}
	
	private void begin()
	{
		Initialise();
		while(!Display.isCloseRequested())
		{
			update();
			render();
			Display.update();
			Display.sync(60);    // 60 frames per second ( matching monitor refresh rate)
		}
		destroy();
	}
	
	public void Initialise()
	{
		
	}
	
	public void update()
	{
		
	}
	
	public void render()
	{
		
	}
	
	public void destroy()
	{
		Display.destroy();System.exit(0);
	}
	
	
}
