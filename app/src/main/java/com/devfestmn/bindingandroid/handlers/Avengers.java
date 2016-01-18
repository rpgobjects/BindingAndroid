package com.devfestmn.bindingandroid.handlers;

import android.support.design.widget.Snackbar;
import android.view.View;

/**
 * Created by chris on 1/11/16.
 */
public class Avengers {

    public void assemble(View view) {
        Snackbar.make(view,"Assemble!",Snackbar.LENGTH_LONG).show();
    }

    public void notMember(View view) {
        Snackbar.make(view,"You're not an Avenger!",Snackbar.LENGTH_LONG).show();
    }
}
