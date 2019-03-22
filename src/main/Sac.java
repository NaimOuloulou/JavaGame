package main;

import java.util.ArrayList;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Sac extends ArrayList<Objet> {
	
	private Image image;
	
	public Sac () throws SlickException{
		
		System.out.println("Recupération de l'image des outils");
		image = new Image("tuiles/365214serie.png");
		if(image != null)
			System.out.println("image is not null");


	}
	
	

}
