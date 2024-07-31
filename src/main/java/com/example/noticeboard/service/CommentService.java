package com.example.noticeboard.service;

import com.example.noticeboard.domain.Comment;
import com.example.noticeboard.domain.Notification;
import com.example.noticeboard.domain.Post;
import com.example.noticeboard.domain.User;
import com.example.noticeboard.dto.request.CommentAddRequest;
import com.example.noticeboard.dto.response.CommentAddResponse;
import com.example.noticeboard.repository.CommentRepository;
import com.example.noticeboard.repository.NotificationRepository;
import com.example.noticeboard.repository.PostRepository;
import com.example.noticeboard.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentService {

    private final CommentRepository commentRepository;
    private final UserRepository userRepository;
    private final PostRepository postRepository;
    private final NotificationRepository notificationRepository;

    public CommentService(CommentRepository commentRepository, UserRepository userRepository, PostRepository postRepository,NotificationRepository notificationRepository) {
        this.commentRepository = commentRepository;
        this.userRepository = userRepository;
        this.postRepository = postRepository;
        this.notificationRepository = notificationRepository;
    }

    public CommentAddResponse addComment(CommentAddRequest request) {

        User user = userRepository.findById(request.getUserId()).orElseThrow(IllegalArgumentException::new);
        Post post = postRepository.findById(request.getPostId()).orElseThrow(IllegalArgumentException::new);

        Comment commentId = null;

        if(request.getParentId() != null){
            commentId = commentRepository.findById(request.getParentId()).orElseThrow(IllegalArgumentException::new);
            notificationRepository.save(new Notification(commentId.getUser(),post,"니 댓글에 대댓글이 달렸습니다"));
        }


        Comment comment = commentRepository.save(new Comment(request.getContent(), user, post,commentId));
        notificationRepository.save(new Notification(post.getUser(),post,"니 글에 댓글이 달렸습니다"));
        return new CommentAddResponse(
                comment.getId(),
                comment.getPost().getId(),
                comment.getContent(),
                comment.getUser().getId(),
                comment.getParentComment().getId()
        );
    }

}
