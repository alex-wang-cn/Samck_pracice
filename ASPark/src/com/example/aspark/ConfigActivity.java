package com.example.aspark;

import com.example.service.IResult;
import com.example.service.XmppManager;

import android.app.Activity;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class ConfigActivity extends Activity {
	private EditText editText;
	private Button button;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.site_config);
		editText = (EditText) findViewById(R.id.hostText);
		button = (Button) findViewById(R.id.ensuerButton);
		button.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				String host = editText.getText().toString();
				try {
					XmppManager.getInstance().connect(host, new IResult.Stub() {
						@Override
						public void result(boolean is) throws RemoteException {

						}
					});
				} catch (RemoteException e) {
					e.printStackTrace();
				}
			}
		});
	}

}
