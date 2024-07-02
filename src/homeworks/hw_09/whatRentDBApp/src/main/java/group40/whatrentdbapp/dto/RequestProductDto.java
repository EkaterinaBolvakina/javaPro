package group40.whatrentdbapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestProductDto {

    private String productName;
    private String productDescription;
    private Double productPrice;
    private Integer productQuantity;

}
