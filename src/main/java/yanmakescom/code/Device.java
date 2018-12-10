package yanmakescom.code;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "device")
public class Device {

    @Id
    private String name;
    private double tempareture;
    private double moisture;
    private double connectivity;
    private double battery;

    public Device(){

    }

    public Device(String N,double T,double CN,double M,double B){
        name=N;
        tempareture=T;
        moisture=M;
        connectivity=CN;
        battery=B;

    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getTempareture() {
        return tempareture;
    }

    public void setTempareture(double tempareture) {
        this.tempareture = tempareture;
    }

    public double getMoisture() {
        return moisture;
    }

    public void setMoisture(double moisture) {
        this.moisture = moisture;
    }

    public double getConnectivity() {
        return connectivity;
    }

    public void setConnectivity(double connectivity) {
        this.connectivity = connectivity;
    }

    public double getBattery() {
        return battery;
    }

    public void setBattery(double battery) {
        this.battery = battery;
    }

    @Override
    public String toString() {
        return "Device{" +
                "name='" + name + '\'' +
                ", tempareture=" + tempareture +
                ", moisture=" + moisture +
                ", connectivity=" + connectivity +
                ", battery=" + battery +
                '}';
    }
}
