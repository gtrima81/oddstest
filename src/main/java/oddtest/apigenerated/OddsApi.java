/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (4.2.2).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package oddtest.apigenerated;

import io.swagger.annotations.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.NativeWebRequest;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

import oddtest.apigenerated.model.*;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2019-12-05T17:57:19.849984Z[Europe/London]")

@Validated
@Api(value = "odds", description = "the odds API")
public interface OddsApi {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    @ApiOperation(value = "Find Odds by Bet ID", nickname = "oddsBetIdGet", notes = "Returns a list of odds for a given bet ID", response = Odds.class, responseContainer = "List", tags={ "odds", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Odds are returned for bet ID", response = Odds.class, responseContainer = "List"),
        @ApiResponse(code = 400, message = "Invalid Bet ID supplied"),
        @ApiResponse(code = 404, message = "Bet not found for given ID") })
    @RequestMapping(value = "/odds/{betId}",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    default ResponseEntity<List<Odds>> oddsBetIdGet(@ApiParam(value = "ID of bet to return", required = true) @PathVariable("betId") Long betId) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"odds\" : \"1/10\", \"betId\" : 0, \"userId\" : \"userId\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    @ApiOperation(value = "Offer odds for a bet", nickname = "oddsPost", notes = "", tags={ "odds", })
    @ApiResponses(value = {
        @ApiResponse(code = 201, message = "Odds have been created for bet"),
        @ApiResponse(code = 400, message = "Invalid format of Odds") })
    @RequestMapping(value = "/odds",
        consumes = { "application/json" },
        method = RequestMethod.POST)
    default ResponseEntity<Void> oddsPost(@ApiParam(value = "Odds that should be offered for a bet", required = true) @Valid @RequestBody Odds body) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
