package dao;

import dto.CommentbDTO;
import dto.ReplyDTO;
import dto.UserDTO;
import org.apache.ibatis.session.SqlSession;
import util.DbUtil;

import java.util.List;

public class JoinDAO {
    /*
        1:1 relationship (association between CommentbDTO + UserDTO)
     */
     public static void associationTest() {
        SqlSession session = null;

        try {
            session = DbUtil.getSession();
            List<CommentbDTO> list = session.selectList("joinMapper.joinAssociation");
            System.out.println("comment board count : " + list.size());

            for(CommentbDTO commentbDTO : list) {
                System.out.println(commentbDTO.getCommentNo() + " | ");
                System.out.print(commentbDTO.getUserId() + " | ");
                System.out.print(commentbDTO.getCommentContent() + " | ");
                System.out.print(commentbDTO.getUsers().getUserName() + " | ");
                System.out.print(commentbDTO.getRegDate());
            }
        }finally {
            DbUtil.sessionClose(session);
        }
     }

     /*
        1:M relationship (collection between CommentbDTO + ReplyDTO(s) )
     */
     public static void collectionTest() {
         SqlSession session = null;

         try {
             session = DbUtil.getSession();
             List<CommentbDTO> list = session.selectList("joinMapper.joinCollection");
             System.out.println("comment board count : " + list.size());

             for(CommentbDTO commentbDTO : list) {
                 System.out.println(commentbDTO.getCommentNo() + " | ");
                 System.out.print(commentbDTO.getCommentContent() + " | ");
                 System.out.print(commentbDTO.getRegDate() + "\n");

                 for(ReplyDTO reply : commentbDTO.getReplies()) {
                     System.out.print(" >> " + reply.getCommentNo() + " | ");
                     System.out.print(reply.getReplyContent()  + " | ");
                     System.out.println(reply.getUserId() + " | ");
                     System.out.println(reply.getRegDate() + "\n");
                 }
                 System.out.println();

             }
         }finally {
             DbUtil.sessionClose(session);
         }
     }

     /*
        1:M relationship between a user and comment boards
      */
     public static void collectionTest2() {
         SqlSession session = null;

         try {
             session = DbUtil.getSession();
             List<UserDTO> list = session.selectList("joinMapper.userCommentJoinCollection");

             for(UserDTO userDTO : list) {
                 System.out.print("User ID : " + userDTO.getUserId() + " | ");
                 System.out.print("Username : " + userDTO.getUserName()  + "\n");

                 System.out.println(">> user's comment board.. comment board count : " + userDTO.getComments().size());
                 for(CommentbDTO commentbDTO : userDTO.getComments()) {
                     System.out.print(" >> " + commentbDTO.getCommentNo() + " | ");
                     System.out.print(commentbDTO.getRegDate() + "\n");
                 }

             }



         }finally {
             DbUtil.sessionClose(session);
         }
     }

}
