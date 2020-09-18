package com.decrises.urlshortenerservice.controller;

import com.decrises.urlshortenerservice.entity.Card;
import com.decrises.urlshortenerservice.exception.TechnicalException;
import com.decrises.urlshortenerservice.service.GroupManagementService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Slf4j
@RestController
@RequestMapping("/group/management/service")
@Tag(name = "Group Management Service", description = "Group Management Service")
public class GroupManagementController {

    @Autowired
    private GroupManagementService groupManagementService;

    @Operation(summary = "Get list of all Groups", description = "Return all groups")
    @GetMapping(value = "groups", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success"),
            @ApiResponse(responseCode = "401", description = "Unauthorized"),
            @ApiResponse(responseCode = "403", description = "Forbidden"),
            @ApiResponse(responseCode = "404", description = "Not Found"),
            @ApiResponse(responseCode = "500", description = "Failure") })
    public List<Card> getGroups() {
        log.info("Fetching groups");
        List<Card> groups;
        try {
            groups = groupManagementService.getGroups();
        }catch(Exception e){
            log.error("Exception occurred while fetching groups as: {}", e.toString());
            throw new TechnicalException(e);
        }
        return groups;
    }

    @Operation(summary = "Update Group", description = "Return true if update is success")
    @PostMapping(value = "groups/{group_id}", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success"),
            @ApiResponse(responseCode = "401", description = "Unauthorized"),
            @ApiResponse(responseCode = "403", description = "Forbidden"),
            @ApiResponse(responseCode = "404", description = "Not Found"),
            @ApiResponse(responseCode = "500", description = "Failure") })
    public boolean updateGroup(@PathVariable int group_id) {
        log.info("Updating group for groupId : {}", group_id);
        boolean response;
        try {
            response = groupManagementService.updateGroup(group_id);
        }catch(Exception e){
            log.error("Exception occurred while updating group for groupId: {} as {}", group_id, e);
            throw new TechnicalException(e);
        }
        return response;
    }

    @Operation(summary = "Delete Group", description = "Return true if delete success")
    @DeleteMapping(value = "groups/{group_id}", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success"),
            @ApiResponse(responseCode = "401", description = "Unauthorized"),
            @ApiResponse(responseCode = "403", description = "Forbidden"),
            @ApiResponse(responseCode = "404", description = "Not Found"),
            @ApiResponse(responseCode = "500", description = "Failure") })
    public boolean deleteGroup(@PathVariable Long group_id) {
        log.info("Deleting group for groupId : {}", group_id);
        boolean response = false;
        try {
            response = groupManagementService.deleteGroup(group_id);
        }catch(Exception e){
            log.error("Exception occurred while deleting group for groupId: {} as {}", group_id, e);
            throw new TechnicalException(e);
        }
        return response;
    }
}
