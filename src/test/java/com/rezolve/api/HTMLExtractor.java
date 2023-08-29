package com.rezolve.api;

import io.restassured.path.json.JsonPath;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class HTMLExtractor {
    public static void main(String[] args) {
        String jsonResponse = "<!DOCTYPE html>\n" +
                "<html>\n" +
                "\n" +
                "<body>\n" +
                "\t<form name='notificationForm'\n" +
                "\t\taction='https://test.ppipe.net/connectors/ar_simulator/3ds2;jsessionid=B8EB0D09DD086D641652C0192BB7E1AC.uat01-vm-con03?asyncsource=ACI_3DS_2&type=methodNotification&ndcid=8ac7a4ca7c93a11f017c93f13589018c_fbf0090867f74e318853002ce5d3a1c6'\n" +
                "\t\tmethod='POST'>\n" +
                "\t\t<input type='hidden' name='threeDSMethodData' value='eyJ0aHJlZURTU2VydmVyVHJhbnNJRCI6IjllMDkzNzZmLTc1MzEtNDdmOS1iOTU2LTU4N2I1OTg5NWQ4NyJ9'>\n" +
                "        </form>\n" +
                "\t\t<script>\n" +
                "\t\t\twindow.onload = submitForm;\n" +
                "            function submitForm() {\n" +
                "                notificationForm.submit();\n" +
                "            }\n" +
                "\t\t</script>\n" +
                "</body>\n" +
                "\n" +
                "</html>";

        Document document = Jsoup.parse(jsonResponse);
        String threeDSMethodData = document.select("input[name=threeDSMethodData]").val();
                String action = document.select("form[name=notificationForm]").attr("action");

        // Print the "type" value
        System.out.println(threeDSMethodData);
        System.out.println(action);
    }
}
