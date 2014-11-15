package com.airpool.Fragment;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;

import com.airpool.Model.TransportationPreference;
import com.airpool.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Maury on 11/14/14.
 */
public class PreferencePickerFragment extends DialogFragment {
    OnPreferencePickedListener callback;
    ArrayList<TransportationPreference> selectedPreferences = new ArrayList<TransportationPreference>();
    List<String> preferences;
    boolean[] preferencesBoolean;

    public int noPreferenceWhich = 0;

    public interface OnPreferencePickedListener {
        public void onPreferencePicked(int which, boolean isChecked);
    }

    public PreferencePickerFragment() {
        preferences = new ArrayList<String>();
        preferencesBoolean = new boolean[TransportationPreference.values().length];

        int i = 0;
        for (TransportationPreference preference : TransportationPreference.values()) {
            if (preference == TransportationPreference.NOPREF) {
                noPreferenceWhich = i;
                preferencesBoolean[i] = true;
            } else {
                preferencesBoolean[i] = false;
            }
            preferences.add(preference.toString());
            i++;
        }
    }


    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        try {
            callback = (OnPreferencePickedListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnPreferencePickedListener");
        }
    }

    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Build a new dialog.
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        // Select the Title
        builder = builder.setTitle(R.string.select_transportation_preferences);

        int i = 0;
        for (TransportationPreference preference : TransportationPreference.values()) {
            preferencesBoolean[i++] = selectedPreferences.contains(preference);
        }

        builder = builder.setMultiChoiceItems(preferences.toArray(new CharSequence[preferences.size()]),
                preferencesBoolean,
                new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                        if (which == noPreferenceWhich && isChecked) {
                            int i = 0;
                            while (i < preferencesBoolean.length) {
                                if (i != noPreferenceWhich) {
                                    preferencesBoolean[i] = false;
                                    ((AlertDialog) dialog).getListView().setItemChecked(i, false);
                                } else {
                                    preferencesBoolean[noPreferenceWhich] = true;
                                    ((AlertDialog) dialog).getListView().setItemChecked(noPreferenceWhich, true);
                                }

                                i++;
                            }
                        } else {
                            preferencesBoolean[noPreferenceWhich] = false;
                            ((AlertDialog) dialog).getListView().setItemChecked(noPreferenceWhich, false);
                        }

                        callback.onPreferencePicked(which, isChecked);
                    }
                });

        builder = builder.setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });

        builder = builder.setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });

        return builder.create();
    }

    public void updateSelectedTransportationPreferences(ArrayList<TransportationPreference> selectedPreferences) {
        this.selectedPreferences = selectedPreferences;
    }

    public int getNoPreferenceWhich() {
        return noPreferenceWhich;
    }
}
