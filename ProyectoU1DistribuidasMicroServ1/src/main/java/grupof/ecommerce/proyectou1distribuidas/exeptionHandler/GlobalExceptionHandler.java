package grupof.ecommerce.proyectou1distribuidas.exeptionHandler;



import grupof.ecommerce.proyectou1distribuidas.exceptions.PublisherNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(PublisherNotFoundException.class)
    public ResponseEntity<String> handleException(PublisherNotFoundException e) {
        HttpStatus status = HttpStatus.BAD_REQUEST;
        String responseMessage = status + "<br>" + e.getMessage();
        return ResponseEntity.status(status).body(responseMessage);
    }

}