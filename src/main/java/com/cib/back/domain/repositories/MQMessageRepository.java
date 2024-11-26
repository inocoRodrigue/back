package com.cib.back.domain.repositories;

import com.cib.back.domain.models.MQMessage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MQMessageRepository extends JpaRepository<MQMessage, Long> { }