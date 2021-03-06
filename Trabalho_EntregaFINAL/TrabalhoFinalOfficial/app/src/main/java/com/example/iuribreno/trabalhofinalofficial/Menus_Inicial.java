package com.example.iuribreno.trabalhofinalofficial;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.iuribreno.trabalhofinalofficial.ENTIDADES.Usuario;
import com.example.iuribreno.trabalhofinalofficial.service.UsuarioService;
import com.google.firebase.FirebaseError;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Menus_Inicial extends AppCompatActivity {
    private Button buttonVisPerfil;
    private Button buttonMarcConsulta;
    private Button buttonVisConsultasMarcadas;
    private Button buttonlogout;
    private Button buttonDuvidasApp;
    private UsuarioService usuarioService = new UsuarioService();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menus__inicial);
        buttonlogout =  (Button) findViewById(R.id.efetuarLogoutuUser);
        buttonVisPerfil = (Button) findViewById(R.id.buttonVisPerfil);
        buttonMarcConsulta = (Button) findViewById(R.id.buttonMarcConsulta);
        buttonVisConsultasMarcadas = (Button) findViewById(R.id.buttonVisConsultasMarcadas);

        buttonDuvidasApp = (Button) findViewById(R.id.buttonDuvidasApp);



        //AQUI
        usuarioService.getCurrentUser();


        buttonVisPerfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abrirTelaPerfil();
            }
        });

        buttonMarcConsulta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abrirTelaMarcConsulta();
            }
        });

        buttonVisConsultasMarcadas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abrirTelaConsultasMarcadas();
            }
        });


        buttonlogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abrirLogout();
            }
        });

        buttonDuvidasApp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               abrirTelaDuvidasApp();
            }
        });




    }

    private void collectUsers(Map<String,Object> users) {

        ArrayList<Long> emails = new ArrayList<>();

        //iterate through each user, ignoring their UID
        for (Map.Entry<String, Object> entry : users.entrySet()){
            Map singleUser = (Map) entry.getValue();
            emails.add((Long) singleUser.get("email"));
        }

        System.out.println(emails.toString());
    }
    public void abrirTelaMarcConsulta() {
        Intent abrirmarcarConsulta = new Intent(this, MarcarConsulta.class);
        startActivity(abrirmarcarConsulta);
    }

    public void abrirTelaPerfil(){
        Intent abrirTelaPerfil = new Intent(this,Perfil.class);
        startActivity(abrirTelaPerfil);

    }
    public void abrirTelaConsultasMarcadas(){
        Intent abrirTelaConsultasMarcadas = new Intent(this,ConsultasMarcadas.class);
        startActivity(abrirTelaConsultasMarcadas);

    }

    public void abrirTelaVisTodasConsultas(){
        Intent abrirTelaVisTodasConsultas = new Intent(this,TodasConsultas.class);
        startActivity(abrirTelaVisTodasConsultas);

    }

    public void abrirTelaDuvidasApp(){
        Intent abrirTelaDuvidasApp = new Intent(this,DuvidasApp.class);
        startActivity(abrirTelaDuvidasApp);

    }

    public void abrirLogout(){
        Intent abrirTelaDuvidasApp = new Intent(this,MainActivity.class);
        startActivity(abrirTelaDuvidasApp);
        finish();

    }


}