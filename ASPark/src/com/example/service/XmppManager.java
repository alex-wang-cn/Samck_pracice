package com.example.service;

import com.example.aspark.SparkApplication;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.widget.Toast;

public class XmppManager {
	private static XmppManager INSTANCE;
	private IXmppManager mManager;
	private ServiceConnection mServiceConnection;
	private Context mContext;
	private IReceiveMessage mReceiveMessage;

	private XmppManager() {
		mContext = SparkApplication.getContext();
		Intent service = new Intent(mContext, AscmacService.class);
		mContext.bindService(service, mServiceConnection,
				Context.BIND_AUTO_CREATE);
		mReceiveMessage = new IReceiveMessage.Stub() {
			@Override
			public void receiveMessage(String message) throws RemoteException {
				Toast.makeText(mContext, message, Toast.LENGTH_LONG).show();
			}
		};
		mServiceConnection = new ServiceConnection() {
			@Override
			public void onServiceDisconnected(ComponentName name) {
				mManager = null;
			}

			@Override
			public void onServiceConnected(ComponentName name, IBinder service) {
				mManager = IXmppManager.Stub.asInterface(service);
				try {
					mManager.registerReciveLisner(mReceiveMessage);
				} catch (RemoteException e) {
					e.printStackTrace();
				}
			}
		};
	}

	public static XmppManager getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new XmppManager();
		}
		return INSTANCE;
	}

	public void login(String name, String passWord, IResult result)
			throws RemoteException {
		mManager.login(name, passWord, result);
	}

	public void connect(String host, IResult result) throws RemoteException {
		mManager.connect(host, result);
	}

	public void sendMessage(String message, int to, IResult result)
			throws RemoteException {
		mManager.sendMessage(to, message, result);
	}

}
