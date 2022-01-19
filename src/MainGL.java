import java.awt.Dimension;

import javax.swing.JFrame;
import com.jogamp.opengl.awt.GLCanvas;
import com.jogamp.opengl.util.FPSAnimator;

public class MainGL{
	
	public static void main(String[] args) {
		JFrame fenetre = new JFrame();
		GLCanvas canvas = new GLCanvas();
		GLHandler events = new GLHandler();
		canvas.addKeyListener(new UserKeyboard(events));
		canvas.setPreferredSize(new Dimension(800, 600));
		canvas.addGLEventListener(events);
		
		fenetre.getContentPane().add(canvas);
		fenetre.setTitle("Space Invader");
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fenetre.pack();
		fenetre.setVisible(true);
		FPSAnimator anim = new FPSAnimator(canvas, 60);
	
		anim.start();
	}
}


