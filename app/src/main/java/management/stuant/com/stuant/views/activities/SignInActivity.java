package management.stuant.com.stuant.views.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import management.stuant.com.stuant.HomeActivity;
import management.stuant.com.stuant.R;
import management.stuant.com.stuant.components.SlidingHeaderContainer;

public class SignInActivity extends AppCompatActivity implements View.OnClickListener {

    TextView title;
    Button login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        title = (TextView) findViewById(R.id.title);
        login = findViewById(R.id.primary_btn);
        title.setText(getString(R.string.welcom_message_sign_in));

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent inte = new Intent(SignInActivity.this, HomeActivity.class);
                startActivity(inte);
            }
        });
    }

    @Override
    public void onClick(View view) {

    }
}
