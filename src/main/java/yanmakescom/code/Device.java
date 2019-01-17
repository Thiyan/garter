package yanmakescom.code;

import org.springframework.data.mongodb.core.mapping.Document;
import yanmakescom.utils.ProductType;

@Document(collection = "device")
public class Device {


    private String name;
    private String temperature;
    private String moisture;
    private String connectivity;
    private String humidity;
    private String luminance;
    private ProductType product;
    private boolean active;

    public Device() {
    }

    public Device(String name, String temperature, String moisture, String connectivity, String humidity,
                  String luminance, ProductType product, boolean active) {
        this.name = name;
        this.temperature = temperature;
        this.moisture = moisture;
        this.connectivity = connectivity;
        this.humidity = humidity;
        this.luminance = luminance;
        this.product = product;
        this.active = active;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public String getMoisture() {
        return moisture;
    }

    public void setMoisture(String moisture) {
        this.moisture = moisture;
    }

    public String getConnectivity() {
        return connectivity;
    }

    public void setConnectivity(String connectivity) {
        this.connectivity = connectivity;
    }

    public String getHumidity() {
        return humidity;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }

    public String getLuminance() {
        return luminance;
    }

    public void setLuminance(String luminance) {
        this.luminance = luminance;
    }

    public ProductType getProduct() {
        return product;
    }

    public void setProduct(ProductType product) {
        this.product = product;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "Device{" +
                "name='" + name + '\'' +
                ", temperature='" + temperature + '\'' +
                ", moisture='" + moisture + '\'' +
                ", connectivity='" + connectivity + '\'' +
                ", humidity='" + humidity + '\'' +
                ", luminance='" + luminance + '\'' +
                ", product=" + product +
                ", active=" + active +
                '}';
    }
}
