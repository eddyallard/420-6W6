package qc.colval.demothymleaf.models.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CustomerDTO {

    private Long customerId;

    private String firstName;

    private String lastName;

    private String email;

    private boolean active;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createDate;

    private Date lastUpdate;

    private Long addressId;

    private Long storeId;
}