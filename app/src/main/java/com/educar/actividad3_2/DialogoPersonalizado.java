package com.educar.actividad3_2;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.support.v4.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

/**
 * Created by Eduardo on 20/01/2016.
 */
public class DialogoPersonalizado extends DialogFragment {

    public interface PasswordListener{
        public void okClick(String pass);
    }

    PasswordListener mListener;

    @Override
    public void onAttach (Activity activity) {
        super.onAttach(activity);
        // Verify that the host activity implements the callback interface
        try {
            // Instantiate the SelectDialogListener so we can send events to the host
            mListener = (PasswordListener) activity;
        } catch (ClassCastException e) {
            // The activity doesn't implement the interface, throw exception
            throw new ClassCastException(activity.toString()
                    + " must implement SelectDialogListener");
        }
    }



    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        final AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        final View view =inflater.inflate(R.layout.personalizado, null);

        builder.setView(view)
                .setTitle("Introduce contraseña")
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                    EditText editText =(EditText)view.findViewById(R.id.et_password);
                        mListener.okClick(editText.getText().toString());
                        dialog.cancel();
                    }
                });

        return builder.create();
    }
}
