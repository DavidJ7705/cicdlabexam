package ie.atu.cicd_labexam;

import com.sun.jdi.request.DuplicateRequestException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalErrorHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String,String>> display (MethodArgumentNotValidException ex)
    {
        Map<String,String>errorList = new HashMap<>();

        for (FieldError error : ex.getBindingResult().getFieldErrors()){
            String errorName = error.getField();
            String errorMessage = error.getDefaultMessage();
            errorList.put(errorName,errorMessage);
        }
        return ResponseEntity.status(400).body(errorList);
    }
    /*
    @ExceptionHandler(DuplicateRequestException)
    public ResponseEntity<Map<String,String>> display (DuplicateRequestException ex)   {
    for (Employee e : email){
            if( e.getEmail().equals(e.getEmail())){
                return ResponseEntity.status(400).body(message="This email already exists");
            }
        }

    }
    */
}
