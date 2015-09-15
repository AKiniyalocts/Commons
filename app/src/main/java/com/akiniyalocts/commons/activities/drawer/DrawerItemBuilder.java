package com.akiniyalocts.commons.activities.drawer;

public class DrawerItemBuilder {
    private String title;
    private int icon = -1;
    private String unicode = null;
    private boolean isHeader = false;

    public DrawerItemBuilder setTitle(String title) {
        this.title = title;
        return this;
    }

    public DrawerItemBuilder setIcon(int icon) {
        this.icon = icon;
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

    public DrawerItem createDrawerItem() {
        return new DrawerItem(title, icon, unicode, isHeader);
    }
}