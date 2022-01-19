import com.jogamp.opengl.GL2;

public class Missile extends Shape3D {
	
	private float rquad = 0.0f;
	public int posMisY;
	
	public Missile(float x, float y, float z, float size) {
		this.x = x; 
		this.y = y; 
		this.z = z;
		this.size = size;	
	}

	private void move() {
		for (int i = 0 ; i < 2; i++) {
			this.y += 0.05;
		} 
	}
	
	public void display(GL2 gl) {
		
		gl.glRotatef(rquad, 0.8f, 0.0f, 0.0f); 
		gl.glPushMatrix();
		gl.glTranslatef(x, y, z);
		gl.glScalef(size, size, size);
		gl.glRotated(size * 10, 1, 1, 1);
		gl.glBegin(GL2.GL_QUADS);
		// Front
		gl.glColor3d(1.0f, 1.0f, 1.0f);
		gl.glVertex3d(-0.1, -0.1, 0.1);
		gl.glVertex3d(0.1, -0.1, 0.1);
		gl.glVertex3d(0.1, 0.5, 0.1);
		gl.glVertex3d(-0.1, 0.5, 0.1);
		// Rear
		gl.glColor3d(1.0f, 1.0f, 1.0f);
		gl.glVertex3d(-0.1, -0.1, -0.1);
		gl.glVertex3d(0.1, -0.1, -0.1);
		gl.glVertex3d(0.1, 0.5, -0.1);
		gl.glVertex3d(-0.1, 0.5, -0.1);
		// Left
		gl.glColor3d(1.0f, 1.0f, 1.0f);
		gl.glVertex3d(-0.1, -0.1, -0.1);
		gl.glVertex3d(-0.1, -0.1, 0.1);
		gl.glVertex3d(-0.1, 0.5,  0.1);
		gl.glVertex3d(-0.1, 0.5, -0.1);
		// Right
		gl.glColor3d(1.0f, 1.0f, 1.0f);
		gl.glVertex3d(0.1, -0.1, -0.1);
		gl.glVertex3d(0.1, -0.1, 0.1);
		gl.glVertex3d(0.1, 0.5,  0.1);
		gl.glVertex3d(0.1, 0.5, -0.1);
		// Bottom
		gl.glColor3d(1.0f, 1.0f, 1.0f);
		gl.glVertex3d(-0.1, -0.1, -0.1);
		gl.glVertex3d(0.1, -0.1, 0.1);
		gl.glVertex3d(0.1, -0.5, -0.1);
		gl.glVertex3d(-0.1, -0.5, -0.1);
		// Up
		gl.glColor3d(1.0f, 1.0f, 1.0f);
		gl.glVertex3d(-0.1, 0.1, 0.1);
		gl.glVertex3d(0.1, 0.1, 0.1);
		gl.glVertex3d(0.1, 0.5, -0.1);
		gl.glVertex3d(-0.1, 0.5, -0.1);
		gl.glEnd();	
		gl.glPopMatrix();
		
		move();
	}

	public float size() {
		return this.size;
	}
	
	public float posMisY() {
		return this.y;
	}
	
	public float posMisX() {
		return this.x;
	}

	public Missile get(int i) {
		return null;
	}

	public float getX() {
		return 0;
	}
}