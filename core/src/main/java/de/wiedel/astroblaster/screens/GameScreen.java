package de.wiedel.astroblaster.screens;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import de.wiedel.astroblaster.GdxGame;
import de.wiedel.astroblaster.assets.AssetDescriptors;
import de.wiedel.astroblaster.config.GameConfig;

public class GameScreen implements Screen {

    private final GdxGame game;
    private final AssetManager assetManager;
    private final SpriteBatch batch;

    private Texture background;

    public GameScreen(GdxGame game){
        this.game = game;
        assetManager = game.getAssetManager();
        batch = game.getBatch();
    }

    @Override
    public void show() {
        background = assetManager.get(AssetDescriptors.BACKGROUND);
    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(GameConfig.CORNFLOWER_BLUE);

        batch.begin();

        batch.draw(background, 0, 0);

        batch.end();
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
