package fr.rekla.notification.service;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class TwilioNotificationServiceImpl implements TwilioNotificationService {

    @Value("${twilio.account_sid}")
    private String twilio_account_sid;

    @Value("${twilio.auth_token}")
    private String twilio_auth_token;

    @Value("${twilio.phone_number}")
    private String twilio_phone_number;

    @Value("${twilio.phone_number_receiver}")
    private String twilio_phone_number_receiver;

    public void sendSMS(String message) {
        Twilio.init(twilio_account_sid, twilio_auth_token);
        Message.creator(
                        new PhoneNumber(twilio_phone_number_receiver),
                        new PhoneNumber(twilio_phone_number),
                        message)
                .create();
    }
}
