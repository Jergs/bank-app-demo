package com.havryliuk.yehor.bank.app.demo.mapper;

import com.havryliuk.yehor.bank.app.demo.model.entity.Notice;
import com.havryliuk.yehor.bank.app.demo.model.response.NoticeDetailsResponse;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface NoticeMapper {

    NoticeMapper INSTANCE = Mappers.getMapper(NoticeMapper.class);

    List<NoticeDetailsResponse> map(List<Notice> notices);
}
