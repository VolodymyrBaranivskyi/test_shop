package com.volodymyrbaranivskyi.test_shop.view.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@JsonAutoDetect(fieldVisibility = ANY)
public class ProductDto {

    @ApiModelProperty(
            value = "Generated UUID",
            readOnly = true)
    private int id;

    @ApiModelProperty(
            value = "Product's name",
            example = "Iphone 14")
    private String name;

    @ApiModelProperty(
            value = "Product's description.",
            example = "Apple brand smartphone, iPhone 14 models")
    private String description;
}
