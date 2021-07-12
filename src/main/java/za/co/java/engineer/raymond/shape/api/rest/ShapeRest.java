package za.co.java.engineer.raymond.shape.api.rest;

import java.util.Date;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import za.co.java.engineer.raymond.shape.api.exception.ErrorDetails;
import za.co.java.engineer.raymond.shape.api.exception.ShapeAlreadyExistsException;
import za.co.java.engineer.raymond.shape.api.model.Shape;
import za.co.java.engineer.raymond.shape.api.service.ShapeService;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/shape")
public class ShapeRest {
    
    @Autowired
    private ShapeService shapeService;

    @GetMapping(value = "/list")
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "Get all Shapes", notes = "Get all Shapes")
    public ResponseEntity<?> listAll() {
        return new ResponseEntity<>(shapeService.listAll(), HttpStatus.OK);
    }

    @PostMapping(value = "/save")
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "Save a Shape", notes = "Save a Shape")
    public ResponseEntity<?> save(@RequestBody Shape shape) {
        try {
            shapeService.save(shape);
            return new ResponseEntity<>(shape, HttpStatus.OK);
        } catch (ShapeAlreadyExistsException e) {
            return new ResponseEntity<>(new ErrorDetails(new Date(), e.getMessage(), shape.toString()), HttpStatus.CONFLICT);
        }
    }
}
