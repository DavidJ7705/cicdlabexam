package ie.atu.cicd_labexam;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

    @Pattern(regexp = "", message = "Emp-xxxx")
    private String employeeCode;

    @NotBlank(message = "Name is required")
    private String name;

    @Email(message = "Invalid format")
    private String email;

    @NotBlank(message = "Position is required")
    private String position;

    @PositiveOrZero(message="Salary must be greater than 0")
    private double salary;

    @DateTimeFormat
    private Date dateOfJoining;

}
