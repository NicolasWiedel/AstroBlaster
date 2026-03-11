package de.wiedel.astroblaster.screens;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.ScreenUtils;
import de.wiedel.astroblaster.GdxGame;
import de.wiedel.astroblaster.assets.AssetDescriptors;
import de.wiedel.astroblaster.config.GameConfig;
import de.wiedel.astroblaster.utils.Direction;
import de.wiedel.astroblaster.utils.Parallax;
import org.w3c.dom.css.Rect;

public class GameScreen implements Screen {

    private final GdxGame game;
    private final AssetManager assetManager;
    private final SpriteBatch batch;

   private Parallax background;
   private TextureRegion backgroundRegion;

    public GameScreen(GdxGame game){
        this.game = game;
        assetManager = game.getAssetManager();
        batch = game.getBatch();
    }

    @Override
    public void show() {
        background = new Parallax();
        background.setSize(GameConfig.WIDTH, GameConfig.HEIGHT);
        background.setDirection(Direction.DOWN);
        background.setSpeed(GameConfig.BACKGROUND_SPEED);
        backgroundRegion = new TextureRegion(game.getAssetManager().get(AssetDescriptors.BACKGROUND));
    }

    @Override
    public void render(float delta) {

        background.update(delta);
        Rectangle first = background.getFirstRectangle();
        Rectangle second = background.getSecondRectangle();

        ScreenUtils.clear(GameConfig.CORNFLOWER_BLUE);

        batch.begin();

        batch.draw(backgroundRegion, first.x, first.y, first.width, first.height);
        batch.draw(backgroundRegion, second.x, second.y, second.width, second.height);

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
