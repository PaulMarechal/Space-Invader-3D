import com.jogamp.opengl.GL2;

public class Cube3D extends Shape3D {
	
	public Cube3D(float x, float y, float z, float size) {
		this.x = x; this.y = y; this.z = z;
		this.size = size;
	}
	
	public void display(GL2 gl) {
		
		gl.glPushMatrix();
		gl.glTranslatef(x, y, z);
		gl.glScalef(size, size, size);
		gl.glRotated(size * 10, 1, 1, 1);
		gl.glBegin(GL2.GL_QUADS);
		// Front
		gl.glColor3d(1, 0, 0);
		gl.glVertex3d(-1, -0.3, 1);
		gl.glVertex3d(1, -0.3, 1);
		gl.glVertex3d(1, 0.5, 1);
		gl.glVertex3d(-1, 0.5, 1);
		// Rear
		gl.glColor3d(1, 1, 0);
		gl.glVertex3d(-1, -0.3, -1);
		gl.glVertex3d(1, -0.3, -1);
		gl.glVertex3d(1, 0.5, -1);
		gl.glVertex3d(-1, 0.5, -1);
		// Left
		gl.glColor3d(0, 1, 0);
		gl.glVertex3d(-1, -0.3, -1);
		gl.glVertex3d(-1, -0.3, 1);
		gl.glVertex3d(-1, 0.5,  1);
		gl.glVertex3d(-1, 0.5, -1);
		// Right
		gl.glColor3d(0, 1, 1);
		gl.glVertex3d(1, -0.3, -1);
		gl.glVertex3d(1, -0.3, 1);
		gl.glVertex3d(1, 0.5,  1);
		gl.glVertex3d(1, 0.5, -1);
		// Bottom
		gl.glColor3d(0, -0.3, -0.3);
		gl.glVertex3d(-1, -0.3, -0.3);
		gl.glVertex3d(1, -0.3, 1);
		gl.glVertex3d(1, -0.5, -1);
		gl.glVertex3d(-1, -0.5, -1);
		// Up
		gl.glColor3d(1, 0.5, 1);
		gl.glVertex3d(-1, 0.3, 1);
		gl.glVertex3d(1, 0.3, 1);
		gl.glVertex3d(1, 0.5, -1);
		gl.glVertex3d(-1, 0.5, -1);
		gl.glEnd();	
		gl.glPopMatrix();
		
	}
	
	public void goRight() { 
		this.x += 0.1f; 
	}
	
	public void goLeft() { 
		this.x -= 0.1f; 
	}

	public float getX() {
		return this.x;
	}
	
	public float getY() {
		return this.y;
	}
}