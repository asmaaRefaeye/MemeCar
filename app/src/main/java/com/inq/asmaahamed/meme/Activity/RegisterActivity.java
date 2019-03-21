package com.inq.eslamwael74.meme.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.inq.eslamwael74.meme.R;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by Omar on 1/31/2018.
 */

public class RegisterActivity extends AppCompatActivity {

    EditText edittextRegisterName;
    TextView textViewRegisterName;
    TextView textViewRegisterEmail;
    EditText editTextRegisterEmail;
    TextView textViewRegisterPass;
    TextView textViewSuccess;
    EditText editTextRegisterPass;
    Button Registerlog ;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_activity);

        iniate();
    }

    public  void iniate() {
        Registerlog = findViewById(R.id.btn_Registerlogin);
        textViewSuccess=findViewById(R.id.en_regsucss_txt);
        editTextRegisterPass=findViewById(R.id.en_regpass_edittext);
        textViewRegisterPass=findViewById(R.id.en_regpass_txt);
        editTextRegisterEmail=findViewById(R.id.en_regmail_edtxt);
        textViewRegisterEmail=findViewById(R.id.en_regmailtxt);
        edittextRegisterName=findViewById(R.id.en_regname_edittext);
        textViewRegisterName=findViewById(R.id.en_regname_txt);

        Registerlog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("register","called button");
                if (!validatationemail(editTextRegisterEmail.getText().toString())) {
                    editTextRegisterEmail.setError(" Email Invalid");
                   //// editTextRegisterEmail.requestFocus();

                } else if (!validatationname(edittextRegisterName.getText().toString())) {
                    edittextRegisterName.setError("Name Invalid");
                   // edittextRegisterName.requestFocus();

                } else if (!validatationpassword(editTextRegisterPass.getText().toString())) {
                    editTextRegisterPass.setError("password Invalid");
                   // editTextRegisterPass.requestFocus();
                } else {
                    Intent RegIntent = new Intent(RegisterActivity.this, LoginActivity.class);
                    startActivity(RegIntent);

                }

            }


        });
    }


        private boolean validatationemail(String email) {

            String regExpn =
                    "^(([\\w-]+\\.)+[\\w-]+|([a-zA-Z]{1}|[\\w-]{2,}))@"
                            +"((([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
                            +"[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\."
                            +"([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
                            +"[0-9]{1,2}|25[0-5]|2[0-4][0-9])){1}|"
                            +"([a-zA-Z]+[\\w-]+\\.)+[a-zA-Z]{2,4})$";

            CharSequence inputStr = email;

            Pattern pattern = Pattern.compile(regExpn,Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(inputStr);

            if(matcher.matches())
                return true;
            else
                return false;

        }


    private boolean validatationname(String name) {
        if (name != null && name.length()>15){
            return true;
        }else
            return false;
    }



    private boolean validatationpassword(String password) {

        if (password != null && password.length()>=9) {
            return true;
        }else {

        return false;
    }

    }



}



    
    
    
    
    
      /* private boolean validatation() {
        if (edittextRegisterName.getText().toString().length() >= 10) {
            edittextRegisterName.setError("Please enter youname ");
            edittextRegisterName.requestFocus();
        }

        else if (editTextRegisterEmail.getText().toString().length() >= 20) {
            editTextRegisterEmail.setError("Please enter correctemail ");
            editTextRegisterEmail.requestFocus();

        }


       else if (editTextRegisterPass.getText().toString().length() >= 8) {

            editTextRegisterPass.setError("please enter correctpassword");
            editTextRegisterPass.requestFocus();
        }
        return false;
    }*/






