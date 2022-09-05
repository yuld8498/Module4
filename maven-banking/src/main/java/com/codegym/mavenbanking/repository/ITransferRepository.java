package com.codegym.mavenbanking.repository;

import com.codegym.mavenbanking.model.Transfer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.Optional;

@Repository
public interface ITransferRepository extends JpaRepository<Transfer, Long> {
    void deleteBySenderIdOrRecipientId(Long senderId, Long RecipientId);
    Iterable<Transfer>  searchAllByDeletedLessThan(int deleted);
    @Modifying(flushAutomatically = true)
    @Query("UPDATE Transfer t SET t.deleted = 1  WHERE t.id = :id ")
    void setDeleted(@Param("id") Long id);
}
