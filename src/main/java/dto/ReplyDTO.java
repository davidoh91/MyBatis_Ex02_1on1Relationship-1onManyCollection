package dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReplyDTO {
    private int replyNo;
    private int commentNo;
    private String userId;
    private String replyContent;
    private String regDate;


}
