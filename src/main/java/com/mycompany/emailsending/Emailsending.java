package com.mycompany.emailsending;

import com.infobip.ApiClient;
import com.infobip.ApiException;
import com.infobip.ApiKey;
import com.infobip.BaseUrl;
import com.infobip.api.SmsApi;
import com.infobip.model.SmsAdvancedTextualRequest;
import com.infobip.model.SmsDestination;
import com.infobip.model.SmsTextualMessage;



import java.util.Collections;



public class Emailsending {
    
    private static final String BASE_URL = "https://ggg43w.api.infobip.com";
    private static final String API_KEY = "Your Api key";
    private static final String RECIPIENT = "Your phone Number";

    public static void main(String[] args) {
        
        
         // Create the API client and the Send SMS API instances.
        var apiClient = ApiClient.forApiKey(ApiKey.from(API_KEY))
                .withBaseUrl(BaseUrl.from(BASE_URL))
                .build();
        var sendSmsApi = new SmsApi(apiClient);

        // Create a message to send.
        var smsMessage = new SmsTextualMessage()
                .addDestinationsItem(new SmsDestination().to(RECIPIENT))
                .text("Hello, kuch ho skta h!");

        // Create a send message request.
        var smsMessageRequest = new SmsAdvancedTextualRequest()
                .messages(Collections.singletonList(smsMessage));

        try {
            // Send the message.
            var smsResponse = sendSmsApi.sendSmsMessage(smsMessageRequest).execute();
            System.out.println("Response body: " + smsResponse);

            // Get delivery reports. It may take a few seconds to show the above-sent message.
            var reportsResponse = sendSmsApi.getOutboundSmsMessageDeliveryReports().execute();
            System.out.println(reportsResponse.getResults());
        } catch (ApiException e) {
            System.out.println("HTTP status code: " + e.responseStatusCode());
            System.out.println("Response body: " + e.rawResponseBody());
        }

       

    
        emailSender e = new emailSender();
        String to = "aliyanabbas2812@gmail.com";
        String from = "moonkhan77761@gmail.com";
        String subject = "Second: Sending email using GMail";
        String text = "yanuuuuuuuuuuuuuR";
        boolean b = e.sendEmail(to, from, subject, text);
        if (b) {
            System.out.println("Email is sent successfully");
        } else {
            System.out.println("There is problem in sending email");
        }

}
}