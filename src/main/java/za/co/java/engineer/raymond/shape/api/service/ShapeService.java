package za.co.java.engineer.raymond.shape.api.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import za.co.java.engineer.raymond.shape.api.exception.ShapeAlreadyExistsException;
import za.co.java.engineer.raymond.shape.api.exception.ShapeNotFoundException;
import za.co.java.engineer.raymond.shape.api.model.Shape;

@Service
@Transactional
public interface ShapeService {
    /**
     * 
     * list all available shapes
     * @return list of Shape
     */
    List<Shape> listAll();
    /**
     * 
     * save a new Shape
     * @param shape object to save
     * @throws ShapeAlreadyExistsException
     */
    void save(Shape shape) throws ShapeAlreadyExistsException;
    /**
     * 
     * get specific shape
     * @param name to retrieve shape
     * @return Shape object
     * @throws ShapeNotFoundException
     */
    Shape getShape(String name) throws ShapeNotFoundException;
    /**
     * 
     * delete specific shape
     * @param name to delete shape
     */
    void deleteShape(String name);
}
