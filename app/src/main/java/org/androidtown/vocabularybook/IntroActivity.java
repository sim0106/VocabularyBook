package org.androidtown.vocabularybook;

import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

/**
 * Created by studio on 2015-12-05.
 */
public class IntroActivity extends Activity {
    TextView introWord = null;
   @Override
    protected void onCreate(Bundle savedInstanceState){
       super.onCreate(savedInstanceState);
       setContentView(R.layout.intro);
       introWord = (TextView)findViewById(R.id.intro);
       introWord.setTypeface(Typeface.createFromAsset(getAssets(),"Surfing Capital.ttf"));
       introWord.setText("Vocabulary\n       Book");
       new Handler().postDelayed(new Runnable() {
           @Override
           public void run() {
               finish();
           }
       },3000);
   }
}
