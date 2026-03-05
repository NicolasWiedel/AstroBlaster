package de.wiedel.astroblaster;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import de.wiedel.astroblaster.entities.Player;
import de.wiedel.astroblaster.entities.config.GameConfig;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class GdxGame extends ApplicationAdapter {

    private GameState currentState = GameState.MENU;

    private SpriteBatch batch;
    private Texture image;

    private Player player;

    @Override
    public void create() {
        batch = new SpriteBatch();
        image = new Texture("libgdx.png");

        player = new Player();
    }

    @Override
    public void render() {
        ScreenUtils.clear(GameConfig.CORNFLOWER_BLUE);

        float deltaTime = Gdx.graphics.getDeltaTime();

        switch (currentState){
            case MENU:
                // Only draw the title screen text and wait for tap
                handleMenuInput();
                drawMenuScreen();
                break;
            case PLAYING:
                // Runs the core logic: Update physics, handle player input, draw game
                handlePlayingInput();
                updateGameLogic();
                drawGameWorld();
                break;
            case GAME_OVER:
                // Draw "GAME_OVER" logic: message and final score
                handleGameOverInput();
                drawGameOverScreen();
                break;
        }

        batch.begin();
        batch.draw(image, 140, 210);
        batch.end();
    }

    private void handleMenuInput(){}
    private void drawMenuScreen(){}

    private void handlePlayingInput(){
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)){
            player.setX(player.getX() + player.getSpeed() * Gdx.graphics.getDeltaTime());
        }
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)){
            player.setX(player.getX() - player.getSpeed() * Gdx.graphics.getDeltaTime());
        }

        if (player.getX() < 0){
            player.setX(0);
        }
        if(player.getX() > GameConfig.WIDTH - player.getWidth()){
           player.setX(GameConfig.WIDTH - player.getWidth());
        }
    }

    private void updateGameLogic(){}
    private void drawGameWorld(){}
    private void handleGameOverInput(){}
    private void drawGameOverScreen(){}

    @Override
    public void dispose() {
        batch.dispose();
        image.dispose();
    }

    public enum GameState {
        MENU,
        PLAYING,
        GAME_OVER
    }
}
