
package Graphics;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.util.glu.GLU.gluPerspective;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;


public class GLContext extends Application
{
	
		
	public void Initialise()
	{
		
		glViewport(0,0,Display.getWidth(), Display.getHeight());
		glMatrixMode(GL_PROJECTION);
		glLoadIdentity();
		//gluPerspective(45.0f, 800f/600f, 1, 200);
		glOrtho(0, 800, 0, 600, 1, -1);
		
		glMatrixMode(GL_MODELVIEW);
		glLoadIdentity();
		
		glEnable(GL_DEPTH_TEST);
		glTranslatef(0.0f, 0.0f, -4.0f);
	}
	
	public void render()
	{
		
		glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
		glLoadIdentity();
		//glPointSize(100f);
		glColor3f(0.0f,0.0f,1.0f);
		glBegin(GL_QUADS);
		/*
		for (int i=0; i<512;i++)
		{
			for(int j=0; sj<512;j++)
			{
				glColor3f(dcmPixelComponents[i][j][0], dcmPixelComponents[i][j][1], dcmPixelComponents[i][j][2]);
				glVertex3f(i,j, -3);
			}
		}
		*/
		
		glVertex3f(1.0f,1.0f,0.0f);
		glVertex3f(-1.0f,1.0f,0.0f);
	    glVertex3f(-1.0f,-1.0f,0.0f);
	    glVertex3f(1.0f,-1.0f,0.0f);
		glEnd();
	}
		//glFlush();
		
	
	public void destroy()
	{
		
	}
	
	public static void main(String[] args)
	{
		new GLContext();
	}

}
