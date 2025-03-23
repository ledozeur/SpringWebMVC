package ru.netology.repository;

import org.springframework.stereotype.Repository;
import ru.netology.model.Post;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

// Stub
@Repository
public class PostRepository {
  private final Map<Long, Post> map = new HashMap<>();
  private int count = 0;

  public List<Post> all() {
    return (List<Post>) map.values();
  }

  public Optional<Post> getById(long id) {
    return Optional.ofNullable(map.get(id));
  }

  public Post save(Post post) {

    if (post.getId() == 0) {
      post.setId(count);
      map.put((long) Math.toIntExact(post.getId()), post);
      count++;

    } else if (!(post.getId() == 0) & !map.containsKey(post.getId())) {
      map.put((long) Math.toIntExact(post.getId()), post);
    } else map.replace((long) Math.toIntExact(post.getId()), post);
    return post;
  }

  public void removeById(long id) {
    map.remove(id);
  }
}