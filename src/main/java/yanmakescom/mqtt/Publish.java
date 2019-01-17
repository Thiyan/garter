package yanmakescom.mqtt;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.springframework.stereotype.Service;
import yanmakescom.exception.AGException;
import yanmakescom.exception.AGStatus;

@Service
public class Publish  {

    public Boolean publish(String device, String product) throws AGException {

        String msg="P:"+product;

        System.out.println(msg);
        System.out.println(device);
        try {
            MqttClient client = new MqttClient("tcp://mqtt.senzmate.com:1883", "Donoor");
            client.connect();

            MqttMessage message = new MqttMessage();
            message.setPayload(msg.getBytes());

            client.publish("SenzMate/s2A/incubator-A/"+product, message);
            client.disconnect();

        }catch (MqttException ex){
            ex.printStackTrace();
            throw new AGException(AGStatus.DEVICE_CONFIGURATION_ERROR);
        }
        return true;

    }
}
