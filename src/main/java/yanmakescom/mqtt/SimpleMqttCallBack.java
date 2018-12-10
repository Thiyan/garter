package yanmakescom.mqtt;

import org.eclipse.paho.client.mqttv3.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import yanmakescom.code.Device;
import yanmakescom.code.DeviceRepository;

import javax.annotation.PostConstruct;
import java.util.concurrent.TimeUnit;

@Service
public class SimpleMqttCallBack implements MqttCallback {
    private MqttClient client;
    String N,S;

    @Autowired
    private DeviceRepository deviceRepository;


    public void connectionLost(Throwable throwable) {

        System.out.println(throwable + "Connection to MQTT broker lost!");
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            subscribe();
        } catch (MqttException e) {
            e.printStackTrace();
        }
    }

    public void messageArrived(String s, MqttMessage mqttMessage) throws Exception {


        double CN=0,T=0,M=0,B=0;
        String N;

        String message = new String(mqttMessage.getPayload()); //Pick the payload String
        System.out.println(message);

        String[] devices=message.split(";");

        for (String dev:devices){

            String[] record = dev.split("-"); //Split message to get device type
//            System.out.println(record[0]);
//            System.out.println(record[1]);
              N=record[0];

            String[] rec=record[1].split(",");

            for (String set : rec) {
//                System.out.println(set);

                String[] data = set.split(":");
                //System.out.println(data[0]);

                switch (data[0]) {
                    case "T":
//                        device.setTempareture(Double.parseDouble(data[1]));
                        T=Double.parseDouble(data[1]);
//                        System.out.println(T);
                        break;
                    case "M":

//                        device.setHumidity(Double.parseDouble(data[1]));
                        M=Double.parseDouble(data[1]);
//                        System.out.println(H);
                        break;
                    case "CN":

//                        device.setMoisture(Double.parseDouble(data[1]));
                        CN=Double.parseDouble(data[1]);
//                        System.out.println(M);
                        break;
                    case "B":

//                        device.setIntensity(Double.parseDouble(data[1]));
                        B=Double.parseDouble(data[1]);
//                        System.out.println(I);
                        break;
                    default:
                }
            }
            Device d=new Device(N,T,CN,M,B);
            System.out.println(d.toString());
            try {
                deviceRepository.save(d);
                System.out.println("Data stored");
            } catch (Exception e) {
                e.printStackTrace();
            }

        }


     }


    public void deliveryComplete(IMqttDeliveryToken iMqttDeliveryToken) {
    }


    @PostConstruct
    public void subscribe() throws MqttException {

        System.out.println("== START SUBSCRIBER ==");

        //client=new MqttClient("tcp://localhost:1883", "Thiyan");
        client = new MqttClient("tcp://mqtt.senzmate.com:1883", "miller");
        client.connect();
        client.subscribe("SenzMate/D2S/Bmich-A");

        client.setCallback(this);
    }
}

