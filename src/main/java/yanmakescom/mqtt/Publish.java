package yanmakescom.mqtt;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.springframework.stereotype.Service;

@Service
public class Publish  {

    public String publish(String msg) throws MqttException {
        MqttClient client = new MqttClient("tcp://mqtt.senzmate.com:1883", "Donoor");

        client.connect();

        MqttMessage message = new MqttMessage();

        message.setPayload(msg.getBytes());

        client.publish("SenzMate/s2A/incubator-A", message);

        client.disconnect();
        return "Success";

    }
}
