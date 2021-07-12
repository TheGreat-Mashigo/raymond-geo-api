package za.co.java.engineer.raymond.shape.api.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import za.co.java.engineer.raymond.shape.api.exception.ShapeAlreadyExistsException;
import za.co.java.engineer.raymond.shape.api.exception.ShapeNotFoundException;
import za.co.java.engineer.raymond.shape.api.model.Shape;
import za.co.java.engineer.raymond.shape.api.repository.ShapeRepository;

@Service
@Transactional
@Slf4j
public class ShapeServiceImpl implements ShapeService{

    @Autowired
    private ShapeRepository shapeRepository;

    @Override
    public List<Shape> listAll() {
        return shapeRepository.findAll();
    }

    @Override
    public void save(Shape shape) throws ShapeAlreadyExistsException {
        if(isPresent(shape.getName())){
            throw new ShapeAlreadyExistsException();
        } else {
            shapeRepository.save(shape);
        }
    }

    @Override
    public Shape getShape(String name) throws ShapeNotFoundException {
        return shapeRepository.findById(name).get();
    }

    @Override
    public void deleteShape(String name) {
        shapeRepository.deleteById(name);
    }
    
    public Boolean isPresent(String name) {
        Boolean isPresent = false;
        List<Shape> shapes = listAll();
        if(!shapes.isEmpty()) {
            for(Shape shape : shapes) {
                if(shape.getName().equals(name)) isPresent = true;
            }
        }       
        return isPresent;
    }
}
