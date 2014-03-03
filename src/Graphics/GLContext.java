
package Graphics;

import static org.lwjgl.opengl.GL11.*;

import org.lwjgl.input.Keyboard;


public class GLContext extends Application
{
	private float rotAngle =0;
		
	public void Initialise()
	{
		
		   
		glMatrixMode(GL_PROJECTION);
		glLoadIdentity();
		glOrtho(0, 800, 0, 600, 1, -1);
		glMatrixMode(GL_MODELVIEW);
	}
	
	public void render()
	{
		
		glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);	
	    glPointSize(1.0f);
	    
	    glBegin(GL_POINTS);
	    for(int i = 0; i < points.size(); ++i)
	    {
	    	float[] c = colors.get(i);
	    	float[] p = points.get(i);
	    	glColor3f(c[0], c[1], c[2]);
	    	glVertex3f(p[0], p[1], p[2]);
	    }
	    
	    
	    glEnd();
	    
	    pollInput();
	   
	    glRotatef(rotAngle,0,1,0);
	}
	
	public void pollInput()
    {
    	while (Keyboard.next()) {
    		if (Keyboard.getEventKeyState()) {
    		if (Keyboard.getEventKey() == Keyboard.KEY_1) {
    			rotAngle = 0.5f;
    				}
    	
    		if (Keyboard.getEventKey() == Keyboard.KEY_3) {
			}
    			rotAngle = -0.5f;
    		}
    	}
    }
		
		
	
	public void destroy()
	{
		
	}
	
	public static void main(String[] args)
	{
		new GLContext();
	}

}
