package com.bmc.loan.accounts.api

import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import io.swagger.annotations.ApiParam
import io.swagger.annotations.ApiResponse
import io.swagger.annotations.ApiResponses

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

import com.bmc.loan.accounts.model.Account
import com.bmc.loan.accounts.service.AccountService

@RestController
@RequestMapping(value = '/v1/accounts', produces = 'application/json')
@Api(value = '/accounts', description = 'the accounts API')
class AccountsController {
    @Autowired
    AccountService service
    
    @ApiOperation(value = 'get all objects',
        notes = 'returns a list of objects that have been created',
        response = Account.class, responseContainer = 'List')
    @ApiResponses(value = [
        @ApiResponse(code = 200, message = 'objects retrieved'),
        @ApiResponse(code = 500, message = 'unexpected error') ])
    @RequestMapping(value = '', produces = 'application/json', method = RequestMethod.GET)
    ResponseEntity<List<Account>> getAll() {
        ResponseEntity<List<Account>> response = null
        try {
            List<Account> objs = service.findAll()
            response = new ResponseEntity<List<Account>>(objs, HttpStatus.OK)
        } catch (Exception e) {
            response = new ResponseEntity<List<Account>>(HttpStatus.INTERNAL_SERVER_ERROR)
        }
        return response
    }
    
    @ApiOperation(value = '', notes = 'returns an object based on a single name', response = Account.class)
    @ApiResponses(value = [
        @ApiResponse(code = 200, message = 'object found'),
        @ApiResponse(code = 404, message = 'object not found'),
        @ApiResponse(code = 500, message = 'unexpected error')])
    @RequestMapping(value = '/{name}', produces = 'application/json', method = RequestMethod.GET)
    ResponseEntity<Account> get(@ApiParam(value = 'name of object to fetch', required=true) @PathVariable('name') String name) {
        ResponseEntity<Account> response = null
        try {
            Account obj = service.findOne(name)
            if (!obj) {
                response = new ResponseEntity<Account>(HttpStatus.NOT_FOUND)
            } else {
                response = new ResponseEntity<Account>(obj, HttpStatus.OK)
            }
        } catch (Exception e) {
            response = new ResponseEntity<Account>(HttpStatus.INTERNAL_SERVER_ERROR)
        }
        return response
    }
}
