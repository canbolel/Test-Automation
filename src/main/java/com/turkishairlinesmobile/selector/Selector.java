package com.turkishairlinesmobile.selector;


import com.turkishairlinesmobile.helper.StoreHelper;
import com.turkishairlinesmobile.model.ElementInfo;
import com.turkishairlinesmobile.model.SelectorInfo;
import org.openqa.selenium.By;

public interface Selector {

    default ElementInfo getElementInfo(String key) {
        return StoreHelper.INSTANCE.findElementInfoByKey(key);
    }

    default By getElementInfoToBy(String key) {
        return getElementInfoToBy(getElementInfo(key));
    }

    default SelectorInfo getSelectorInfo(ElementInfo elementInfo) {
        return new SelectorInfo(getElementInfoToBy(elementInfo), getElementInfoToIndex(elementInfo));
    }

    default SelectorInfo getSelectorInfo(String key) {
        return new SelectorInfo(getElementInfoToBy(key), getElementInfoToIndex(key));
    }

    By getElementInfoToBy(ElementInfo elementInfo);

    int getElementInfoToIndex(ElementInfo elementInfo);

    default int getElementInfoToIndex(String key) {
        return getElementInfoToIndex(getElementInfo(key));
    }
}
