package flapjack.gui.visualization.colors;

import java.awt.*;
import java.awt.color.*;
import java.awt.geom.*;
import java.awt.image.*;

import flapjack.data.*;
import flapjack.gui.*;

public class SimpleColorState extends ColorState
{
	SimpleColorState(AlleleState state, Color c, int w, int h)
	{
		super(state, c, w, h);

		image = createBuffer(color);
		gsImage = createBuffer(getGreyScale(color));
	}

	private BufferedImage createBuffer(Color c)
	{
		BufferedImage image = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
		Graphics2D g = image.createGraphics();

		g.setColor(c);

		Rectangle2D.Float r = new Rectangle2D.Float(0, 0, w, h);
		g.fill(r);
		g.dispose();

		return image;
	}
}