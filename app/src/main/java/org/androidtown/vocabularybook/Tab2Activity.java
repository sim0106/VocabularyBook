package org.androidtown.vocabularybook;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created by studio on 2015-11-22.
 */
public class Tab2Activity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        TextView textView = new TextView(this);
        textView.setText("사전");

        setContentView(textView);
    }

}



