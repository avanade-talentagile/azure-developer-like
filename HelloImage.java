package com.exple;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.lang.Object;

import javax.imageio.ImageIO;
import javax.swing.text.Position;

public class HelloImage {

	public static  void main(String[] args) throws IOException {
		
		
		
		File file = new File("C:/Users/balkis.machlouch/OneDrive - Accenture/Documents/captureEcran/d.png");
		String fileUrl = "C:/Users/balkis.machlouch/OneDrive - Accenture/Documents/captureEcran/d.png";
		 String newFileUrl = fileUrl.replace(".png", "wtmark.png");
		   System.out.println(newFileUrl);
		   System.out.println(fileUrl.replace(".png", "wtmark.png"));
		File destImageFile = new File(newFileUrl);
	
		String text="Hello World";
		
		BufferedImage sourceImage = ImageIO.read(file);
        Graphics2D g2d = (Graphics2D) sourceImage.getGraphics();
 
        // initializes necessary graphic properties
        AlphaComposite alphaChannel = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.1f);
        g2d.setComposite(alphaChannel);
        g2d.setColor(Color.BLUE);
        g2d.setFont(new Font("Arial", Font.BOLD, 64));
        FontMetrics fontMetrics = g2d.getFontMetrics();
        Rectangle2D rect = fontMetrics.getStringBounds(text, g2d);
 
        // calculates the coordinate where the String is painted
        int centerX = (sourceImage.getWidth() - (int) rect.getWidth()) / 2;
        int centerY = sourceImage.getHeight() / 2;
 
        // paints the textual watermark
        g2d.drawString(text, centerX, centerY);
 
        ImageIO.write(sourceImage, "PNG", destImageFile);
        g2d.dispose();
 
        System.out.println("The tex watermark is added to the image.");

	}

}
