package com.decrises.urlshortenerservice.controller;

import com.decrises.urlshortenerservice.exception.TechnicalException;
import com.decrises.urlshortenerservice.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Slf4j
@RestController
@RequestMapping("/bookmark/user/service")
@Tag(name = "User Service", description = "User Service")
public class UserController {

    @Autowired
    private UserService userService;

    @Operation(summary = "Delete User Profile", description = "Return true if delete success")
    @DeleteMapping(value = "delete/user/profile", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success"),
            @ApiResponse(responseCode = "401", description = "Unauthorized"),
            @ApiResponse(responseCode = "403", description = "Forbidden"),
            @ApiResponse(responseCode = "404", description = "Not Found"),
            @ApiResponse(responseCode = "500", description = "Failure") })
    public boolean deleteUserProfile(@Valid @RequestBody @PathVariable(value = "value", required = true) String username, @RequestHeader("Authorization") String authHeader) {
        log.info("Deleting record for request : {}", username);
        boolean response = false;
        try {
            response = userService.deleteUserProfile(username);
        }catch(Exception e){
            log.error("Exception occured while processing user account deletion request for user: {} as {}", username, e);
            throw new TechnicalException(e);
        }

        return response;
    }

}
