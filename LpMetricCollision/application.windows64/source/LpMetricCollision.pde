void setup() {
  size(800, 600); 
  noStroke(); 
  rectMode(CENTER);
}

int centerRectX = 400, centerRectY = 300;
void draw() {
  background(50); 
  
  //Change color on collision
  if(detectCollision(mouseX,centerRectX,mouseY,centerRectY,70.711,45)){
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
boolean detectCollision(int x1, int x2,int y1,int y2,float diameter, float angle) {
  float xPrime = (x1 - x2)*cos(radians(angle)) - ((y1 - y2)*sin(radians(angle)));
  float yPrime =  (x1 - x2)*sin(radians(angle)) + ((y1 - y2)*cos(radians(angle)));
  return abs(xPrime)+abs(yPrime)< diameter;
}