package com.firstdata.firstapi.googlepaysampleapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Displays the Json response from the First Data servers and allows the user to quit
 * the application.
 */
public class ResponseActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_response);
        String message = getIntent().getStringExtra(Constants.EXTRA_RESULT_MESSAGE);

        TextView mTextMessage = findViewById(R.id.response_message);
        Button mQuitButton = findViewById(R.id.quit_button);

        mQuitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = CheckoutActivity.newIntent(getApplicationContext(), true);
                startActivity(intent);
            }
        });
        mTextMessage.setText(message);
    }

    public static Intent newIntent(Activity activity, String status, String message) {
        Intent intent = new Intent(activity, ResponseActivity.class);
        intent.putExtra(Constants.EXTRA_RESULT_STATUS, status);
        intent.putExtra(Constants.EXTRA_RESULT_MESSAGE, message);
        return intent;
    }


}
