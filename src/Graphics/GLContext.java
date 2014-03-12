
package Graphics;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.util.glu.GLU.gluPerspective;

import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;


public class GLContext extends Application
{
	//private float rotAngle =0;
	  private float x = 0;
	  private boolean temp = false;
	public void Initialise()
	{
		/*
		glMatrixMode(GL_PROJECTION);
		glLoadIdentity();
		glOrtho(0, 800, 0, 600, 1, -1);
		glMatrixMode(GL_MODELVIEW);
		
		*/
		
		/*
		// 3D shape has a more realistic look with Perspective mode rather than Orthographic
				glMatrixMode(GL_PROJECTION);
				gluPerspective(70f, 800f/600f, 0.2f, 800);
				
				// render to the full size of the window
				glViewport(0,0,Display.getWidth(), Display.getHeight());
				
				glMatrixMode(GL_MODELVIEW);
				glLoadIdentity(); 
				
				glEnable(GL_DEPTH_TEST);
				*/
		
		camera = new Camera(70, (float)Display.getWidth()/ (float)Display.getHeight(), 0.001f, 800);
				
	//	glTranslatef(0, 0, -2); 
	}
			
	
	public void render()
	{
		
		glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);	
	    glPointSize(1.0f);
	    
		
	
		boolean forward = Keyboard.isKeyDown(Keyboard.KEY_W);
		boolean backward = Keyboard.isKeyDown(Keyboard.KEY_S); 
		boolean	left = Keyboard.isKeyDown(Keyboard.KEY_A);
		boolean right = Keyboard.isKeyDown(Keyboard.KEY_D);
		
		
			if(forward)
			camera.move(0.1f,1);
			if(backward)
			camera.move(-0.1f,1);
			if(left)
			camera.move(0.1f,0);//cam.rotateY(-0.1f);
			if(right)
			camera.move(-0.1f,0);//cam.rotateY(0.1f);
	
			if(Keyboard.isKeyDown(Keyboard.KEY_LEFT))
			camera.rotateY(2f);
			if(Keyboard.isKeyDown(Keyboard.KEY_RIGHT))
			camera.rotateY(-2f);
			if(Keyboard.isKeyDown(Keyboard.KEY_UP))
				camera.rotateX(2f);
			if(Keyboard.isKeyDown(Keyboard.KEY_DOWN))
				camera.rotateX(-02f);
			
		
		
		
		glClear(GL_COLOR_BUFFER_BIT);
		glLoadIdentity();
		
		camera.useView();
		//glLoadIdentity();
		glTranslatef(0,0,-2);
		
		
		

		//glColor3f(1.0f,0.5f,0f);
		//glTranslatef(0,0,-5);
		
		
		
	
	    
	    
		
		glBegin(GL_POINTS);
	    for(int i = 0; i < points.size(); ++i)
	    {
	    	float[] c = colors.get(i);
	    	float[] p = points.get(i);
	    	glColor3f(c[0], c[1], c[2]);
	    	glVertex3f((float)(511-p[0])/ (float) 1000, (float)(511-p[1])/ (float) 1000, ((float)(200-p[2])/ (float) 1000));
	    	
	    	//glVertex3f(511-p[0],511-p[1],511-p[2]);
	    }
	    
	    
	    glEnd();
	    
	    
	   

	}
	
	public void rotate(int x)
	{
		glLoadIdentity();
		if (x==1)
		{
			glTranslatef(0,0,5);
			glRotatef(1,0,1,0);
			glTranslatef(0,0,-5);
			//System.out.println("sadness");
		}
		else
		{
			glTranslatef(0,0,5);
			glRotatef(-1,0,1,0);
			glTranslatef(0,0,-5);
			//System.out.println("sadness 2");
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*
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
    */
		
		
	
	public void destroy()
	{
		
	}
	
	public static void main(String[] args)
	{
		new GLContext();
	}

}
