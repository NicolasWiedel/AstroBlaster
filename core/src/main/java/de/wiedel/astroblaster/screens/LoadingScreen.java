package de.wiedel.astroblaster.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import de.wiedel.astroblaster.GdxGame;
import de.wiedel.astroblaster.assets.AssetDescriptors;
import de.wiedel.astroblaster.config.GameConfig;

public class LoadingScreen implements Screen {

    private final GdxGame game;
    private final AssetManager assetManager;
    private final SpriteBatch batch;

    private final Texture background;
    private final Texture loadingbarFill;
    private final Texture loadingbarEmpty;
    private final BitmapFont defaultFont;

    private float timer;

    public LoadingScreen(GdxGame game){
        this.game = game;
        assetManager = game.getAssetManager();
        batch = game.getBatch();

        assetManager.load(AssetDescriptors.BACKGROUND);
        assetManager.load(AssetDescriptors.LOADING_BAR_EMPTY);
        assetManager.load(AssetDescriptors.LOADING_BAR_FILL);
        assetManager.load(AssetDescriptors.DEFAULT_FONT);
        assetManager.finishLoading();

        background = assetManager.get(AssetDescriptors.BACKGROUND);
        loadingbarFill = assetManager.get(AssetDescriptors.LOADING_BAR_FILL);
        loadingbarEmpty = assetManager.get(AssetDescriptors.LOADING_BAR_EMPTY);
        defaultFont = assetManager.get(AssetDescriptors.DEFAULT_FONT);

        assetManager.load(AssetDescriptors.GAME_PLAY_ATLAS);
        assetManager.load(AssetDescriptors.BACKGROUND_MUSIC);
        assetManager.load(AssetDescriptors.FIRE1_SOUND);
        assetManager.load(AssetDescriptors.FIRE2_SOUND);
        assetManager.load(AssetDescriptors.FIRE3_SOUND);
        assetManager.load(AssetDescriptors.FIRE4_SOUND);
        assetManager.load(AssetDescriptors.FIRE5_SOUND);
        assetManager.load(AssetDescriptors.FIRE6_SOUND);
        assetManager.load(AssetDescriptors.GAME_OVER_SOUND);
        assetManager.load(AssetDescriptors.HIT_SOUND);
        assetManager.load(AssetDescriptors.MISC_LASER_SOUND);
    }

    @Override
    public void show() {
        timer = 0;
    }

    @Override
    public void render(float delta) {

        boolean done = assetManager.update();

        if (done){
            game.setScreen(new GameScreen(game));
        }

        ScreenUtils.clear(GameConfig.CORNFLOWER_BLUE);

        batch.begin();
        batch.draw(background, 0, 0);

        float x = Gdx.graphics.getWidth() / 2f - loadingbarEmpty. getWidth() / 2f;
        float y = Gdx.graphics.getHeight() / 2f - loadingbarEmpty.getHeight() / 2f;
        float width = loadingbarEmpty.getWidth() * assetManager.getProgress();
        batch.draw(loadingbarEmpty, x, y);
        batch.draw(loadingbarFill, x, y, width, loadingbarFill.getHeight());
        defaultFont.draw(batch,
            String.format("Loading %d%%",
                (int)(assetManager.getProgress() * 100)),
            x + 140, y + loadingbarEmpty.getHeight() + 50);

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
        batch.dispose();
    }
}
