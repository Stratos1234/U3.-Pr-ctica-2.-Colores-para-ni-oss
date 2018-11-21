package mx.edu.ittepic.dadm_u3_ejercio5;

import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.media.AudioManager;
import android.media.MediaExtractor;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Environment;
import android.view.MotionEvent;
import android.view.View;
import java.io.File;
import java.io.IOException;

public class Lienzo extends View {

    String mensaje;
    Imagen amarillo, negro, morado, verde, azul, naranja,manotas;
    float x = 100, y = 100, x1 = 500, y1 = 100, x2 = 100, y2 = 500, x3 = 500, y3 = 500,
            x4 = 100, y4 = 900, x5 = 500, y5 = 900;
    MediaPlayer md;
    Principal2 puntero2;


    public Lienzo(Context context) {
        super(context);
        mensaje = "Toca el color y escuche el audio";
        manotas=new Imagen(R.drawable.manotas,0,0,this);
        amarillo = new Imagen(R.drawable.amarrillo, x, y, this);
        negro = new Imagen(R.drawable.negra, x1, y1, this);
        morado = new Imagen(R.drawable.purpura, x2, y2, this);
        verde = new Imagen(R.drawable.verde, x3, y3, this);
        azul = new Imagen(R.drawable.azul, x4, y4, this);
        naranja = new Imagen(R.drawable.naranja, x5, y5, this);
        puntero2 = (Principal2) context;


    }


    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint p = new Paint();
        manotas.pintar(canvas, p);
        p.setTextSize(30);
        p.setColor(Color.RED);
        canvas.drawText(mensaje, 350, 50, p);
        //canvas.drawColor(Color.CYAN);
        //canvas.draw
        amarillo.pintar(canvas, p);
        negro.pintar(canvas, p);
        morado.pintar(canvas, p);
        verde.pintar(canvas, p);
        azul.pintar(canvas, p);
        naranja.pintar(canvas, p);


    }


    public boolean onTouchEvent(MotionEvent e) {
        float xtoque = e.getX();
        float ytoque = e.getY();


        switch (e.getAction()) {
            case MotionEvent.ACTION_DOWN:
                //Entra si e.getAction esta presionado
                if (amarillo.estEnArea(xtoque, ytoque)) {

                    mensaje = "Color amarrillo";
                    puntero2.amarillo();
                }
                if (negro.estEnArea(xtoque, ytoque)) {

                    mensaje = "Color negro";
                    puntero2.negro();

                }
                if (morado.estEnArea(xtoque, ytoque)) {

                    mensaje = "Color morado";
                    puntero2.morado();

                }
                if (verde.estEnArea(xtoque, ytoque)) {

                    mensaje = "Color Verde";
                    puntero2.verdes();
                }
                if (azul.estEnArea(xtoque, ytoque)) {

                    mensaje = "Color azul";
                    puntero2.azull();

                }
                if (naranja.estEnArea(xtoque, ytoque)) {

                    mensaje = "Color Naranja";
                    puntero2.naranjas();

                }

                break;

        }
        invalidate();//manda llamar a onDraw
        return true;
    }


}