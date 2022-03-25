package com.example.a09_broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;

public class SmsReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Bundle bundle = intent.getExtras();

        SmsMessage[] msgs = null;

        String str = "";
        String OTPCode ="";

        if (bundle != null) {
            // Retrieve the SMS Messages received
            Object[] pdus = (Object[]) bundle.get("pdus");
            msgs = new SmsMessage[pdus.length];

            String sender = "";

            for (int i=0; i < msgs.length; i++) {
                msgs[i] = SmsMessage.createFromPdu((byte[]) pdus[i]);
                sender = msgs[i].getOriginatingAddress();
                str += msgs[i].getMessageBody().toString();
            }

            // Display the entire SMS Message

            if(str.length()>3 && str.contains("asd"))
            {
                OTPCode = str.substring(0,4);

                try {
                    int otp = Integer.parseInt(OTPCode);


                }
                catch (Exception e)
                {}
            }
        }

    }
}
