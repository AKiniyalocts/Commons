package com.akiniyalocts.commons.activities.drawer;

/**
 * Created by anthony on 9/15/15.
 */
public class DrawerItem {

    private String title;

    private int icon;

    private String unicode;

    private boolean isHeader;

    public DrawerItem(String title, int icon, String unicode, boolean isHeader) {
        this.title = title;
        this.icon = icon;
        this.unicode = unicode;
        this.isHeader = isHeader;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public String getUnicode() {
        return unicode;
    }

    public void setUnicode(String unicode) {
        this.unicode = unicode;
    }

    public boolean isHeader() {
        return isHeader;
    }

    public void setIsHeader(boolean isHeader) {
        this.isHeader = isHeader;
    }
}
