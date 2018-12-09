package com.briansia.interfaces;

import android.view.MenuItem;

/**
 * Created by asifiqbal on 2015-04-26.
 *
 * Fragment that contains an Alert Dialog. Abstract methods to be instantiated by MainActivity
 * and MoreInformationDialog.
 */
public interface FragmentAlertDialog {
    void showDialog ( MenuItem item );
    void doPositiveClick();
    void doNegativeClick();
}