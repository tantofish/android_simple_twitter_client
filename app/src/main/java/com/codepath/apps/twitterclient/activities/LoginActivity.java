package com.codepath.apps.twitterclient.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Toast;

import com.codepath.apps.twitterclient.R;
import com.codepath.apps.twitterclient.utils.TwitterClient;
import com.codepath.oauth.OAuthLoginActionBarActivity;


// where the user will sign in twitter
public class LoginActivity extends OAuthLoginActionBarActivity<TwitterClient> {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
        getSupportActionBar().hide();
	}


	// Inflate the menu; this adds items to the action bar if it is present.
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.login, menu);
		return true;
	}

	// OAuth authenticated successfully, launch primary authenticated activity
	// i.e Display application "homepage"
	@Override
	public void onLoginSuccess() {
        Toast.makeText(this, "oAuth Succeed", Toast.LENGTH_SHORT).show();
		Intent i = new Intent(this, TimelineActivity.class);
        finish();
		startActivity(i);
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
	}

	// OAuth authentication flow failed, handle the error
	// i.e Display an error dialog or toast
	@Override
	public void onLoginFailure(Exception e) {
        Toast.makeText(this, "oAuth Failed", Toast.LENGTH_SHORT).show();
        e.printStackTrace();
	}

	// Click handler method for the button used to start OAuth flow
	// Uses the client to initiate OAuth authorization
	// This should be tied to a button used to login
	public void loginToRest(View view) {
        getClient().connect();
	}

}
