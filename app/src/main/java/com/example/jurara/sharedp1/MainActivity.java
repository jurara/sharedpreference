package com.example.jurara.sharedp1;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private final String NAME="NAME";
    private final String CORR="CORR";
    private final String NCC="NC";
    private EditText mEditTextName,num,corre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView textView = (TextView)findViewById(R.id.textView);
        SharedPreferences sharedPreferences = getPreferences(MODE_PRIVATE);
        String texto = sharedPreferences.getString(NAME,null);
        String correo = sharedPreferences.getString(CORR,null);
        String nc = sharedPreferences.getString(NCC,null);
        if (texto==null) {
            textView.setText("Hola Mundo");


        }
        else {textView.setText( texto +"\n"+nc+"\n"+correo);}
        mEditTextName = (EditText)findViewById(R.id.editText);
        num=(EditText)findViewById(R.id.txtNC);
        corre=(EditText)findViewById(R.id.txtC);
    }
    public void saveText(View view) {
        SharedPreferences.Editor editor = getPreferences(MODE_PRIVATE).edit();
        editor.putString(NAME, mEditTextName.getText().toString());
        editor.putString(NCC,num.getText().toString());
        editor.putString(CORR,corre.getText().toString());
        editor.commit();
        Toast.makeText(getApplicationContext(), "Datos Guardados!!!",
                Toast.LENGTH_LONG).show();
    }
}