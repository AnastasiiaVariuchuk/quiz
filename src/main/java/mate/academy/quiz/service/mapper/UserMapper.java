package mate.academy.quiz.service.mapper;

import mate.academy.quiz.dto.UserDTO;
import mate.academy.quiz.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createDate", ignore = true)
    @Mapping(target = "block", ignore = true)
    UserDTO mapToDto(User user);

    User mapFromDto(UserDTO userDTO);
}
