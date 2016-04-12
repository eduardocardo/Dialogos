package com.educar.actividad3_2;

import android.app.AlertDialog;
import android.app.Dialog;
import android.support.v4.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;

/**
 * Created by Alumno on 20/01/2016.
 */
public class DialogoAlerta extends DialogFragment {

    public static DialogoAlerta newInstance(String msj)
    {
        DialogoAlerta frag = new DialogoAlerta();
        Bundle bundle = new Bundle();

        bundle.putString("mensaje",msj);
        frag.setArguments(bundle);
        return  frag;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder builder =
                new AlertDialog.Builder(getActivity());

        String mensaje = getArguments().getString("mensaje");

        builder.setMessage(mensaje)
                .setTitle("Error")
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        //dialog el dialogo clickado
                        // id es el id del botón tecleado
                        dialog.cancel();
                    }
                });

        return builder.create();
    }


}
