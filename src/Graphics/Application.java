package Graphics;



import java.io.File;
import java.util.ArrayList;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;

import DicomParse.dicomParser;



public class Application 
{
	
	protected ArrayList<float[]> points = new ArrayList<float[]>();
	protected ArrayList<float[]> colors = new ArrayList<float[]>();
	protected Camera camera;
	
	public Application()
	{
		
		ArrayList<int[][][]> dcmList;
        dicomParser dcmParser = new dicomParser();
        dcmList = new ArrayList<int[][][]>();
       
        for(int i=1; i<186;i++)
        {
        	int number=i;
        	String path = "C:\\Users\\Kapil\\Downloads\\Whole_body_Bone_1mm_16\\IM-0005-";
        	if(number<10)
        		path+="000";
        	else if(number <100)
        		path+="00";
        	else
        		path+="0";
        		
        	File dcm = new File(path+number+".dcm");
        	dcmList.add(dcmParser.getRGBComponents(dcmParser.getDCMBufferedImage(dcm)));
        	
        	
        }
        
        for(int k=0;k<dcmList.size();k++)
	    {
	    	int[][][] dcmPixelComponents = dcmList.get(k);
		    for (int i=0; i<512;i++)
			{
				for(int j=0; j<512;j++)
				{
					if(dcmPixelComponents[i][j][0] >=170)
					{
						float[] p = new float[3];
						p[0] = (float) i;
						p[1] = (float) j;
						p[2] = (float) k * 2.0f;
						
						float[] c = new float[3];
						c[0] = dcmPixelComponents[i][j][0]/255.0f;
						c[1] = dcmPixelComponents[i][j][0]/255.0f;
						c[2] = dcmPixelComponents[i][j][0]/255.0f;
						
						colors.add(c);
						points.add(p);
					}
				}
			}
	    }
        
    System.out.println("LOADED!!!");
        
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
