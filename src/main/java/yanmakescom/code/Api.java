package yanmakescom.code;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import yanmakescom.exception.AGException;
import yanmakescom.mqtt.Publish;
import yanmakescom.utils.AGResponse;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/")
public class Api {
    @Autowired
    private DeviceService deviceService;

    @Autowired
    private Publish publish;


    @GetMapping("/device")
    public AGResponse getDevice(@RequestParam("id") String id) throws AGException {

        return new AGResponse(deviceService.getDevice(id));

    }

//    @GetMapping("/device")
//    public List<Device> getAllDevice() {
//        List<Device> d=null;
//
//        try{
//            d=deviceRepository.findAll();
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//        return d;
//
//    }

    @PostMapping("/config")
    public AGResponse control(@RequestParam("device") String id, @RequestParam("product") String product) throws AGException {


        return new AGResponse(publish.publish(id,product));
    }



}
