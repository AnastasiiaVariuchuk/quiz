package mate.academy.quiz.service.mapper;

import mate.academy.quiz.dto.QuizDTO;
import mate.academy.quiz.model.Quiz;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface QuizMapper {
    QuizMapper INSTANCE = Mappers.getMapper(QuizMapper.class);

    @Mapping(target = "createDate", ignore = true)
    QuizDTO mapToDto(Quiz quiz);

    Quiz mapFromDto(QuizDTO dto);
}
