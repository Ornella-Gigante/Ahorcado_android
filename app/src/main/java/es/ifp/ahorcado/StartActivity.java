package es.ifp.ahorcado;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.EditText;
import android.widget.TextView;

public class StartActivity extends AppCompatActivity {

    protected TextView label1;
    protected TextView label2;
    protected TextView label3;
    protected Button boton1;
    protected ImageView imagen1;
    protected EditText caja1;

    private String contenidoCaja1= "";
    private int intentos= 5; //maximo de intentos en el juego

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imagen1=(ImageView) findViewById(R.id.imagen1_start);
        caja1= (EditText) findViewById(R.id.caja1_start);
        boton1 = (Button) findViewById(R.id.boton1_start);
        label1=(TextView) findViewById(R.id.label1_start);
        label2=(TextView) findViewById(R.id.label2_start);
        label3=(TextView) findViewById(R.id.label3_start);

        label3.setText("Te quedan: " + intentos + " intentos");
        // se genera el método
        boton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                contenidoCaja1= caja1.getText().toString();

                // Se crean las reglas del juego
                if (contenidoCaja1.equalsIgnoreCase("gato")){
                    imagen1.setImageResource(R.drawable.simbolo_de_verdugo_enmascarado_ilustracion_del_vector_de_ejecucion_2dp9w05);
                    label3.setText("¡Ganaste!");
                    boton1.setEnabled(false); //si gana, ya no podrá seguir metineod palabras
                } else {
                    if (intentos > 0){
                        imagen1.setImageResource(R.drawable._7841408_dibujos_animados_verdugo);
                        intentos= intentos -1;
                        label3.setText("Te quedan " + intentos + " intentos");
                        // label3.setText("Intenta de nuevo");
                    } else  if (intentos== 2){
                        imagen1.setImageResource(R.drawable.ic_action_accessibility);
                        intentos= intentos -1;
                        label3.setText("Te quedan " + intentos + " intentos");

                    } else  if (intentos== 1){
                        imagen1.setImageResource(R.drawable._7841408_dibujos_animados_verdugo);
                        intentos= intentos -1;
                        label3.setText("Te quedan " + intentos + " intentos");

                    } else {
                        imagen1.setImageResource(R.drawable.ahorcado);
                        label3.setText("No lo has conseguido");
                        boton1.setEnabled(false);
                    }
                }
            }
        });
    }
}