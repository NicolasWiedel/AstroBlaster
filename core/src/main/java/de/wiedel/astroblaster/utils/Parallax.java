package de.wiedel.astroblaster.utils;

import com.badlogic.gdx.math.Rectangle;
import de.wiedel.astroblaster.config.GameConfig;

public class Parallax {

    private final Rectangle firstRectangle;
    private final Rectangle secondRectangle;

    private float speed = 1f;
    private Direction direction = Direction.DOWN;

    private float startX;
    private float startY;
    private float width = 1;
    private float height = 1;

    public Parallax(){
        firstRectangle = new Rectangle(startX, startY, width, height);
        secondRectangle = new Rectangle(startX, startY + height, width, height);
    }

    public void update(float delta){
        if(rectReachedBounds(delta)){
            resetRects();
            return;
        }

        float velocity = delta * speed;

        if (direction .isDown()){
            firstRectangle.y -= velocity;
            secondRectangle.y -= velocity;
        } else if (direction.isUp()) {
            firstRectangle.y += velocity;
            secondRectangle.y += velocity;
        } else if (direction.isRight()) {
            firstRectangle.x += velocity;
            secondRectangle.x += velocity;
        } else if (direction.isLeft()) {
            firstRectangle.x -= velocity;
            secondRectangle.x -= velocity;
        }
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    public void setStartPosition(float startX, float startY){
        this.startX = startX;
        this.startY = startY;
        updateRect();
    }

    public Rectangle getFirstRectangle() {
        return firstRectangle;
    }

    public Rectangle getSecondRectangle() {
        return secondRectangle;
    }

    public void setSize(float width, float height){
        this.width = width;
        this.height = height;
        updateRect();
    }

    public void setDirection(Direction direction){
        this.direction = direction;
        updateRect();
    }

    public void updateRect(){
        firstRectangle.set(startX, startY, width, height);
        secondRectangle.set(startX, startY + height, width, height);

        if (direction.isUp()){
            secondRectangle.set(startX, startY - height, width, height);
        }else if (direction.isRight()){
            secondRectangle.set(startX - width, startY, width, height);
        }else if (direction.isLeft()){
            secondRectangle.set(startX + width, startY, width, height);
        }
    }

    private boolean rectReachedBounds(float delta){
        float velocity = speed * delta;

        if (direction.isRight()){
            float nextPos = secondRectangle.x + velocity;
            return nextPos >= 0f;
        }
        else if (direction.isUp()){
            float nextPos = secondRectangle.y + velocity;
            return nextPos >= 0f;
        }
        else if (direction.isLeft()){
            float nextPos = secondRectangle.x -velocity;
            return nextPos <= 0f;
        }

        float nextPos = secondRectangle.y -velocity;
        return nextPos <= 0f;
    }

    private void resetRects(){
        firstRectangle.setPosition(startX, startY);
        secondRectangle.setPosition(startX, height);

        if (direction.isUp()){
            secondRectangle.setPosition(startX, -height);
        } else if (direction.isRight()) {
            secondRectangle.setPosition(-width, startY);
        } else if (direction.isLeft()) {
            secondRectangle.setPosition(width, startY);
        }
    }
}
