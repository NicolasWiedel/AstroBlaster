package de.wiedel.astroblaster;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class GdxGame extends ApplicationAdapter {

    private GameState currentState = GameState.MENU;

    private SpriteBatch batch;
    private Texture image;

    @Override
    public void create() {
        batch = new SpriteBatch();
        image = new Texture("libgdx.png");
    }

    @Override
    public void render() {
        ScreenUtils.clear(0.15f, 0.15f, 0.2f, 1f);

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
