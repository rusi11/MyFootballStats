package rusi.myfootballstats;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EditUserActivity extends AppCompatActivity {

    Button accept;
    Button cancell;
    EditText editName;
    EditText editSurname;
    EditText editAlias;
    EditText editFavNumber;
    EditText editPeso;
    EditText editAltura;

    protected void init(){
        accept = (Button) findViewById(R.id.acceptButton);
        cancell = (Button) findViewById(R.id.cancellButton);
        editName = (EditText) findViewById(R.id.inputName);
        editSurname = (EditText) findViewById(R.id.inputSurname);
        editAlias = (EditText) findViewById(R.id.inputAlias);
        editFavNumber = (EditText) findViewById(R.id.inputFavNumber);
        editPeso = (EditText) findViewById(R.id.inputPeso);
        editAltura = (EditText) findViewById(R.id.inputAltura);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_user);

        init();


        accept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), UserActivity.class);
                i.putExtra("nombre",editName.getText().toString());
                i.putExtra("apellidos", editSurname.getText().toString());
                i.putExtra("apodo", editAlias.getText().toString());
                i.putExtra("dorsal",editFavNumber.getText().toString());
                i.putExtra("peso", editPeso.getText().toString());
                i.putExtra("altura", editAltura.getText().toString());



                startActivity(i);
                finish();
            }
        });

        cancell.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), UserActivity.class);
                startActivity(i);
                finish();
            }
        });
    }
}
