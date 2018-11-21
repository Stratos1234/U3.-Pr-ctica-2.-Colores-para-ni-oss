package mx.edu.ittepic.dadm_u3_ejercio5;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Principal extends AppCompatActivity {

    Button star, play ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        star=findViewById(R.id.inicio);
        play=findViewById(R.id.play);

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent otraVentana = new Intent(Principal.this, Principal2.class);
                startActivityForResult(otraVentana, 1);
               // setContentView(new Lienzo(Principal.this));
            }
        });
        star.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent otraVentana = new Intent(Principal.this, Principal3.class);
                startActivityForResult(otraVentana, 1);
            }
        });


    }
}
