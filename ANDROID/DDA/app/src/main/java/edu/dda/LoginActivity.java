package edu.dda;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import edu.dda.nw.ChatClient;
import edu.dda.nw.DDAClient;
import edu.dda.utils.ServerCheck;
import edu.dda.utils.Variables;

public class LoginActivity extends AppCompatActivity {
    EditText emailET, passwdET;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        emailET = (EditText) findViewById(R.id.email);
        passwdET = (EditText) findViewById(R.id.passwd);
    }

    public void login(View view) {
        try {
            boolean serverfound = ServerCheck.isServerFound(Variables.DDAServerIp, Variables.DDAServerPort);
            if (serverfound) {
                String email = emailET.getText().toString();
                String passwd = passwdET.getText().toString();
                if ("".equals(email)) {
                    emailET.setError("ENTER EMAIL");
                } else if ("".equals(passwd)) {
                    passwdET.setError("ENTER PASSWORD");
                } else {
                    int empId = DDAClient.empLogin(email, passwd);
                    if (empId != 0) {
                        Variables.sessionId = empId;
                        Variables.sessionEmail = email;
                        ChatClient client = new ChatClient(Variables.sessionEmail);
                        Variables.chatClient = client;
                        Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                        startActivity(intent);
                        finish();
                    } else {
                        Toast.makeText(LoginActivity.this, "Failed", Toast.LENGTH_SHORT).show();
                    }
                }


            } else {
                Toast.makeText(LoginActivity.this, "SERVER NOT FOUND!!!", Toast.LENGTH_SHORT).show();
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void reset(View view) {
        emailET.setText(null);
        passwdET.setText(null);

    }
}
