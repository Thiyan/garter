package yanmakescom.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import yanmakescom.utils.AGResponse;

//@RestController
@ControllerAdvice
class ExceptionController {

    private static final Logger LOGGER= LoggerFactory.getLogger(ExceptionController.class);


    @ResponseBody
    @ExceptionHandler(value = AGException.class)
    public AGResponse customExceptionHandler(AGException ex){
        LOGGER.error("In Exception handler");
        AGResponse response=new AGResponse(ex.getStatus());
        return response;
    }

    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public AGResponse ExceptionHandler(Exception ex){
        System.out.println("In Exception handler");
        AGResponse response=new AGResponse(AGStatus.ERROR);
        return response;
    }
}
