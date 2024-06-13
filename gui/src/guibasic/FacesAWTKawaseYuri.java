package guibasic;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class FacesAWTKawaseYuri {

    FacesAWTKawaseYuri() {
        FaceFrame f = new FaceFrame();
        f.setSize(800, 800);
        f.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        f.setVisible(true);
    }

    public static void main(String[] args) {
        new FacesAWTKawaseYuri();
    }

    class FaceFrame extends Frame {  // Corrected 'extend' to 'extends'
        private int xStart = 100;
        private int yStart = 100;
        private FaceObj[] fobjs= new FaceObj[9];

        FaceFrame() {
        }

        public void paint(Graphics g) {
			for(int i=0; i<3; i++) {
				for (int j=0; j<3; j++) {
				   fobjs[i+3*j]= new FaceObj();
				   fobjs[i+3*j].setPosition(200*i+50,200*j+50);
				   fobjs[i+3*j].setEmotionLevel(i,j);
				   fobjs[i+3*j].drawFace(g);
				}
			 }
        }
    }

    private class FaceObj {
        private int xStart = 0;
        private int yStart = 0;
		private String emotion = "";

        FaceObj() {
        }

		public void setPosition (int xStart, int yStart){
		this.xStart = xStart;
		this.yStart = yStart;
		}

		public void setEmotionLevel (int i, int j){
            if(i == 0){
                if(j == 0){
                    this.emotion = "Happy";
                }
                if(j == 1){
                    this.emotion = "Sad";
                }
                if(j == 2){
                    this.emotion = "Normal";
                }
            }
            if(i == 1){
                if(j == 0){
                    this.emotion = "Angry";
                }
                if(j == 1){
                    this.emotion = "High";
                }
                if(j == 2){
                    this.emotion = "Low";
                }
            }
            if(i == 2){
                if(j == 0){
                    this.emotion = "Name1";
                }
                if(j == 1){
                    this.emotion = "Name2";
                }
                if(j == 2){
                    this.emotion = "Name3";
                }
            }
			}

        public void drawFace(Graphics g) {
            drawRim(g);
            drawBrow(g);
            drawEye(g);
            drawNose(g);
            drawMouth(g);
        }

        public void drawRim(Graphics g) {
			g.setColor(Color.BLACK);
			g.drawRoundRect(xStart+5,yStart+5,200,200,200,200);
        }

        public void drawBrow(Graphics g) {
			g.setColor(Color.BLACK);
            switch(emotion){
                case "Happy":
                g.drawLine(xStart+40, yStart+50, xStart+55, yStart+40);
                g.drawLine(xStart+55, yStart+40, xStart+70, yStart+50);
                g.drawLine(xStart+130, yStart+50, xStart+145, yStart+40);
                g.drawLine(xStart+145, yStart+40, xStart+160, yStart+50);
                break;
                case "Sad":
            	g.drawLine(xStart+40, yStart+55, xStart+70, yStart+45);
			    g.drawLine(xStart+130, yStart+45, xStart+160, yStart+55);
                break;
                case "Normal": 
                g.drawLine(xStart+40, yStart+50, xStart+70, yStart+50);
                g.drawLine(xStart+130, yStart+50, xStart+160, yStart+50);
                break;
                case "High":
                g.drawLine(xStart+40, yStart+50, xStart+55, yStart+40);
                g.drawLine(xStart+55, yStart+40, xStart+70, yStart+50);
                g.drawLine(xStart+130, yStart+50, xStart+145, yStart+40);
                g.drawLine(xStart+145, yStart+40, xStart+160, yStart+50);
                break;
                case "Low":
                g.drawLine(xStart+40, yStart+55, xStart+70, yStart+45);
			    g.drawLine(xStart+130, yStart+45, xStart+160, yStart+55);
                break;
                case "Angry":
                g.drawLine(xStart+40, yStart+45, xStart+70, yStart+55);
			    g.drawLine(xStart+130, yStart+55, xStart+160, yStart+45);
                break;
                case "Name1":
                g.drawLine(xStart+40, yStart+50, xStart+70, yStart+50);
                g.drawLine(xStart+130, yStart+50, xStart+160, yStart+50);
                break;
                case "Name2":
                g.drawLine(xStart+40, yStart+50, xStart+70, yStart+50);
                g.drawLine(xStart+130, yStart+50, xStart+160, yStart+50);
                break;
                case "Name3":
                g.drawLine(xStart+40, yStart+50, xStart+70, yStart+50);
                g.drawLine(xStart+130, yStart+50, xStart+160, yStart+50);
                break;
                default:
                g.drawLine(xStart+40, yStart+50, xStart+70, yStart+50);
                g.drawLine(xStart+130, yStart+50, xStart+160, yStart+50);
                break;
            }
        }

        public void drawNose(Graphics g) {
			g.setColor(Color.BLACK);
            switch(emotion){
                case "Happy":
                g.drawLine(xStart+100, yStart+100, xStart+100, yStart+120);
                break;
                case "Sad":
		    	g.drawLine(xStart+100, yStart+100, xStart+100, yStart+120);
                break;
                case "Normal": 
			    g.drawLine(xStart+100, yStart+100, xStart+100, yStart+120);
                break;
                case "High":
		    	g.drawLine(xStart+100, yStart+100, xStart+100, yStart+120);
                break;
                case "Low":
			    g.drawLine(xStart+100, yStart+100, xStart+100, yStart+120);
                break;
                case "Angry":
			    g.drawLine(xStart+100, yStart+100, xStart+100, yStart+120);
                break;
                case "Name1":
                g.drawLine(xStart+100, yStart+100, xStart+100, yStart+120);
                break;
                case "Name2":
                g.drawLine(xStart+100, yStart+100, xStart+100, yStart+120);
                break;
                case "Name3":
			    g.drawLine(xStart+100, yStart+100, xStart+100, yStart+120);
                break;
                default:
			    g.drawLine(xStart+100, yStart+100, xStart+100, yStart+120);
                break;
            }
        }

        public void drawEye(Graphics g) {
			g.setColor(Color.BLACK);
            switch(emotion){
                case "Happy":
                g.drawLine(xStart+50, yStart+70, xStart+70, yStart+85);
                g.drawLine(xStart+70, yStart+85, xStart+50, yStart+100);
                g.drawLine(xStart+150, yStart+70, xStart+130, yStart+85);
                g.drawLine(xStart+130, yStart+85, xStart+150, yStart+100);
                break;
                case "Sad":
                g.fillOval(xStart+40, yStart+70, 30,30);
	    		g.fillOval(xStart+130, yStart+70, 30,30);
                break;
                case "Normal": 
                g.fillOval(xStart+40, yStart+70, 30,30);
			    g.fillOval(xStart+130, yStart+70, 30,30);
                break;
                case "High":
                g.fillOval(xStart+40, yStart+70, 30,30);
                g.fillOval(xStart+130, yStart+70, 30,30);
                break;
                case "Low":
                g.fillOval(xStart+40, yStart+70, 30,30);
			    g.fillOval(xStart+130, yStart+70, 30,30);
                break;
                case "Angry":
                g.fillOval(xStart+40, yStart+70, 30,30);
			    g.fillOval(xStart+130, yStart+70, 30,30);
                break;
                case "Name1":
			    g.fillOval(xStart+40, yStart+70, 30,30);
			    g.fillOval(xStart+130, yStart+70, 30,30);
                break;
                case "Name2":
                g.fillOval(xStart+40, yStart+70, 30,30);
			    g.fillOval(xStart+130, yStart+70, 30,30);
                break;
                case "Name3":
                g.fillOval(xStart+40, yStart+70, 30,30);
			    g.fillOval(xStart+130, yStart+70, 30,30);
                break;
                default:
                g.fillOval(xStart+40, yStart+70, 30,30);
                g.fillOval(xStart+130, yStart+70, 30,30);
                break;
            }
        }

        public void drawMouth(Graphics g) {
            g.setColor(Color.RED);
            switch(emotion){
                case "Happy":
                g.drawLine(xStart+70, yStart+140, xStart+100, yStart+160);
                g.drawLine(xStart+100, yStart+160, xStart+130, yStart+140);
                break;
                case "Sad":
                g.drawLine(xStart+70, yStart+160, xStart+100, yStart+140);
                g.drawLine(xStart+100, yStart+140, xStart+130, yStart+160);
                break;
                case "Normal": 
                g.drawLine(xStart+70, yStart+150, xStart+100, yStart+150);
                g.drawLine(xStart+100, yStart+150, xStart+130, yStart+150);
                break;
                case "High":
                g.drawLine(xStart+70, yStart+140, xStart+100, yStart+160);
                g.drawLine(xStart+100, yStart+160, xStart+130, yStart+140);
                break;
                case "Low":
                g.drawLine(xStart+70, yStart+140, xStart+100, yStart+160);
                g.drawLine(xStart+100, yStart+160, xStart+130, yStart+140);
                break;
                case "Angry":
                g.drawLine(xStart+70, yStart+140, xStart+100, yStart+160);
			    g.drawLine(xStart+100, yStart+160, xStart+130, yStart+140);
                break;
                case "Name1":
                g.drawLine(xStart+70, yStart+140, xStart+100, yStart+160);
			    g.drawLine(xStart+100, yStart+160, xStart+130, yStart+140);
                break;
                case "Name2":
                g.drawLine(xStart+70, yStart+140, xStart+100, yStart+160);
			    g.drawLine(xStart+100, yStart+160, xStart+130, yStart+140);
                break;
                case "Name3":
                g.drawLine(xStart+70, yStart+140, xStart+100, yStart+160);
			    g.drawLine(xStart+100, yStart+160, xStart+130, yStart+140);
                break;
                default:
			    g.drawLine(xStart+70, yStart+140, xStart+100, yStart+160);
			    g.drawLine(xStart+100, yStart+160, xStart+130, yStart+140);
                break;
            }
        }
    }
}
