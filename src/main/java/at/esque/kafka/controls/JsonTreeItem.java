package at.esque.kafka.controls;

import javafx.collections.ListChangeListener;
import javafx.scene.control.TreeItem;

public class JsonTreeItem extends TreeItem<String> {
    private String propertyName;
    private String propertyValue;
    private String propertyChangedType;
    private String displayValueSuffix;
    private boolean array = false;

    public JsonTreeItem(String propertyName, String propertyValue) {
        this(propertyName, propertyValue, null, null);
    }

    public JsonTreeItem(String propertyName, String propertyValue, String propertyChangedType, String displayValueSuffix) {
        super();
        this.propertyName = propertyName;
        this.propertyValue = propertyValue;
        this.propertyChangedType = propertyChangedType;
        this.displayValueSuffix = displayValueSuffix;
        this.getChildren().addListener((ListChangeListener.Change<?> c) -> {
            updateDisplayValue();
        });
        updateDisplayValue();
    }

    public String getPropertyName() {
        return propertyName;
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
        updateDisplayValue();
    }

    public String getPropertyValue() {
        return propertyValue;
    }

    public void setPropertyValue(String propertyValue) {
        this.propertyValue = propertyValue;
        updateDisplayValue();
    }

    public String getPropertyChangedType() {
        return propertyChangedType;
    }

    public void setPropertyChangedType(String propertyChangedType) {
        this.propertyChangedType = propertyChangedType;
    }

    public String getDisplayValueSuffix() {
        return displayValueSuffix;
    }

    public void setDisplayValueSuffix(String displayValueSuffix) {
        this.displayValueSuffix = displayValueSuffix;
        updateDisplayValue();
    }

    public boolean isArray() {
        return array;
    }

    public void setArray(boolean array) {
        this.array = array;
    }

    private void updateDisplayValue() {
        if (propertyName == null && propertyValue == null) {
            this.setValue("<null>");
        } else if (propertyName != null && propertyValue == null) {
            this.setValue(propertyName);
        } else if (propertyName == null && propertyValue != null) {
            this.setValue(propertyValue);
        } else {
            this.setValue(propertyName + ": " + propertyValue);
        }

        if (displayValueSuffix != null) {
            this.setValue(this.getValue() + " " + displayValueSuffix);
        }
    }

    public String getPath() {
        return getPath(this);
    }

    private String getPath(JsonTreeItem jsonTreeItem) {
        if (jsonTreeItem.getParent() == null) {
            return "";
        }
        return getPath((JsonTreeItem) jsonTreeItem.getParent()) + "/" + jsonTreeItem.getPropertyName();
    }
}
