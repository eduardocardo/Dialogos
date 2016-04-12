package com.educar.actividad3_2;



import android.content.res.TypedArray;
import android.graphics.Color;
import android.os.Bundle;


import android.support.v4.app.DialogFragment;


import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends FragmentActivity implements DialogoConfirmacion.ConfirmacionListener,
        DialogoSeleccion.SelectDialogListener,DialogoPersonalizado.PasswordListener {

    private EditText name;
    private EditText age;
    private Button aceptar;
    private Button datos;
    private Button color;
    private Button pass;
    private TextView resultName;
    private TextView resultAge;
    private LinearLayout layout;
    private static final String contraseña = "1234";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        name =(EditText)findViewById(R.id.et_nombre);
        age =(EditText)findViewById(R.id.et_edad);
        aceptar =(Button)findViewById(R.id.bt_aceptar);
        datos =(Button)findViewById(R.id.bt_datos);
        color =(Button)findViewById(R.id.bt_color);
        pass =(Button)findViewById(R.id.bt_pass);
        resultName =(TextView)findViewById(R.id.tv_resultName);
        resultAge =(TextView)findViewById(R.id.tv_resultAge);
        layout =(LinearLayout)findViewById(R.id.layout_result);

        aceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String msj;
                if(name.getText().length() > 0 && !name.getText().toString().isEmpty()) //hay datos en el nombre
                {
                    if(age.getText().length() > 0 && !age.getText().toString().isEmpty()) //hay datos en la edad
                    {
                        resultName.setText(name.getText().toString());
                        resultAge.setText(age.getText().toString());
                    }
                    else //no hay datos en la edad
                    {
                        FragmentManager fragmentManager = getSupportFragmentManager();
                        DialogoAlerta dialogo = DialogoAlerta.newInstance(getResources().getString(R.string.msjNoEdad));
                        dialogo.show(fragmentManager,"tagAlerta");
                    }
                }
                else //no hay datos en el nombre
                {

                    if(age.getText().length() > 0 && !age.getText().toString().isEmpty()) //hay datos en la edad
                    {
                         FragmentManager fragmentManager = getSupportFragmentManager();
                        DialogoAlerta dialogo = DialogoAlerta.newInstance(getResources().getString(R.string.msjNoNombre));
                        dialogo.show(fragmentManager,"tagAlerta");
                    }
                    else //no hay datos en la edad
                    {
                        FragmentManager fragmentManager = getSupportFragmentManager();
                        DialogoAlerta dialogo = DialogoAlerta.newInstance(getResources().getString(R.string.msjNoEdadNombre));
                        dialogo.show(fragmentManager,"tagAlerta");
                    }
                }

            }
        });

        datos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //primero se elimina el texto existente
                resultName.setText("");
                resultAge.setText("");
                FragmentManager fragmentManager = getSupportFragmentManager();
                DialogoConfirmacion dialogo = new DialogoConfirmacion();
                dialogo.show(fragmentManager, "tagConfirmacion");


            }
        });


        color.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getSupportFragmentManager();
                DialogoSeleccion  dialogo = new DialogoSeleccion();
                dialogo.show(fragmentManager, "tagSeleccion");
            }
        });

        pass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getSupportFragmentManager();
                DialogoPersonalizado  dialogo = new DialogoPersonalizado();
                dialogo.show(fragmentManager, "tagPersonalizado");
            }
        });
    }

    @Override
    public void okSelectClick() {
        if(name.getText().length() > 0 && !name.getText().toString().isEmpty()) //hay datos en el nombre
        {
            if (age.getText().length() > 0 && !age.getText().toString().isEmpty()) //hay datos en la edad
            {
                resultName.setText(name.getText().toString());
                resultAge.setText(age.getText().toString());
            }
        }
        else{
             resultName.setText("No hay datos que mostrar");
        }

    }

    @Override
    public void cancelSelectClick() {

    }



    @Override
    public void okClick(String p) {
         if(contraseña.equals(p))
         {
             resultName.setText(R.string.msjPassAcertada);
         }
        else {
             String error = getResources().getString(R.string.msjPassNoAcertada) + contraseña;
             resultName.setText(error);
         }
    }

    @Override
    public void onDialogSelecClick(DialogFragment dialog, int item) {
        TypedArray colors = getResources().obtainTypedArray(R.array.colors);

        layout.setBackgroundColor(colors.getColor(item,0));

    }
}
