package de.wiedel.astroblaster.assets;

import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

public class AssetDescriptors {

    public static final AssetDescriptor<Texture> BACKGROUND =
        new AssetDescriptor<>(Assets.BACKGROUND, Texture.class);

    public static final AssetDescriptor<Texture> LOADING_BAR_EMPTY =
        new AssetDescriptor<>(Assets.LOADING_BAR_EMPTY, Texture.class);

    public static final AssetDescriptor<Texture> LOADING_BAR_FILL =
        new AssetDescriptor<>(Assets.LOADING_BAR_FILL, Texture.class);

    public static final AssetDescriptor<BitmapFont> DEFAULT_FONT =
        new AssetDescriptor<>(Assets.DEFAULT_FONT, BitmapFont.class);

    public static final AssetDescriptor<TextureAtlas> GAME_PLAY_ATLAS =
        new AssetDescriptor<>(Assets.GAME_PLAY, TextureAtlas.class);

    public static final AssetDescriptor<Music> BACKGROUND_MUSIC =
        new AssetDescriptor<>(Assets.BACKGROUND_MUSIC, Music.class);

    public static final AssetDescriptor<Sound> FIRE1_SOUND =
        new AssetDescriptor<>(Assets.FIRE1_SOUND, Sound.class);
    public static final AssetDescriptor<Sound> FIRE2_SOUND =
        new AssetDescriptor<>(Assets.FIRE2_SOUND, Sound.class);
    public static final AssetDescriptor<Sound> FIRE3_SOUND =
        new AssetDescriptor<>(Assets.FIRE3_SOUND, Sound.class);
    public static final AssetDescriptor<Sound> FIRE4_SOUND =
        new AssetDescriptor<>(Assets.FIRE4_SOUND, Sound.class);
    public static final AssetDescriptor<Sound> FIRE5_SOUND =
        new AssetDescriptor<>(Assets.FIRE5_SOUND, Sound.class);
    public static final AssetDescriptor<Sound> FIRE6_SOUND =
        new AssetDescriptor<>(Assets.FIRE6_SOUND, Sound.class);
    public static final AssetDescriptor<Sound> GAME_OVER_SOUND =
        new AssetDescriptor<>(Assets.GAME_OVER_SOUND, Sound.class);
    public static final AssetDescriptor<Sound> HIT_SOUND =
        new AssetDescriptor<>(Assets.HIT_SOUND, Sound.class);
    public static final AssetDescriptor<Sound> MISC_LASER_SOUND =
        new AssetDescriptor<>(Assets.MISC_LASERS_SOUND, Sound.class);
}
