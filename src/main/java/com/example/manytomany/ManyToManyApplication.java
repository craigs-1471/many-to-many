package com.example.manytomany;

import com.example.manytomany.model.Post;
import com.example.manytomany.model.Tag;
import com.example.manytomany.repository.PostRepository;
import com.example.manytomany.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Array;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class ManyToManyApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(ManyToManyApplication.class, args);
    }

    @Autowired
    private PostRepository postRepository;
    @Autowired
    private TagRepository tagRepository;

    @Override
    public void run(String... args) throws Exception {

    Post post = new Post("Post 1", "Description 1", "Content 1");
    Post post1 = new Post("Post 2", "Description 2", "Content 2");
    Post post2 = new Post("Post 3", "Description 3", "Content 3");

    Tag tag = new Tag("Tag 1");
    Tag tag1 = new Tag("Tag 2");
    Tag tag2 = new Tag("Tag 3");

    post.getTags().add(tag);
    post.getTags().add(tag1);

    post1.getTags().add(tag);
    post1.getTags().add(tag2);

    post2.getTags().add(tag1);
    post2.getTags().add(tag2);

    List<Post> posts = new ArrayList<>();
    posts.add(post);
    posts.add(post1);
    posts.add(post2);

    postRepository.saveAll(posts);
    Object[] array = tag.getPosts().toArray();

    }
}
