package links;

import org.springframework.stereotype.Component;

@Component
public class PostLinks {

    public static final String POSTS = "/posts";
    public static final String POST = "/post/{id}";
    public static final String CREATE_POST = "/post";
    public static final String UPDATE_POST = "/post";
    public static final String DELETE_POST = "/post/{id}";

    /*public Link getCancelLink(Event event) {
        return entityLinks.linkForSingleResource(event).slash(CANCEL_EVENT).withRel(CANCEL_REL);
    }*/
}