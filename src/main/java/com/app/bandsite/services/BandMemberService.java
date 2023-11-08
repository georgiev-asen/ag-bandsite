package com.app.bandsite.services;

import com.app.bandsite.model.dtos.BandMemberDto;
import com.app.bandsite.model.dtos.EventDto;

import java.util.List;

public interface BandMemberService {

  List<BandMemberDto> getAllMembers();

}
