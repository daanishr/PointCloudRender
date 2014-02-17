package Graphics;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;



public class Application 
{
	
	public Application()
	{
		
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
