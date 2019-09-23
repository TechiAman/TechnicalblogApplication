package technicalblog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import technicalblog.model.Post;
import technicalblog.repository.PostRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.TypedQuery;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public List<Post> getAllPosts(){


        return this.postRepository.getAllPosts();
    }

    public Post getOnePost() {

        return this.postRepository.getLatestPost();

    }

    public Post getPost(Integer postId) {
        return this.postRepository.getPost(postId);
    }

    public void createPost(Post post){
        post.setDate(new Date());
        this.postRepository.createPost(post);
        System.out.println("New Post created : " + post);
    }

    public void updatePost(Post updatedPost) {
        updatedPost.setDate(new Date());
        this.postRepository.updatePost(updatedPost);
    }

    public void deletePost(Integer postId){
        this.postRepository.deletePost(postId);
    }
}
