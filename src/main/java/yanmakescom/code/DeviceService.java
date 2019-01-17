package yanmakescom.code;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import yanmakescom.exception.AGException;
import yanmakescom.exception.AGStatus;

@Service
public class DeviceService {

    @Autowired
    private DeviceRepository deviceRepository;

    public Device getDevice(String id) throws AGException {

        Device device;
        try {
            device=deviceRepository.findByName(id);
        }catch (Exception ex){
            throw new AGException(AGStatus.DB_ERROR);
        }

        if(device==null)
            throw new AGException(AGStatus.NO_ENTRY_FOUND);

        return device;
    }
}
