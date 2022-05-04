package dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class CommentbDTO {
    private int commentNo;
    private String userId;
    private String commentContent;
    private String regDate;

    //1:1 relationship (association)
    private UserDTO users;

    //1:M relationshiop (collection)
    private List<ReplyDTO> replies;

}
