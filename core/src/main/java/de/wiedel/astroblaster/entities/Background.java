package de.wiedel.astroblaster.entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import de.wiedel.astroblaster.GdxGame;
import de.wiedel.astroblaster.assets.AssetDescriptors;

public class Background {

    private Texture backgroundTexture;
    private Sprite background1;
    private Sprite background2;

    public Background(GdxGame game){
        backgroundTexture = game.getAssetManager().get(AssetDescriptors.BACKGROUND);       
        background1 = new Sprite(backgroundTexture);
        background2 = new Sprite(backgroundTexture);
        background1.setPosition(0, 0);
        background2.setPosition(0, background1.getHeight());
    }


}
