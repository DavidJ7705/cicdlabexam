package ie.atu.cicd_labexam;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.UniqueElements;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {


    @Pattern(regexp = "EMP-XXXX", message = "Must be in format EMP-XXXX ")
    private String employeeCode;

    @NotBlank(message = "Name is required")
    private String name;

    /*@UniqueElements*/
    @Email(message = "Invalid Email format")
    private String email;

    @NotBlank(message = "Position is required")
    private String position;

    @PositiveOrZero(message="Salary must be greater than 0")
    private double salary;


    @PastOrPresent(message = "Must be today or earlier and Must be in format DD/MM/YYYY")
    private Date dateOfJoining;

}
