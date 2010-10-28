package com.androidwars;


import com.stickycoding.rokon.Texture;
import com.stickycoding.rokon.TextureAtlas;

public class Textures {

    public static TextureAtlas atlas;
    public static Texture background, guy;

    public static void load() {
        atlas = new TextureAtlas();
        atlas.insert(background = new Texture("mapbackground.png"));
        atlas.insert(guy = new Texture("bob.png"));
        atlas.complete();
    }
}
