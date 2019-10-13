package config;

public enum LocalConfig {
    INSTANCE;

    private String browser = System.getProperty("BROWSER") == null ? "chrome" : System.getProperty("BROWSER");
    private String url = System.getProperty("URL") == null ? "http://google.com" : System.getProperty("URL");
    private String searchTerm = System.getProperty("SEARCH_TERM") == null ? "888 Holdings" : System.getProperty("SEARCH_TERM");

    public String getBrowser() {
        return browser;
    }

    public String getUrl() {
        return url;
    }

    public String getSearchTerm() {
        return searchTerm;
    }


}
