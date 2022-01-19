import com.jogamp.opengl.GL2;

public abstract class Shape3D {
	protected float x, y, z;
	protected float r, g, b;
	protected float size;
	
	public Shape3D() { 
		x = 0; y = 0; z = 0;
		r = 0; g = 0; b = 0;
		size = 1;
	}
	
	public abstract void display(GL2 gl);

	public float getY() {
		return this.y;
	}

	public void setY(float y) {
		this.y = y;
	}
	
	public float getX() {
		return this.x;
	}
	
	public float getSize() {
		return this.size;
	}
	
	public boolean hit(float x, float y) {
		return (x - size/2 <= getX() && x+size/2>=getX() && y >= getY() + size/2);
	}
}