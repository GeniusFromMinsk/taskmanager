package com.itclopedia.courses.mapper;

import com.itclopedia.courses.dto.TagDTO;
import com.itclopedia.courses.models.Tag;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface TagMapper {

    TagMapper INSTANCE = Mappers.getMapper(TagMapper.class);

    TagDTO toTagDTO(Tag tag);

    Tag toTag(TagDTO tagDTO);
}
