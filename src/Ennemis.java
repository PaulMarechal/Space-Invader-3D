import com.jogamp.opengl.GL2;

public class Ennemis extends Shape3D {
	private float rquad = 0.0f;
	private float maxY;
	private float maxX;
	double m = 0.0;
	
	public Ennemis(float x, float y, float z, float size) {
		this.x = x; this.y = y; this.z = z;
		this.size = size;
		this.maxY = 2;

	}
	

	public void display(GL2 gl) {
		gl.glPushMatrix();
		gl.glTranslatef(x, y, z);
		gl.glScalef(size, size, size);
		gl.glRotated(size * 10, 1, 1, 1);
		gl.glBegin(GL2.GL_QUADS);
		// Front
		gl.glColor3d(1, 0, 0);
		gl.glVertex3d(-1, -1, 1);
		gl.glVertex3d(1, -1, 1);
		gl.glVertex3d(1, 1, 1);
		gl.glVertex3d(-1, 1, 1);
		// Rear
		gl.glColor3d(1, 1, 0);
		gl.glVertex3d(-1, -1, -1);
		gl.glVertex3d(1, -1, -1);
		gl.glVertex3d(1, 1, -1);
		gl.glVertex3d(-1, 1, -1);
		// Left
		gl.glColor3d(0, 1, 0);
		gl.glVertex3d(-1, -1, -1);
		gl.glVertex3d(-1, -1, 1);
		gl.glVertex3d(-1, 1,  1);
		gl.glVertex3d(-1, 1, -1);
		// Right
		gl.glColor3d(0, 1, 1);
		gl.glVertex3d(1, -1, -1);
		gl.glVertex3d(1, -1, 1);
		gl.glVertex3d(1, 1,  1);
		gl.glVertex3d(1, 1, -1);
		// Bottom
		gl.glColor3d(0, 0, 1);
		gl.glVertex3d(-1, -1, 1);
		gl.glVertex3d(1, -1, 1);
		gl.glVertex3d(1, -1, -1);
		gl.glVertex3d(-1, -1, -1);
		// Up
		gl.glColor3d(1, 0, 1);
		gl.glVertex3d(-1, 1, 1);
		gl.glVertex3d(1, 1, 1);
		gl.glVertex3d(1, 1, -1);
		gl.glVertex3d(-1, 1, -1);
		gl.glEnd();	
		gl.glPopMatrix();
		
		
		
		for(int i = 0; i < 9; i++) {
			System.out.println("i : " + i);
			if(i%2 == 0) {
				this.x += 0.01;
			} else if (i%8 == 0 ) {
				this.x -= 0.01;
			} else if ( x >= -4) {
				this.x -= 0.01;
			}
		}
		
		
		System.out.println("x : " + this.x);
		System.out.println("\n");
		
		
	}

	public float getX() {
		// TODO Auto-generated method stub
		return (float) this.x;
	}
	
	public void goRight() { 
		this.x += 0.01; 
	}
	
	public void goLeft() { 
		this.x -= 0.01; 
	}
	
	public void moveCubes() {
		for(int i=0; i<3000; i++) {
			this.x += 1;
		}
	}


}