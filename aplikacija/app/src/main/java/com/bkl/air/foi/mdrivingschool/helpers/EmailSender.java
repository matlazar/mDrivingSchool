package com.bkl.air.foi.mdrivingschool.helpers;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

/**
 * Created by Dalibor on 11.11.2016..
 */

public class EmailSender{
    /**posaljiMail metoda je zadužena za slanje e-maila autoškoli sa naslovom i porukom koje joj se proslijede
     *
     * @param poruka - prosljedena poruka
     * @param naslov - prosljedjen naslov
     * @param mActivity - prosljeden activity kako bi se znao context (zbog startActivity-a i Toasta)
     */
    public void posaljiMail(String poruka, String naslov, Activity mActivity){
        Intent i = new Intent(Intent.ACTION_SEND);
        i.setType("message/rfc822");
        i.putExtra(Intent.EXTRA_EMAIL, new String[]{"dadolg22@gmail.com"});
        i.putExtra(Intent.EXTRA_SUBJECT, naslov);
        i.putExtra(Intent.EXTRA_TEXT, poruka);
        i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        try {
            mActivity.startActivity(Intent.createChooser(i, "Mail se šalje..."));
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(mActivity, "Nažalost, nije pronađen e-mail client na vašem uređaju.", Toast.LENGTH_LONG).show();
        }
    }

}