package com.example.ahorcado;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class ActividadJuego1 extends AppCompatActivity {

    private int ids_respuestas[]={
            R.id.respuesta1, R.id.respuesta2,R.id.respuesta3,R.id.respuesta4,R.id.respuesta5,R.id.respuesta6,R.id.respuesta7,
            R.id.respuesta8
    };
    private ImageView[]parts;
    private int sizeParts=7;
    private int currPart;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad_juego1);

        parts=new ImageView[sizeParts];
        parts[0]=findViewById(R.id.ahorcado1);
        parts[1]=findViewById(R.id.ahorcado2);
        parts[2]=findViewById(R.id.ahorcado3);
        parts[3]=findViewById(R.id.ahorcado4);
        parts[4]=findViewById(R.id.ahorcado5);
        parts[5]=findViewById(R.id.ahorcado6);
        parts[6]=findViewById(R.id.ahorcado7);

        currPart=0;
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Ganaste");
        builder.setMessage("Haz Salvado al pobre muchacho");
        builder.setPositiveButton("Aceptar", null);

        AlertDialog dialog = builder.create();



        TextView text_question = findViewById(R.id.text_question);
        text_question.setText(R.string.question_content);
        String[] respuestas=getResources().getStringArray(R.array.respuestas);

        for(int i=0; i<ids_respuestas.length;i++){
            RadioButton rb = findViewById(ids_respuestas[i]);
            rb.setText(respuestas[i]);
        }
        int respuesta_correcta =getResources().getInteger(R.integer.respuesta_correcta);


        RadioGroup group =findViewById(R.id.gruporespuesta);
        Button btn_check =findViewById(R.id.btn_check);


        btn_check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id = group.getCheckedRadioButtonId();
                int respuesta =-1;
                for(int i=0; i<ids_respuestas.length;i++) {
                    if (ids_respuestas[i] == id) {
                        respuesta = i;
                    }
                }
                    if(respuesta==respuesta_correcta){
                        Toast.makeText(ActividadJuego1.this, "Correcto!", Toast.LENGTH_SHORT).show();
                            dialog.show();

                    }else if(currPart<sizeParts) {
                        parts[currPart].setVisibility(View.VISIBLE);
                        currPart++;
                        Toast.makeText(ActividadJuego1.this, "Incorrecto...", Toast.LENGTH_SHORT).show();


                        }
                    }



        });



    }
    public void JugardeNuevo(View view){
    Intent intent = new Intent(this, MainActivity.class);
    startActivity(intent);
}

}