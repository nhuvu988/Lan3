package za.co.riggaroo.datecountdown.Connect;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import za.co.riggaroo.datecountdown.R;
import za.co.riggaroo.datecountdown.ui.event.add.AddEventFragment;


public class LoginActivity extends AppCompatActivity {
    EditText mTextUsername;
    EditText mTextPassword;
    Button mButtonLogin;
    TextView mTextViewRegister;
    DatabaseHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        db = new DatabaseHelper(this);
        mTextUsername = (EditText)findViewById(R.id.edittext_username);
        mTextPassword = (EditText)findViewById(R.id.edittext_password);
        mButtonLogin = (Button)findViewById(R.id.button_login);
        mTextViewRegister = (TextView)findViewById(R.id.textview_register);
        mTextViewRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent registerIntent = new Intent(LoginActivity.this,LoginActivity.class);
                startActivity(registerIntent);
            }
        });
        mButtonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = mTextUsername.getText().toString().trim();
                String pwd = mTextPassword.getText().toString().trim();
                Boolean res = db.checkUser(user, pwd);
                if(res == true)
                {
//                    Toast.makeText(LoginActivity.this,"Login thanh cong",Toast.LENGTH_SHORT).show();
                    Intent loginScreen = new Intent(LoginActivity.this, AddEventFragment.class);
                    startActivity(loginScreen);
                }
                else
                {
                    Toast.makeText(LoginActivity.this,"Login Lỗi ! Nhập Lại Tài Khoản và Mật Khẩu", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
