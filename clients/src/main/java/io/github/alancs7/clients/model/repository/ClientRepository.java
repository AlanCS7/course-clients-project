package io.github.alancs7.clients.model.repository;

import io.github.alancs7.clients.model.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Integer> {
}
