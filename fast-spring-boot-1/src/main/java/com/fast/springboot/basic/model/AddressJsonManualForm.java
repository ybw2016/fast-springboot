package com.fast.springboot.basic.model;

import com.fast.springboot.basic.annotation.DecryptPostJsonFormField;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author bowen.yan
 * @date 2018-11-16
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddressJsonManualForm {
    @DecryptPostJsonFormField
    private String addressCode;
    private String addressName;
}
