package yanmakescom.utils;

public enum ProductType {

    R("rose"),
    M("mushroom");

    private String value;

    ProductType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
