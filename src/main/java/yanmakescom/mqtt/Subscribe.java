package yanmakescom.mqtt;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.springframework.beans.factory.annotation.Autowired;


public class Subscribe {

    @Autowired
    SimpleMqttCallBack simpleMqttCallBack;


    public void subscribe() throws MqttException {

        System.out.println("== START SUBSCRIBER ==");

        MqttClient client = new MqttClient("tcp://localhost:1883", MqttClient.generateClientId());
        client.connect();
        client.subscribe("iot_data");

        client.setCallback(new SimpleMqttCallBack());
    }
}
