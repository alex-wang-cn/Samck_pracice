package com.example.aspark;

import com.example.service.IResult;
import com.example.service.XmppManager;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends Activity {
	private EditText etName;
	private EditText etPass;
	private Button btLogin;
	private Button btConfig;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login_main);
		etName = (EditText) findViewById(R.id.etName);
		etPass = (EditText) findViewById(R.id.etPass);
		btLogin = (Button) findViewById(R.id.btLogin);
		btLogin.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				try {
					XmppManager.getInstance().login(
							etName.getText().toString(),
							etPass.getText().toString(), new IResult.Stub() {

								@Override
								public void result(boolean is)
										throws RemoteException {
								}
							});
				} catch (RemoteException e) {
					e.printStackTrace();
				}
			}
		});
		btConfig = (Button) findViewById(R.id.btConfig);
		btConfig.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				startActivity(new Intent(LoginActivity.this,
						ConfigActivity.class));
			}
		});
	}

}
