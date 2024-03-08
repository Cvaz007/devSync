package riwi.devSync.domain.service;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import org.springframework.stereotype.Service;

@Service
public class SMSService {
    private final static String ACCOUNT_SID = "AC59b7f0109c94466d3e3fa3b6d2606a08";
    private final static String AUTH_ID = "400dc96245bb9deb84ccc911780bfa36";

    static {
        Twilio.init(ACCOUNT_SID, AUTH_ID);
    }

    public boolean send2faCode(String phoneNumber, String twoFaCode) {
        Message.creator(new PhoneNumber(phoneNumber), new PhoneNumber("+12768007015"), "Your Two Factor Authentication code is: " + twoFaCode).create();
        return true;
    }
}
