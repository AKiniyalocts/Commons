package com.akiniyalocts.commons.activities.drawer;

/**
 * Created by anthony on 9/15/15.
 */
public class DrawerItem {

    private String title;

    private int headerDrawable;

    private String headerImageUrl;

    private String headerTitle;

    private String unicode;

    private boolean isHeader;

    private boolean isSeparator;

    private boolean isSelected;

    private boolean selectable;

    private String separatorTitle;

    public DrawerItem(String title, int headerDrawable, String headerImageUrl, String headerTitle, String unicode, boolean isHeader, boolean isSeparator, String separatorTitle, boolean isSelected, boolean selectable) {
        this.title = title;
        this.headerDrawable = headerDrawable;
        this.headerImageUrl = headerImageUrl;
        this.headerTitle = headerTitle;
        this.unicode = unicode;
        this.isHeader = isHeader;
        this.isSeparator = isSeparator;
        this.separatorTitle = separatorTitle;
        this.isSelected = isSelected;
        this.selectable = selectable;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getHeaderDrawable() {
        return headerDrawable;
    }

    public void setHeaderDrawable(int headerDrawable) {
        this.headerDrawable = headerDrawable;
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

    public boolean isSeparator() {
        return isSeparator;
    }

    public void setIsSeparator(boolean isSeparator) {
        this.isSeparator = isSeparator;
    }

    public String getHeaderImageUrl() {
        return headerImageUrl;
    }

    public void setHeaderImageUrl(String headerImageUrl) {
        this.headerImageUrl = headerImageUrl;
    }

    public boolean hasUrlForHeader(){
        return this.headerImageUrl != null;
    }

    public String getHeaderTitle() {
        return headerTitle;
    }

    public void setHeaderTitle(String headerTitle) {
        this.headerTitle = headerTitle;
    }

    public String getSeparatorTitle() {
        return separatorTitle;
    }

    public void setSeparatorTitle(String separatorTitle) {
        this.separatorTitle = separatorTitle;
    }

    public boolean isSelected() {
      return isSelected;
    }

    public void setIsSelected(boolean isSelected) {
      this.isSelected = isSelected;
    }

    public boolean isSelectable() {
      return selectable;
    }

    public void setSelectable(boolean selectable) {
      this.selectable = selectable;
    }
}
