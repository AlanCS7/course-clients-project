package io.github.alancs7.clients.model.repository;

import io.github.alancs7.clients.model.entity.Service;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceRepository extends JpaRepository<Service, Integer> {
}
