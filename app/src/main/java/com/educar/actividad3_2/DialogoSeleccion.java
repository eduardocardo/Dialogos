package com.educar.actividad3_2;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.support.v4.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;

/**
 * Created by Alumno on 20/01/2016.
 */
public class DialogoSeleccion extends DialogFragment {


    public interface SelectDialogListener{
        public void onDialogSelecClick(DialogFragment dialog, int item);
    }


    SelectDialogListener mListener;



    @Override
    public void onAttach (Activity activity) {
        super.onAttach(activity);
        // Verify that the host activity implements the callback interface
        try {
            // Instantiate the SelectDialogListener so we can send events to the host
            mListener = (SelectDialogListener) activity;
        } catch (ClassCastException e) {
            // The activity doesn't implement the interface, throw exception
            throw new ClassCastException(activity.toString()
                    + " must implement SelectDialogListener");
        }
    }


    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {


        final String[] itemsR = getActivity().getResources().getStringArray(R.array.colores);
        AlertDialog.Builder builder =
                new AlertDialog.Builder(getActivity());

        builder.setTitle("Elige color")
               /* .setItems(itemsR, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int item) {
                        Log.i("Dialogos", "Opción elegida: " + itemsR[item]);
                        *//**
                         * Añadimos el método asociado al evento selección, donde le pasamos todos los datos que deseamos
                         *//*
                        mListener.onDialogSelecClick(DialogoSeleccion.this, item);
                    }
                });*/
                .setSingleChoiceItems(itemsR, -1,
       		   new DialogInterface.OnClickListener() {
	    	    public void onClick(DialogInterface dialog, int item) {
	    	        Log.i("Dialogos", "Opción elegida: " + itemsR[item]);
                    mListener.onDialogSelecClick(DialogoSeleccion.this, item);
                    dialog.cancel();
	    	    }
               });


        return builder.create();
    }
}
