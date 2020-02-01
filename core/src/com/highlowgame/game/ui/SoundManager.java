package com.highlowgame.game.ui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;

public class SoundManager {
    Sound sound;
    Music music;
    public SoundManager()
    {
    }
    public void playOutsideSchoolandOutside()
    {
        sound = Gdx.audio.newSound(Gdx.files.internal("Audio/Girl_voice_for_bennies_thing.mp3"));
        sound.play();
    }
    public void playOutsideCasino()
    {
        sound = Gdx.audio.newSound(Gdx.files.internal("Audio/Mexican_Outside_Casino.mp3"));
        sound.play();
    }
    public void playInsideCasinoPt1()
    {
        sound = Gdx.audio.newSound(Gdx.files.internal("Audio/PART_1_INSIDE_CASINO_MEXICAN.mp3"));
        sound.play();
    }
    public void playBadEnding()
    {
        sound = Gdx.audio.newSound(Gdx.files.internal("Audio/BAD_ENDING_FT_MEXICAN_fdn.mp3"));
        sound.play();
    }
    public void playNormalEnding()
    {
        sound = Gdx.audio.newSound(Gdx.files.internal("Audio/NORMAL_ENDING_FT_MEXICAN.mp3"));
        sound.play();
    }
    public void playRicoEnding()
    {
        sound = Gdx.audio.newSound(Gdx.files.internal("Audio/RICO_ENDING_FT_MEXICAN.mp3"));
        sound.play();
    }
    public void playInsideCasinoPt2()
    {
        sound = Gdx.audio.newSound(Gdx.files.internal("Audio/PART_2_INSIDE_CASINO_MEXICAN.mp3"));
        sound.play();
    }
    public void stopSound()
    {
        if(sound!=null)
            sound.stop();
    }

    public void playMusicMainMenu()
    {
        music = Gdx.audio.newMusic(Gdx.files.internal("Audio/music/Ay... que Rico.mp3"));
        music.play();
        music.setVolume(0.1f);
    }
    public void playInSchool()
    {
        music = Gdx.audio.newMusic(Gdx.files.internal("Audio/music/Sono chi no sadame but perfectly kazoo'd.mp3"));
        music.play();
        music.setVolume(0.1f);
    }

    public void playOutside()
    {
        music = Gdx.audio.newMusic(Gdx.files.internal("Audio/music/Rachmaninoff - Prelude in G Minor (Op. 23 No. 5).mp3"));
        music.play();
        music.setVolume(0.1f);
    }
    public void playCasino()
    {
        music = Gdx.audio.newMusic(Gdx.files.internal("Audio/music/Coolio - Gangsta's Paradise Instrumental w choir.mp3"));
        music.play();
        music.setVolume(0.1f);
    }
    public void playDangerMusic()
    {
        music = Gdx.audio.newMusic(Gdx.files.internal("Audio/music/Rachmaninoff - Prelude in C Sharp Minor (Op. 3 No. 2).mp3"));
        music.play();
        music.setVolume(0.1f);
    }
    public void playLoveMusic()
    {
        music = Gdx.audio.newMusic(Gdx.files.internal("Audio/music/RENAI CIRCULATION (Full) ENGLISH [] EileMonty Cover.mp3"));
        music.play();
        music.setVolume(0.05f);
    }
    public void playFunkMusic()
    {
        music = Gdx.audio.newMusic(Gdx.files.internal("Audio/music/anosci - Jt2oUaHBFStY (SU mashup).mp3"));
        music.play();
        music.setVolume(0.05f);
    }









    public void stopMusic()
    {
        if(music!=null)
        music.stop();
    }



}
