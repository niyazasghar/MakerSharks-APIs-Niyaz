package Assignment.API.dto;

import Assignment.API.entity.ManufacturingProcess;
import Assignment.API.entity.NatureOfBusiness;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.Set;
// we can use @Getter @Setter also
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SupplierSearchRequest {

    @NotBlank
    private String location;

    @NotNull
    private NatureOfBusiness natureOfBusiness;

    @NotEmpty
    private Set<ManufacturingProcess> manufacturingProcesses;


}