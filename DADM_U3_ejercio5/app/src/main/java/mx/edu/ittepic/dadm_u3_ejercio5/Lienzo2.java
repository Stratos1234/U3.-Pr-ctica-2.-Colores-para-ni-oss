package mx.edu.ittepic.dadm_u3_ejercio5;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.view.MotionEvent;
import android.view.View;

import java.io.IOException;

public class Lienzo2 extends View {
    String mensaje;
    Imagen2 amarillo;
    Imagen2 letras_amarillas;
    Imagen2 morado;
    Imagen2 letras_moradas;
    Imagen2 azul;
    Imagen2 letras_azul;
    Imagen2 puntero,manotas;
    MediaPlayer md;


    public Lienzo2(Context context) {
        super(context);
        mensaje = "Arratre el texto al color que corresponde";
        manotas=new Imagen2(R.drawable.manotas,0,0,this);
        amarillo = new Imagen2(R.drawable.amarrillo, 100, 100, this);
        letras_amarillas = new Imagen2(R.drawable.yellow, 500, 100, this);
        morado = new Imagen2(R.drawable.purpura, 100, 500, this);
        letras_moradas = new Imagen2(R.drawable.purple, 500, 500, this);
        azul = new Imagen2(R.drawable.azul, 100, 900, this);
        letras_azul = new Imagen2(R.drawable.blue, 500, 900, this);
        puntero = null;

    }


    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint p = new Paint();
        manotas.pintar(canvas, p);
        p.setTextSize(30);
        p.setColor(Color.RED);
        canvas.drawText(mensaje, 300, 50, p);
        //canvas.drawColor(Color.CYAN);
        //canvas.draw
        amarillo.pintar(canvas, p);
        letras_amarillas.pintar(canvas, p);
        morado.pintar(canvas, p);
        letras_moradas.pintar(canvas, p);
        azul.pintar(canvas, p);
        letras_azul.pintar(canvas, p);


    }


    public boolean onTouchEvent(MotionEvent e) {

        float xp = e.getX(), yp = e.getY();

        switch (e.getAction()) {
            case MotionEvent.ACTION_DOWN:
                //Entra si e.getAction esta presionado

                if (amarillo.estEnArea(xp, yp)) {
                    // mensaje = "Se toco icono 1";
                    puntero = amarillo;//puntero apunta  a basura
                }
                if (letras_amarillas.estEnArea(xp, yp)) {
                    // mensaje = "Tocaste icono 2";
                    puntero = letras_amarillas;
                }
                if (morado.estEnArea(xp, yp)) {
                    puntero = morado;
                }
                if (letras_moradas.estEnArea(xp, yp)) {
                    puntero = letras_moradas;
                }
                if (azul.estEnArea(xp, yp)) {
                    puntero = azul;
                }
                if (letras_azul.estEnArea(xp, yp)) {
                    puntero = letras_azul;
                }


                break;

            case MotionEvent.ACTION_MOVE: //no es eficiente el if en mover

                if (puntero != null) {
                    puntero.mover(xp, yp);
                    if (puntero.colision(amarillo) && puntero == letras_amarillas) {

                        mensaje = "Tocaste las letras amarillas con el cuadro amarillo";
                        amarillo.hacerVisible(false);
                        letras_amarillas.hacerVisible(false);
                    } else {
                        puntero.mover(xp, yp);
                        if (puntero.colision(letras_amarillas) && puntero == amarillo) {
                            mensaje = "Tocaste el cuadro amarillo con las letras amarillas";
                            amarillo.hacerVisible(false);
                            letras_amarillas.hacerVisible(false);
                        } else {
                            puntero.mover(xp, yp);
                            if (puntero.colision(morado) && puntero == letras_moradas) {

                                mensaje = "Tocaste las letras moradas con el cuadro morado";
                                morado.hacerVisible(false);

                                letras_moradas.hacerVisible(false);
                            } else {
                                puntero.mover(xp, yp);
                                if (puntero.colision(letras_moradas) && puntero == morado) {
                                    mensaje = "Tocaste el cuadro morado con las letras morado";
                                    morado.hacerVisible(false);
                                    letras_moradas.hacerVisible(false);
                                }
                            }
                            puntero.mover(xp, yp);
                            if (puntero.colision(azul) && puntero == letras_azul) {

                                mensaje = "Tocaste las letras azules con el cuadro azul";
                                azul.hacerVisible(false);
                                letras_azul.hacerVisible(false);
                            } else {
                                if (puntero.colision(letras_azul) && puntero == azul) {
                                    mensaje = "Tocaste el cuadro azul con las letras azules";
                                    azul.hacerVisible(false);
                                    letras_azul.hacerVisible(false);
                                }

                            }
                        }
                    }
                }


                break;


            case MotionEvent.ACTION_UP:
                puntero = null;
                break;

        }
        invalidate();//manda llamar a onDraw
        return true;
    }


}

