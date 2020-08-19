import java.awt.Rectangle;

public class GameObject {
	int x;
	int y;
	int width;
	int height;
	int speed;
	boolean isActive;
	Rectangle collisionBox;
	
	
	Relation relationship;
	
	
	GameObject(int x,int y,int width,int height){
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		collisionBox = new Rectangle(x, y, width, height);
		
		speed = 0;
		isActive = true;
	}
	
	void update(){
        collisionBox.setBounds(x, y, width, height);
        
	}
}
