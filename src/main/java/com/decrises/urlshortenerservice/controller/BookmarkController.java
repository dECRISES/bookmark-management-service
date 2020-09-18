package com.decrises.urlshortenerservice.controller;

import com.decrises.urlshortenerservice.entity.Card;
import com.decrises.urlshortenerservice.exception.TechnicalException;
import com.decrises.urlshortenerservice.service.BookmarkService;
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
@RequestMapping("/bookmark/service")
@Tag(name = "Bookmark Service", description = "Bookmark Service")
public class BookmarkController {

    @Autowired
    private BookmarkService bookmarkService;

    @Operation(summary = "Get list of all Cards", description = "Return all cards")
    @GetMapping(value = "cards", produces = APPLICATION_JSON_VALUE)
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success"),
            @ApiResponse(responseCode = "401", description = "Unauthorized"),
            @ApiResponse(responseCode = "403", description = "Forbidden"),
            @ApiResponse(responseCode = "404", description = "Not Found"),
            @ApiResponse(responseCode = "500", description = "Failure") })
    public List<Card> getCards() {
        log.info("Fetching cards");
        List<Card> cards;
        try {
            cards = bookmarkService.getCards();
        }catch(Exception e){
            log.error("Exception occurred while fetching cards as: {}", e.toString());
            throw new TechnicalException(e);
        }
        return cards;
    }

    @Operation(summary = "Get a Card", description = "Returns a card")
    @GetMapping(value = "cards/{card_id}", produces = APPLICATION_JSON_VALUE)
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success"),
            @ApiResponse(responseCode = "401", description = "Unauthorized"),
            @ApiResponse(responseCode = "403", description = "Forbidden"),
            @ApiResponse(responseCode = "404", description = "Not Found"),
            @ApiResponse(responseCode = "500", description = "Failure") })
    public Card getCard(@PathVariable Long card_id) {
        log.info("Fetching card for card_id: {}", card_id);
        Card card;
        try {
            card = bookmarkService.getCard(card_id);
        }catch(Exception e){
            log.error("Exception occurred while fetching card for card_id {} as: {}", card_id, e.toString());
            throw new TechnicalException(e);
        }
        return card;
    }

    @Operation(summary = "Update Card", description = "Return true if update is success")
    @PostMapping(value = "cards/{card_id}", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success"),
            @ApiResponse(responseCode = "401", description = "Unauthorized"),
            @ApiResponse(responseCode = "403", description = "Forbidden"),
            @ApiResponse(responseCode = "404", description = "Not Found"),
            @ApiResponse(responseCode = "500", description = "Failure") })
    public boolean updateCard(@PathVariable int card_id) {
        log.info("Updating card for cardId : {}", card_id);
        boolean response;
        try {
            response = bookmarkService.updateCard(card_id);
        }catch(Exception e){
            log.error("Exception occurred while updating card for cardId: {} as {}", card_id, e);
            throw new TechnicalException(e);
        }
        return response;
    }

    @Operation(summary = "Delete Card", description = "Return true if delete success")
    @DeleteMapping(value = "cards/{card_id}", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success"),
            @ApiResponse(responseCode = "401", description = "Unauthorized"),
            @ApiResponse(responseCode = "403", description = "Forbidden"),
            @ApiResponse(responseCode = "404", description = "Not Found"),
            @ApiResponse(responseCode = "500", description = "Failure") })
    public boolean deleteCard(@PathVariable Long card_id) {
        log.info("Deleting card for cardId : {}", card_id);
        boolean response;
        try {
            response = bookmarkService.deleteCard(card_id);
        }catch(Exception e){
            log.error("Exception occurred while deleting card for cardId: {} as {}", card_id, e);
            throw new TechnicalException(e);
        }
        return response;
    }

    @Operation(summary = "Get list of all cards for a group", description = "Return all cards for a group")
    @GetMapping(value = "groups/{group_id}/cards", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success"),
            @ApiResponse(responseCode = "401", description = "Unauthorized"),
            @ApiResponse(responseCode = "403", description = "Forbidden"),
            @ApiResponse(responseCode = "404", description = "Not Found"),
            @ApiResponse(responseCode = "500", description = "Failure") })
    public List<Card> getCardsForGroup(@PathVariable int group_id) {
        log.info("Fetching cards for groupId: {}", group_id);
        List<Card> cards;
        try {
            cards = bookmarkService.getCardsForGroup(group_id);
        }catch(Exception e){
            log.error("Exception occurred while fetching cards for a group {} as: {}", group_id, e.toString());
            throw new TechnicalException(e);
        }
        return cards;
    }

    @Operation(summary = "Update Card for a Group", description = "Return true if update is success")
    @PostMapping(value = "group/{group_id}/cards/{card_id}", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success"),
            @ApiResponse(responseCode = "401", description = "Unauthorized"),
            @ApiResponse(responseCode = "403", description = "Forbidden"),
            @ApiResponse(responseCode = "404", description = "Not Found"),
            @ApiResponse(responseCode = "500", description = "Failure") })
    public boolean updateCardForGroup(@PathVariable int group_id, @PathVariable int card_id) {
        log.info("Updating card {} for groupId : {}", card_id, group_id);
        boolean response;
        try {
            response = bookmarkService.updateCardForGroup(group_id, card_id);
        }catch(Exception e){
            log.error("Exception occurred while updating card {} for groupId: {} as {}", card_id, group_id, e);
            throw new TechnicalException(e);
        }
        return response;
    }

    @Operation(summary = "Delete Group", description = "Return true if delete success")
    @DeleteMapping(value = "group/{group_id}/cards/{card_id}", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success"),
            @ApiResponse(responseCode = "401", description = "Unauthorized"),
            @ApiResponse(responseCode = "403", description = "Forbidden"),
            @ApiResponse(responseCode = "404", description = "Not Found"),
            @ApiResponse(responseCode = "500", description = "Failure") })
    public boolean deleteCardForGroup(@PathVariable int group_id, @PathVariable int card_id) {
        log.info("Deleting card {} for groupId : {}", card_id, group_id);
        boolean response = false;
        try {
            response = bookmarkService.deleteCardForGroup(group_id, card_id);
        }catch(Exception e){
            log.error("Exception occurred while deleting card {} for groupId: {} as {}", card_id, group_id, e);
            throw new TechnicalException(e);
        }
        return response;
    }
}
