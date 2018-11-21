package mx.edu.ittepic.dadm_u3_ejercio5;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Principal3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new Lienzo2(this));
    }
}
