package test.utils.config;

import org.apache.commons.lang3.StringUtils;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.util.Enumeration;
import java.util.Properties;

/**
 * The {@link EnvDataConfig} exposes all properties contained in env.properties derived from {@link ResourcesConfig} to the tests.
 */
public class EnvDataConfig {

    ResourcesConfig resourcesConfig;

    public EnvDataConfig() {
        resourcesConfig = new ResourcesConfig();
    }

    public String getTimeout() {
        return getEnvProperties().getProperty("timeout");
    }

    public String getInterval() {
        return getEnvProperties().getProperty("interval");
    }

    public String getBrowser() {
        return getEnvProperties().getProperty("browser");
    }

    public String getRemoteURL() {
        return removeTrailingSlash(getEnvProperties().getProperty("driver.remote.url"));
    }

    public Boolean getHeadlessMode() {
        return Boolean.parseBoolean(getEnvProperties().getProperty("headless.mode"));
    }

    public String getURL(String applicationName) {
        return removeTrailingSlash(getEnvProperties().getProperty(applicationName + ".url"));
    }

    public String getAPIURL() {
        return removeTrailingSlash(getEnvProperties().getProperty("api.url"));
    }

    public String getUsername(String userRole) {
        return getEnvProperties().getProperty(userRole + ".USERNAME");
    }

    public String getPassword(String userRole) {
        return getEnvProperties().getProperty(userRole + ".PASSWORD");
    }

    private Properties getEnvProperties() {
        return getProperties(loadProperties(resourcesConfig.getEnvironmentProperties()));
    }

    private static Properties loadProperties(String testDataFile) {
        Properties prop = new Properties();
        try {
            InputStream inputStream = new FileInputStream(testDataFile);
            Reader reader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
            prop.load(reader);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return prop;
    }

    private static Properties getProperties(Properties params) {
        Properties result = new Properties();
        Enumeration<?> names = params.propertyNames();
        while (names.hasMoreElements()) {
            String name = (String) names.nextElement();
            result.put(name, params.get(name));
        }
        return result;
    }

    private static String removeTrailingSlash(String url) {
        for (int i = 0; i < url.length(); i++) {
            if (url.endsWith("/")) {
                url = StringUtils.removeEnd(url, "/");
            } else {
                break;
            }
        }
        return url;
    }

}
