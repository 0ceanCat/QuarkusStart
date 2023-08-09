package com.desafio.labseq.resource;

import com.desafio.ApiPaths;
import com.desafio.labseq.Labseq;
import com.desafio.labseq.dto.LabsqeDTO;
import io.smallrye.common.constraint.NotNull;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.parameters.Parameter;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;

@Path(ApiPaths.BASE_PATH)
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class LabseqResource {

    @Inject
    Labseq labseq;

    @GET()
    @Path(ApiPaths.COMPUTE_LABSEQ)
    @Operation(description = "Compute the labseq value for the given index", summary = "Compute the labseq value for the given index")
    @APIResponses(value = {
            @APIResponse(responseCode = "200", description = "Labseq value computed successfully",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = LabsqeDTO.class))),
            @APIResponse(responseCode = "400", description = "Bad Request, the given index is. ",
                    content = @Content(mediaType = "application/json"))
    })
    public Response computeLabseq(@PathParam("n") @NotNull @Parameter(description = "The index of the sequence’s (single) value to return") final Integer n) {
        Response response;
        if (n < 0) {
            response = Response
                    .status(400, "Bad Request, " +
                            "the index of the sequence’s (single) value must be a non-negative integer number! ")
                    .build();
        } else {
            response = Response
                    .ok(LabsqeDTO
                            .of(labseq.getLabsqeValue(n)))
                    .build();
        }
        return response;
    }
}
