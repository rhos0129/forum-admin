package admin.forum.controller;

import admin.forum.entity.PostEntity;
import admin.forum.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin/post")
public class PostController {

    @Autowired
    private PostService postService;

    @GetMapping
    public String listPosts(Model model) {
        model.addAttribute("posts", postService.getAllPosts());
        return "post/list";
    }

    @GetMapping("/create")
    public String createPostForm(Model model) {
        model.addAttribute("post", new PostEntity());
        return "post/form";
    }

    @PostMapping
    public String savePost(@ModelAttribute PostEntity post) {
        postService.savePost(post);
        return "redirect:/admin/post";
    }

    @PostMapping("/delete/{id}")
    public String deletePost(@PathVariable Long id) {
        postService.deletePost(id);
        return "redirect:/admin/post";
    }
}
