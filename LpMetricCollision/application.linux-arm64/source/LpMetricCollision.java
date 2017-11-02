import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class LpMetricCollision extends PApplet {

public void setup() {
   
  noStroke(); 
  rectMode(CENTER);
}

int centerRectX = 400, centerRectY = 300;
public void draw() {
  background(50); 
  
  //Change color on collision
  if(detectCollision(mouseX,centerRectX,mouseY,centerRectY,70.711f,45)){
    fill(155); 
  } else {
    fill(255); 
  }
  
  //Rect at mouse location
  rect(mouseX, mouseY,50,50);
  
  //Rect at center screen
  rect(centerRectX,centerRectY,50,50);
}

//The diameter will be the length of the squares hypotenuse.
public boolean detectCollision(int x1, int x2,int y1,int y2,float diameter, float angle) {
  float xPrime = (x1 - x2)*cos(radians(angle)) - ((y1 - y2)*sin(radians(angle)));
  float yPrime =  (x1 - x2)*sin(radians(angle)) + ((y1 - y2)*cos(radians(angle)));
  return abs(xPrime)+abs(yPrime)< diameter;
}
  public void settings() {  size(800, 600); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "LpMetricCollision" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
