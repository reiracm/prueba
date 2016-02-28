package gui;

import java.util.Observable;

public class Square extends Observable implements Runnable {
	
	private int speed;
	//minimo valor en x que puede tener la bola
	private int min_x = 0;
	//minimo valor en y que puede tener la bola
	private int min_y = 0;
	//posición en x de la bola
	private int pos_x;
	//poscición en y de la bola
	private int pos_y;
	//máximo valor en x que puede tener la bola
	private int max_x;
	//máximo valor en y que puede tener la bola
	private int max_y;
	//velocidad en x
	private int speed_x=1;
	//velocidad en y
	private int speed_y=1;
	
	private boolean alive = false;
	
	public Square(int speed, int max_x, int max_y) {
		//rapidez inicial
		this.speed = speed;
		//valor inicial de x
		pos_x = max_x/2;
		//valor inicial de y
		pos_y = max_y/2;
		this.max_x = max_x;
		this.max_y = max_y;
		
		alive = true;
	}
	/**
	 * Dirección respecto a la posición inicial que va a determinar velocidad
	 * en y y en x
	 * @param x
	 * @param y
	 */
	public void setInitialVector(int x, int y){
		/*double angle = Math.atan(Math.abs((double)(y-pos_y)/(x-pos_x)));
		if((x-pos_x) > 0){
			speed_x = ((Double)(speed*Math.cos(angle))).intValue();
		}else{
			speed_x = ((Double)(speed*Math.cos(angle))).intValue()*-1;
		}
		if((y-pos_y) > 0){
			speed_y = ((Double)(speed*Math.sin(angle))).intValue();
		}else{
			speed_y = ((Double)(speed*Math.sin(angle))).intValue()*-1;
		}*/
	}
	

	@Override
	public void run() {
		
		// TODO Auto-generated method stub
		// Todo lo que va a aqui adentro es otro hilo
				while(alive){
					
					System.out.format("Velocidad en x: %d \nVelocidad en y: %d\n\n", speed_x, speed_y);
					
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					int temp_x = pos_x + speed_x;
					if(temp_x < max_x && temp_x > min_x){
						pos_x = temp_x;
					}
					else if(temp_x >= max_x){
						pos_x = max_x;
						speed_x *= -1;
					}
					else if(temp_x <= min_x){
						pos_x = min_x;
						speed_x *= -1;
					}
					
					int temp_y = pos_y + speed_y;
					if(temp_y < max_y && temp_y > min_y){
						pos_y = temp_y;
					}
					else if(temp_y >= max_y){
						pos_y = max_y;
						speed_y *= -1;
					}
					else if(temp_y <= min_y){
						pos_y = min_y;
						speed_y *= -1;
					}
					
					int positions[] = {pos_x, pos_y};
					
					setChanged();
					notifyObservers(positions);
					
				}
				
			}
	/**
	 * @return the alive
	 */
	public boolean isAlive() {
		return alive;
	}

	/**
	 * @param alive the alive to set
	 */
	public void setAlive(boolean alive) {
		this.alive = alive;
	}
	
	/**
	 * @return the pos_x
	 */
	public int getPos_x() {
		return pos_x;
	}

	/**
	 * @return the pos_y
	 */
	public int getPos_y() {
		return pos_y;
	}
	
	public void yCollision(){
		speed_y *= -1;
	}
	
	public void xCollision(){
		speed_x *= -1;
	}
}
