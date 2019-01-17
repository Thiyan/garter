package yanmakescom.code;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DeviceRepository extends MongoRepository<Device, String> {
    Device findByName(String name);

}


