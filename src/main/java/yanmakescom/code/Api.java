package yanmakescom.code;

import org.eclipse.paho.client.mqttv3.MqttException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import yanmakescom.mqtt.Publish;

import java.util.List;
import java.util.Optional;

@RestController
public class Api {
    @Autowired
    private DeviceRepository deviceRepository;

    @Autowired
    private Publish publish;


    @GetMapping("/")
    public String getDevice() {

        return "Welcome to ======Sensor 1.0======";

    }


    @GetMapping("/device/{id}")
    public Optional<Device> getDevice(@PathVariable String id) {
        Optional<Device> d=null;
        System.out.println(id);
        try{
            d=deviceRepository.findById(id);
        }catch (Exception e){
            e.printStackTrace();
        }
        return d;

    }

    @GetMapping("/device")
    public List<Device> getAllDevice() {
        List<Device> d=null;

        try{
            d=deviceRepository.findAll();
        }catch (Exception e){
            e.printStackTrace();
        }
        return d;

    }

//    @GetMapping("/control/{msg}")
//    public String control(@PathVariable String msg) {
//        try {
//            publish.publish(msg);
//        } catch (MqttException ex) {
//            return "error";
//        }
//        return "Success";
//    }



}
