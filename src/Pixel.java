import java.awt.Image;
import java.awt.Graphics;
import java.awt.Toolkit;

public class Pixel {
	protected int x;
	protected int y;
	protected int dx;
	protected int dy;
	protected int h;
	protected int w;
	protected Image img;

	public Pixel(final int x, final int y, final int dx, final int dy, final int h, final int w, final String img) {
		this.x = x;
		this.y = y;
		this.dx = dx;
		this.dy = dy;
		this.h = h;
		this.w = w;
		this.img = getImage(img);
	}

	public void draw(Graphics g) {
		g.drawImage(img, x, y, w, h, null);
	}

	void update() {
		this.x = this.x + dx;
		this.y = this.y + dy;
		this.dy = this.dy + 1;
	}

	Image getImage(String img) {
		return Toolkit.getDefaultToolkit().getImage(img);
	}
}
