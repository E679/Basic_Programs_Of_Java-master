package ReverseArray;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RequestParser {

    public static List<String> parseRequest(List<String> validAuthTokens, List<String[]> requests) {
        List<String> result = new ArrayList<>();

        for (String[] request : requests) {
            String requestType = request[0];
            String url = request[1];
            int paramsStart = url.indexOf('?');

            // Extracting tokens from the URL
            Map<String, String> urlTokens = new HashMap<>();
            if (paramsStart != -1) {
                String paramsString = url.substring(paramsStart + 1);
                String[] paramsList = paramsString.split("&");
                for (String param : paramsList) {
                    String[] keyValue = param.split("=");
                    if (keyValue.length == 2) {
                        urlTokens.put(keyValue[0], keyValue[1]);
                    }
                }
            }

            // Validating authentication token
            String authToken = urlTokens.getOrDefault("token", "");
            if (!validAuthTokens.contains(authToken)) {
                result.add("INVALID");
                continue;
            }

            // Validating CSRF token for POST requests
            if (requestType.equals("POST")) {
                String csrfToken = urlTokens.getOrDefault("csrf_token", "");
                if (!csrfToken.matches("[a-zA-Z0-9]{8,}")) {
                    result.add("INVALID");
                    continue;
                }
            }

            // Valid request, constructing comma-separated string of parameters
            StringBuilder paramString = new StringBuilder();
            for (Map.Entry<String, String> entry : urlTokens.entrySet()) {
                paramString.append(entry.getKey()).append("=").append(entry.getValue()).append(",");
            }
            if (paramString.length() > 0) {
                paramString.deleteCharAt(paramString.length() - 1); // Remove trailing comma
            }

            result.add("VALID," + paramString.toString());
        }

        return result;
    }

    public static void main(String[] args) {
        List<String> validAuthTokens = List.of("token1", "token2");
        List<String[]> requests = List.of(
                new String[]{"GET", "https://example.com/action?token=token1&param1=value1&param2=value2"},
                new String[]{"POST", "https://example.com/action?token=token2&csrf_token=abc123&param3=value3"}
        );

        List<String> result = parseRequest(validAuthTokens, requests);
        for (String status : result) {
            System.out.println(status);
        }
    }
}
