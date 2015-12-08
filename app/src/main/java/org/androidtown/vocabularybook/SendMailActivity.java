package org.androidtown.vocabularybook;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by studio on 2015-12-06.
 */
public class SendMailActivity extends Dialog {
    private EditText mailTitle, mail;
    private Button sendOk, sendCancel;
    private String _mailTitle, _mail;

    public SendMailActivity(Context context){
        super(context);
        this.setCancelable(true);
        this.setCanceledOnTouchOutside(false);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sendemail);

        mailTitle=(EditText)findViewById(R.id.mailtitle);
        mail=(EditText)findViewById(R.id.email);

        sendOk=(Button)findViewById(R.id.sendOk);
        sendCancel=(Button)findViewById(R.id.sendCancel);

        sendOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                _mailTitle=mailTitle.getText().toString();
                _mail=mail.getText().toString();

                mailTitle.setText("");
                mail.setText("");
                dismiss();
            }
        });

    }

    public String getMailTitle(){return _mailTitle;}
    public String getMail(){return _mail;}
}
