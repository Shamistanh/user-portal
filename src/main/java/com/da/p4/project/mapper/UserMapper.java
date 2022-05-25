package com.da.p4.project.mapper;

import com.da.p4.project.dto.UserDto;
import com.da.p4.project.model.User;
import org.mapstruct.Mapper;
import static org.mapstruct.ReportingPolicy.IGNORE;
import static org.mapstruct.ReportingPolicy.WARN;

@Mapper(componentModel = "spring", unmappedTargetPolicy = IGNORE, unmappedSourcePolicy = WARN)
public interface UserMapper {

    User toUserModel(UserDto userDto);
}
