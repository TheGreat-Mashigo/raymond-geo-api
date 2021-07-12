package za.co.java.engineer.raymond.shape.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import za.co.java.engineer.raymond.shape.api.model.Shape;

public interface ShapeRepository extends JpaRepository<Shape, String> {
    
}
