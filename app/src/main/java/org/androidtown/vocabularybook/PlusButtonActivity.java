package org.androidtown.vocabularybook;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by studio on 2015-11-22.
 */
public class PlusButtonActivity extends Dialog {
    private EditText wordName, wordMean;
    private Button addOk, addCancel;
    private String _wordName, _wordMean;


    public PlusButtonActivity(Context context){
        super(context);
        this.setCanceledOnTouchOutside(false);
        this.setCancelable(true);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.plusbutton);

        wordName=(EditText)findViewById(R.id.word);
        wordMean=(EditText)findViewById(R.id.meaning);

        addOk=(Button)findViewById(R.id.addOk);
        addCancel=(Button)findViewById(R.id.addCancel);


        addOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                _wordName = wordName.getText().toString();
                _wordMean = wordMean.getText().toString();

                wordName.setText("");
                wordMean.setText("");

                dismiss();

            }
        });

    }
    public String getWordName(){
        return _wordName;
    }

    public String getWordMean(){
        return _wordMean;
    }

    public boolean onClick(View v, MotionEvent event){
        if(v==addCancel)
            cancel();
        return false;
    }


}
