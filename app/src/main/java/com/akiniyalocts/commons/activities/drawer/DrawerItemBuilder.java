package com.akiniyalocts.commons.activities.drawer;

public class DrawerItemBuilder {
    private String title;
    private int headerDrawable = -1;
    private String headerImageUrl = null;
    private String headerTitle = null;
    private String unicode = null;
    private boolean isHeader = false;
    private boolean isSeparator = false;
    private String separatorTitle = null;

    public DrawerItemBuilder(String title){
        this.title = title;
    }

    public DrawerItemBuilder setTitle(String title) {
        this.title = title;
        return this;
    }

    public DrawerItemBuilder setHeaderDrawable(int headerDrawable) {
        this.headerDrawable = headerDrawable;
        return this;
    }

    public DrawerItemBuilder setUnicode(String unicode) {
        this.unicode = unicode;
        return this;
    }

    public DrawerItemBuilder setIsHeader(boolean isHeader) {
        this.isHeader = isHeader;
        return this;
    }

    public DrawerItemBuilder setIsSeparator(boolean isSeparator){
        this.isSeparator = isSeparator;
        return this;
    }

    /**
     * Setting this will override the setting of headerImageDrawable as the header image
     * @param headerImageUrl url of image for header
     * @return
     */
    public DrawerItemBuilder setHeaderImageDrawable(String headerImageUrl){
        this.headerImageUrl = headerImageUrl;
        return this;
    }

    public DrawerItemBuilder setHeaderTitle(String headerTitle){
        this.headerTitle = headerTitle;
        return this;
    }

    public DrawerItemBuilder setSeparatorTitle(String separatorTitle){
        this.separatorTitle = separatorTitle;
        return this;
    }

    public DrawerItem createDrawerItem() {
        return new DrawerItem(title, headerDrawable, headerImageUrl, headerTitle, unicode, isHeader, isSeparator, separatorTitle);
    }
}