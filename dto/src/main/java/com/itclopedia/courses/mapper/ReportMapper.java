package com.itclopedia.courses.mapper;

import com.itclopedia.courses.dao.UserRepository;
import com.itclopedia.courses.dto.ReportDTO;
import com.itclopedia.courses.models.Report;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ReportMapper {
    ReportMapper INSTANCE = Mappers.getMapper(ReportMapper.class);
    ReportDTO toReportDTO(Report report);
    Report toReport(ReportDTO reportDTO, @Context UserRepository userRepository);
}
