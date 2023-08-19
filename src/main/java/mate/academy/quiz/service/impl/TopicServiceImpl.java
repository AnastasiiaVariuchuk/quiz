package mate.academy.quiz.service.impl;

import lombok.AllArgsConstructor;
import mate.academy.quiz.model.Topic;
import mate.academy.quiz.repository.TopicRepository;
import mate.academy.quiz.service.TopicService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class TopicServiceImpl implements TopicService {
    private final TopicRepository topicRepository;

    @Override
    public boolean create(Topic topic) {
        if (topicRepository.isTopicExistByName(topic.getName())) {
            topicRepository.save(topic);
            return true;
        }
        return false;
    }

    @Override
    public Optional<Topic>findById(String id){
        return topicRepository.findById(Long.parseLong(id));
    }

    @Override
    public List<Topic> findAll() {
        return topicRepository.findAllTopics();
    }
}
