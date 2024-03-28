package Level_2_Lesson_1;

import java.awt.*;
import java.util.Random;

public class Background extends Sprite {

    Random rnd = new Random();
    Color backgroundColor;
    Background(){
        halfHeight = MainCircles.HEIGHT;
        halfWidth = MainCircles.WIDTH;
        backgroundColor = new Color(
                (int) (Math.random() * 255),
                (int) (Math.random() * 255),
                (int) (Math.random() * 255));
    }

    @Override
    void update(GameCanvas canvas, float deltaTime) {
        canvas.setBackground(new Color(
                (int) (Math.random() * 255),
                (int) (Math.random() * 255),
                (int) (Math.random() * 255)));
    }

    @Override
    void render(GameCanvas canvas, Graphics g) {
        g.fillRect(0,0,(int) getWidth(),(int) getHeight());
    }
}
