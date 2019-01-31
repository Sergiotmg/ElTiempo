package com.sergio.eltiempo;

public class Source {
    private String title;
    private String slug;
    private String url;
    private int crawl_rate;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getCrawl_rate() {
        return crawl_rate;
    }

    public void setCrawl_rate(int crawl_rate) {
        this.crawl_rate = crawl_rate;
    }
}
