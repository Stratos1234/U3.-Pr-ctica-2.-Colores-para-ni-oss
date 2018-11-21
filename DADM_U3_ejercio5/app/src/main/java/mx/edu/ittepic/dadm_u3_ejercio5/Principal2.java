package mx.edu.ittepic.dadm_u3_ejercio5;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.media.DrmInitData;
import android.media.MediaPlayer;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Principal2 extends AppCompatActivity {

    MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new Lienzo(this));

    }

    public void amarillo() {
        mp = MediaPlayer.create(this, R.raw.yelowricardo);
        mp.start();
    }

    public void negro() {
        mp = MediaPlayer.create(this, R.raw.negroricardo);
        mp.start();
    }

    public void morado() {
        mp = MediaPlayer.create(this, R.raw.moradoricardo);
        mp.start();

    }
    public void azull()
    {
        mp=MediaPlayer.create(this,R.raw.azulricardo);
        mp.start();
    }
    public  void  naranjas ()
    {
        mp=MediaPlayer.create(this,R.raw.naranjaricardo);
        mp.start();
    }
    public void verdes()
    {
        mp=MediaPlayer.create(this,R.raw.verdericardo);
        mp.start();
    }
}
