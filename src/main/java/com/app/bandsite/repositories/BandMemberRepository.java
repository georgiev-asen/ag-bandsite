package com.app.bandsite.repositories;

import com.app.bandsite.model.entities.BandMember;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BandMemberRepository extends JpaRepository<BandMember, Long> {
}
