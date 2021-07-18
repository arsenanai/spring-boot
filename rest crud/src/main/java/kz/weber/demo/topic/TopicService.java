package kz.weber.demo.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class TopicService {
    private List<Topic> topics = new ArrayList<Topic>(Arrays.asList(
        new Topic(1,"Java","Java description"),
        new Topic(2,"Javascript","Javascript description"),
        new Topic(3,"Go","Go description")
    ));

    public List<Topic> getAllTopics() {
        return topics;
    }

    public void setTopics(List<Topic> topics) {
        this.topics = topics;
    }

    public Topic getTopicById(Integer id){
        Optional<Topic> o = topics.stream().filter(t -> t.getId().equals(id)).findFirst();
        return o.isPresent()?o.get():null;
    }

    public boolean addNewTopic(Topic topic){
        return this.topics.add(topic);
    }

    public boolean updateTopic(Topic topic, Integer id){
        boolean r = false;
        for(int i=0;i<topics.size();i++){
            if(topics.get(i).getId()==id){
                topics.set(i, topic);
                r = true;
                break;
            }
        }
        return r;
    }

    public boolean deleteTopic(Integer id){
        // int j=-1;
        // for(int i=0;i<topics.size();i++){
        //     if(topics.get(i).getId()==id){
        //         j=i;
        //         break;
        //     }
        // }
        // if(j>0)
        //     topics.remove(j);
        // return j>0?true:false;

        return topics.removeIf(t -> (t.getId() == id));
    }
}
