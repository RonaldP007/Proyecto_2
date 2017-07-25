package juego_1;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.Timer;

public class panel extends JPanel{
     
    //instancia a la persona en posicion (X,Y) => (0,0)
    private objetos persona1 = new objetos(0, 15);
    private objetos persona2 = new objetos(0, 115);
    private objetos persona3 = new objetos(0, 220);
    private Timer timer;
    
    //Constructor
    public panel(Dimension d) {
        this.setSize(d);
        this.setPreferredSize(d);
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        this.setBackground(new Color(0,200,234));
        persona1.LimitesX(getWidth(), getHeight());
        
        persona2.LimitesX(getWidth(), getHeight());
        persona3.LimitesX(getWidth(), getHeight());
        //para la animación
        timer = new Timer(16, new ActionListener (){
            public void actionPerformed(ActionEvent e) {                
                persona1.mover();
                persona2.mover();
                persona3.mover();
                repaint();    
            }
        });
    }

    //Controla el inicio y fin de la animación
    public void animar(boolean turnOnOff) {
        if (turnOnOff) {
            persona1.VelocidadX();
            persona2.VelocidadX();
            persona3.VelocidadX();
            timer.start(); 
        } else {
            timer.stop();
        }
    }

    //pinta la animación
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        persona1.dibujar(g);
        persona2.dibujar(g);
        persona3.dibujar(g);
    }

}
