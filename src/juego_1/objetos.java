package juego_1;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;


public class objetos {
    
    private Image nadador;
    //Coordenadas del nadador
    private int X;       
    private int Y;

    private int velocidad_X;

    private int limite_izquierda=0;
    private int limite_derecha;
    private int limite_superior=0;
   

     public objetos(int x, int y) {
        //coordenadas iniciales
        this.X = x; this.Y = y;
        //imagen de nadadores
        nadador = new ImageIcon(getClass().getResource("images.jpg")).getImage();
    }

    //dado las dimensiones del contendor JPanel
   public void LimitesX(int width, int height) {
        limite_derecha  = width  - nadador.getWidth(null);
        
    }

   //recalcula variables para dar la sensacion de movimiento
   public void mover() {
        //nueva posicion
        X += velocidad_X;
        //controla que la imagen no salga de los limites del contenedor
        if (X < this.limite_izquierda) {
            X = 0;     
            velocidad_X = -velocidad_X; 
        } else if (X > limite_derecha) {
            X = limite_derecha; 
        }
        
    }

    public void VelocidadX(){
        velocidad_X = NumeroRandom(8);
        //System.out.println(velocidad_X );
    }
    
    public void dibujar(Graphics g) {
        Graphics2D g2 = (Graphics2D)g;
        g2.drawImage(nadador, X, Y, null);
        g2.setColor(Color.black);
        g2.drawLine(0, 100, 700, 100);
        g2.setColor(Color.black);
        g2.drawLine(0, 200, 700, 200);
        g2.setColor(Color.black);
        g2.drawLine(0, 300, 700, 300);
    }

    //devuelve un número aleatorio entre 1 y MAX
    private int NumeroRandom(int Max){
        return (int) (Math.random()*Max+1);
    }
    

    
}