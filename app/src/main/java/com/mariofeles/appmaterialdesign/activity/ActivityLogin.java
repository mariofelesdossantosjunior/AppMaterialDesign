package com.mariofeles.appmaterialdesign.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import com.mariofeles.appmaterialdesign.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Mario Feles dos Santos Junior on 10/09/15.
 */
public class ActivityLogin extends Activity {

    @Bind(R.id.etUser)
    EditText etUser;
    @Bind(R.id.etSenha)
    EditText etSenha;
    @Bind(R.id.btLogin)
    AppCompatButton btLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
    }


    @OnClick(R.id.btLogin)
    public void clickLogin(){
        login();
    }

    private void login() {
        Log.i("mario", "USER: " + etUser.getText());
        Log.i("mario", "SENHA: " + etSenha.getText());
        if(etUser.getText().toString().equals("testeUser") && etSenha.getText().toString().equals("123456")){
            Intent i = new Intent(ActivityLogin.this,MainActivity.class);
            startActivity(i);
            finish();
        }else{
            Toast.makeText(this, "Login Invalido", Toast.LENGTH_LONG).show();
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_login, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

