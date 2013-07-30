package com.example.service;

import java.io.File;

import org.jivesoftware.smack.Chat;
import org.jivesoftware.smack.ChatManager;
import org.jivesoftware.smack.ChatManagerListener;
import org.jivesoftware.smack.ConnectionConfiguration;
import org.jivesoftware.smack.ConnectionListener;
import org.jivesoftware.smack.MessageListener;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.ConnectionConfiguration.SecurityMode;
import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smack.provider.ProviderManager;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import android.widget.Toast;

public class AscmacService extends Service {
	private XMPPConnection connection;
	private IReceiveMessage receiveMessageLinser;
	private IXmppManager.Stub mBinber = new IXmppManager.Stub() {

		@Override
		public void sendMessage(int userId, String message, IResult result)
				throws RemoteException {

		}

		@Override
		public void registerReciveLisner(IReceiveMessage linser)
				throws RemoteException {
			receiveMessageLinser = linser;
		}

		@Override
		public void login(String name, String passWorkd, IResult result)
				throws RemoteException {

		}

		@Override
		public void connect(String host, IResult result) throws RemoteException {
			connectSever(host, result);
		}
	};

	@Override
	public IBinder onBind(Intent intent) {
		return mBinber;
	}

	private void loginServer(String userName, String passWord, IResult result)
			throws RemoteException {
		if (connection != null && connection.isConnected()) {
			try {
				connection.login(userName, passWord, "Android");
				ChatManager chatManager = connection.getChatManager();
				chatManager.addChatListener(new ChatManagerListener() {
					@Override
					public void chatCreated(Chat chat, boolean createdLocally) {
						if (!createdLocally) {
							chat.addMessageListener(new MessageListener() {
								@Override
								public void processMessage(Chat chat,
										Message arg1) {
									Toast.makeText(
											getContext(),
											"From:" + arg1.getFrom()
													+ ">>body:"
													+ arg1.getBody(),
											Toast.LENGTH_LONG).show();
								}
							});
						}
					}
				});
			} catch (XMPPException e) {
				e.printStackTrace();
				result.result(false);
			}
		}
	}

	private void sendMessage() {

	}

	private void connectSever(String host, IResult result) {
		ConnectionConfiguration connConfig = new ConnectionConfiguration(host,
				5222);
		connConfig.setSecurityMode(SecurityMode.required);
		connConfig.setSASLAuthenticationEnabled(false);
		connConfig.setCompressionEnabled(false);

		if (Build.VERSION.SDK_INT >= 14) {
			connConfig.setTruststoreType("AndroidCAStore");
			connConfig.setTruststorePassword(null);
			connConfig.setTruststorePath(null);
		} else {
			connConfig.setTruststoreType("BKS");
			String path = System.getProperty("javax.net.ssl.trustStore");
			if (path == null)
				path = System.getProperty("java.home") + File.separator + "etc"
						+ File.separator + "security" + File.separator
						+ "cacerts.bks";
			connConfig.setTruststorePath(path);
			connConfig.setReconnectionAllowed(true);
		}

		connection = new XMPPConnection(connConfig);
		try {
			connection.addConnectionListener(new ConnectionPersisten());
			connection.connect();
		} catch (XMPPException e) {
			Log.e("", e.getMessage(), e);
			String errorMessage = e.getMessage();
			String NetworkIsUnreachable = "Network is unreachable";
			if (errorMessage != null
					&& errorMessage.contains(NetworkIsUnreachable)) {
				return;
			}
		}
	}

	private Context getContext() {
		return this;
	}

	private class ConnectionPersisten implements ConnectionListener {

		@Override
		public void connectionClosed() {
			Toast.makeText(getContext(), "connectionClosed", Toast.LENGTH_LONG)
					.show();
		}

		@Override
		public void connectionClosedOnError(Exception arg0) {
			Toast.makeText(getContext(), "connectionClosedOnError",
					Toast.LENGTH_LONG).show();

		}

		@Override
		public void reconnectingIn(int arg0) {
			Toast.makeText(getContext(), "reconnectingIn", Toast.LENGTH_LONG)
					.show();

		}

		@Override
		public void reconnectionFailed(Exception arg0) {
			Toast.makeText(getContext(), "reconnectionFailed",
					Toast.LENGTH_LONG).show();

		}

		@Override
		public void reconnectionSuccessful() {
			Toast.makeText(getContext(), "reconnectionSuccessful",
					Toast.LENGTH_LONG).show();
		}

	}
}
