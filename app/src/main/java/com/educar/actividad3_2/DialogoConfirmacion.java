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
public class DialogoConfirmacion extends DialogFragment {

    public interface ConfirmacionListener{

        //se definen los metodos del interface
        public void okSelectClick();
        public void cancelSelectClick();

    }

    ConfirmacionListener mListener;


    // Override the Fragment.onAttach() method to instantiate the SelectDialogListener
    @Override
    public void onAttach (Activity activity) {
        super.onAttach(activity);
        // Verify that the host activity implements the callback interface
        try {
            // Instantiate the SelectDialogListener so we can send events to the host
            mListener = (ConfirmacionListener) activity;
        } catch (ClassCastException e) {
            // The activity doesn't implement the interface, throw exception
            throw new ClassCastException(activity.toString()
                    + " must implement SelectDialogListener");
        }
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder builder =
                new AlertDialog.Builder(getActivity());

        builder.setMessage("Deseas usar esta foto para la identificación ?")
                .setTitle("Confirmación")
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Log.i("Dialogos", "Confirmacion Aceptada.");
                        mListener.okSelectClick();
                        dialog.cancel();
                    }
                })
                .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Log.i("Dialogos", "Confirmacion Cancelada.");
                        mListener.cancelSelectClick();
                        dialog.cancel();
                    }
                });



        return builder.create();
    }
}
