package com.briansia.dialogs;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;

import com.briansia.modernartui.R;
import com.briansia.interfaces.FragmentAlertDialog;

/*
*  Class to be called by MainActivity when user clicks on the three dots menu on the top right.
*  Creates an alert dialog builder from the calling activity, and then sets the
*  FragmentAlertDialog abstract methods to the ones implemented in MainActivity.
 */
public class MoreInformationDialog extends DialogFragment {

    @Override
    public Dialog onCreateDialog ( Bundle savedInstanceState ) {

        AlertDialog.Builder builder = new AlertDialog.Builder( getActivity() );

        builder.setMessage( R.string.dialog_text );

        builder.setPositiveButton( R.string.dialog_visit,
                new DialogInterface.OnClickListener() {

                    public void onClick ( DialogInterface dialog, int id ) {
                        ((FragmentAlertDialog)getActivity()).doPositiveClick();
                    }
        } );

        builder.setNegativeButton( R.string.dialog_not_now,
                new DialogInterface.OnClickListener() {

                    public void onClick ( DialogInterface dialog, int id ) {
                        ((FragmentAlertDialog)getActivity()).doNegativeClick();
                    }
        });

        return builder.create();
    }
}