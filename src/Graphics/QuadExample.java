package Graphics;

import java.io.File;
import java.util.ArrayList;

import org.lwjgl.LWJGLException;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;

import DicomParse.dicomParser;
 
public class QuadExample {
	
float rotAngle = 0;

ArrayList<float[]> points;
ArrayList<float[]> colors;
 
    public void start() {
        try {
	    Display.setDisplayMode(new DisplayMode(800,600));
	    Display.create();
	} catch (LWJGLException e) {
	    e.printStackTrace();
	    System.exit(0);
	}
 
	// init OpenGL
        //int[][][] dcmPixelComponents =new int[512][512][3];
        ArrayList<int[][][]> dcmList = new ArrayList<int[][][]>();
        dicomParser dcmParser = new dicomParser();
       
        for(int i=1; i<180;i++)
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
        
        points = new ArrayList<float[]>();
        colors = new ArrayList<float[]>();
        
        for(int k=0;k<dcmList.size();k++)
	    {
	    	int[][][] dcmPixelComponents = dcmList.get(k);
		    for (int i=0; i<512;i++)
			{
				for(int j=0; j<512;j++)
				{
					if(dcmPixelComponents[i][j][0] > 180)
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
 	   
 	   
	GL11.glMatrixMode(GL11.GL_PROJECTION);
	GL11.glLoadIdentity();
	GL11.glOrtho(0, 800, 0, 600, 1, -1);
	
	GL11.glMatrixMode(GL11.GL_MODELVIEW);
	
	while (!Display.isCloseRequested()) {
	//	GL11.glPushMatrix();
	    // Clear the screen and depth buffer
	    GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);	
	    GL11.glPointSize(1.0f);
	    
	    GL11.glBegin(GL11.GL_POINTS);
	    for(int i = 0; i < points.size(); ++i)
	    {
	    	float[] c = colors.get(i);
	    	float[] p = points.get(i);
	    	GL11.glColor3f(c[0], c[1], c[2]);
	    	GL11.glVertex3f(p[0], p[1], p[2]);
	    }
	    
	    
	    GL11.glEnd();
	    
	    pollInput();
	   // GL11.glTranslatef(0, 100, 0);
	    GL11.glRotatef(rotAngle,0,1,0);
	    
	    Display.update();
	  //  GL11.glPopMatrix();
	}
 
	Display.destroy();
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
 
    public static void main(String[] argv) {
        QuadExample quadExample = new QuadExample();
        quadExample.start();
    }
}