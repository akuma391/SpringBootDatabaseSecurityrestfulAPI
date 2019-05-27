package com.info.app.dao;

import com.info.app.entities.Topic;

import java.util.*;

public interface	 TopicDao {

	public abstract List<Topic> getAllTopics();
	
	public abstract Topic getTopicById(int topicId);
	
	public abstract void addTopic(Topic topic);
	
	public abstract void deleteTopic(int topicId);
	 
	public abstract void updateTopic(Topic topic);
	
	public abstract  boolean topicExists(String title, String category);
	
}
