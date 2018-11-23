package com.example.kodols.visitatateur.utils;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.NumberPicker;

import com.example.kodols.visitatateur.R;
import com.example.kodols.visitatateur.ui.login.SignInFragment;

public class NumberPickerDialog extends DialogFragment {

    /**
     * If you want to get back the value, you need to implement:
     * public void onActivityResult(int requestCode, int resultCode, Intent data)
     * and use data.getExtras()
     * @param minValue Min value to set in the number picker
     * @param maxValue Max value to set in the number picker
     * @return
     */
    public static NumberPickerDialog newInstance(int minValue, int maxValue, int defaultValue) {

        NumberPickerDialog dialogFragment = new NumberPickerDialog();
        Bundle bundle = new Bundle();
        bundle.putInt("minValue", minValue);
        bundle.putInt("maxValue", maxValue);
        bundle.putInt("defaultValue", defaultValue);
        dialogFragment.setArguments(bundle);

        return dialogFragment;

    }


    // Layout part
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        // Set layout builder
        final AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.fragment_number_picker, null);

        // Get variables
        int minValue = getArguments().getInt("minValue");
        int maxValue = getArguments().getInt("maxValue");
        int defaultValue = getArguments().getInt("defaultValue");

        // Set the number picker
        final NumberPicker np = dialogView.findViewById(R.id.number_picker_selector);
        np.setMinValue(minValue);
        np.setMaxValue(maxValue);
        np.setValue(defaultValue);
        np.setWrapSelectorWheel(false);


        builder.setTitle("Pick you age")
                .setView(dialogView)
                .setPositiveButton("Ok",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int whichButton) {
                                //Do stuff when clicked
                                getTargetFragment().onActivityResult(getTargetRequestCode(),
                                        Activity.RESULT_OK,
                                        getActivity().getIntent().putExtra("age",np.getValue()));
                                dialog.dismiss();
                            }
                        }
                )
                .setNegativeButton("Cancel",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                //Do stuff when clicked
                                dialog.dismiss();
                    }
                });

        return builder.create();
    }
}
