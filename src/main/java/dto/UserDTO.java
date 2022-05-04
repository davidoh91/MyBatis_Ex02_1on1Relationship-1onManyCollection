package dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class UserDTO {
    private String userId;
    private String userName;

    List<CommentbDTO> comments;
}
