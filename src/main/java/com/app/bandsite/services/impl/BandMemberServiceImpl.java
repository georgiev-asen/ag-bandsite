package com.app.bandsite.services.impl;

import com.app.bandsite.model.dtos.BandMemberDto;
import com.app.bandsite.model.entities.BandMember;
import com.app.bandsite.repositories.BandMemberRepository;
import com.app.bandsite.services.BandMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BandMemberServiceImpl implements BandMemberService {

  private final BandMemberRepository bandMemberRepository;

  @Autowired
  public BandMemberServiceImpl(BandMemberRepository bandMemberRepository) {
    this.bandMemberRepository = bandMemberRepository;
  }

  @Override
  public List<BandMemberDto> getAllMembers() {
     if (bandMemberRepository.count() == 0) return new ArrayList<BandMemberDto>();

    return
      bandMemberRepository.findAll().stream().map(member -> mapBandMemberToDto(member, false)).toList();
  }

  private BandMemberDto mapBandMemberToDto(BandMember bandMember, boolean isCompleteDto) {
    BandMemberDto dto = new BandMemberDto();

    dto.setName(bandMember.getName());
    dto.setPosition(bandMember.getBandPosition());
    dto.setImgUrl(bandMember.getImgUrl());

    if (isCompleteDto) dto.setStory(bandMember.getStory());

    return dto;
  }
}
