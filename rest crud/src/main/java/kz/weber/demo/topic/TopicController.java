package kz.weber.demo.topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import kz.weber.demo.common.Response;

@RestController
public class TopicController {
    @Autowired
    private TopicService topicService;
    // @RequestMapping("/topics")
    // public String getAllTopics(){
    //     return "All topics";
    // }

    @RequestMapping("/topics")
    public Response getFirstTopic(){
        Response r = new Response();
        r.type = "Array_Topic";
        r.status = topicService.getAllTopics().size()>0?"success":"empty";
        r.response = topicService.getAllTopics();
        return r;
    }

    @RequestMapping("/topics/{id}")
    public Response getTopicById(@PathVariable Integer id){
        Topic t = topicService.getTopicById(id);
        Response r = new Response();
        r.response = t;
        r.type = "Topic";
        r.status = "success";
        if(t==null)
            r.status = "not found";
        return r;
    }

    @RequestMapping(value = "/topics", method = RequestMethod.POST)
    public Response addNewTopic(@RequestBody Topic t){
        Response r = new Response();
        r.type = "Topic";
        r.status = (topicService.addNewTopic(t)==true)?"success":"error";
        r.response = t;
        return r;
    }

    @RequestMapping(value = "/topics/{id}", method = RequestMethod.PUT)
    public Response updateTopic(@RequestBody Topic t, @PathVariable Integer id){
        Response r = new Response();
        r.type = "Topic";
        r.status = (topicService.updateTopic(t,id)==true)?"success":"error";
        r.response = t;
        return r;
    }

    @RequestMapping(value = "/topics/{id}", method = RequestMethod.DELETE)
    public Response deleteTopic(@PathVariable Integer id){
        Response r = new Response();
        boolean ans = topicService.deleteTopic(id);
        r.type = "boolean";
        r.status = (ans==true)?"success":"error";
        r.response = ans;
        return r;
    }

}
