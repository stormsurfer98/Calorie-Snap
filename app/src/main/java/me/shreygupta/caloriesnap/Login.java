package me.shreygupta.caloriesnap;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.parse.LogInCallback;
import com.parse.Parse;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

public class Login extends Activity {
    private Button button01;
    private Button button02;
    private EditText editText01;
    private EditText editText02;
    private EditText editText03;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Parse.initialize(this, "0gAkNOUna8vIraB2SRjL5sxHbsvsRcNgBK8rENyv", "8fETUTRfgcmw47IxYQBcOMzU3WaKDe3yZn2UvcUx");
        button01 = (Button)findViewById(R.id.buttonSignup);
        button02 = (Button)findViewById(R.id.buttonSubmit);
        editText01 = (EditText)findViewById(R.id.usernameText);
        editText02 = (EditText)findViewById(R.id.passwordText);
        editText03 = (EditText)findViewById(R.id.emailText);
        button01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ParseUser user = new ParseUser();
                user.setUsername(editText01.getText().toString());
                user.setPassword(editText02.getText().toString());
                user.setEmail(editText03.getText().toString());

                user.signUpInBackground(new SignUpCallback() {
                    public void done(com.parse.ParseException e) {
                        if (e == null) {
                            editText01.setText("");
                            editText02.setText("");
                            editText03.setText("");
                        } else {
                            //Do something
                        }
                    }
                });
            }
        });
        button02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ParseUser user = new ParseUser();
                user.setUsername(editText01.getText().toString());
                user.setPassword(editText02.getText().toString());
                user.setEmail(editText03.getText().toString());

                ParseUser.logInInBackground(editText01.getText().toString(), editText02.getText().toString(), new LogInCallback() {
                    public void done(ParseUser user, com.parse.ParseException e) {
                        if (e == null) {
                            editText01.setText("");
                            editText02.setText("");
                            editText03.setText("");
                        } else {
                            //Do something
                        }
                    }
                });
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.login, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
