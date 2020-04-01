package com.firstdata.firstapi.googlepaysampleapp;

import java.util.HashMap;
import java.util.Map;

/**
 *  Prepare for support of multiple environments
 */
public class EnvData {

    private static Map<String, EnvProperties> envMap = new HashMap<>();

    private static class EnvPropertiesImpl implements EnvProperties {

        private String envName;
        private String url;
        private String apiKey;
        private String token;
        private String apiSecret;

        public EnvPropertiesImpl(String envName, String url, String apiKey, String token,
        String apiSecret)
        {
            this.envName = envName;
            this.url = url;
            this.apiKey = apiKey;
            this.token = token;
            this.apiSecret = apiSecret;
        }

        @Override
        public String getEnvName() {
            return envName;
        }

        @Override
        public String getUrl() {
            return url;
        }

        @Override
        public String getApiKey() {
            return apiKey;
        }

        @Override
        public String getToken() {
            return token;
        }

        @Override
        public String getApiSecret() {
            return apiSecret;
        }

    }

    static {
       envMap.put("CERT", new EnvPropertiesImpl(
                        "CERT",
                        "https://api-cert.payeezy.com/v1/transactions",
                        "9hAb6X9kLgOSVvrnsFUyoH53dZaDYL9s",
                        "fdoa-63d74ca2ffc155aa",
                        "ef3be5a9a5ca11385f140bb0ba044739588af4fe83c7b53da23cfeb8b2e54334" //-Consumer Token
                )
        );
/*
       envMap.put("CERT", new EnvPropertiesImpl(
                        "CERT",
                        "https://api-cert.payeezy.com/v1/transactions",
                        "y6pWAJNyJyjGv66IsVuWnklkKUPFbb0a",
                        "fdoa-a480ce8951daa73262734cf102641994c1e55e7cdf4c02b6",
                        "86fbae7030253af3cd15faef2a1f4b67353e41fb6799f576b5093ae52901e6f7" //-Consumer Token
                )
        );
*/
    }

    public static EnvProperties getProperties(String envName) {
        return envMap.get(envName);
    }
}
