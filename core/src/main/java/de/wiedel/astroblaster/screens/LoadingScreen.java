package de.wiedel.astroblaster.screens;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import de.wiedel.astroblaster.GdxGame;

public class LoadingScreen implements Screen {

    private final GdxGame game;
    private final AssetManager assetManager;
    private SpriteBatch batch;

    public LoadingScreen(GdxGame game){
        this.game = game;
        assetManager = game.getAssetManager();
        batch = game.getBatch();
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {

    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
