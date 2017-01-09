import java.awt.Image;
import java.awt.Graphics;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JFrame;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.PointerInfo;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

public class Spark extends JFrame implements MouseListener {
	public static ArrayList sparks = new ArrayList();
	private Image image;
	private Graphics graphics;
	private String imagename = "pixel1.png";

	public static void main(String[] args) {
		new Spark();
	}

	public Spark() {
		setTitle("Spark");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		setResizable(false); 
		setSize(800, 600); 
		setBackground(Color.BLACK); 
		setVisible(true); 
		addMouseListener(this);
	}

	public void paint(Graphics g) {
		try {
			Thread.sleep(20);
		} catch (InterruptedException ex) {
			Thread.currentThread().interrupt();
		}
		Random rand = new Random();
		int randx = 0; 
		int randy = rand.nextInt(20) - 21;
		while (randx == 0) {
			randx = rand.nextInt(10) - 5;
		}
		PointerInfo a = MouseInfo.getPointerInfo();
		Point b = a.getLocation();
		int mousex = (int) b.getX();
		int mousey = (int) b.getY();
		Pixel newpixel = new Pixel(mousex, mousey, randx, randy, 2, 2, imagename);
		sparks.add(newpixel);
		newpixel = null;
		randx = rand.nextInt(10) - 5;
		randy = rand.nextInt(20) - 21;
		while (randx == 0) {
			randx = rand.nextInt(10) - 5;
		}
		a = MouseInfo.getPointerInfo();
		b = a.getLocation();
		mousex = (int) b.getX();
		mousey = (int) b.getY();
		newpixel = new Pixel(mousex, mousey, randx, randy, 2, 2, imagename);
		sparks.add(newpixel);
		image = createImage(getWidth(), getHeight());
		graphics = image.getGraphics();
		updatepos(graphics);
		g.drawImage(image, 0, 0, null);
		repaint();
	}

	public void updatepos(Graphics g) {
		for (int x = 0; x < sparks.size(); x++) {
			Pixel drawpixel = (Pixel) sparks.get(x);
			drawpixel.draw(g);
			drawpixel.update();
		}
	}

	public void mousePressed(MouseEvent e) {
		
	}

	public void mouseReleased(MouseEvent e) {
		if ((Character.getNumericValue (imagename.charAt(5))) == 4) {
			imagename = "pixel1.png";
		} else {
			imagename = "pixel" + Integer.toString(Character.getNumericValue(imagename.charAt(5)) + 1) + ".png";
		}
	}

	public void mouseClicked(MouseEvent e) {

	}

	public void mouseEntered(MouseEvent e) {

	}

	public void mouseExited(MouseEvent e) {

	}

}