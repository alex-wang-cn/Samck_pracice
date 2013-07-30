/*
 * This file is auto-generated.  DO NOT MODIFY.
 * Original file: C:\\Users\\Administrator\\git\\Samck_pracice\\ASPark\\src\\com\\example\\service\\IXmppManager.aidl
 */
package com.example.service;
public interface IXmppManager extends android.os.IInterface
{
/** Local-side IPC implementation stub class. */
public static abstract class Stub extends android.os.Binder implements com.example.service.IXmppManager
{
private static final java.lang.String DESCRIPTOR = "com.example.service.IXmppManager";
/** Construct the stub at attach it to the interface. */
public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
/**
 * Cast an IBinder object into an com.example.service.IXmppManager interface,
 * generating a proxy if needed.
 */
public static com.example.service.IXmppManager asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof com.example.service.IXmppManager))) {
return ((com.example.service.IXmppManager)iin);
}
return new com.example.service.IXmppManager.Stub.Proxy(obj);
}
@Override public android.os.IBinder asBinder()
{
return this;
}
@Override public boolean onTransact(int code, android.os.Parcel data, android.os.Parcel reply, int flags) throws android.os.RemoteException
{
switch (code)
{
case INTERFACE_TRANSACTION:
{
reply.writeString(DESCRIPTOR);
return true;
}
case TRANSACTION_login:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
java.lang.String _arg1;
_arg1 = data.readString();
com.example.service.IResult _arg2;
_arg2 = com.example.service.IResult.Stub.asInterface(data.readStrongBinder());
this.login(_arg0, _arg1, _arg2);
reply.writeNoException();
return true;
}
case TRANSACTION_connect:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
com.example.service.IResult _arg1;
_arg1 = com.example.service.IResult.Stub.asInterface(data.readStrongBinder());
this.connect(_arg0, _arg1);
reply.writeNoException();
return true;
}
case TRANSACTION_registerReciveLisner:
{
data.enforceInterface(DESCRIPTOR);
com.example.service.IReceiveMessage _arg0;
_arg0 = com.example.service.IReceiveMessage.Stub.asInterface(data.readStrongBinder());
this.registerReciveLisner(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_sendMessage:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
java.lang.String _arg1;
_arg1 = data.readString();
com.example.service.IResult _arg2;
_arg2 = com.example.service.IResult.Stub.asInterface(data.readStrongBinder());
this.sendMessage(_arg0, _arg1, _arg2);
reply.writeNoException();
return true;
}
}
return super.onTransact(code, data, reply, flags);
}
private static class Proxy implements com.example.service.IXmppManager
{
private android.os.IBinder mRemote;
Proxy(android.os.IBinder remote)
{
mRemote = remote;
}
@Override public android.os.IBinder asBinder()
{
return mRemote;
}
public java.lang.String getInterfaceDescriptor()
{
return DESCRIPTOR;
}
@Override public void login(java.lang.String name, java.lang.String passWorkd, com.example.service.IResult result) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(name);
_data.writeString(passWorkd);
_data.writeStrongBinder((((result!=null))?(result.asBinder()):(null)));
mRemote.transact(Stub.TRANSACTION_login, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@Override public void connect(java.lang.String host, com.example.service.IResult result) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(host);
_data.writeStrongBinder((((result!=null))?(result.asBinder()):(null)));
mRemote.transact(Stub.TRANSACTION_connect, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@Override public void registerReciveLisner(com.example.service.IReceiveMessage linser) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeStrongBinder((((linser!=null))?(linser.asBinder()):(null)));
mRemote.transact(Stub.TRANSACTION_registerReciveLisner, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@Override public void sendMessage(int userId, java.lang.String message, com.example.service.IResult result) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(userId);
_data.writeString(message);
_data.writeStrongBinder((((result!=null))?(result.asBinder()):(null)));
mRemote.transact(Stub.TRANSACTION_sendMessage, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
}
static final int TRANSACTION_login = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
static final int TRANSACTION_connect = (android.os.IBinder.FIRST_CALL_TRANSACTION + 1);
static final int TRANSACTION_registerReciveLisner = (android.os.IBinder.FIRST_CALL_TRANSACTION + 2);
static final int TRANSACTION_sendMessage = (android.os.IBinder.FIRST_CALL_TRANSACTION + 3);
}
public void login(java.lang.String name, java.lang.String passWorkd, com.example.service.IResult result) throws android.os.RemoteException;
public void connect(java.lang.String host, com.example.service.IResult result) throws android.os.RemoteException;
public void registerReciveLisner(com.example.service.IReceiveMessage linser) throws android.os.RemoteException;
public void sendMessage(int userId, java.lang.String message, com.example.service.IResult result) throws android.os.RemoteException;
}
