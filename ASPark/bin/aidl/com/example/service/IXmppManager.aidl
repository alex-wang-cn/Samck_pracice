package com.example.service;
import com.example.service.IResult;
import com.example.service.IReceiveMessage;

interface IXmppManager{
   void login(String name,String passWorkd,IResult result);
   void connect(String host,IResult result);
   void registerReciveLisner(IReceiveMessage linser);
   void sendMessage(int userId,String message,IResult result);
}