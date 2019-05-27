package com.info.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.info.app.dao.TopicDao;
import com.info.app.entities.Topic;
import com.info.app.service.TopicService;

@Service
public class TopicServiceImpl implements TopicService {
	
	@Autowired
	private TopicDao topicDao;

	@Override
	public List<Topic> getAllTopics() {
		
		return topicDao.getAllTopics();
	}

	@Override
	public Topic getTopicById(int topicId) {
		Topic topic=topicDao.getTopicById(topicId);
		return topic;
	}

	@Override
	public boolean addTopic(Topic topic) {
		if(topicDao.topicExists(topic.getTitle(), topic.getCategory())) {
			return false;
		}else {
			topicDao.addTopic(topic);
			return true;
		}
		
	}
	
	

	@Override
	public void deleteTopic(int topicId) {
		topicDao.deleteTopic(topicId);
		
	}

	@Override
	public void updateTopic(Topic topic) {
		topicDao.updateTopic(topic);
		
	}

}
