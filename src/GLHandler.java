import java.util.ArrayList;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.glu.GLU;
import java.awt.event.MouseEvent;


public class GLHandler implements GLEventListener {
	
	private GLU glu;
	private float angle = 45;
	private float posX, posY;
	private ArrayList<Shape3D> items3D;
	private ArrayList<Shape3D> ennemis3D;
	
	public GLHandler() {
		this.glu = new GLU();
		this.angle = 0;
		this.items3D = new ArrayList<Shape3D>();
		this.ennemis3D = new ArrayList<Shape3D>();				
		this.items3D.add(new Cube3D(0, -3, -13, 0.5f));
		
		
		
		//this.ennemis3D.add(new Ennemis(0, 2, -10, 0.5f));
		this.ennemis3D.add(new Ennemis(2, 2, -13, 0.5f));
		this.ennemis3D.add(new Ennemis(4, 2, -13, 0.5f));
		this.ennemis3D.add(new Ennemis(0, 2, -13, 0.5f));
		this.ennemis3D.add(new Ennemis(-2, 2, -13, 0.5f));
		this.ennemis3D.add(new Ennemis(-4, 2, -13, 0.5f));
		
		this.ennemis3D.add(new Ennemis(2, 0, -13, 0.5f));
		this.ennemis3D.add(new Ennemis(4, 0, -13, 0.5f));
		this.ennemis3D.add(new Ennemis(0, 0, -13, 0.5f));
		this.ennemis3D.add(new Ennemis(-2, 0, -13, 0.5f));
		this.ennemis3D.add(new Ennemis(-4, 0, -13, 0.5f));
		
		this.ennemis3D.add(new Ennemis(2, 4, -13, 0.5f));
		this.ennemis3D.add(new Ennemis(4, 4, -13, 0.5f));
		this.ennemis3D.add(new Ennemis(0, 4, -13, 0.5f));
		this.ennemis3D.add(new Ennemis(-2, 4, -13, 0.5f));
		this.ennemis3D.add(new Ennemis(-4, 4, -13, 0.5f));
	}
	
	@Override
	public void init(GLAutoDrawable draw) {
		GL2 gl = draw.getGL().getGL2();
		gl.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
		// TODO Auto-generated method stub
		//gl.glClearDepth(0.0f);
		gl.glEnable(GL2.GL_DEPTH_TEST);
		
	}
	
	@Override
	public void reshape(GLAutoDrawable draw, int x, int y, int width, int height) {
		// TODO Auto-generated method stub
		GL2 gl = draw.getGL().getGL2();
		// -- SCREEN
		float aspect = (float)width / height;
		gl.glViewport(0, 0, width, height);
		// -- CAMERA
		gl.glMatrixMode(GL2.GL_PROJECTION);
		gl.glLoadIdentity();
		// FOCAL, ASPECT, Zmin, Zmax
		this.glu.gluPerspective(45.0, aspect, 0.1, 100);
		// -- OBJECTS ?
		gl.glMatrixMode(GL2.GL_MODELVIEW);
		gl.glLoadIdentity();
		int posX = 0;
		int posY = 0;
		gl.glViewport( posX, posY, width, height );
		gl.glScaled( width, height, 1 );
	}

	@Override
	public void display(GLAutoDrawable draw) {
		// TODO Auto-generated method stub
		// DESSIN ???
		GL2 gl = draw.getGL().getGL2();
		gl.glClear(GL2.GL_COLOR_BUFFER_BIT | GL2.GL_DEPTH_BUFFER_BIT);
		gl.glLoadIdentity();
		gl.glTranslatef(this.posX, this.posY, -0.01f);
		
		gl.glRotatef(angle, 1.0f, 0.0f, 0.0f);
		
		for (Shape3D s : this.items3D)
			s.display(gl);
		
		// Update properties
		//this.angle += 0.01;
		
		for (Shape3D e : this.ennemis3D)
			e.display(gl);		
		
	}


	public void goRight() { 
		Cube3D cube = (Cube3D)this.items3D.get(0);
		cube.goRight();
	}

	public void goLeft() { 
		Cube3D cube = (Cube3D)this.items3D.get(0);
		cube.goLeft();
	}
	
	public void goMissile() {
		this.ennemis3D.add(new Missile(0, -3, -13, 0.5f));
	}

	@Override
	public void dispose(GLAutoDrawable arg0) {
		// TODO Auto-generated method stub
		
	}


}