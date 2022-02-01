package com.adhessit.rems.util;

import com.adhessit.rems.model.Address;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class Utils {

    public static Address retrieveAddress(Double lat, Double lon) throws Exception {
        URL url = new URL("https://nominatim.openstreetmap.org/reverse?format=json&lon=" + lon + "&lat=" + lat);
        URLConnection connection = url.openConnection();
        String redirect = connection.getHeaderField("Location");
        if (redirect != null) {
            connection = new URL(redirect).openConnection();
        }

        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String inputLine, ans = "";
        System.out.println();
        while ((inputLine = in.readLine()) != null) {
            ans += inputLine + "\n";
            System.out.println(inputLine);
        }

        int addressIndex = ans.indexOf("address");
        int start = ans.indexOf("{", addressIndex);
        int end = ans.indexOf("}", start) + 1;

        ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        Address address = mapper.readValue(ans.substring(start, end), Address.class);

        return address;
    }

}
